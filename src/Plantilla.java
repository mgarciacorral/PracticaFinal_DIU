import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class Plantilla extends JPanel  implements Observer {
    protected ModeloDaltonicos mDalt;
    protected ModeloIdiomas mIdiomas;

    public Plantilla(ModeloDaltonicos mDalt, ModeloIdiomas mIdiomas){
        this.mDalt = mDalt;
        this.mIdiomas = mIdiomas;
        mDalt.addObserver(this);
        mIdiomas.addObserver(this);
        setSize(700, 800);
    }

    public void update(Observable o, Object arg) {
        setBackground(mDalt.getColorFondo());
    }
}
