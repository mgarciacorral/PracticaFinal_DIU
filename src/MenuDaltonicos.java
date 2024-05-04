import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

public class MenuDaltonicos extends Plantilla{
    private JPanel panelModos = new JPanel();
    private JPanel panelLabel = new JPanel();
    private VistaBotonNormal[] botonesModos = new VistaBotonNormal[4];
    private VistaLabel label;
    private VistaBotonAtras atras;
    private JButton botonActivo; //Variable que indica que boton está activo
    public MenuDaltonicos(ModeloDaltonicos mDalt, ModeloIdiomas mIdiomas, ModeloControladorGeneral mContr)
    {
        super(mDalt, mIdiomas);

        setLayout(new BorderLayout());
        panelLabel.setLayout(new BorderLayout());

        atras = new VistaBotonAtras(mDalt);

        label = new VistaLabel(mDalt, mIdiomas, "Daltonismo");
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 45));

        panelLabel.add(atras, BorderLayout.WEST);
        panelLabel.add(label, BorderLayout.CENTER);
        panelLabel.setOpaque(false);
        panelLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        add(panelLabel, BorderLayout.NORTH);

        panelModos.setLayout(new GridLayout(4,1));
        panelModos.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panelModos.setOpaque(false);

        botonesModos[0] = new VistaBotonNormal(mDalt, mIdiomas, "Desactivado");
        botonesModos[1] = new VistaBotonNormal(mDalt, mIdiomas, "Deuteranopia");
        botonesModos[2] = new VistaBotonNormal(mDalt, mIdiomas, "Protanopia");
        botonesModos[3] = new VistaBotonNormal(mDalt, mIdiomas, "Tritanopia");

        for (int i = 0; i < botonesModos.length; i++) {
            panelModos.add(botonesModos[i], CENTER_ALIGNMENT);
        }

        panelModos.setBorder(BorderFactory.createEmptyBorder(0, mDalt.getBotonNormal().getIconWidth()+50, 0, mDalt.getBotonNormal().getIconWidth()+50));
        add(panelModos, BorderLayout.CENTER);

        botonesModos[0].addActionListener(e -> {
            mDalt.setModoDaltonico("desactivado");

        });

        botonesModos[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mDalt.setModoDaltonico("deuteranopia");
            }
        });

        botonesModos[1].addActionListener(e -> {
            mDalt.setModoDaltonico("deuteranopia");
        });

        botonesModos[2].addActionListener(e -> {
            mDalt.setModoDaltonico("protanopia");
        });

        botonesModos[3].addActionListener(e -> {
            mDalt.setModoDaltonico("tritanopia");
        });

        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mContr.setVistaActual("Configuracion");
            }
        });
    }

    public void update(Observable o, Object arg)
    {
        super.update(o, arg);
        botonesModos[0].setEnabled(true);
        botonesModos[1].setEnabled(true);
        botonesModos[2].setEnabled(true);
        botonesModos[3].setEnabled(true);

        if(DatosSerialiazados.getInstancia().getModoDaltonico().equals("desactivado"))
        {
            botonActivo = botonesModos[0];
        }
        else if(DatosSerialiazados.getInstancia().getModoDaltonico().equals("deuteranopia"))
        {
            botonActivo = botonesModos[1];
        }
        else if(DatosSerialiazados.getInstancia().getModoDaltonico().equals("protanopia"))
        {
            botonActivo = botonesModos[2];
        }
        else if(DatosSerialiazados.getInstancia().getModoDaltonico().equals("tritanopia"))
        {
            botonActivo = botonesModos[3];
        }

        botonActivo.setEnabled(false);
    }
}
