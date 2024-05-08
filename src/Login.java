import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Login extends Plantilla{

    private JPanel panelLabel = new JPanel();
    private VistaLabel label;
    private VistaBotonAtras atras;
    private JTextField usuario = new JTextField();
    private VistaBotonNormal submit;
    private JPanel panelAtras = new JPanel();
    private JPanel panelUsuario = new JPanel();

    public Login(ModeloDaltonicos mDalt, ModeloIdiomas mIdiomas, ModeloControladorGeneral mContr){
        super(mDalt, mIdiomas);
        setLayout(new GridLayout(3, 1));

        panelAtras.setLayout(new BorderLayout());
        panelAtras.setOpaque(false);

        atras = new VistaBotonAtras(mDalt);

        panelAtras.add(atras, BorderLayout.WEST);
        add(panelAtras);


        panelLabel.setLayout(new GridLayout(3, 1));

        label = new VistaLabel(mDalt, mIdiomas, "Usuario");

        submit = new VistaBotonNormal(mDalt, mIdiomas ,"Aceptar");
        submit.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        panelUsuario.setLayout(new BorderLayout());
        panelUsuario.setOpaque(false);
        panelUsuario.add(usuario, BorderLayout.CENTER);
        panelUsuario.setBorder(BorderFactory.createEmptyBorder(0, 150, 30, 150));

        usuario.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
        usuario.setPreferredSize(new Dimension(100, 20));
        usuario.setHorizontalAlignment(SwingConstants.CENTER);
        usuario.setBackground(Color.GRAY);

        panelLabel.setOpaque(false);
        panelLabel.add(label);
        panelLabel.add(panelUsuario);
        panelLabel.add(submit);

        add(panelLabel, BorderLayout.CENTER);

        usuario.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submit.doClick();
                }
            }
        });

        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mContr.setVistaActual("MenuPrincipal");
            }
        });

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(usuario.getText().length() > 0){
                    boolean encontrado = false;
                    for (Usuario user : DatosSerialiazados.getInstancia().getUsuarios()) {
                        if(user.getNombre().equalsIgnoreCase(usuario.getText())){
                            encontrado = true;
                            mContr.getMenuNiveles().setUser(user);
                            mContr.getMenuNiveles().activarNiveles();
                            mContr.setVistaActual("MenuNiveles");
                        }
                    }

                    if(!encontrado)
                    {
                        Usuario user = new Usuario();
                        user.setNombre(usuario.getText());
                        mContr.getMenuNiveles().setUser(user);
                        DatosSerialiazados.getInstancia().getUsuarios().add(user);
                        mContr.getMenuNiveles().activarNiveles();
                        mContr.setVistaActual("MenuNiveles");
                    }
                }
            }
        });
    }
}

