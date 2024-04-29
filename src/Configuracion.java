import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Configuracion  extends Plantilla
{
    private JPanel panelLabel = new JPanel();
    private JLabel label = new JLabel("Configuracion");
    private JButton atras = new JButton();
    private JPanel panelBotones = new JPanel();
    private JButton[] botones = new JButton[4];
    private boolean sonido = true;
    public Configuracion()
    {
        setLayout(new BorderLayout());

        atras.setIcon(botonAtras);
        atras.setContentAreaFilled(false);
        atras.setBorderPainted(false);
        atras.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        label.setFont(new Font("Showcard Gothic", Font.BOLD, 45));
        label.setForeground(colorLabel);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 45));

        panelLabel.setLayout(new BorderLayout());
        panelLabel.add(label, BorderLayout.CENTER);
        panelLabel.add(atras, BorderLayout.WEST);
        panelLabel.setBackground(colorFondo);
        panelLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 70, 0));

        add(panelLabel, BorderLayout.NORTH);
        panelBotones.setLayout(new GridLayout(4,1));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panelBotones.setOpaque(false);
        botones[0] = new JButton("Sonido");
        botones[1] = new JButton("Daltónico");
        botones[2] = new JButton("Idioma");
        botones[3] = new JButton("Predeterminado");
        for (int i = 0; i < botones.length; i++) {
            botones[i].setFont(new Font("Showcard Gothic", Font.BOLD, 15));
            botones[i].setForeground(colorLetraBoton);
            botones[i].setHorizontalTextPosition(SwingConstants.CENTER);
            botones[i].setContentAreaFilled(false);
            botones[i].setBorderPainted(false);
            botones[i].setIcon(botonNormal);
            botones[i].setAlignmentX(CENTER_ALIGNMENT);
            animacionPulsar(i);
            panelBotones.add(botones[i], CENTER_ALIGNMENT);
        }
        panelBotones.setBorder(BorderFactory.createEmptyBorder(0, botonNormal.getIconWidth()+50, 0, botonNormal.getIconWidth()+50));
        add(panelBotones, BorderLayout.CENTER);

        botones[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(sonido)
                {
                    sonido=false;
                    botones[0].setText("Sonido: Off");
                    ControladorGeneral.instancia.stopMusica();
                }
                else
                {
                    sonido=true;
                    botones[0].setText("Sonido: On");
                    ControladorGeneral.instancia.startMusica();
                }

            }
        });

        botones[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                cl.show(ControladorGeneral.instancia.getContentPane(), "MenuIdioma");
            }
        });

        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                cl.show(ControladorGeneral.instancia.getContentPane(), "MenuPrincipal");
            }
        });
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

    public void actualizarTexto()
    {
        label.setText(translate("Configuracion"));
        botones[0].setText(translate("Sonido"));
        botones[1].setText(translate("Daltónico"));
        botones[2].setText(translate("Idioma"));
        botones[3].setText(translate("Predeterminado"));
    }
}
