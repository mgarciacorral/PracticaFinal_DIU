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

public class VistaBotonNivel extends JButton implements Observer {
    private ModeloDaltonicos md;
    private Clip sonidoBoton;

    public VistaBotonNivel(ModeloDaltonicos modeloDaltonicos, String texto){
        super(texto);
        this.md = modeloDaltonicos;
        md.addObserver(this);
        setFont(new Font("Showcard Gothic", Font.BOLD, 20));
        setForeground(md.getColorLetraBoton());
        setHorizontalTextPosition(SwingConstants.CENTER);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setIcon(md.getBotonNivel());
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
        setForeground(md.getColorLetraBoton());
        setIcon(md.getBotonNivel());
    }

    public void animacionPulsar(){
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                setIcon(md.getBotonNivelPulsado());
                new Thread(new Runnable() {
                    public void run() {
                        sonidoBoton.setFramePosition(0);
                        sonidoBoton.start();
                    }
                }).start();
            }

            public void mouseReleased(MouseEvent e) {
                setIcon(md.getBotonNivel());
            }
        });
    }


}
