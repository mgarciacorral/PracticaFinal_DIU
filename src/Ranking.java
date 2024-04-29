import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ranking extends Plantilla
{
    private JPanel panelLabel = new JPanel();
    private JLabel label = new JLabel();
    private JButton atras = new JButton();
    public Ranking()
    {
        setLayout(new BorderLayout());

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
        panelLabel.setBackground(colorFondo);
        panelLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        add(panelLabel, BorderLayout.NORTH);
        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                cl.show(ControladorGeneral.instancia.getContentPane(), "MenuPrincipal");
            }
        });

    }

    public void actualizarTexto()
    {
        label.setText(translate("Ranking"));
    }
}
