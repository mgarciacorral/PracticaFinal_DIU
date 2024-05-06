import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

public class Configuracion  extends Plantilla
{
    private JPanel panelLabel = new JPanel();
    private VistaLabel label;
    private VistaBotonAtras atras;
    private JPanel panelBotones = new JPanel();
    private VistaBotonNormal[] botones = new VistaBotonNormal[5];
    private boolean sonido;

    public Configuracion(ModeloDaltonicos mDalt, ModeloIdiomas mIdiomas, ModeloControladorGeneral mContr)
    {
        super(mDalt, mIdiomas);
        setLayout(new BorderLayout());

        atras = new VistaBotonAtras(mDalt);

        label = new VistaLabel(mDalt, mIdiomas, "Configuracion");
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 45));

        panelLabel.setLayout(new BorderLayout());
        panelLabel.add(label, BorderLayout.CENTER);
        panelLabel.add(atras, BorderLayout.WEST);
        panelLabel.setOpaque(false);
        panelLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 70, 0));

        add(panelLabel, BorderLayout.NORTH);
        panelBotones.setLayout(new GridLayout(5,1));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panelBotones.setOpaque(false);

        sonido = DatosSerialiazados.getInstancia().getSonido();
        if(sonido)
        {
            botones[0] = new VistaBotonNormal(mDalt, mIdiomas, "Musica: On");
        }
        else
        {
            botones[0] = new VistaBotonNormal(mDalt, mIdiomas, "Musica: Off");
        }
        botones[1] = new VistaBotonNormal(mDalt, mIdiomas, "Daltonismo");
        botones[2] = new VistaBotonNormal(mDalt, mIdiomas, "Idioma");
        botones[3] = new VistaBotonNormal(mDalt, mIdiomas, "Predeterminado");
        botones[4] = new VistaBotonNormal(mDalt, mIdiomas, "Ayuda");

        botones[3].setFont(new Font("Showcard Gothic", Font.BOLD, 15));

        for (int i = 0; i < botones.length; i++) {
            panelBotones.add(botones[i], CENTER_ALIGNMENT);
        }
        panelBotones.setBorder(BorderFactory.createEmptyBorder(0, mDalt.getBotonNormal().getIconWidth()+50, 0, mDalt.getBotonNormal().getIconWidth()+50));
        add(panelBotones, BorderLayout.CENTER);

        botones[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(sonido)
                {
                    sonido=false;
                    botones[0].setText("Musica: Off");
                }
                else
                {
                    sonido=true;
                    botones[0].setText("Musica: On");
                }
                DatosSerialiazados.getInstancia().setSonido(sonido);
                mContr.controlarMusica();
            }
        });

        botones[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mContr.setVistaActual("MenuDaltonicos");
            }
        });

        botones[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mContr.setVistaActual("MenuIdioma");
            }
        });

        botones[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sonido = true;
                DatosSerialiazados.getInstancia().setSonido(true);
                mContr.controlarMusica();
                mDalt.setModoDaltonico("desactivado");
                mIdiomas.setIdioma("es");
                botones[0].setText("Musica: On");
            }
        });

        botones[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mContr.setVistaActual("Tutorial");
            }
        });

        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mContr.setVistaActual("MenuPrincipal");
            }
        });

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    atras.doClick();
                }
            }
        });
    }
}
