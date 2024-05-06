import java.util.Observable;
import java.util.Observer;

public class VistaNivel implements Observer {

    ControladorNivel controlador;
    ModeloNivel modelo;

    public VistaNivel(ControladorNivel controlador, ModeloNivel modelo) {
        this.controlador = controlador;
        this.modelo = modelo;
    }



    @Override
    public void update(Observable o, Object arg) {
        controlador.repaint();
    }
}
