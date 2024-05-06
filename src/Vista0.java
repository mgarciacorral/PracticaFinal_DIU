import java.util.Observable;
import java.util.Observer;

public class Vista0 implements Observer {

    ControladorNivel controlador;
    ModeloNivel modelo;

    public Vista0(ControladorNivel controlador, ModeloNivel modelo) {
        this.controlador = controlador;
        this.modelo = modelo;
    }



    @Override
    public void update(Observable o, Object arg) {
        controlador.repaint();
    }
}
