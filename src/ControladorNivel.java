import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class ControladorNivel extends JFrame {

    private VistaNivel vista0;
    private ModeloNivel modelo;
    private Nivel nivel;
    private ImageIcon ball, bar, ladrillo;
    private ArrayList<ImageIcon> vidas = new ArrayList<ImageIcon>();
    private DrawCanvas canvas;
    private ModeloControladorGeneral mContr;
    private boolean parao = false;
    private int puntos = 0;

    public ControladorNivel(String nivel){
        confControladorNivel(nivel);
    }

    public void confControladorNivel(String bloques){
        nivel = new Nivel(bloques);
        modelo  = new ModeloNivel(nivel);
        vista0 = new VistaNivel(this, modelo);

        modelo.addObserver(vista0);

        setSize(700, 800);

        setImages();
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(new byte[0]).getImage(), new Point(), "invisibleCursor"));

        canvas = new DrawCanvas();
        canvas.setOpaque(false);
        this.add(canvas);

        modelo.setBarH(bar.getIconHeight());
        modelo.setBarW(bar.getIconWidth());

        for(int i = 0; i < modelo.getBalls().size(); i++){
            modelo.getBalls().get(i).ballW = ball.getIconWidth();
            modelo.getBalls().get(i).ballH = ball.getIconHeight();
        }

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    if(modelo.getBarX() > 0 && modelo.getGameStarted()){
                        modelo.setBarX(modelo.getBarX() - 10);
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT && modelo.getGameStarted()){
                    if(modelo.getBarX() < 510){
                        modelo.setBarX(modelo.getBarX() + 10);
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    if(!modelo.getGameStarted()){
                        modelo.startGame();
                    }

                    if (!parao)
                    {
                        modelo.init();
                    }
                }

                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    if(parao)
                    {
                        mContr.setVistaActual("MenuPrincipal");
                    }else
                    {
                        modelo.getJuego().stop();
                        parao = true;
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    modelo.crearPelota();
                }
            }

        });

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(!modelo.getGameStarted()){
                    modelo.startGame();
                }
            }

        });

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(evt.getX() > 100 && evt.getX() < 610 && modelo.getGameStarted()){
                    int x = evt.getX();
                    modelo.setBarX(x-100);
                }
            }
        });

    }

    public void setImages(){
        ball = new ImageIcon("src/ball.png");
        bar = new ImageIcon(getClass().getResource("/resources/Imagenes/grey_button03.png"));
        ball = new ImageIcon(getClass().getResource("/resources/Imagenes/grey_circle.png"));
        ladrillo = new ImageIcon(getClass().getResource("/resources/Imagenes/blue_button03.png"));

        vidas.add(new ImageIcon(getClass().getResource("/resources/Imagenes/corazon.png")));
        vidas.add(new ImageIcon(getClass().getResource("/resources/Imagenes/corazon.png")));
        vidas.add(new ImageIcon(getClass().getResource("/resources/Imagenes/corazon.png")));

        Image scaleImage = vidas.get(0).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        vidas.set(0, new ImageIcon(scaleImage));

        scaleImage = vidas.get(1).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        vidas.set(1, new ImageIcon(scaleImage));

        scaleImage = vidas.get(2).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        vidas.set(2, new ImageIcon(scaleImage));

        scaleImage = ladrillo.getImage().getScaledInstance(117, 28, Image.SCALE_DEFAULT);
        ladrillo = new ImageIcon(scaleImage);

    }

    public void setPuntos(int puntos){
        this.puntos = puntos;
    }

    public int getPuntos(){
        return puntos;
    }


    class DrawCanvas extends JPanel {
        public DrawCanvas() {
            this.setPreferredSize(new Dimension(700, 800));
            setBackground(Color.BLACK);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(mDalt.getColorFondo());
            g.fillRect(0, 0, 700, 50);

            for(int i = 0; i < modelo.getBalls().size(); i++){
                ball.paintIcon(this, g, modelo.getBalls().get(i).ballX, modelo.getBalls().get(i).ballY);
            }

            bar.paintIcon(this, g, modelo.getBarX(), 600);

            for(int i = 0; i < nivel.ladrillos.size(); i++){
                ladrillo.paintIcon(this, g, nivel.ladrillos.get(i).ladrilloX, nivel.ladrillos.get(i).ladrilloY);
            }


            for(int i = 0; i < modelo.getVidas(); i++){
                vidas.get(i).paintIcon(this, g, 0 + (i * 50), 0);
            }

            g.setFont(new Font("Arial", Font.BOLD, 20));

            FontMetrics metrics = g.getFontMetrics();
            int x = (getWidth() - metrics.stringWidth(modelo.getTexto())) / 2;
            int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
            g.drawString(modelo.getTexto(), x, y);
            g.setColor(mDalt.getColorTexto());
            g.drawString("Puntos: " + puntos, 500, 30);
        }
    }




}
