import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuIdioma extends Plantilla{
    private JPanel panelIdioma = new JPanel();
    private JPanel panelLabel = new JPanel();
    private JButton[] botonesIdioma = new JButton[4];
    private JLabel label = new JLabel("Selector Idioma");
    private JButton atras = new JButton();
    private JButton botonActivo;
    public MenuIdioma()
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

        panelIdioma.setLayout(new GridLayout(4,1));
        panelIdioma.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panelIdioma.setOpaque(false);

        botonesIdioma[0] = new JButton("Español");
        botonesIdioma[1] = new JButton("Ingles");
        botonesIdioma[2] = new JButton("Portugués");
        botonesIdioma[3] = new JButton("Gallego");

        for (int i = 0; i < botonesIdioma.length; i++) {
            botonesIdioma[i].setFont(new Font("Showcard Gothic", Font.BOLD, 15));
            botonesIdioma[i].setForeground(colorLetraBoton);
            botonesIdioma[i].setHorizontalTextPosition(SwingConstants.CENTER);
            botonesIdioma[i].setContentAreaFilled(false);
            botonesIdioma[i].setBorderPainted(false);
            botonesIdioma[i].setIcon(botonNormal);
            botonesIdioma[i].setAlignmentX(CENTER_ALIGNMENT);
            animacionPulsar(i);
            panelIdioma.add(botonesIdioma[i], CENTER_ALIGNMENT);
        }

        botonActivo = botonesIdioma[0];
        botonActivo.setEnabled(false);

        panelIdioma.setBorder(BorderFactory.createEmptyBorder(0, botonNormal.getIconWidth()+50, 0, botonNormal.getIconWidth()+50));
        add(panelIdioma, BorderLayout.CENTER);

        botonesIdioma[0].addActionListener(e -> {
            ControladorGeneral.idioma = "es";
            ControladorGeneral.instancia.actualizarTexto();
            botonActivo.setEnabled(true);
            botonActivo = botonesIdioma[0];
            botonActivo.setEnabled(false);

        });
        botonesIdioma[1].addActionListener(e -> {
            ControladorGeneral.idioma = "en";
            ControladorGeneral.instancia.actualizarTexto();
            botonActivo.setEnabled(true);
            botonActivo = botonesIdioma[1];
            botonActivo.setEnabled(false);
        });
        botonesIdioma[2].addActionListener(e -> {
            ControladorGeneral.idioma = "pt";
            ControladorGeneral.instancia.actualizarTexto();
            botonActivo.setEnabled(true);
            botonActivo = botonesIdioma[2];
            botonActivo.setEnabled(false);
        });
        botonesIdioma[3].addActionListener(e -> {
            ControladorGeneral.idioma = "gl";
            ControladorGeneral.instancia.actualizarTexto();
            botonActivo.setEnabled(true);
            botonActivo = botonesIdioma[3];
            botonActivo.setEnabled(false);
        });

        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                cl.show(ControladorGeneral.instancia.getContentPane(), "Configuracion");
            }
        });
    }

    public void actualizarTexto()
    {
        label.setText(translate("Selector Idioma"));
        botonesIdioma[0].setText(translate("Español"));
        botonesIdioma[1].setText(translate("Ingles"));
        botonesIdioma[2].setText(translate("Portugués"));
        botonesIdioma[3].setText(translate("Gallego"));
    }

    public void animacionPulsar(int i)
    {
        botonesIdioma[i].addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                botonesIdioma[i].setIcon(botonPulsado);
                new Thread(new Runnable() {
                    public void run() {
                        sonidoBoton.setFramePosition(0);
                        sonidoBoton.start();
                    }
                }).start();
            }

            public void mouseEntered(MouseEvent e) {
                botonesIdioma[i].setIcon(botonHover);
            }

            public void mouseExited(MouseEvent e) {
                botonesIdioma[i].setIcon(botonNormal);
            }

            public void mouseReleased(MouseEvent e) {
                botonesIdioma[i].setIcon(botonNormal);
            }
        });
    }
}
