import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuNiveles extends Plantilla {
    private VistaBotonNivel[] botones = new VistaBotonNivel[16];
    private JPanel panelBoton = new JPanel();
    private VistaBotonAtras atras;
    private JPanel panelLabel = new JPanel();
    private VistaLabel label;
    private Usuario user;
    private String[] semillasNiveles = {"110011002200110011002200110011","101010010101101010010101000000000000000000505505", "000000000110001111001111000111000011000001", "000000011000111100111100111000110000100000", "020020020020020020020020000000200002200002011110011110", "110011110011001100001100100001100001222222", "000033003300330000000022002200220000000011001100110000", "111111111111000000222222000000000000333333", "020000020000212020212020020212020212000020000020", "202020202020020202020202202020202020020202", "000000030030034430133331002200133331034430030030", "331133312213120021203302203302120021012210001100550055", "210012121121210012121121210012120021211112550055", "330033330033000000550555220022220022555055110011110011", "000000010101010101101010101010000000232323343434505050", "444444400044350533350533250522150511150511550555"};

    public MenuNiveles(ModeloDaltonicos mDalt, ModeloIdiomas mIdiomas, ModeloControladorGeneral mContr){
        super(mDalt, mIdiomas);

        panelBoton.setLayout(new GridLayout(4,4));
        panelBoton.setOpaque(false);
        panelBoton.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        setLayout(new BorderLayout());

        for(int i=0; i<botones.length;i++){
            botones[i] = new VistaBotonNivel(mDalt, String.valueOf(i+1));
            botones[i].setEnabled(false);
            panelBoton.add(botones[i]);
            botones[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new ControladorNivel(Integer.parseInt(((VistaBotonNivel)e.getSource()).getText()), user, semillasNiveles[Integer.parseInt(((VistaBotonNivel)e.getSource()).getText()) - 1], mDalt, mIdiomas, mContr);
                    mContr.setVisible(false);
                    if(DatosSerialiazados.getInstancia().getSonido())
                    {
                        mContr.musicaOff();
                    }
                }
            });
        }

        atras = new VistaBotonAtras(mDalt);
        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mContr.setVistaActual("MenuPrincipal");
            }
        });

        label = new VistaLabel(mDalt, mIdiomas, "Niveles");
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 45));

        panelLabel.setLayout(new BorderLayout());
        panelLabel.add(label, BorderLayout.CENTER);
        panelLabel.add(atras, BorderLayout.WEST);
        panelLabel.setOpaque(false);
        panelLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        add(panelBoton, BorderLayout.CENTER);
        add(panelLabel, BorderLayout.NORTH);
    }

    public void activarNiveles()
    {
        desactivarNiveles();
        for (int i = 0; i < user.getNiveles(); i++) {
            if(i<16){
                botones[i].setEnabled(true);
            }
        }
    }

    public void desactivarNiveles(){
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(false);
        }
    }

    public void setUser(Usuario user){
        if(DatosSerialiazados.getInstancia().getUsuarios().contains(user)) {
            this.user = DatosSerialiazados.getInstancia().getUsuarios().get(DatosSerialiazados.getInstancia().getUsuarios().indexOf(user));
        }else{
            this.user = user;
        }
    }
}
