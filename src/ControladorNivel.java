import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

public class ControladorNivel extends JFrame {
    private Clip musicaFondo;
    private VistaNivel vNivel;
    private ModeloNivel mNivel;
    private Nivel nivel;
    private Timer moverBarraDerecha, moverBarraIzquierda;
    private ImageIcon ball, bar;
    private ArrayList<ImageIcon> vidas = new ArrayList<ImageIcon>();
    private DrawCanvas canvas;
    private boolean parao = false;
    private int puntos = 0;
    private ModeloDaltonicos mDalt;
    private ModeloIdiomas mIdioma;
    private ModeloControladorGeneral mContr;
    private Usuario user;

    public ControladorNivel(int numNv, Usuario user, String semilla, ModeloDaltonicos mDalt, ModeloIdiomas mIdioma, ModeloControladorGeneral mContr){
        this.user = user;
        this.mDalt = mDalt;
        this.mIdioma = mIdioma;
        this.mContr = mContr;
        setMusicaFondo();
        controlarMusica();
        setTimers();
        confControladorNivel(semilla, numNv);
    }

    public void confControladorNivel(String semilla, int numNv){
        nivel = new Nivel(semilla, mDalt);
        mNivel = new ModeloNivel(nivel, user, numNv, mIdioma, mDalt);
        vNivel = new VistaNivel(this, mNivel);

        mNivel.addObserver(vNivel);

        setIconImage(new ImageIcon("src/resources/Imagenes/logo2.png").getImage());
        setTitle("Break out");
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(mDalt.getColorFondo());

        setImages();
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(new byte[0]).getImage(), new Point(), "invisibleCursor"));

        canvas = new DrawCanvas();
        canvas.setOpaque(false);
        add(canvas);

        mNivel.setBarH(bar.getIconHeight());
        mNivel.setBarW(bar.getIconWidth());

        for(int i = 0; i < mNivel.getBalls().size(); i++){
            mNivel.getBalls().get(i).ballW = ball.getIconWidth();
            mNivel.getBalls().get(i).ballH = ball.getIconHeight();
        }

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    if(mNivel.getBarX() > -50 && mNivel.getGameStarted()){
                        moverBarraIzquierda.start();
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT && mNivel.getGameStarted()){
                    if(mNivel.getBarX() < 560){
                        moverBarraDerecha.start();
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    if (mNivel.getGameStarted() && parao)
                    {
                        mNivel.continuar();
                        parao = false;
                    }

                    if(mNivel.getGameOver())
                    {
                        mContr.setVisible(true);
                        mContr.getMenuNiveles().activarNiveles();
                        if(DatosSerialiazados.getInstancia().getSonido())
                        {
                            mContr.musicaOn();
                        }
                        musicaFondo.stop();
                        dispose();
                    }

                    if(!mNivel.getGameStarted()){
                        mNivel.startGame();
                    }
                }

                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    if(mNivel.getGameStarted()){
                        if(parao)
                        {
                            mContr.setVisible(true);
                            mContr.getMenuNiveles().activarNiveles();
                            if(DatosSerialiazados.getInstancia().getSonido())
                            {
                                mContr.musicaOn();
                            }
                            musicaFondo.stop();
                            dispose();
                        }else
                        {
                            mNivel.pauseGame();
                            parao = true;
                        }
                    }else
                    {
                        mContr.setVisible(true);
                        mContr.getMenuNiveles().activarNiveles();
                        if(DatosSerialiazados.getInstancia().getSonido())
                        {
                            mContr.musicaOn();
                        }
                        musicaFondo.stop();
                        dispose();
                    }
                }
            }

        });

        addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    moverBarraIzquierda.stop();
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    moverBarraDerecha.stop();
                }
            }
        });

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(!mNivel.getGameStarted()){
                    mNivel.startGame();
                }
            }
        });

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(evt.getX() > 100 && evt.getX() < 610 && mNivel.getGameStarted()){
                    int x = evt.getX();
                    mNivel.setBarX(x-100);
                }
            }
        });
        setVisible(true);
    }

    public void setImages(){
        bar = mDalt.getBarra();
        ball = mDalt.getBola();

        vidas.add(mDalt.getCorazon());
        vidas.add(mDalt.getCorazon());
        vidas.add(mDalt.getCorazon());

        Image scaleImage = vidas.get(0).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        vidas.set(0, new ImageIcon(scaleImage));

        scaleImage = vidas.get(1).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        vidas.set(1, new ImageIcon(scaleImage));

        scaleImage = vidas.get(2).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        vidas.set(2, new ImageIcon(scaleImage));
    }

    public void setPuntos(int puntos){
        this.puntos = puntos;
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

            bar.paintIcon(this, g, mNivel.getBarX(), 600);

            for(int i = 0; i < mNivel.getBalls().size(); i++){
                ball.paintIcon(this, g, mNivel.getBalls().get(i).ballX, mNivel.getBalls().get(i).ballY);
            }

            for(Ladrillo ladrillo : nivel.getLadrillos()){
                ladrillo.getLadrilloImg().paintIcon(this, g, ladrillo.ladrilloX, ladrillo.ladrilloY);
            }

            for(int i = 0; i < mNivel.getVidas(); i++){
                vidas.get(i).paintIcon(this, g, 0 + (i * 50), 0);
            }

            for(Buff buff : mNivel.getBuffs()){
                buff.paintIcon(this, g, buff.getBallX(), buff.getBallY());
            }

            g.setFont(new Font("Arial", Font.BOLD, 20));

            FontMetrics metrics = g.getFontMetrics();
            int x = (getWidth() - metrics.stringWidth(mNivel.getTexto())) / 2;
            int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
            g.setColor(mDalt.getColorTexto());
            g.drawString(mNivel.getTexto(), x, y);
            g.drawString(mIdioma.translate("Puntos: ") + puntos, 500, 30);
            for(Ladrillo ladrillo : nivel.getLadrillos()){
                if(ladrillo.getChocado())
                {
                    g.drawString("+10", ladrillo.ladrilloX, ladrillo.ladrilloY);
                }
            }
        }
    }

    public void setMusicaFondo()
    {
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/resources/Sonidos/musicaEpica.wav").getAbsoluteFile());
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

    public void setTimers()
    {
        moverBarraDerecha = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(mNivel.getBarX() < 560){
                    mNivel.setBarX(mNivel.getBarX() + 10);
                }
                else{
                    ((Timer)e.getSource()).stop();
                }
            }
        });

        moverBarraIzquierda = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(mNivel.getBarX() > -50){
                    mNivel.setBarX(mNivel.getBarX() - 10);
                }
                else{
                    ((Timer)e.getSource()).stop();
                }
            }
        });
    }
}
