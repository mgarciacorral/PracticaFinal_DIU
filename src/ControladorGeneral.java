import resources.Utiles.Serializador;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ControladorGeneral extends JFrame {
    static ControladorGeneral instancia = null;
    static String idioma;
    static String modoDaltonico;
    private Clip musicaFondo;
    static Map<String, String> espanolIngles = new HashMap<>();
    static Map<String, String> espanolGallego = new HashMap<>();
    static Map<String, String> espanolPortugues = new HashMap<>();
    private Menu menuPrincipal;
    private MenuNiveles menuNiveles;
    private Ranking ranking;
    private Configuracion configuracion;
    private MenuIdioma menuIdioma;
    private MenuDaltonicos menuDaltonicos;
    private Login login;
    private DatosSerialiazados datos;
    private Tutorial tutorial;

    public ControladorGeneral(){
        instancia = this;
        datos.setInstancia(Serializador.deserialize("data.dat"));
        if(datos == null)
        {
            datos = DatosSerialiazados.getInstancia();
        }

        idioma = datos.getIdioma();
        modoDaltonico = datos.getModoDaltonico();

        setIdiomas();

        menuPrincipal = new Menu();
        login = new Login();
        menuNiveles = new MenuNiveles();
        ranking = new Ranking();
        configuracion = new Configuracion();
        menuIdioma = new MenuIdioma();
        menuDaltonicos = new MenuDaltonicos();
        tutorial = new Tutorial();

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

        if (datos.getSonido()) {
            startMusica();
        }

        add(menuPrincipal, "MenuPrincipal");
        add(menuNiveles, "MenuNiveles");
        add(ranking, "Ranking");
        add(configuracion, "Configuracion");
        add(menuIdioma, "MenuIdioma");
        add(menuDaltonicos, "MenuDaltonicos");
        add(login, "Login");
        add(tutorial, "Tutorial");

        setVisible(true);
    }

    public void actualizarTexto()
    {
        menuPrincipal.actualizarTexto();
        menuNiveles.actualizarTexto();
        ranking.actualizarTexto();
        configuracion.actualizarTexto();
        menuIdioma.actualizarTexto();
        menuDaltonicos.actualizarTexto();
        login.actualizarTexto();
        tutorial.actualizarTexto();
    }

    public void actualizarVista()
    {
        menuPrincipal.actualizarVista();
        menuNiveles.actualizarVista();
        ranking.actualizarVista();
        configuracion.actualizarVista();
        menuIdioma.actualizarVista();
        menuDaltonicos.actualizarVista();
        login.actualizarVista();
        tutorial.actualizarVista();
    }

    public void actualizarBotones()
    {
        menuIdioma.actualizarBotones();
        menuDaltonicos.actualizarBotones();
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

    private void setIdiomas()
    {
        espanolIngles.put("Jugar", "Play");
        espanolIngles.put("Ranking", "Ranking");
        espanolIngles.put("Configuracion", "Settings");
        espanolIngles.put("Salir", "Exit");
        espanolIngles.put("Niveles", "Levels");
        espanolIngles.put("Musica", "Music");
        espanolIngles.put("Musica: On", "Music: On");
        espanolIngles.put("Musica: Off", "Music: Off");
        espanolIngles.put("Idioma", "Language");
        espanolIngles.put("Predeterminado", "Default");
        espanolIngles.put("Selector Idioma", "Language Selector");
        espanolIngles.put("Español", "Spanish");
        espanolIngles.put("Ingles", "English");
        espanolIngles.put("Portugués", "Portuguese");
        espanolIngles.put("Gallego", "Galician");
        espanolIngles.put("Daltonico", "Colorblind");
        espanolIngles.put("Desactivado", "Disabled");
        espanolIngles.put("Deuteranopia", "Deuteranopia");
        espanolIngles.put("Protanopia", "Protanopia");
        espanolIngles.put("Tritanopia", "Tritanopia");
        espanolIngles.put("Daltonismo", "Colorblindness");
        espanolIngles.put("Usuario", "User");
        espanolIngles.put("Aceptar", "Accept");
        espanolIngles.put("No hay datos", "No data");
        espanolIngles.put("Tutorial", "Tutorial");
        espanolIngles.put("Como Jugar", "How to Play");
        espanolIngles.put("Bonificadores", "Boosters");
        espanolIngles.put("Creditos", "Credits");

        espanolPortugues.put("Jugar", "Jogar");
        espanolPortugues.put("Ranking", "Classificação");
        espanolPortugues.put("Configuracion", "Contexto");
        espanolPortugues.put("Salir", "Sair");
        espanolPortugues.put("Niveles", "Níveis");
        espanolPortugues.put("Musica", "Música");
        espanolPortugues.put("Musica: On", "Música: On");
        espanolPortugues.put("Musica: Off", "Música: Off");
        espanolPortugues.put("Idioma", "Linguagem");
        espanolPortugues.put("Predeterminado", "Predeterminado");
        espanolPortugues.put("Selector Idioma", "Seletor de Idioma");
        espanolPortugues.put("Español", "Espanhol");
        espanolPortugues.put("Ingles", "Inglês");
        espanolPortugues.put("Portugués", "Português");
        espanolPortugues.put("Gallego", "Galego");
        espanolPortugues.put("Daltonico", "Daltonico");
        espanolPortugues.put("Desactivado", "Desativado");
        espanolPortugues.put("Deuteranopia", "Deuteranopia");
        espanolPortugues.put("Protanopia", "Protanopia");
        espanolPortugues.put("Tritanopia", "Tritanopia");
        espanolPortugues.put("Daltonismo", "Daltonismo");
        espanolPortugues.put("Usuario", "Usuário");
        espanolPortugues.put("Aceptar", "Aceitar");
        espanolPortugues.put("No hay datos", "Não há dados");
        espanolPortugues.put("Tutorial", "Tutorial");
        espanolPortugues.put("Como Jugar", "Como Jogar");
        espanolPortugues.put("Bonificadores", "Bônus");
        espanolPortugues.put("Creditos", "Créditos");

        espanolGallego.put("Jugar", "Xogar");
        espanolGallego.put("Ranking", "Clasificacion");
        espanolGallego.put("Configuracion", "Configuración");
        espanolGallego.put("Salir", "Saia");
        espanolGallego.put("Niveles", "Niveis");
        espanolGallego.put("Musica", "Música");
        espanolGallego.put("Musica: On", "Música: On");
        espanolGallego.put("Musica: Off", "Música: Off");
        espanolGallego.put("Idioma", "Lingua");
        espanolGallego.put("Predeterminado", "Predeterminado");
        espanolGallego.put("Selector Idioma", "Selector de Lingua");
        espanolGallego.put("Español", "Español");
        espanolGallego.put("Ingles", "Ingles");
        espanolGallego.put("Portugués", "Portugués");
        espanolGallego.put("Gallego", "Galego");
        espanolGallego.put("Daltonico", "Daltonico");
        espanolGallego.put("Desactivado", "Desactivado");
        espanolGallego.put("Deuteranopia", "Deuteranopia");
        espanolGallego.put("Protanopia", "Protanopia");
        espanolGallego.put("Tritanopia", "Tritanopia");
        espanolGallego.put("Daltonismo", "Daltonismo");
        espanolGallego.put("Usuario", "Usuario");
        espanolGallego.put("Aceptar", "Aceptar");
        espanolGallego.put("No hay datos", "Non hai datos");
        espanolGallego.put("Tutorial", "Tutorial");
        espanolGallego.put("Como Jugar", "Como Xogar");
        espanolGallego.put("Bonificadores", "Bonificadores");
        espanolGallego.put("Creditos", "Créditos");
    }

    public static String translate(String key){
        if(idioma.equals("en")){
            if(espanolIngles.get(key) == null){
                return key;
            }
            return espanolIngles.get(key);
        }
        else if(idioma.equals("pt")){
            if(espanolPortugues.get(key) == null){
                return key;
            }
            return espanolPortugues.get(key);
        }
        else if(idioma.equals("gl")){
            if(espanolGallego.get(key) == null){
                return key;
            }
            return espanolGallego.get(key);
        }
        else{
            return key;
        }
    }

    public MenuNiveles getMenuNiveles()
    {
        return menuNiveles;
    }

    public void cambiarModoDaltonico()
    {
        if(modoDaltonico.equals("deuteranopia"))
        {
            menuDaltonicos.setDeuteranopia();
        }
        else if(modoDaltonico.equals("protanopia"))
        {
            menuDaltonicos.setProtanopia();
        }
        else if(modoDaltonico.equals("tritanopia"))
        {
            menuDaltonicos.setTritanopia();
        }
        else
        {
            menuDaltonicos.setDesactivado();
        }
    }
}
