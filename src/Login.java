import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends Plantilla{

    private JPanel panelLabel = new JPanel();
    private JLabel label = new JLabel(translate("Login"));
    private JButton atras = new JButton();
    private JTextField usuario = new JTextField();
    private JButton submit = new JButton();
    private JPanel panelAtras = new JPanel();


    public Login(){
        setLayout(new GridLayout(3, 1));

        panelAtras.setLayout(new BorderLayout());
        panelAtras.setOpaque(false);

        atras.setIcon(botonAtras);
        atras.setContentAreaFilled(false);
        atras.setBorderPainted(false);
        atras.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
        atras.setVerticalAlignment(SwingConstants.TOP);
        panelAtras.add(atras, BorderLayout.WEST);
        add(panelAtras);


        panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.Y_AXIS));
        panelLabel.add(label);
        label.setForeground(colorLabel);
        label.setFont(new Font("Showcard Gothic", Font.BOLD, 45));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 45));
        label.setOpaque(false);

        usuario.setOpaque(false);
        usuario.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
        usuario.setPreferredSize(new Dimension(100, 20));
        usuario.setToolTipText(translate("Introduce Usuario"));
        usuario.setHorizontalAlignment(SwingConstants.CENTER);
        panelLabel.setOpaque(false);

        panelLabel.add(usuario);


        submit.setText(translate("Submit"));
        submit.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
        submit.setForeground(colorLetraBoton);
        submit.setHorizontalTextPosition(SwingConstants.CENTER);
        submit.setContentAreaFilled(false);
        submit.setBorderPainted(false);
        submit.setIcon(botonNormal);
        submit.setAlignmentX(CENTER_ALIGNMENT);
        submit.setOpaque(false);
        submit.setBorder(BorderFactory.createEmptyBorder(0, 100, 30, 0));


        animacionPulsar();
        panelLabel.add(submit);

        add(panelLabel, BorderLayout.CENTER);


        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                cl.show(ControladorGeneral.instancia.getContentPane(), "MenuPrincipal");
            }
        });

    }

    public void animacionPulsar()
    {
        submit.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                submit.setIcon(botonPulsado);
                new Thread(new Runnable() {
                    public void run() {
                        sonidoBoton.setFramePosition(0);
                        sonidoBoton.start();
                    }
                }).start();
            }
                public void mouseEntered(MouseEvent e) {
                    submit.setIcon(botonHover);
                }

                public void mouseExited(MouseEvent e) {
                    submit.setIcon(botonNormal);
                }

                public void mouseReleased(MouseEvent e) {
                    submit.setIcon(botonNormal);
                }
        });
    }
}

