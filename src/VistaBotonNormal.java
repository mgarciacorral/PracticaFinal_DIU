import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

public class VistaBotonNormal extends JButton implements Observer {
    private ModeloDaltonicos mDalt;
    private ModeloIdiomas mIdiomas;
    private Clip sonidoBoton;
    private String text;

    public VistaBotonNormal(ModeloDaltonicos modeloDaltonicos, ModeloIdiomas idiomas, String texto){
        this.mDalt = modeloDaltonicos;
        this.mIdiomas = idiomas;
        this.text = texto;
        setText(mIdiomas.translate(texto));
        mDalt.addObserver(this);
        mIdiomas.addObserver(this);
        setFont(new Font("Showcard Gothic", Font.BOLD, 20));
        setForeground(mDalt.getColorLetraBoton());
        setHorizontalTextPosition(SwingConstants.CENTER);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setIcon(mDalt.getBotonNormal());
        setAlignmentX(CENTER_ALIGNMENT);
        try {
            sonidoBoton = AudioSystem.getClip();
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/resources/Sonidos/click.wav"));
            sonidoBoton.open(audio);
        } catch (Exception e) {
            e.printStackTrace();
        }
        animacionPulsar();
    }
    public void update(Observable o, Object arg) {
        if (o.equals(mDalt)) {
            setForeground(mDalt.getColorLetraBoton());
            setIcon(mDalt.getBotonNormal());
        } else if (o.equals(mIdiomas)) {
            setText(mIdiomas.translate(text));
        }
    }

    public void animacionPulsar(){
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                setIcon(mDalt.getBotonPulsado());
                new Thread(new Runnable() {
                    public void run() {
                        sonidoBoton.setFramePosition(0);
                        sonidoBoton.start();
                    }
                }).start();
            }

            public void mouseEntered(MouseEvent e) {
                setIcon(mDalt.getBotonHover());
            }

            public void mouseExited(MouseEvent e) {
                setIcon(mDalt.getBotonNormal());
            }

            public void mouseReleased(MouseEvent e) {
                setIcon(mDalt.getBotonNormal());
            }
        });
    }


}
