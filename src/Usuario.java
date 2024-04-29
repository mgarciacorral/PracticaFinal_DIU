import java.io.Serializable;

public class Usuario implements Serializable {
    private int[] puntuaciones = new int[16];
    private int niveles;
    private String nombre;
    public Usuario(String nombre)
    {
        this.nombre = nombre;
        niveles = 1;
        for (int i = 0; i < puntuaciones.length; i++) {
            puntuaciones[i] = 0;
        }
    }
    public String getNombre()
    {
        return nombre;
    }
    public int getNiveles()
    {
        return niveles;
    }
    public int getPuntuacion(int nivel)
    {
        return puntuaciones[nivel];
    }
}
