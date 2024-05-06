import java.util.Observable;
import java.util.Observer;

public class VistaNivel implements Observer {

    private ControladorNivel controlador;
    private ModeloNivel modelo;

    public VistaNivel(ControladorNivel controlador, ModeloNivel modelo) {
        this.controlador = controlador;
        this.modelo = modelo;
    }

    @Override
    public void update(Observable o, Object arg) {
        controlador.setPuntos(modelo.getPuntos());
        controlador.repaint();
    }
}
