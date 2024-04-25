import javax.swing.*;
import java.awt.*;

import static java.awt.Transparency.TRANSLUCENT;

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
        botones[0] = new JButton();
        botones[1] = new JButton();
        botones[2] = new JButton();
        botones[3] = new JButton();
        add(Box.createHorizontalGlue());
        add(logo, BorderLayout.NORTH);
        for(int i=0; i<botones.length; i++){

            botones[i].setText("Boton " + i);
            botones[i].setFont(new Font("Showcard Gothic", Font.BOLD, 20));
            botones[i].setForeground(Color.decode("#75F94D"));
            botones[i].setHorizontalTextPosition(SwingConstants.CENTER);
            botones[i].setContentAreaFilled(false);
            botones[i].setBorderPainted(false);
            botones[i].setIcon(new ImageIcon("src/resources/red_button02.png"));
            botones[i].setAlignmentX(CENTER_ALIGNMENT);
            panelBoton.add(botones[i], CENTER_ALIGNMENT);
        }
        add(Box.createHorizontalGlue());
        panelBoton.setAlignmentY(Component.CENTER_ALIGNMENT);
        panelBoton.setOpaque(false);
        add(panelBoton, BorderLayout.CENTER);


    }

}
