import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

public class ModeloNivel extends Observable {

    private int barX = 250;
    private int barW, barH;
    private ArrayList <Ball> balls = new ArrayList<>();
    private Timer juego;
    private int puntos = 0;
    private int initialSpeedX = 4;
    private int initialSpeedY = -4;
    private String texto = "Pulsa <Enter> para comenzar o <Esc> para salir";
    private boolean gameStarted = false;
    private Rectangle barRect = new Rectangle(250, 600, 100, 20);
    private int vidas = 3;
    private int numNv;
    private boolean gameOver = false;
    private Nivel nivel;
    private Usuario user;

    public ModeloNivel(Nivel nivel, Usuario user, int numNv){
        this.numNv = numNv;
        this.user = user;
        this.nivel = nivel;
    }

    public int getVidas(){
        return vidas;
    }

    public int getPuntos(){
        return puntos;
    }

    public boolean getGameStarted(){
        return gameStarted;
    }

    public String getTexto(){
        return texto;
    }

    public void setBarX(int barX){
        this.barX = barX;
        setChanged();
        notifyObservers();
    }

    public  ArrayList <Ball> getBalls(){
        return balls;
    }

    public int getBarX(){
        return barX;
    }

    public void setBarW(int barW){
        this.barW = barW;
    }

    public void setBarH(int barH){
        this.barH = barH;
    }

    public void startGame(){
        texto = "";
        crearPelota();
        gameStarted = true;
        if (gameOver){
            vidas = 3;
            gameOver = false;
        }
        this.init();
        setChanged();
        notifyObservers();
    }

    public void pauseGame(){
        juego.stop();
        texto = "Pulsa <Enter> para continuar o <Esc> para salir";
        setChanged();
        notifyObservers();
    }

    public void continuar(){
        juego.start();
        texto = "";
        setChanged();
        notifyObservers();
    }

    public int numLadrillos(){
        int num = 0;
        for (int i = 0; i < nivel.ladrillos.size(); i++){
            if(nivel.ladrillos.get(i).refuerzo != -1){
                num++;
            }
        }
        return num;
    }
    public void crearPelota(){
        balls.add(new Ball());
    }

    public void eliminarPelota(int indice){
        balls.remove(indice);
    }

    public void init() {
        juego = new Timer(5, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){

                for(int i = 0; i < balls.size(); i++){
                    balls.get(i).move();
                    setChanged();
                    notifyObservers();
                }
                for(int i = 0; i < balls.size(); i++){
                    if(balls.get(i).ballX < 0 || balls.get(i).ballX > 660){
                        balls.get(i).speedX = -balls.get(i).speedX;
                    }
                }

                for(int i = 0; i < balls.size(); i++){
                    if(balls.get(i).ballY < 50 || balls.get(i).ballY == 49){
                        balls.get(i).speedY = Math.abs(balls.get(i).speedY) + 1;
                    }
                }

                for(int i = 0; i < balls.size(); i++){
                    if(balls.get(i).ballY > 800){
                        if(balls.size() != 1){
                            eliminarPelota(i);
                        }else{
                            gameStarted = false;
                            juego.stop();
                            vidas--;
                            if(vidas == 0){
                                texto = "No te quedan vidas <Enter> para volver al menu";
                                gameStarted = false;
                                gameOver = true;
                            }else{
                                texto = "Pulsa <Enter> para continuar";
                            }
                            juego.stop();
                            setChanged();
                            notifyObservers();
                        }
                    }
                }

                barRect.setBounds(barX, 600, barW, barH);

                for(int i = 0; i < balls.size(); i++){
                    if(balls.get(i).ballRect.intersects(barRect)){
                        int midPointBallX = balls.get(i).ballX + balls.get(i).ballW/2;
                        int midPointBarX = barX + barW/2;
                        if(midPointBallX < midPointBarX){
                            float colisionPoint = 2 * (midPointBallX - barX);
                            float speedMultiplier = colisionPoint / 100;
                            balls.get(i).speedY = -Math.abs(initialSpeedY * speedMultiplier);
                            balls.get(i).speedX = -(initialSpeedX * (1-speedMultiplier));
                        }else if(midPointBallX > midPointBarX){
                            float colisionPoint = 2 * (midPointBallX - midPointBarX);
                            float speedMultiplier = (100 - colisionPoint) / 100;
                            balls.get(i).speedY = -Math.abs(initialSpeedY * speedMultiplier);
                            balls.get(i).speedX = initialSpeedX * (1 - speedMultiplier);
                        }
                    }
                }

                for(int i = 0; i < balls.size(); i++){
                    for(int j = 0; j < nivel.ladrillos.size(); j++){
                        if(balls.get(i).ballRect.intersects(nivel.ladrillos.get(j).ladrilloRectXUp) || balls.get(i).ballRect.intersects(nivel.ladrillos.get(j).ladrilloRectXDown)){
                            balls.get(i).speedY = Math.abs(balls.get(i).speedY) + 1;
                            comprobarChoque(i, j);
                        }
                        else if(balls.get(i).ballRect.intersects(nivel.ladrillos.get(j).ladrilloRectYLeft) || balls.get(i).ballRect.intersects(nivel.ladrillos.get(j).ladrilloRectYRight)){
                            balls.get(i).speedX = -balls.get(i).speedX;
                            comprobarChoque(i, j);
                        }
                    }
                }
            }
        });
        juego.start();
    }

    public void comprobarChoque(int i, int j)
    {
        if(nivel.ladrillos.get(i).refuerzo != -1)
        {
            puntos += 10;
            if(nivel.restarVidaLadrillo(j)){
                if(numLadrillos() == 0){
                    texto = "¡¡Has ganado!! <Enter> para volver al menu";
                    juego.stop();
                    if(user.getNiveles() == numNv){
                        user.setNiveles(user.getNiveles() + 1);
                    }
                    if(puntos > user.getPuntuacion(numNv-1)){
                        user.setPuntuacion(numNv-1, puntos);
                    }
                    setChanged();
                    notifyObservers();
                    gameStarted = false;
                    gameOver = true;
                }
            }
        }
    }

    public boolean getGameOver(){
        return gameOver;
    }
}
