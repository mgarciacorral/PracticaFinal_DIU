import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends Plantilla{
    private JLabel logo = new JLabel();
    private JButton[] botones = new JButton[4];
    JPanel panelBoton = new JPanel();

    public Menu(){
        setLayout(new BorderLayout());
        logo.setIcon(new ImageIcon("src/resources/logo.png"));
        logo.setBorder(BorderFactory.createEmptyBorder(20, 55, 0, 50));
        panelBoton.setLayout(new BoxLayout(panelBoton, BoxLayout.Y_AXIS));
        panelBoton.setAlignmentX(CENTER_ALIGNMENT);
        botones[0] = new JButton("Jugar");
        botones[1] = new JButton("Puntuajes");
        botones[2] = new JButton("Configuracion");
        botones[3] = new JButton("Salir");
        add(Box.createHorizontalGlue());
        add(logo, BorderLayout.NORTH);
        for(int i=0; i<botones.length; i++){
            botones[i].setFont(new Font("Showcard Gothic", Font.BOLD, 20));
            botones[i].setForeground(Color.decode("#75F94D"));
            botones[i].setHorizontalTextPosition(SwingConstants.CENTER);
            botones[i].setContentAreaFilled(false);
            botones[i].setBorderPainted(false);
            botones[i].setIcon(new ImageIcon("src/resources/red_button01.png"));
            botones[i].setAlignmentX(CENTER_ALIGNMENT);
            panelBoton.add(botones[i], CENTER_ALIGNMENT);
            animacionPulsar(i);
        }

        add(Box.createHorizontalGlue());
        panelBoton.setAlignmentY(Component.CENTER_ALIGNMENT);
        panelBoton.setOpaque(false);
        add(panelBoton, BorderLayout.CENTER);

        botones[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                cl.next(ControladorGeneral.instancia.getContentPane());
            }
        });

        botones[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        botones[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        botones[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void animacionPulsar(int i)
    {
        botones[i].addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                botones[i].setIcon(new ImageIcon("src/resources/red_button02.png"));
            }

            public void mouseReleased(MouseEvent e) {
                botones[i].setIcon(new ImageIcon("src/resources/red_button01.png"));
            }
        });
    }

}
