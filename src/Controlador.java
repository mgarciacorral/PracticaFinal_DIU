import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

public class Controlador extends JFrame {

    Vista0 vista0;
    Modelo modelo;
    private ImageIcon ball, bar;
    private ArrayList<ImageIcon> vidas = new ArrayList<ImageIcon>();

    private DrawCanvas canvas;
    private Font fuente;


    public void configControlador(){
        modelo  = new Modelo();
        vista0 = new Vista0(this, modelo);

        modelo.addObserver(vista0);

        setTitle("Break out");
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setBackground(java.awt.Color.BLACK);

        setImages();
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(new byte[0]).getImage(), new Point(), "invisibleCursor"));

        canvas = new DrawCanvas();
        this.add(canvas);
        pack();

        modelo.barH = bar.getIconHeight();
        modelo.barW = bar.getIconWidth();
        modelo.ballH = ball.getIconHeight();
        modelo.ballW = ball.getIconWidth();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    if(modelo.barX > 0 && modelo.gameStarted){
                        modelo.setBarX(modelo.barX - 10);
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT && modelo.gameStarted){
                    if(modelo.barX < 510){
                        modelo.setBarX(modelo.barX + 10);
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    if(!modelo.gameStarted){
                        modelo.startGame();
                    }

                }
            }

        });

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(!modelo.gameStarted){
                    modelo.startGame();
                }
            }

        });

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(evt.getX() > 100 && evt.getX() < 610 && modelo.gameStarted){
                    int x = evt.getX();
                    modelo.setBarX(x-100);
                }
            }
        });

    }

    public void setImages(){
        ball = new ImageIcon("src/ball.png");
        bar = new ImageIcon(getClass().getResource("/resources/grey_button03.png"));
        ball = new ImageIcon(getClass().getResource("/resources/grey_circle.png"));

        vidas.add(new ImageIcon(getClass().getResource("/resources/corazon.png")));
        vidas.add(new ImageIcon(getClass().getResource("/resources/corazon.png")));
        vidas.add(new ImageIcon(getClass().getResource("/resources/corazon.png")));

        Image scaleImage = vidas.get(0).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        vidas.set(0, new ImageIcon(scaleImage));

        scaleImage = vidas.get(1).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        vidas.set(1, new ImageIcon(scaleImage));

        scaleImage = vidas.get(2).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        vidas.set(2, new ImageIcon(scaleImage));

    }


    class DrawCanvas extends JPanel {
        public DrawCanvas() {
            this.setPreferredSize(new Dimension(700, 800));
            setBackground(Color.BLACK);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            this.setBackground(Color.black);
            g.setColor(Color.white);
            g.fillRect(0, 0, 700, 50);  // Pinta el fondo
            // Pinta los iconos después de llenar el fondo
            ball.paintIcon(this, g, modelo.ballX, modelo.ballY);
            bar.paintIcon(this, g, modelo.barX, 600);

            for(int i = 0; i < modelo.vidas; i++){
                vidas.get(i).paintIcon(this, g, 0 + (i * 50), 0);
            }

            // Dibuja el texto en el centro del canvas
            g.setFont(new Font("Arial", Font.BOLD, 20));


            FontMetrics metrics = g.getFontMetrics();
            int x = (getWidth() - metrics.stringWidth(modelo.texto)) / 2;
            int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
            g.drawString(modelo.texto, x, y);
        }
    }


}
