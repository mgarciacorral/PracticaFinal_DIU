import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Login extends Plantilla{

    private JPanel panelLabel = new JPanel();
    private JLabel label = new JLabel(translate("Usuario"));
    private JButton atras = new JButton();
    private JTextField usuario = new JTextField();
    private JButton submit = new JButton();
    private JPanel panelAtras = new JPanel();
    private JPanel panelUsuario = new JPanel();

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


        panelLabel.setLayout(new GridLayout(3, 1));

        label.setForeground(colorLabel);
        label.setFont(new Font("Showcard Gothic", Font.BOLD, 45));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        label.setOpaque(false);

        panelUsuario.setLayout(new BorderLayout());
        panelUsuario.setOpaque(false);
        panelUsuario.add(usuario, BorderLayout.CENTER);
        panelUsuario.setBorder(BorderFactory.createEmptyBorder(0, 150, 30, 150));

        usuario.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
        usuario.setPreferredSize(new Dimension(100, 20));
        usuario.setHorizontalAlignment(SwingConstants.CENTER);
        usuario.setBackground(Color.GRAY);

        panelLabel.setOpaque(false);
        panelLabel.add(label);
        panelLabel.add(panelUsuario);
        panelLabel.add(submit);

        submit.setText(translate("Aceptar"));
        submit.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
        submit.setForeground(colorLetraBoton);
        submit.setHorizontalTextPosition(SwingConstants.CENTER);
        submit.setContentAreaFilled(false);
        submit.setBorderPainted(false);
        submit.setIcon(botonNormal);
        submit.setAlignmentX(CENTER_ALIGNMENT);
        submit.setOpaque(false);
        submit.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        animacionPulsar();

        add(panelLabel, BorderLayout.CENTER);

        usuario.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submit.doClick();
                }
            }
        });

        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                cl.show(ControladorGeneral.instancia.getContentPane(), "MenuPrincipal");
            }
        });

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(usuario.getText().length() > 0){
                    Usuario user = new Usuario();
                    user.setNombre(usuario.getText());
                    ControladorGeneral.instancia.getMenuNiveles().setUser(user);
                    DatosSerialiazados.getInstancia().getUsuarios().add(user);
                    ControladorGeneral.instancia.getMenuNiveles().activarNiveles();
                    CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                    cl.show(ControladorGeneral.instancia.getContentPane(), "MenuNiveles");
                }
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

    public void actualizarTexto(){
        label.setText(translate("Usuario"));
        submit.setText(translate("Aceptar"));
    }

    public void actualizarVista(){
        super.actualizarVista();
        label.setForeground(colorLabel);
        submit.setForeground(colorLetraBoton);
        submit.setIcon(botonNormal);
        atras.setIcon(botonAtras);
    }
}

