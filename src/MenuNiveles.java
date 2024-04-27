import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuNiveles extends Plantilla{
    private JButton[] botones;
    private JPanel panelBoton = new JPanel();
    private JButton atras = new JButton();
    private JPanel panelLabel = new JPanel();
    private JLabel label = new JLabel("Niveles");
    public MenuNiveles(){
        botones = new JButton[16];
        panelBoton.setLayout(new GridLayout(4,4));
        panelBoton.setBackground(Color.decode("#475C8D"));
        panelBoton.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        setLayout(new BorderLayout());

        for(int i=0; i<botones.length;i++){
            botones[i] = new JButton();
            botones[i].setText(String.valueOf(i+1));
            botones[i].setFont(new Font("Showcard Gothic", Font.BOLD, 30));
            botones[i].setForeground(Color.decode("#75F94D"));
            botones[i].setHorizontalTextPosition(SwingConstants.CENTER);
            botones[i].setContentAreaFilled(false);
            botones[i].setBorderPainted(false);
            botones[i].setIcon(new ImageIcon("src/resources/red_button06.png"));
            panelBoton.add(botones[i]);
            animacionPulsar(i);
        }

        atras.setIcon(new ImageIcon("src/resources/red_sliderLeft.png"));
        atras.setForeground(Color.decode("#75F94D"));
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
        label.setForeground(Color.decode("#75F94D"));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 45));
        panelLabel.setBackground(Color.decode("#475C8D"));
        panelLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        add(panelBoton, BorderLayout.CENTER);
        add(panelLabel, BorderLayout.NORTH);
    }

    public void animacionPulsar(int i)
    {
        botones[i].addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                botones[i].setIcon(new ImageIcon("src/resources/red_button07.png"));
            }

            public void mouseReleased(MouseEvent e) {
                botones[i].setIcon(new ImageIcon("src/resources/red_button06.png"));
            }
        });
    }

}
