import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Ranking extends Plantilla
{
    private JPanel panelLabel = new JPanel();
    private VistaLabel label;
    private VistaBotonAtras atras;
    private JPanel panelRanking = new JPanel();
    private JPanel niveles = new JPanel();
    private VistaBotonNivel[] botones = new VistaBotonNivel[16];
    private JPanel contenedor = new JPanel();
    private ArrayList<Usuario> users;
    private boolean mostrandoRanking = false;

    public Ranking(ModeloDaltonicos mDalt, ModeloIdiomas mIdiomas, ModeloControladorGeneral mContr)
    {
        super(mDalt, mIdiomas);
        setLayout(new BorderLayout());

        actualizarInfo();

        atras = new VistaBotonAtras(mDalt);

        label = new VistaLabel(mDalt, mIdiomas, "Ranking");
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 45));

        panelLabel.setLayout(new BorderLayout());
        panelLabel.add(label, BorderLayout.CENTER);
        panelLabel.add(atras, BorderLayout.WEST);
        panelLabel.setOpaque(false);
        panelLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        panelRanking.setLayout(new BoxLayout(panelRanking, BoxLayout.Y_AXIS));
        panelRanking.setOpaque(false);
        panelRanking.setBorder(BorderFactory.createEmptyBorder(70, 30, 0, 30));

        niveles.setLayout(new GridLayout(4, 4));
        niveles.setOpaque(false);
        niveles.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        for(int i=0; i<botones.length;i++){
            botones[i] = new VistaBotonNivel(mDalt, String.valueOf(i+1));
            niveles.add(botones[i]);
            botones[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int nivel = Integer.parseInt(((JButton) e.getSource()).getText()) - 1;
                    rellenarPanelRanking(nivel);
                    CardLayout cl = (CardLayout) contenedor.getLayout();
                    cl.show(contenedor, "Ranking");
                    mostrandoRanking = true;
                }
            });
        }

        contenedor.setLayout(new CardLayout());
        contenedor.setOpaque(false);
        contenedor.add(niveles, "Niveles");
        contenedor.add(panelRanking, "Ranking");

        add(panelLabel, BorderLayout.NORTH);
        add(contenedor, BorderLayout.CENTER);
        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!mostrandoRanking){
                    mContr.setVistaActual("MenuPrincipal");
                }
                else
                {
                    CardLayout cl = (CardLayout) contenedor.getLayout();
                    cl.show(contenedor, "Niveles");
                    mostrandoRanking = false;
                }
            }
        });

    }

    public void actualizarInfo()
    {
        users = DatosSerialiazados.getInstancia().getUsuarios();
    }

    public void rellenarPanelRanking(int nivel)
    {
        panelRanking.removeAll();
        int max = users.size() > 10 ? 10 : users.size();
        if (max > 0)
        {
            users.sort((u1, u2) -> u2.getPuntuacion(nivel) - u1.getPuntuacion(nivel));
            for (int i = 0; i < max; i++)
            {
                VistaLabel label = new VistaLabel(mDalt, mIdiomas, (i + 1) + ". " + users.get(i).getNombre() + " - " + users.get(i).getPuntuacion(nivel));
                label.setFont(new Font("Showcard Gothic", Font.BOLD, 30));
                label.setForeground(mDalt.getColorLetraBoton());
                label.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
                panelRanking.add(label);
            }
        }
        else
        {
            VistaLabel label = new VistaLabel(mDalt, mIdiomas, mIdiomas.translate("No hay datos"));
            label.setForeground(mDalt.getColorLetraBoton());
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            panelRanking.add(label);
        }
    }
}
