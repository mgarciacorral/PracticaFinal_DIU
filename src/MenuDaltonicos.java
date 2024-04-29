import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuDaltonicos extends Plantilla{
    private JPanel panelModos = new JPanel();
    private JPanel panelLabel = new JPanel();
    private JButton[] botonesModos = new JButton[4];
    private JLabel label = new JLabel("Daltonismo");
    private JButton atras = new JButton();
    private JButton botonActivo;
    public MenuDaltonicos()
    {
        setLayout(new BorderLayout());
        panelLabel.setLayout(new BorderLayout());

        atras.setIcon(botonAtras);
        atras.setContentAreaFilled(false);
        atras.setBorderPainted(false);
        atras.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        label.setFont(new Font("Showcard Gothic", Font.BOLD, 40));
        label.setForeground(colorLabel);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 45));

        panelLabel.add(atras, BorderLayout.WEST);
        panelLabel.add(label, BorderLayout.CENTER);
        panelLabel.setOpaque(false);
        panelLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        add(panelLabel, BorderLayout.NORTH);

        panelModos.setLayout(new GridLayout(4,1));
        panelModos.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panelModos.setOpaque(false);

        botonesModos[0] = new JButton(translate("Desactivado"));
        botonesModos[1] = new JButton(translate("Deuteranopia"));
        botonesModos[2] = new JButton(translate("Protanopia"));
        botonesModos[3] = new JButton(translate("Tritanopia"));

        for (int i = 0; i < botonesModos.length; i++) {
            botonesModos[i].setFont(new Font("Showcard Gothic", Font.BOLD, 15));
            botonesModos[i].setForeground(colorLetraBoton);
            botonesModos[i].setHorizontalTextPosition(SwingConstants.CENTER);
            botonesModos[i].setContentAreaFilled(false);
            botonesModos[i].setBorderPainted(false);
            botonesModos[i].setIcon(botonNormal);
            botonesModos[i].setAlignmentX(CENTER_ALIGNMENT);
            animacionPulsar(i);
            panelModos.add(botonesModos[i], CENTER_ALIGNMENT);
        }

        actualizarBotones();

        panelModos.setBorder(BorderFactory.createEmptyBorder(0, botonNormal.getIconWidth()+50, 0, botonNormal.getIconWidth()+50));
        add(panelModos, BorderLayout.CENTER);

        botonesModos[0].addActionListener(e -> {
            ControladorGeneral.modoDaltonico = "desactivado";
            DatosSerialiazados.getInstancia().setModoDaltonico("desactivado");
            setDesactivado();
            ControladorGeneral.instancia.actualizarVista();
            botonActivo.setEnabled(true);
            botonActivo = botonesModos[0];
            botonActivo.setEnabled(false);

        });
        botonesModos[1].addActionListener(e -> {
            ControladorGeneral.modoDaltonico = "deuteranopia";
            DatosSerialiazados.getInstancia().setModoDaltonico("deuteranopia");
            setDeuteranopia();
            ControladorGeneral.instancia.actualizarVista();
            botonActivo.setEnabled(true);
            botonActivo = botonesModos[1];
            botonActivo.setEnabled(false);

        });
        botonesModos[2].addActionListener(e -> {
            ControladorGeneral.modoDaltonico = "protanopia";
            DatosSerialiazados.getInstancia().setModoDaltonico("protanopia");
            setProtanopia();
            ControladorGeneral.instancia.actualizarVista();
            botonActivo.setEnabled(true);
            botonActivo = botonesModos[2];
            botonActivo.setEnabled(false);
        });

        botonesModos[3].addActionListener(e -> {
            ControladorGeneral.modoDaltonico = "tritanopia";
            DatosSerialiazados.getInstancia().setModoDaltonico("tritanopia");
            setTritanopia();
            ControladorGeneral.instancia.actualizarVista();
            botonActivo.setEnabled(true);
            botonActivo = botonesModos[3];
            botonActivo.setEnabled(false);

        });

        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                cl.show(ControladorGeneral.instancia.getContentPane(), "Configuracion");
            }
        });
    }

    public void actualizarVista()
    {
        super.actualizarVista();
        for (int i = 0; i < botonesModos.length; i++) {
            botonesModos[i].setForeground(colorLetraBoton);
            botonesModos[i].setIcon(botonNormal);
        }
        atras.setIcon(botonAtras);
        label.setForeground(colorLabel);
    }

    public void actualizarTexto()
    {
        label.setText(translate("Daltonismo"));
        botonesModos[0].setText(translate("Desactivado"));
        botonesModos[1].setText(translate("Deuteranopia"));
        botonesModos[2].setText(translate("Protanopia"));
        botonesModos[3].setText(translate("Tritanopia"));
    }

    public void actualizarBotones()
    {
        botonesModos[0].setEnabled(true);
        botonesModos[1].setEnabled(true);
        botonesModos[2].setEnabled(true);
        botonesModos[3].setEnabled(true);

        if(DatosSerialiazados.getInstancia().getModoDaltonico().equals("desactivado"))
        {
            botonActivo = botonesModos[0];
        }
        else if(DatosSerialiazados.getInstancia().getModoDaltonico().equals("deuteranopia"))
        {
            botonActivo = botonesModos[1];
        }
        else if(DatosSerialiazados.getInstancia().getModoDaltonico().equals("protanopia"))
        {
            botonActivo = botonesModos[2];
        }
        else if(DatosSerialiazados.getInstancia().getModoDaltonico().equals("tritanopia"))
        {
            botonActivo = botonesModos[3];
        }

        botonActivo.setEnabled(false);
    }
    public void animacionPulsar(int i)
    {
        botonesModos[i].addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                botonesModos[i].setIcon(botonPulsado);
                new Thread(new Runnable() {
                    public void run() {
                        sonidoBoton.setFramePosition(0);
                        sonidoBoton.start();
                    }
                }).start();
            }

            public void mouseEntered(MouseEvent e) {
                botonesModos[i].setIcon(botonHover);
            }

            public void mouseExited(MouseEvent e) {
                botonesModos[i].setIcon(botonNormal);
            }

            public void mouseReleased(MouseEvent e) {
                botonesModos[i].setIcon(botonNormal);
            }
        });
    }
}
