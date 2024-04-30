import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tutorial extends Plantilla{
    private JPanel panelLabel = new JPanel();
    private JLabel label = new JLabel("Tutorial");
    private JButton atras = new JButton();
    private JTabbedPane panelTexto = new JTabbedPane();
    private JTextArea[] textArea = new JTextArea[3];

    public Tutorial(){
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
        panelLabel.setOpaque(false);
        panelLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 70, 0));

        add(panelLabel, BorderLayout.NORTH);

        for (int i = 0; i < textArea.length; i++) {
            textArea[i] = new JTextArea();
            textArea[i].setFont(new Font("Showcard Gothic", Font.BOLD, 30));
            textArea[i].setForeground(colorLetraBoton);
            textArea[i].setOpaque(true);
            textArea[i].setEditable(false);
            textArea[i].setLineWrap(false);
            textArea[i].setWrapStyleWord(true);
            textArea[i].setBorder(BorderFactory.createEmptyBorder(50, 50, 0, 50));
            textArea[i].setBackground(colorFondo);
        }

        actualizarTexto();

        panelTexto.addTab(translate("Como Jugar"), textArea[0]);
        panelTexto.addTab(translate("Bonificadores"), textArea[1]);
        panelTexto.addTab(translate("Creditos"), textArea[2]);
        panelTexto.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        panelTexto.setBackground(Color.GRAY);
        add(panelTexto, BorderLayout.CENTER);

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
        for (int i = 0; i < textArea.length; i++) {
            textArea[i].setForeground(colorLetraBoton);
            textArea[i].setBackground(colorFondo);
        }
        label.setForeground(colorLabel);
        atras.setIcon(botonAtras);
    }

    public void actualizarTexto()
    {
        label.setText(translate("Tutorial"));
        textArea[0].setText(translate("Como Jugar"));
        textArea[1].setText(translate("Bonificadores"));
        textArea[2].setText(translate("Creditos"));
    }

}
