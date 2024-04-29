import java.io.Serializable;
import java.util.ArrayList;

public class DatosSerialiazados implements Serializable
{
    private static DatosSerialiazados instancia;
    private String idioma;
    private String modoDaltonico;
    private boolean sonido;
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    private DatosSerialiazados()
    {
        idioma = "es";
        sonido = true;
        modoDaltonico = "desactivado";
    }

    public static DatosSerialiazados getInstancia()
    {
        if(instancia == null)
        {
            instancia = new DatosSerialiazados();
        }
        return instancia;
    }

    public static void setInstancia(DatosSerialiazados instancia)
    {
        DatosSerialiazados.instancia = instancia;
    }

    public String getIdioma()
    {
        return idioma;
    }

    public void setIdioma(String idioma)
    {
        this.idioma = idioma;
    }

    public boolean getSonido()
    {
        return sonido;
    }

    public void setSonido(boolean sonido)
    {
        this.sonido = sonido;
    }

    public String getModoDaltonico()
    {
        return modoDaltonico;
    }

    public void setModoDaltonico(String modoDaltonico)
    {
        this.modoDaltonico = modoDaltonico;
    }
}
