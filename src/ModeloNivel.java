import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

@SuppressWarnings("ALL")
public class ModeloNivel extends Observable {

    private int barX = 250;
    private int barW, barH;
    private ArrayList <Ball> balls = new ArrayList<>();
    private ArrayList <BuffGenerico> buffs = new ArrayList<>();
    private ArrayList <Ladrillo> ladrillosGolpeados = new ArrayList<>();
    private Timer juego;
    private int puntos = 0;
    private int initialSpeedX = 4;
    private int initialSpeedY = -4;
    private String texto = "";
    private boolean gameStarted = false;
    private int numCrearPelotas = 0;
    private Rectangle barRect = new Rectangle(250, 600, 100, 20);
    private int vidas = 3;
    private int numNv;
    private boolean gameOver = false;
    private Nivel nivel;
    private Usuario user;
    private ModeloIdiomas mIdioma;
    private ModeloDaltonicos mDalt;
    private boolean buffTamanoBarra = false;
    private boolean buffMusica = false;

    private Clip musicaFondo;

    public ModeloNivel(Nivel nivel, Usuario user, int numNv, ModeloIdiomas mIdioma, ModeloDaltonicos mDalt){
        this.numNv = numNv;
        this.mIdioma = mIdioma;
        this.mDalt = mDalt;
        setMusicaFondo(0);
        controlarMusica();
        texto = mIdioma.translate("Pulsa <Enter> para lanzar la bola o <Esc> para salir");
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
        numCrearPelotas = 1;
        gameStarted = true;
        if (gameOver){
            vidas = 3;
            gameOver = false;
        }
        this.init();
    }

    public void pauseGame(){
        juego.stop();
        texto = mIdioma.translate("Pulsa <Enter> para lanzar la bola o <Esc> para salir");
        musicaFondo.stop();
        setChanged();
        notifyObservers();
    }

    public void continuar(){
        texto = "";
        juego.start();
        musicaFondo.start();
        setChanged();
        notifyObservers();
    }

    public int numLadrillos(){
        int num = 0;
        for (Ladrillo ladrillo : nivel.getLadrillos()) {
            if(ladrillo.refuerzo != -1){
                num++;
            }
        }
        return num;
    }

    public void init() {
        juego = new Timer(3, new ActionListener() {
            public void actionPerformed(ActionEvent e){
                barRect.setBounds(barX, 600, barW, barH);
                for(int i = 0; i < numCrearPelotas; i++){
                    balls.add(new Ball(mDalt, new Random().nextInt(13) - 6));
                }
                numCrearPelotas = 0;

                for(int i = 0; i < balls.size(); i++){
                    //comprueba si la bola ha caido
                    if(balls.get(i).ballY > 800){
                        balls.remove(i);
                        if(balls.size() == 0) {
                            gameStarted = false;
                            juego.stop();
                            vidas--;
                            if (vidas == 0) {
                                texto = mIdioma.translate("¡¡Has perdido!! <Enter> para volver al menu");
                                gameStarted = false;
                                gameOver = true;
                            } else {
                                texto = mIdioma.translate("Pulsa <Enter> para lanzar la bola o <Esc> para salir");
                            }
                            juego.stop();
                        }
                    }
                }

                for (Ball ball : balls) {
                    ball.move();

                    //comprueba choque con paredes
                    if (ball.ballX < 0 || ball.ballX > 660) {
                        ball.speedX = -ball.speedX;
                    }

                    if (ball.ballY < 50 || ball.ballY == 49) {
                        ball.speedY = Math.abs(ball.speedY) + 1;
                    }

                    //comprueba choque con barra
                    if (ball.ballRect.intersects(barRect)) {
                        int midPointBallX = ball.ballX + ball.ballW / 2;
                        int midPointBarX = barX + barW / 2;
                        if (midPointBallX < midPointBarX) {
                            float colisionPoint = 2 * (midPointBallX - barX);
                            float speedMultiplier = colisionPoint / 100;
                            ball.speedY = -Math.abs(initialSpeedY * speedMultiplier);
                            ball.speedX = -(initialSpeedX * (1 - speedMultiplier));
                        } else if (midPointBallX > midPointBarX) {
                            float colisionPoint = 2 * (midPointBallX - midPointBarX);
                            float speedMultiplier = (100 - colisionPoint) / 100;
                            ball.speedY = -Math.abs(initialSpeedY * speedMultiplier);
                            ball.speedX = initialSpeedX * (1 - speedMultiplier);
                        }
                    }

                    //comprueba choque con ladrillos
                    for(int j = 0; j < nivel.getLadrillos().size(); j++){
                        if(ball.ballRect.intersects(nivel.getLadrillos().get(j).ladrilloRectXUp))
                        {
                            ball.speedY = -6;
                            nivel.getLadrillos().get(j).setChocado(true);
                            comprobarChoque(j);
                        }else if(ball.ballRect.intersects(nivel.getLadrillos().get(j).ladrilloRectXDown))
                        {
                            ball.speedY = 6;
                            nivel.getLadrillos().get(j).setChocado(true);
                            comprobarChoque(j);
                        }else if(ball.ballRect.intersects(nivel.getLadrillos().get(j).ladrilloRectYLeft))
                        {
                            ball.speedX = -6;
                            nivel.getLadrillos().get(j).setChocado(true);
                            comprobarChoque(j);
                        }else if(ball.ballRect.intersects(nivel.getLadrillos().get(j).ladrilloRectYRight))
                        {
                            ball.speedX = 6;
                            nivel.getLadrillos().get(j).setChocado(true);
                            comprobarChoque(j);
                        }
                    }
                }

                for (int i = 0; i < buffs.size(); i++) {
                    buffs.get(i).move();
                    if(buffs.get(i).getBallRect().intersects(barRect)){
                        buffs.get(i).ejecutarAccion();
                        buffs.remove(i);
                    }
                }

                setChanged();
                notifyObservers();
            }
        });
        juego.start();
    }

    //en caso de choque con ladrillo se comprueba si es destruido y si se ha ganado
    public void comprobarChoque(int j)
    {
        if(nivel.getLadrillos().get(j).refuerzo != -1)
        {
            puntos += 10;
            nivel.getLadrillos().get(j).setChocado(true);
            ladrillosGolpeados.add(nivel.getLadrillos().get(j));
            if(nivel.restarVidaLadrillo(j)){
                switch(new Random().nextInt(25))
                {
                    case 0:
                        if(!buffTamanoBarra)
                        {
                            buffs.add(new BuffBarraGrande(nivel.getLadrillos().get(j).ladrilloX, nivel.getLadrillos().get(j).ladrilloY, mDalt, this));
                        }
                        break;
                    case 1:
                        if(!buffTamanoBarra)
                        {
                            buffs.add(new BuffBarraPequena(nivel.getLadrillos().get(j).ladrilloX, nivel.getLadrillos().get(j).ladrilloY, mDalt, this));
                        }
                        break;
                    case 2:
                        if(!buffMusica)
                        {
                            buffs.add(new BuffMusica(nivel.getLadrillos().get(j).ladrilloX, nivel.getLadrillos().get(j).ladrilloY, mDalt, this));
                        }
                        break;
                    case 3:
                        buffs.add(new Buff3BolasMas(nivel.getLadrillos().get(j).ladrilloX, nivel.getLadrillos().get(j).ladrilloY, mDalt, this));
                        break;
                    case 4:
                        buffs.add(new BuffMas50Puntos(nivel.getLadrillos().get(j).ladrilloX, nivel.getLadrillos().get(j).ladrilloY, mDalt, this));
                        break;
                    case 5:
                        buffs.add(new BuffMenos50Puntos(nivel.getLadrillos().get(j).ladrilloX, nivel.getLadrillos().get(j).ladrilloY, mDalt, this));
                        break;
                    case 6:
                        buffs.add(new BuffAumentarRefuerzos(nivel.getLadrillos().get(j).ladrilloX, nivel.getLadrillos().get(j).ladrilloY, mDalt, this));
                        break;
                    case 7:
                        if(vidas < 3)
                        {
                            buffs.add(new BuffRecuperarVida(nivel.getLadrillos().get(j).ladrilloX, nivel.getLadrillos().get(j).ladrilloY, mDalt, this));
                        }
                        break;
                    default:
                        break;
                }
                nivel.getLadrillos().remove(j);
                if(numLadrillos() == 0){
                    texto = mIdioma.translate("¡¡Has ganado!! <Enter> para volver al menu");
                    juego.stop();
                    if(user.getNiveles() == numNv){
                        user.setNiveles(user.getNiveles() + 1);
                    }
                    if(puntos > user.getPuntuacion(numNv-1)){
                        user.setPuntuacion(numNv-1, puntos);
                    }
                    gameStarted = false;
                    gameOver = true;
                }
            }
        }
    }

    public ArrayList<Ladrillo> getLadrillosGolpeados(){
        return ladrillosGolpeados;
    }

    public boolean getGameOver(){
        return gameOver;
    }

    public ArrayList<BuffGenerico> getBuffs(){
        return buffs;
    }

    public ArrayList<Ladrillo> getLadrillos(){
        return nivel.getLadrillos();
    }

    public void setNumCrearPelotas(int numCrearPelotas){
        this.numCrearPelotas = numCrearPelotas;
    }

    public int getNumCrearPelotas(){
        return numCrearPelotas;
    }

    public void setMusicaFondo(int i)
    {
        if(musicaFondo != null)
        {
            musicaFondo.stop();
        }
        try
        {
            AudioInputStream audioInputStream;
            if(i == 0)
            {
                audioInputStream = AudioSystem.getAudioInputStream(new File("src/resources/Sonidos/musicaEpica.wav").getAbsoluteFile());
            }
            else
            {
                audioInputStream = AudioSystem.getAudioInputStream(new File("src/resources/Sonidos/musicaEpica2.wav").getAbsoluteFile());
            }
            musicaFondo = AudioSystem.getClip();
            musicaFondo.open(audioInputStream);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void controlarMusica()
    {
        if(DatosSerialiazados.getInstancia().getSonido())
        {
            new Thread(new Runnable() {
                public void run() {
                    musicaFondo.loop(Clip.LOOP_CONTINUOUSLY);
                    musicaFondo.start();
                }
            }).start();
        }
        else
        {
            musicaFondo.stop();
        }
    }

    public void setBuffTamanoBarra(boolean buffTamanoBarra){
        this.buffTamanoBarra = buffTamanoBarra;
    }

    public boolean getBuffTamanoBarra(){
        return buffTamanoBarra;
    }

    public void setPuntos(int puntos){
        this.puntos = puntos;
    }

    public Nivel getNivel(){
        return nivel;
    }

    public void setVidas(int vidas){
        this.vidas = vidas;
    }

    public void setBuffMusica(boolean buffMusica){
        this.buffMusica = buffMusica;
    }

    public boolean getBuffMusica(){
        return buffMusica;
    }

    public void stopMusic(){
        musicaFondo.stop();
    }
}
