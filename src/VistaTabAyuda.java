import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class VistaTabAyuda extends JTextArea implements Observer
{
    private ModeloDaltonicos mDalt;
    private ModeloIdiomas mIdiomas;
    private String text;
    public VistaTabAyuda(ModeloDaltonicos mDalt, ModeloIdiomas idiomas, String texto)
    {
        this.mDalt = mDalt;
        this.mIdiomas = idiomas;
        this.text = texto;
        mDalt.addObserver(this);
        mIdiomas.addObserver(this);
        setText(mIdiomas.translate(text));
        setFont(new Font("Arial", Font.BOLD, 15));
        setForeground(mDalt.getColorTexto());
        setOpaque(true);
        setEditable(false);
        setLineWrap(false);
        setWrapStyleWord(true);
        setBorder(BorderFactory.createEmptyBorder(50, 50, 0, 50));
        setBackground(mDalt.getColorFondo());
    }

    public void update(Observable o, Object arg)
    {
        if (o.equals(mDalt)) {
            setForeground(mDalt.getColorTexto());
            setBackground(mDalt.getColorFondo());
        } else if (o.equals(mIdiomas)) {
            setText(mIdiomas.translate(text));
        }
    }
}
