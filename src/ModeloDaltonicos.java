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
    private ImageIcon barra;
    private ImageIcon ladrillo1;
    private ImageIcon ladrillo2;
    private ImageIcon ladrillo3;
    private ImageIcon ladrillo4;
    private ImageIcon ladrilloUB;
    private ImageIcon corazon;
    private ImageIcon bola;

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
        ladrillo1 = new ImageIcon("src/resources/Imagenes/red_button02.png");
        ladrillo2 = new ImageIcon("src/resources/Imagenes/yellow_button03.png");
        ladrillo3 = new ImageIcon("src/resources/Imagenes/blue_button03.png");
        ladrillo4 = new ImageIcon("src/resources/Imagenes/green_button03.png");
        ladrilloUB = new ImageIcon("src/resources/Imagenes/grey_button02.png");
        corazon = new ImageIcon("src/resources/Imagenes/corazon.png");
        barra = new ImageIcon("src/resources/Imagenes/grey_button03.png");
        bola = new ImageIcon("src/resources/Imagenes/grey_circle.png");
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
        ladrillo1 = new ImageIcon("src/resources/Imagenes/yellow_button03.png");
        ladrillo2 = new ImageIcon("src/resources/Imagenes/red_button02.png");
        ladrillo3 = new ImageIcon("src/resources/Imagenes/green_button03.png");
        ladrillo4 = new ImageIcon("src/resources/Imagenes/blue_button03.png");
        ladrilloUB = new ImageIcon("src/resources/Imagenes/grey_button02.png");
        corazon = new ImageIcon("src/resources/Imagenes/corazon.png");
        barra = new ImageIcon("src/resources/Imagenes/grey_button03.png");
        bola = new ImageIcon("src/resources/Imagenes/grey_circle.png");
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
        ladrillo1 = new ImageIcon("src/resources/Imagenes/yellow_button03.png");
        ladrillo2 = new ImageIcon("src/resources/Imagenes/red_button02.png");
        ladrillo3 = new ImageIcon("src/resources/Imagenes/green_button03.png");
        ladrillo4 = new ImageIcon("src/resources/Imagenes/blue_button03.png");
        ladrilloUB = new ImageIcon("src/resources/Imagenes/grey_button02.png");
        corazon = new ImageIcon("src/resources/Imagenes/corazon.png");
        barra = new ImageIcon("src/resources/Imagenes/blue_button00.png");
        bola = new ImageIcon("src/resources/Imagenes/yellow_circle.png");
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
        ladrillo1 = new ImageIcon("src/resources/Imagenes/blue_button03.png");
        ladrillo2 = new ImageIcon("src/resources/Imagenes/red_button02.png");
        ladrillo3 = new ImageIcon("src/resources/Imagenes/yellow_button03.png");
        ladrillo4 = new ImageIcon("src/resources/Imagenes/green_button03.png");
        ladrilloUB = new ImageIcon("src/resources/Imagenes/grey_button02.png");
        corazon = new ImageIcon("src/resources/Imagenes/corazon.png");
        barra = new ImageIcon("src/resources/Imagenes/grey_button03.png");
        bola = new ImageIcon("src/resources/Imagenes/grey_circle.png");
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

    public ImageIcon getBarra() {
        return barra;
    }

    public ImageIcon getLadrillo1() {
        return ladrillo1;
    }

    public ImageIcon getLadrillo2() {
        return ladrillo2;
    }

    public ImageIcon getLadrillo3() {
        return ladrillo3;
    }

    public ImageIcon getLadrillo4() {
        return ladrillo4;
    }

    public ImageIcon getLadrilloUB() {
        return ladrilloUB;
    }

    public ImageIcon getCorazon() {
        return corazon;
    }

    public ImageIcon getBola() {
        return bola;
    }
}
