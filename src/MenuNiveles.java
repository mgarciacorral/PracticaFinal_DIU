import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuNiveles extends Plantilla{
    private JButton[] botones = new JButton[16];
    public MenuNiveles(){
        setLayout(new GridLayout(4, 4));
        for(int i=0; i<=botones.length;i++){
            botones[i].setText(String.valueOf(i));
            botones[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                }
            });
            add(botones[i]);
        }



    }

}
