import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

public class MenuNiveles extends Plantilla {
    private VistaBotonNivel[] botones = new VistaBotonNivel[16];
    private JPanel panelBoton = new JPanel();
    private VistaBotonAtras atras;
    private JPanel panelLabel = new JPanel();
    private VistaLabel label;
    private Usuario user;
    private String[] confNivel = {"11111111111111111111111000000000000011111111111", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};

    public MenuNiveles(ModeloDaltonicos mDalt, ModeloIdiomas mIdiomas, ModeloControladorGeneral mContr){
        super(mDalt, mIdiomas);

        panelBoton.setLayout(new GridLayout(4,4));
        panelBoton.setOpaque(false);
        panelBoton.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        setLayout(new BorderLayout());

        for(int i=0; i<botones.length;i++){
            botones[i] = new VistaBotonNivel(mDalt, String.valueOf(i+1));
            botones[i].setEnabled(false);
            panelBoton.add(botones[i]);
            botones[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new ControladorNivel(confNivel[Integer.parseInt(((VistaBotonNivel)e.getSource()).getText()) - 1], mDalt, mIdiomas, mContr);
                    mContr.setVisible(false);
                }
            });
        }

        atras = new VistaBotonAtras(mDalt);
        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mContr.setVistaActual("MenuPrincipal");
            }
        });

        label = new VistaLabel(mDalt, mIdiomas, "Niveles");
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 45));

        panelLabel.setLayout(new BorderLayout());
        panelLabel.add(label, BorderLayout.CENTER);
        panelLabel.add(atras, BorderLayout.WEST);
        panelLabel.setOpaque(false);
        panelLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        add(panelBoton, BorderLayout.CENTER);
        add(panelLabel, BorderLayout.NORTH);
    }

    public void activarNiveles()
    {
        for (int i = 0; i < user.getNiveles(); i++) {
            botones[i].setEnabled(true);
        }
    }

    public void setUser(Usuario user){
        if(DatosSerialiazados.getInstancia().getUsuarios().contains(user)) {
            this.user = DatosSerialiazados.getInstancia().getUsuarios().get(DatosSerialiazados.getInstancia().getUsuarios().indexOf(user));
        }else{
            this.user = user;
        }
    }
}
