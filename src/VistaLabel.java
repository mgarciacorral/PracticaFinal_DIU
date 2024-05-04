import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VistaLabel extends JLabel implements Observer {
    private ModeloDaltonicos mDalt;
    private ModeloIdiomas mIdiomas;
    private String text;

    public VistaLabel(ModeloDaltonicos modeloDaltonicos, ModeloIdiomas idiomas, String texto){
        this.mDalt = modeloDaltonicos;
        this.mIdiomas = idiomas;
        this.text = texto;
        setText(mIdiomas.translate(texto));
        mDalt.addObserver(this);
        mIdiomas.addObserver(this);
        setFont(new Font("Showcard Gothic", Font.BOLD, 45));
        setForeground(mDalt.getColorLabel());
        setHorizontalAlignment(SwingConstants.CENTER);
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setOpaque(false);
    }
    public void update(Observable o, Object arg) {
        if(o.equals(mDalt)){
            setForeground(mDalt.getColorLabel());
        } else if (o.equals(mIdiomas)) {
            setText(mIdiomas.translate(text));
        }
    }
}
