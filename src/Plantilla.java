import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Plantilla extends JPanel {
    protected static Color colorFondo;
    protected static Color colorLetraBoton;
    protected static Color colorLabel;
    protected static ImageIcon botonNormal;
    protected static ImageIcon botonPulsado;
    protected static ImageIcon botonHover;
    protected static ImageIcon botonAtras;
    protected static ImageIcon botonNivel;
    protected static ImageIcon botonNivelPulsado;
    protected Clip sonidoBoton;

    public Plantilla(){
        modoNormal();

        setSize(700, 800);
        setBackground(colorFondo);

        try {
            sonidoBoton = AudioSystem.getClip();
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/resources/Sonidos/click.wav"));
            sonidoBoton.open(audio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modoNormal()
    {
        colorFondo = Color.decode("#475C8D");
        colorLetraBoton = Color.decode("#404040");
        colorLabel = Color.decode("#74CD4F");
        botonNormal = new ImageIcon("src/resources/Imagenes/red_button01.png");
        botonPulsado = new ImageIcon("src/resources/Imagenes/red_button02.png");
        botonHover = new ImageIcon("src/resources/Imagenes/red_button11.png");
        botonAtras = new ImageIcon("src/resources/Imagenes/red_sliderLeft.png");
        botonNivel = new ImageIcon("src/resources/Imagenes/red_button06.png");
        botonNivelPulsado = new ImageIcon("src/resources/Imagenes/red_button07.png");
    }
    public void daltonicos1(){
        //rellenar con cosas de daltonicos
    }

    public void setIdioma()
    {
        //rellenar con cosas de idioma
    }

}
