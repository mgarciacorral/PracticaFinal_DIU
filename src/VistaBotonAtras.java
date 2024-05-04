import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

public class VistaBotonAtras extends JButton implements Observer
{
    private ModeloDaltonicos md;
    private Clip sonidoBoton;

    public VistaBotonAtras(ModeloDaltonicos modeloDaltonicos){
        this.md = modeloDaltonicos;
        md.addObserver(this);
        setIcon(md.getBotonAtras());
        setContentAreaFilled(false);
        setBorderPainted(false);
        setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        try {
            sonidoBoton = AudioSystem.getClip();
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/resources/Sonidos/click.wav"));
            sonidoBoton.open(audio);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sonidoClick();
    }

    public void sonidoClick(){
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {
                new Thread(new Runnable() {
                    public void run() {
                        sonidoBoton.setFramePosition(0);
                        sonidoBoton.start();
                    }
                }).start();
            }
        });
    }

    public void update(Observable o, Object arg) {
        setIcon(md.getBotonAtras());
    }
}
