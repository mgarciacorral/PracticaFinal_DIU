import javax.swing.*;
import java.awt.*;

public class ControladorGeneral extends JFrame {
    static ControladorGeneral instancia = null;
    public ControladorGeneral(){
        instancia = this;
        setTitle("BreakOut");
        setIconImage(new ImageIcon("src/resources/logo.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 800);
        setResizable(false);
        setLayout(new CardLayout());
        Menu menuPrincipal = new Menu();
        MenuNiveles menuNiveles = new MenuNiveles();
        add(menuPrincipal);
        add(menuNiveles);

        setVisible(true);
    }

}
