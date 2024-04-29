import resources.Utiles.Serializador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Menu extends Plantilla{
    private JLabel logo = new JLabel();
    private JButton[] botones = new JButton[4];
    private JPanel panelBoton = new JPanel();

    public Menu(){
        setLayout(new BorderLayout());

        logo.setIcon(new ImageIcon("src/resources/Imagenes/logo.png"));
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.setBorder(BorderFactory.createEmptyBorder(50, 0, 60, 0));

        panelBoton.setLayout(new GridLayout(4,1));
        panelBoton.setAlignmentX(CENTER_ALIGNMENT);

        botones[0] = new JButton(translate("Jugar"));
        botones[1] = new JButton(translate("Ranking"));
        botones[2] = new JButton(translate("Configuracion"));
        botones[3] = new JButton(translate("Salir"));


        add(Box.createHorizontalGlue());
        add(logo, BorderLayout.NORTH);

        for(int i=0; i<botones.length; i++){

            botones[i].setFont(new Font("Showcard Gothic", Font.BOLD, 20));
            botones[i].setForeground(colorLetraBoton);
            botones[i].setHorizontalTextPosition(SwingConstants.CENTER);
            botones[i].setContentAreaFilled(false);
            botones[i].setBorderPainted(false);
            botones[i].setIcon(botonNormal);
            botones[i].setAlignmentX(CENTER_ALIGNMENT);
            animacionPulsar(i);
            panelBoton.add(botones[i], CENTER_ALIGNMENT);
        }


        panelBoton.setBorder(BorderFactory.createEmptyBorder(0, botonNormal.getIconWidth()+50, 0, botonNormal.getIconWidth()+50));
        panelBoton.setAlignmentY(Component.CENTER_ALIGNMENT);
        panelBoton.setOpaque(false);
        add(panelBoton, BorderLayout.CENTER);

        botones[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                cl.show(ControladorGeneral.instancia.getContentPane(), "MenuNiveles");
            }
        });

        botones[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                cl.show(ControladorGeneral.instancia.getContentPane(), "Ranking");
            }
        });

        botones[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                cl.show(ControladorGeneral.instancia.getContentPane(), "Configuracion");
            }
        });

        botones[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Serializador.serialize(DatosSerialiazados.getInstancia(), "data.dat");
                System.exit(0);
            }
        });
    }

    public void actualizarVista()
    {
        super.actualizarVista();
        for(int i=0; i<botones.length; i++){

            botones[i].setForeground(colorLetraBoton);
            botones[i].setIcon(botonNormal);
        }
    }

    public void animacionPulsar(int i)
    {
        botones[i].addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                botones[i].setIcon(botonPulsado);
                new Thread(new Runnable() {
                    public void run() {
                        sonidoBoton.setFramePosition(0);
                        sonidoBoton.start();
                    }
                }).start();
            }

            public void mouseEntered(MouseEvent e) {
                botones[i].setIcon(botonHover);
            }

            public void mouseExited(MouseEvent e) {
                botones[i].setIcon(botonNormal);
            }

            public void mouseReleased(MouseEvent e) {
                botones[i].setIcon(botonNormal);
            }
        });
    }

    public void actualizarTexto(){
        botones[0].setText(translate("Jugar"));
        botones[1].setText(translate("Ranking"));
        botones[2].setText(translate("Configuracion"));
        botones[3].setText(translate("Salir"));
    }
}
