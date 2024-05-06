import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Observable;

public class ModeloControladorGeneral extends Observable
{
    private Clip musicaFondo;
    private String vistaActual;
    private MenuNiveles mn;
    private ControladorNivel nivel;
    private boolean visible = true;

    public ModeloControladorGeneral(){
        setMusicaFondo();
        controlarMusica();
    }

    public void notificar()
    {
        setChanged();
        notifyObservers();
    }

    public void setVisible(boolean visible)
    {
        this.visible = visible;
        notificar();
    }

    public boolean getVisible()
    {
        return visible;
    }

    public void setVistaActual(String vista)
    {
        vistaActual = vista;
        notificar();
    }

    public String getVistaActual()
    {
        return vistaActual;
    }

    public void setMusicaFondo()
    {
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/resources/Sonidos/musicaFondo.wav").getAbsoluteFile());
            musicaFondo = AudioSystem.getClip();
            musicaFondo.open(audioInputStream);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setNivel(ControladorNivel nivel) {
        this.nivel = nivel;
    }

    public ControladorNivel getNivel() {
        return nivel;
    }

    public void controlarMusica()
    {
        if(DatosSerialiazados.getInstancia().getSonido())
        {
            musicaOn();
        }
        else
        {
            musicaOff();
        }
    }

    public void musicaOn()
    {
        new Thread(new Runnable() {
            public void run() {
                musicaFondo.loop(Clip.LOOP_CONTINUOUSLY);
                musicaFondo.start();
            }
        }).start();
    }

    public void musicaOff() {
        musicaFondo.stop();
    }

    public void setMn(MenuNiveles mn)
    {
        this.mn = mn;
    }
    public MenuNiveles getMenuNiveles()
    {
        return mn;
    }
}
