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
        setModoDaltonico();
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

    public void setModoDaltonico()
    {
        switch (ControladorGeneral.modoDaltonico) {
            case "deuteranopia":
                setDeuteranopia();
                break;
            case "protanopia":
                setProtanopia();
                break;
            case "tritanopia":
                setTritanopia();
                break;
            default:
                setDesactivado();
                break;
        }
    }

    public void setDesactivado()
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

    public void setDeuteranopia()
    {
        colorFondo = Color.decode("#475C8D");
        colorLetraBoton = Color.decode("#404040");
        colorLabel = Color.WHITE;
        botonNormal = new ImageIcon("src/resources/Imagenes/yellow_button02.png");
        botonPulsado = new ImageIcon("src/resources/Imagenes/yellow_button03.png");
        botonHover = new ImageIcon("src/resources/Imagenes/yellow_button00.png");
        botonAtras = new ImageIcon("src/resources/Imagenes/yellow_sliderLeft.png");
        botonNivel = new ImageIcon("src/resources/Imagenes/yellow_button09.png");
        botonNivelPulsado = new ImageIcon("src/resources/Imagenes/yellow_button10.png");
    }

    public void setProtanopia() {
        colorFondo = Color.WHITE;
        colorLetraBoton = Color.decode("#404040");
        colorLabel = Color.decode("#475C8D");
        botonNormal = new ImageIcon("src/resources/Imagenes/yellow_button02.png");
        botonPulsado = new ImageIcon("src/resources/Imagenes/yellow_button03.png");
        botonHover = new ImageIcon("src/resources/Imagenes/yellow_button00.png");
        botonAtras = new ImageIcon("src/resources/Imagenes/yellow_sliderLeft.png");
        botonNivel = new ImageIcon("src/resources/Imagenes/yellow_button09.png");
        botonNivelPulsado = new ImageIcon("src/resources/Imagenes/yellow_button10.png");
    }

    public void setTritanopia() {
        colorFondo = Color.decode("#475C8D");
        colorLetraBoton = Color.decode("#404040");
        colorLabel = Color.decode("#FFCC00");
        botonNormal = new ImageIcon("src/resources/Imagenes/yellow_button02.png");
        botonPulsado = new ImageIcon("src/resources/Imagenes/yellow_button03.png");
        botonHover = new ImageIcon("src/resources/Imagenes/yellow_button00.png");
        botonAtras = new ImageIcon("src/resources/Imagenes/yellow_sliderLeft.png");
        botonNivel = new ImageIcon("src/resources/Imagenes/yellow_button09.png");
        botonNivelPulsado = new ImageIcon("src/resources/Imagenes/yellow_button10.png");
    }

    protected String translate(String key){
        return ControladorGeneral.translate(key);
    }

    public void actualizarTexto(){
        //rellenar con cosas de actualizar texto en hijos
    }

    public void actualizarVista(){
        //rellenar con cosas de actualizar vista en hijos
        setBackground(colorFondo);
    }



}
