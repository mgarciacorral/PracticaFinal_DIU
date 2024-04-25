import javax.swing.*;
import java.awt.*;

public class ControladorGeneral extends JFrame {
    public ControladorGeneral(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 800);
        setResizable(false);
        setLayout(new CardLayout());
        Plantilla p = new Menu();
        add(p);
        setVisible(true);

    }
}
