import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Ranking extends Plantilla
{
    private JPanel panelLabel = new JPanel();
    private JLabel label = new JLabel();
    private JButton atras = new JButton();
    private JPanel panelRanking = new JPanel();
    private JPanel niveles = new JPanel();
    private JButton[] botones = new JButton[16];
    private JPanel contenedor = new JPanel();
    private ArrayList<Usuario> users;
    private boolean mostrandoRanking = false;

    public Ranking()
    {
        setLayout(new BorderLayout());

        actualizarInfo();

        label.setText(translate("Ranking"));

        atras.setIcon(botonAtras);
        atras.setContentAreaFilled(false);
        atras.setBorderPainted(false);
        atras.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        label.setFont(new Font("Showcard Gothic", Font.BOLD, 60));
        label.setForeground(colorLabel);
        label.setHorizontalAlignment(SwingConstants.CENTER);
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
            botones[i] = new JButton();
            botones[i].setText(String.valueOf(i+1));
            botones[i].setFont(new Font("Showcard Gothic", Font.BOLD, 30));
            botones[i].setForeground(colorLetraBoton);
            botones[i].setHorizontalTextPosition(SwingConstants.CENTER);
            botones[i].setContentAreaFilled(false);
            botones[i].setBorderPainted(false);
            botones[i].setIcon(botonNivel);
            niveles.add(botones[i]);
            animacionPulsar(i);
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
                    CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                    cl.show(ControladorGeneral.instancia.getContentPane(), "MenuPrincipal");
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

    public void actualizarVista()
    {
        super.actualizarVista();
        label.setForeground(colorLabel);
        atras.setIcon(botonAtras);
        for(int i=0; i<botones.length;i++){
            botones[i].setForeground(colorLetraBoton);
            botones[i].setIcon(botonNivel);
        }
    }

    public void actualizarTexto()
    {
        label.setText(translate("Ranking"));
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
            for (int i = 0; i < max; i++)
            {
                users.sort((u1, u2) -> u2.getPuntuacion(nivel) - u1.getPuntuacion(nivel));
                Usuario user = users.get(i);
                JLabel label = new JLabel();
                label.setText((i + 1) + ". " + user.getNombre() + " - " + user.getPuntuacion(nivel));
                label.setFont(new Font("Showcard Gothic", Font.BOLD, 30));
                label.setForeground(colorLetraBoton);
                label.setBackground(Color.WHITE);
                label.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
                panelRanking.add(label);
            }
        }
        else
        {
            JLabel label = new JLabel();
            label.setText(translate("No hay datos"));
            label.setFont(new Font("Showcard Gothic", Font.BOLD, 30));
            label.setForeground(colorLetraBoton);
            label.setBackground(Color.WHITE);
            label.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            panelRanking.add(label);
        }
    }

    public void animacionPulsar(int i)
    {
        botones[i].addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                botones[i].setIcon(botonNivelPulsado);
                new Thread(new Runnable() {
                    public void run() {
                        sonidoBoton.setFramePosition(0);
                        sonidoBoton.start();
                    }
                }).start();
            }

            public void mouseReleased(MouseEvent e) {
                botones[i].setIcon(botonNivel);
            }
        });
    }
}
