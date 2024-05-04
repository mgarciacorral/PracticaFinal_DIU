import resources.Utiles.Serializador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

public class Menu extends Plantilla{
    private JLabel logo = new JLabel();
    private JPanel panelBoton = new JPanel();
    private VistaBotonNormal[] botones = new VistaBotonNormal[4];

    public Menu(ModeloDaltonicos mDalt, ModeloIdiomas mIdiomas, ModeloControladorGeneral mContr){
        super(mDalt, mIdiomas);
        setLayout(new BorderLayout());

        logo.setIcon(new ImageIcon("src/resources/Imagenes/logo.png"));
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.setBorder(BorderFactory.createEmptyBorder(50, 0, 60, 0));

        panelBoton.setLayout(new GridLayout(5,1));
        panelBoton.setAlignmentX(CENTER_ALIGNMENT);

        botones[0] = new VistaBotonNormal(this.mDalt, mIdiomas, "Jugar");
        botones[1] = new VistaBotonNormal(this.mDalt, mIdiomas, "Ranking");
        botones[2] = new VistaBotonNormal(this.mDalt, mIdiomas, "Configuracion");
        botones[3] = new VistaBotonNormal(this.mDalt, mIdiomas, "Salir");

        for(int i=0; i<botones.length; i++){
            panelBoton.add(botones[i]);
        }

        add(Box.createHorizontalGlue());
        add(logo, BorderLayout.NORTH);

        panelBoton.setBorder(BorderFactory.createEmptyBorder(0, mDalt.getBotonNormal().getIconWidth()+50, 0, mDalt.getBotonNormal().getIconWidth()+50));
        panelBoton.setAlignmentY(Component.CENTER_ALIGNMENT);
        panelBoton.setOpaque(false);
        add(panelBoton, BorderLayout.CENTER);

        botones[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mContr.setVistaActual("Login");
            }
        });

        botones[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mContr.setVistaActual("Ranking");
            }
        });

        botones[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mContr.setVistaActual("Configuracion");
            }
        });

        botones[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Serializador.serialize(DatosSerialiazados.getInstancia(), "data.dat");
                System.exit(0);
            }
        });
    }
}
