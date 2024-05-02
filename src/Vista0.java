import java.util.Observable;
import java.util.Observer;

public class Vista0 implements Observer {

    Controlador controlador;
    Modelo modelo;

    public Vista0(Controlador controlador, Modelo modelo) {
        this.controlador = controlador;
        this.modelo = modelo;
    }



    @Override
    public void update(Observable o, Object arg) {
        controlador.repaint();
    }
}
