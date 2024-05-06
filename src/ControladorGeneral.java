import resources.Utiles.Serializador;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ControladorGeneral extends JFrame implements Observer {
    private Menu menuPrincipal;
    private MenuNiveles menuNiveles;
    private Ranking ranking;
    private Configuracion configuracion;
    private MenuIdioma menuIdioma;
    private MenuDaltonicos menuDaltonicos;
    private Login login;
    private DatosSerialiazados datos;
    private Tutorial tutorial;
    private ModeloDaltonicos mDalt;
    private ModeloIdiomas mIdioma;
    private ModeloControladorGeneral mContr;
    private ControladorNivel nivel;

    public ControladorGeneral(){
        setTitle("BreakOut");
        setIconImage(new ImageIcon("src/resources/Imagenes/logo2.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 800);
        setResizable(false);
        setLayout(new CardLayout());

        datos.setInstancia(Serializador.deserialize("data.dat"));
        if(datos == null)
        {
            datos = DatosSerialiazados.getInstancia();
        }

        mDalt = new ModeloDaltonicos();
        mIdioma = new ModeloIdiomas();
        mContr = new ModeloControladorGeneral();

        mContr.addObserver(this);

        menuPrincipal = new Menu(mDalt, mIdioma, mContr);
        login = new Login(mDalt, mIdioma, mContr);
        menuNiveles = new MenuNiveles(mDalt, mIdioma, mContr);
        ranking = new Ranking(mDalt, mIdioma, mContr);
        configuracion = new Configuracion(mDalt, mIdioma, mContr);
        menuIdioma = new MenuIdioma(mDalt, mIdioma, mContr);
        menuDaltonicos = new MenuDaltonicos(mDalt, mIdioma, mContr);
        tutorial = new Tutorial(mDalt, mIdioma, mContr);
        nivel = new ControladorNivel(mDalt, mIdioma, mContr);

        mContr.setMn(menuNiveles);
        mContr.setNivel(nivel);
        mDalt.setModoDaltonico(datos.getModoDaltonico());
        mIdioma.setIdioma(datos.getIdioma());

        add(menuPrincipal, "MenuPrincipal");
        add(menuNiveles, "MenuNiveles");
        add(ranking, "Ranking");
        add(configuracion, "Configuracion");
        add(menuIdioma, "MenuIdioma");
        add(menuDaltonicos, "MenuDaltonicos");
        add(login, "Login");
        add(tutorial, "Tutorial");
        add(nivel, "Nivel");

        setVisible(true);
    }

    public void update(Observable o, Object arg)
    {
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), mContr.getVistaActual());
    }

}
