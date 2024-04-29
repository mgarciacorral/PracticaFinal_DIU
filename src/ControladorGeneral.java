import com.sun.java.accessibility.util.Translator;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ControladorGeneral extends JFrame {
    static ControladorGeneral instancia = null;
    static String idioma = "es";
    private Clip musicaFondo;
    public ControladorGeneral(){
        instancia = this;
        setTitle("BreakOut");
        setIconImage(new ImageIcon("src/resources/Imagenes/logo2.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 800);
        setResizable(false);
        setLayout(new CardLayout());

        try {
            musicaFondo = AudioSystem.getClip();
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/resources/Sonidos/musicafondo.wav"));
            musicaFondo.open(audio);
        } catch (Exception e) {
            e.printStackTrace();
        }

        startMusica();


        Menu menuPrincipal = new Menu();
        MenuNiveles menuNiveles = new MenuNiveles();
        Ranking ranking = new Ranking();
        Configuracion configuracion = new Configuracion();
        MenuIdioma menuIdioma = new MenuIdioma();

        add(menuPrincipal, "MenuPrincipal");
        add(menuNiveles, "MenuNiveles");
        add(ranking, "Ranking");
        add(configuracion, "Configuracion");
        add(menuIdioma, "MenuIdioma");

        setVisible(true);
    }
    public void startMusica(){
        new Thread(new Runnable() {
            public void run() {
                musicaFondo.loop(Clip.LOOP_CONTINUOUSLY);
                musicaFondo.start();
            }
        }).start();
    }
    public void stopMusica(){
        musicaFondo.stop();
    }
    public static String translate(String key){
        return Translator.getString(key, idioma);
    }

}
