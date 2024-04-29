import java.io.Serializable;

public class DatosSerialiazados implements Serializable
{
    private static DatosSerialiazados instancia;
    private String idioma;
    private boolean sonido;

    private DatosSerialiazados()
    {
        idioma = "es";
        sonido = true;
    }

    public static DatosSerialiazados getInstancia()
    {
        if(instancia == null)
        {
            instancia = new DatosSerialiazados();
        }
        return instancia;
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
}
