import java.io.Serializable;
import java.util.ArrayList;

public class DatosSerialiazados implements Serializable
{
    private static DatosSerialiazados instancia;
    private String idioma;
    private String modoDaltonico;
    private boolean sonido;
    private ArrayList<Usuario> usuarios;

    private DatosSerialiazados()
    {
        usuarios = new ArrayList<>();
        idioma = "es";
        sonido = true;
        modoDaltonico = "";
    }

    public static DatosSerialiazados getInstancia()
    {
        if(instancia == null)
        {
            instancia = new DatosSerialiazados();
        }
        return instancia;
    }

    public static void setInstancia(DatosSerialiazados inst)
    {
        instancia = inst;
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

    public ArrayList<Usuario> getUsuarios()
    {
        return usuarios;
    }
}
