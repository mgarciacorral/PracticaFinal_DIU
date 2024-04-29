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

public class MenuNiveles extends Plantilla{
    private JButton[] botones;
    private JPanel panelBoton = new JPanel();
    private JButton atras = new JButton();
    private JPanel panelLabel = new JPanel();
    private JLabel label = new JLabel(translate("Niveles"));
    private Usuario user;

    public MenuNiveles(){
        botones = new JButton[16];
        panelBoton.setLayout(new GridLayout(4,4));
        panelBoton.setOpaque(false);
        panelBoton.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        setLayout(new BorderLayout());

        for(int i=0; i<botones.length;i++){
            botones[i] = new JButton();
            botones[i].setText(String.valueOf(i+1));
            botones[i].setFont(new Font("Showcard Gothic", Font.BOLD, 30));
            botones[i].setForeground(colorLetraBoton);
            botones[i].setHorizontalTextPosition(SwingConstants.CENTER);
            botones[i].setContentAreaFilled(false);
            botones[i].setBorderPainted(false);
            botones[i].setIcon(botonNivel);
            botones[i].setEnabled(false);
            panelBoton.add(botones[i]);
            animacionPulsar(i);
        }

        atras.setIcon(botonAtras);
        atras.setContentAreaFilled(false);
        atras.setBorderPainted(false);
        atras.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                cl.show(ControladorGeneral.instancia.getContentPane(), "MenuPrincipal");
            }
        });

        panelLabel.setLayout(new BorderLayout());
        panelLabel.add(label, BorderLayout.CENTER);
        panelLabel.add(atras, BorderLayout.WEST);
        label.setFont(new Font("Showcard Gothic", Font.BOLD, 60));
        label.setForeground(colorLabel);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 45));
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

    public void actualizarVista()
    {
        super.actualizarVista();
        label.setForeground(colorLabel);
        for(int i=0; i<botones.length;i++){
            botones[i].setForeground(colorLetraBoton);
            botones[i].setIcon(botonNivel);
        }
        atras.setIcon(botonAtras);
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

    public void actualizarTexto()
    {
        label.setText(translate("Niveles"));
    }

    public void setUser(Usuario user){
        this.user = user;
    }

}
