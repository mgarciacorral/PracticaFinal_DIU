import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

public class MenuIdioma extends Plantilla{
    private JPanel panelIdioma = new JPanel();
    private JPanel panelLabel = new JPanel();
    private VistaBotonNormal[] botonesIdioma = new VistaBotonNormal[4];
    private VistaLabel label;
    private VistaBotonAtras atras;
    private JButton botonActivo; //Variable que indica que boton está activo

    public MenuIdioma (ModeloDaltonicos mDalt, ModeloIdiomas mIdiomas, ModeloControladorGeneral mContr)
    {
        super(mDalt, mIdiomas);

        setLayout(new BorderLayout());
        panelLabel.setLayout(new BorderLayout());

        atras = new VistaBotonAtras(mDalt);

        label = new VistaLabel(mDalt, mIdiomas, "Idioma");
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 45));

        panelLabel.add(atras, BorderLayout.WEST);
        panelLabel.add(label, BorderLayout.CENTER);
        panelLabel.setOpaque(false);
        panelLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        add(panelLabel, BorderLayout.NORTH);

        panelIdioma.setLayout(new GridLayout(4,1));
        panelIdioma.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panelIdioma.setOpaque(false);

        botonesIdioma[0] = new VistaBotonNormal(mDalt, mIdiomas, "Español");
        botonesIdioma[1] = new VistaBotonNormal(mDalt, mIdiomas, "Ingles");
        botonesIdioma[2] = new VistaBotonNormal(mDalt, mIdiomas, "Portugués");
        botonesIdioma[3] = new VistaBotonNormal(mDalt, mIdiomas, "Gallego");

        for (int i = 0; i < botonesIdioma.length; i++) {
            panelIdioma.add(botonesIdioma[i], CENTER_ALIGNMENT);
        }

        panelIdioma.setBorder(BorderFactory.createEmptyBorder(0, mDalt.getBotonNormal().getIconWidth()+50, 0, mDalt.getBotonNormal().getIconWidth()+50));
        add(panelIdioma, BorderLayout.CENTER);

        botonesIdioma[0].addActionListener(e -> {
            mIdiomas.setIdioma("es");
        });
        botonesIdioma[1].addActionListener(e -> {
            mIdiomas.setIdioma("en");
        });
        botonesIdioma[2].addActionListener(e -> {
            mIdiomas.setIdioma("pt");
        });
        botonesIdioma[3].addActionListener(e -> {
            mIdiomas.setIdioma("gl");
        });

        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mContr.setVistaActual("Configuracion");
            }
        });
    }

    public void update(Observable o, Object arg)
    {
        if(o.equals(mDalt))
        {
            super.update(o, arg);
        }else if(o.equals(mIdiomas)) {
            botonesIdioma[0].setEnabled(true);
            botonesIdioma[1].setEnabled(true);
            botonesIdioma[2].setEnabled(true);
            botonesIdioma[3].setEnabled(true);

            if (DatosSerialiazados.getInstancia().getIdioma().equals("es")) {
                botonActivo = botonesIdioma[0];
            } else if (DatosSerialiazados.getInstancia().getIdioma().equals("en")) {
                botonActivo = botonesIdioma[1];
            } else if (DatosSerialiazados.getInstancia().getIdioma().equals("pt")) {
                botonActivo = botonesIdioma[2];
            } else if (DatosSerialiazados.getInstancia().getIdioma().equals("gl")) {
                botonActivo = botonesIdioma[3];
            }
            botonActivo.setEnabled(false);
        }
    }
}

