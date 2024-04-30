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
    private JButton botonActivo = new JButton();

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
            textArea[i].setText("Tutorial");
            textArea[i].setFont(new Font("Showcard Gothic", Font.BOLD, 15));
            textArea[i].setForeground(colorLetraBoton);
            textArea[i].setOpaque(true);
            textArea[i].setEditable(false);
            textArea[i].setLineWrap(false);
            textArea[i].setWrapStyleWord(true);
            textArea[i].setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
            textArea[i].setBackground(colorFondo);
            panelTexto.addTab("Tutorial "+(i+1), textArea[i]);
        }
        panelTexto.setBackground(colorFondo); //AQUI HAY QUE PONER OTRO COLOR PARA QUE QUEDE BONITO, ES EL COLOR DE LAS PESTAÑAS NO SELECCIONADAS
        add(panelTexto, BorderLayout.CENTER);




        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                cl.show(ControladorGeneral.instancia.getContentPane(), "Configuracion");
            }
        });
    }



    public void actualizarTexto()
    {
        label.setText(translate("Tutorial"));
    }

}
