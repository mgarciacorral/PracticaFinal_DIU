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
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.setBorder(BorderFactory.createEmptyBorder(50, 0, 60, 0));

        panelBoton.setLayout(new GridLayout(4,1));
        panelBoton.setAlignmentX(CENTER_ALIGNMENT);

        botones[0] = new JButton("Jugar");
        botones[1] = new JButton("Ranking");
        botones[2] = new JButton("Configuracion");
        botones[3] = new JButton("Salir");

        add(Box.createHorizontalGlue());
        add(logo, BorderLayout.NORTH);
        ImageIcon icono = new ImageIcon("src/resources/red_button01.png");

        for(int i=0; i<botones.length; i++){

            botones[i].setFont(new Font("Showcard Gothic", Font.BOLD, 20));
            botones[i].setForeground(Color.decode("#75F94D"));
            botones[i].setHorizontalTextPosition(SwingConstants.CENTER);
            botones[i].setContentAreaFilled(false);
            botones[i].setBorderPainted(false);
            botones[i].setIcon(icono);
            botones[i].setAlignmentX(CENTER_ALIGNMENT);
            animacionPulsar(i);
            panelBoton.add(botones[i], CENTER_ALIGNMENT);
        }


        panelBoton.setBorder(BorderFactory.createEmptyBorder(0, icono.getIconWidth()+50, 0, icono.getIconWidth()+50));
        panelBoton.setAlignmentY(Component.CENTER_ALIGNMENT);
        panelBoton.setOpaque(false);
        add(panelBoton, BorderLayout.CENTER);

        botones[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                cl.show(ControladorGeneral.instancia.getContentPane(), "MenuNiveles");
            }
        });

        botones[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                cl.show(ControladorGeneral.instancia.getContentPane(), "Ranking");
            }
        });

        botones[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                cl.show(ControladorGeneral.instancia.getContentPane(), "Configuracion");
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

            public void mouseEntered(MouseEvent e) {
                botones[i].setIcon(new ImageIcon("src/resources/red_button11.png"));
            }

            public void mouseExited(MouseEvent e) {
                botones[i].setIcon(new ImageIcon("src/resources/red_button01.png"));
            }

            public void mouseReleased(MouseEvent e) {
                botones[i].setIcon(new ImageIcon("src/resources/red_button01.png"));
            }
        });
    }

}
