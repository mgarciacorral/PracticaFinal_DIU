import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class ModeloDaltonicos extends Observable {
    private Color colorFondo;
    private Color colorLetraBoton;
    private Color colorLabel;
    private Color colorTexto;
    private ImageIcon botonNormal;
    private ImageIcon botonPulsado;
    private ImageIcon botonHover;
    private ImageIcon botonAtras;
    private ImageIcon botonNivel;
    private ImageIcon botonNivelPulsado;

    public ModeloDaltonicos(){
        setModoDaltonico(DatosSerialiazados.getInstancia().getModoDaltonico());
    }

    public void notificar()
    {
        setChanged();
        notifyObservers();
    }

    public void setModoDaltonico(String modo)
    {
        switch (modo) {
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
        notificar();
    }

    public void setDesactivado()
    {
        colorFondo = Color.decode("#475C8D");
        colorLetraBoton = Color.decode("#404040");
        colorLabel = Color.decode("#74CD4F");
        colorTexto = Color.WHITE;
        botonNormal = new ImageIcon("src/resources/Imagenes/red_button01.png");
        botonPulsado = new ImageIcon("src/resources/Imagenes/red_button02.png");
        botonHover = new ImageIcon("src/resources/Imagenes/red_button11.png");
        botonAtras = new ImageIcon("src/resources/Imagenes/red_sliderLeft.png");
        botonNivel = new ImageIcon("src/resources/Imagenes/red_button06.png");
        botonNivelPulsado = new ImageIcon("src/resources/Imagenes/red_button07.png");
        DatosSerialiazados.getInstancia().setModoDaltonico("desactivado");
    }

    public void setDeuteranopia()
    {
        colorFondo = Color.decode("#475C8D");
        colorLetraBoton = Color.decode("#404040");
        colorLabel = Color.WHITE;
        colorTexto = Color.WHITE;
        botonNormal = new ImageIcon("src/resources/Imagenes/yellow_button02.png");
        botonPulsado = new ImageIcon("src/resources/Imagenes/yellow_button03.png");
        botonHover = new ImageIcon("src/resources/Imagenes/yellow_button00.png");
        botonAtras = new ImageIcon("src/resources/Imagenes/yellow_sliderLeft.png");
        botonNivel = new ImageIcon("src/resources/Imagenes/yellow_button09.png");
        botonNivelPulsado = new ImageIcon("src/resources/Imagenes/yellow_button10.png");
        DatosSerialiazados.getInstancia().setModoDaltonico("deuteranopia");
    }

    public void setProtanopia() {
        colorFondo = Color.WHITE;
        colorLetraBoton = Color.decode("#404040");
        colorLabel = Color.decode("#475C8D");
        colorTexto = Color.GRAY;
        botonNormal = new ImageIcon("src/resources/Imagenes/yellow_button02.png");
        botonPulsado = new ImageIcon("src/resources/Imagenes/yellow_button03.png");
        botonHover = new ImageIcon("src/resources/Imagenes/yellow_button00.png");
        botonAtras = new ImageIcon("src/resources/Imagenes/yellow_sliderLeft.png");
        botonNivel = new ImageIcon("src/resources/Imagenes/yellow_button09.png");
        botonNivelPulsado = new ImageIcon("src/resources/Imagenes/yellow_button10.png");
        DatosSerialiazados.getInstancia().setModoDaltonico("protanopia");
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
        DatosSerialiazados.getInstancia().setModoDaltonico("tritanopia");
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public Color getColorLetraBoton() {
        return colorLetraBoton;
    }

    public Color getColorLabel() {
        return colorLabel;
    }

    public Color getColorTexto() {
        return colorTexto;
    }

    public ImageIcon getBotonNormal() {
        return botonNormal;
    }

    public ImageIcon getBotonPulsado() {
        return botonPulsado;
    }

    public ImageIcon getBotonHover() {
        return botonHover;
    }

    public ImageIcon getBotonAtras() {
        return botonAtras;
    }

    public ImageIcon getBotonNivel() {
        return botonNivel;
    }

    public ImageIcon getBotonNivelPulsado() {
        return botonNivelPulsado;
    }



}
