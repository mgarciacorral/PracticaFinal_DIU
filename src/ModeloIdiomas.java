import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class ModeloIdiomas extends Observable
{
    private Map<String, String> espanolIngles = new HashMap<>();
    private Map<String, String> espanolGallego = new HashMap<>();
    private Map<String, String> espanolPortugues = new HashMap<>();

    public ModeloIdiomas()
    {
        crearDiccionarios();

    }

    public void setIdioma(String idioma)
    {
        DatosSerialiazados.getInstancia().setIdioma(idioma);
        notificar();
    }

    public void notificar()
    {
        setChanged();
        notifyObservers();
    }

    private void crearDiccionarios()
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
        espanolIngles.put("Ayuda", "Help");
        espanolIngles.put("Como Jugar", "How to Play");
        espanolIngles.put("Bonificadores", "Boosters");
        espanolIngles.put("Creditos", "Credits");
        espanolIngles.put("Tutorial:\n\n-El objetivo del juego es romper todos los bloques de la pantalla\n con la bola.\n\n-Para mover la pala, utiliza las flechas izquierda y derecha del\n teclado o arrastrala con el raton.\n\n-El juego cuenta con bonificadores que caeran aleatoriamente al romper\n un bloque, puede ser bueno o perjudicial. Consular en pestaña: Bonificadores.\n\n-Si la bola cae al suelo, perderas una vida.\n\n-Si rompes todos los bloques, pasaras al siguiente nivel.\n\n-Si pierdes todas las vidas, perderas la partida.", "Tutorial:\n\n-The objective of the game is to break all the blocks on the screen\n with the ball.\n\n-To move the paddle, use the left and right arrows on the\n keyboard or drag it with the mouse.\n\n-The game has boosters that will fall randomly when breaking\n a block, it can be good or harmful. Consult in tab: Boosters.\n\n-If the ball falls to the ground, you will lose a life.\n\n-If you break all the blocks, you will move on to the next level.\n\n-If you lose all lives, you will lose the game.");
        espanolIngles.put("Creditos:\n\n-Desarrollado por:\n -Matias Garcia Corral\n -Diego Garcia Santos\n -Andres Garcia De Pablos\n -Laura Bertolo Gomez\n -Daniel Diaz Pache\n\n-Testers:\n -Alonso Martin Diez {Jugabilidad}\n -Gianluca Spalina {Jugabilidad}\n -Alonso Castro Hernandez {Jugabilidad}\n -Samuel Jadelegend {Daltonismo (Daltonico diagnosticado)}\n\n\n-Gracias por jugar a nuestro juego.", "Credits:\n\n-Developed by:\n -Matias Garcia Corral\n -Diego Garcia Santos\n -Andres Garcia De Pablos\n -Laura Bertolo Gomez\n -Daniel Diaz Pache\n\n-Testers:\n -Alonso Martin Diez {Gameplay}\n -Gianluca Spalina {Gameplay}\n -Alonso Castro Hernandez {Gameplay}\n -Samuel Jadelegend {Colorblindness (Diagnosed colorblind)}\n\n\n-Thank you for playing our game.");
        espanolIngles.put("Bonificadores:\n\n-Al romper un bloque existe una probabilidad de que aparezca un bonificador,\n estos son bolas de distintos colores. Para Recogerlos bastará con que caigan\nen la pala.\nHay bonificadores positivos y negativos, son aleatorios asi que la única forma de\n saber qué bonificador ha tocado es recogiéndolo\n\nBonificadores Positivos:\n-Aumento del tamaño de la pala, así será más fácil dar a la bola\n-Suma 50 puntos, así podrás posicionarte en lo más alto de cada ranking\n-Recuperar vida, este bonificador solo aparecerá si se ha perdido una vida,\n será una segunda oportunidad\n-Cambio de música\n\nBonificadores Negativos:\n-Disminución de la pala, así será un poco más dificil acertar con las bolas\n-Resta 50 puntos, así podrás conseguir una puntuación negativa\n-Aumento de refuerzo, todos los bloques ganan un refuerzo haciendo que sea\nmás dificil terminar el nivel", "Bonuses:\n\n-When breaking a block there is a chance that a bonus will appear,\n these are balls of different colors. To Pick them up all you have to do is have\nthem fall on the shovel.\nThere are positive and negative bonuses, they are random so the only way to\n know which bonus you have touched is to pick it up\n\nPositive Bonuses:\n-Increase in the size of the shovel , so it will be easier to hit the ball\n-Add 50 points, so you can position yourself at the top of each ranking\n-Recover life, this bonus will only appear if a life has been lost,\n it will be a second chance\n\n-Music change\n\nNegative Bonuses:\n-Decrease in the paddle, so it will be a little more difficult to hit the balls\n-Subtract 50 points, so you can get a negative score\n-Increase reinforcement, all The blocks gain a boost making it\nmore difficult to finish the level");
        espanolIngles.put("Puntos: ", "Points: ");
        espanolIngles.put("Pulsa <Enter> para lanzar la bola o <Esc> para salir", "Press <Enter> to launch the ball or <Esc> to exit");
        espanolIngles.put("¡¡Has perdido!! <Enter> para volver al menu", "You lost!! <Enter> to return to the menu");
        espanolIngles.put("¡¡Has ganado!! <Enter> para volver al menu", "You won!! <Enter> to return to the menu");

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
        espanolPortugues.put("Ayuda", "Ajuda");
        espanolPortugues.put("Como Jugar", "Como Jogar");
        espanolPortugues.put("Bonificadores", "Bônus");
        espanolPortugues.put("Creditos", "Créditos");
        espanolPortugues.put("Tutorial:\n\n-El objetivo del juego es romper todos los bloques de la pantalla\n con la bola.\n\n-Para mover la pala, utiliza las flechas izquierda y derecha del\n teclado o arrastrala con el raton.\n\n-El juego cuenta con bonificadores que caeran aleatoriamente al romper\n un bloque, puede ser bueno o perjudicial. Consular en pestaña: Bonificadores.\n\n-Si la bola cae al suelo, perderas una vida.\n\n-Si rompes todos los bloques, pasaras al siguiente nivel.\n\n-Si pierdes todas las vidas, perderas la partida.", "Tutorial:\n\n-O objetivo do jogo é quebrar todos os blocos da tela\n com a bola.\n\n-Para mover a raquete, use as setas esquerda e direita no\n teclado ou arraste com o mouse.\n\n-O jogo tem bônus que cairão aleatoriamente ao quebrar\n um bloco, pode ser bom ou ruim. Consulte na guia: Bônus.\n\n-Se a bola cair no chão, você perderá uma vida.\n\n-Se você quebrar todos os blocos, passará para o próximo nível.\n\n-Se você perder todas as vidas, perderá o jogo.");
        espanolPortugues.put("Bonificadores:\n\n-Al romper un bloque existe una probabilidad de que aparezca un bonificador,\n estos son bolas de distintos colores. Para Recogerlos bastará con que caigan\nen la pala.\nHay bonificadores positivos y negativos, son aleatorios asi que la única forma de\n saber qué bonificador ha tocado es recogiéndolo\n\nBonificadores Positivos:\n-Aumento del tamaño de la pala, así será más fácil dar a la bola\n-Suma 50 puntos, así podrás posicionarte en lo más alto de cada ranking\n-Recuperar vida, este bonificador solo aparecerá si se ha perdido una vida,\n será una segunda oportunidad\n-Cambio de música\n\nBonificadores Negativos:\n-Disminución de la pala, así será un poco más dificil acertar con las bolas\n-Resta 50 puntos, así podrás conseguir una puntuación negativa\n-Aumento de refuerzo, todos los bloques ganan un refuerzo haciendo que sea\nmás dificil terminar el nivel", "Bônus:\n\n-Ao quebrar um bloco existe a chance de aparecer um bônus,\n são bolas de cores diferentes. Para pegá-los, tudo o que você precisa fazer é\ndeixá-los cair na pá.\nExistem bônus positivos e negativos, eles são aleatórios, então a única maneira\nde saber em qual bônus você tocou é pegá-lo\n\nPositivo Bônus:\n-Aumente o tamanho da pá, assim será mais fácil acertar a bola\n-Adicione 50 pontos, para poder se posicionar no topo de cada ranking\n-Recupere vida, esse bônus só irá aparecerá caso uma vida tenha sido perdida,\n será uma segunda chance\n\n-Mudança de música\n\nBônus negativos:\n-Diminuição na raquete, assim será um pouco mais difícil acertar as bolas\n -Subtraia 50 pontos, para obter uma pontuação negativa\n-Aumente o reforço, todos Os blocos ganham um impulso tornando\nmais difícil terminar o nível");
        espanolPortugues.put("Creditos:\n\n-Desarrollado por:\n -Matias Garcia Corral\n -Diego Garcia Santos\n -Andres Garcia De Pablos\n -Laura Bertolo Gomez\n -Daniel Diaz Pache\n\n-Testers:\n -Alonso Martin Diez {Jugabilidad}\n -Gianluca Spalina {Jugabilidad}\n -Alonso Castro Hernandez {Jugabilidad}\n -Samuel Jadelegend {Daltonismo (Daltonico diagnosticado)}\n\n\n-Gracias por jugar a nuestro juego.", "Créditos:\n\n-Desenvolvido por:\n -Matias Garcia Corral\n -Diego Garcia Santos\n -Andres Garcia De Pablos\n -Laura Bertolo Gomez\n -Daniel Diaz Pache\n\n-Testers:\n -Alonso Martin Diez {Jogabilidade}\n -Gianluca Spalina {Jogabilidade}\n -Alonso Castro Hernandez {Jogabilidade}\n -Samuel Jadelegend {Daltonismo (Daltonico diagnosticado)}\n\n\n-Obrigado por jogar o nosso jogo.");
        espanolPortugues.put("Puntos: ", "Pontos: ");
        espanolPortugues.put("Pulsa <Enter> para lanzar la bola o <Esc> para salir", "Pressione <Enter> para lançar a bola ou <Esc> para sair");
        espanolPortugues.put("¡¡Has perdido!! <Enter> para volver al menu", "Você perdeu!! <Enter> para voltar ao menu");
        espanolPortugues.put("¡¡Has ganado!! <Enter> para volver al menu", "Você ganhou!! <Enter> para voltar ao menu");

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
        espanolGallego.put("Ayuda", "Axuda");
        espanolGallego.put("Como Jugar", "Como Xogar");
        espanolGallego.put("Bonificadores", "Bonificadores");
        espanolGallego.put("Creditos", "Créditos");
        espanolGallego.put("Tutorial:\n\n-El objetivo del juego es romper todos los bloques de la pantalla\n con la bola.\n\n-Para mover la pala, utiliza las flechas izquierda y derecha del\n teclado o arrastrala con el raton.\n\n-El juego cuenta con bonificadores que caeran aleatoriamente al romper\n un bloque, puede ser bueno o perjudicial. Consular en pestaña: Bonificadores.\n\n-Si la bola cae al suelo, perderas una vida.\n\n-Si rompes todos los bloques, pasaras al siguiente nivel.\n\n-Si pierdes todas las vidas, perderas la partida.", "Tutorial:\n\n-O obxectivo do xogo é romper todos os bloques da pantalla\n coa bola.\n\n-Para mover a pala, utiliza as frechas esquerda e dereita do\n teclado ou arrastrala co rato.\n\n-O xogo conta con bonificadores que caeran aleatoriamente ao romper\n un bloque, pode ser bo ou perxudicial. Consultar en lapela: Bonificadores.\n\n-Se a bola cae ao chan, perderas unha vida.\n\n-Se rompes todos os bloques, pasaras ao seguinte nivel.\n\n-Se perdes todas as vidas, perderas a partida.");
        espanolGallego.put("Bonificadores:\n\n-Al romper un bloque existe una probabilidad de que aparezca un bonificador,\n estos son bolas de distintos colores. Para Recogerlos bastará con que caigan\nen la pala.\nHay bonificadores positivos y negativos, son aleatorios asi que la única forma de\n saber qué bonificador ha tocado es recogiéndolo\n\nBonificadores Positivos:\n-Aumento del tamaño de la pala, así será más fácil dar a la bola\n-Suma 50 puntos, así podrás posicionarte en lo más alto de cada ranking\n-Recuperar vida, este bonificador solo aparecerá si se ha perdido una vida,\n será una segunda oportunidad\n-Cambio de música\n\nBonificadores Negativos:\n-Disminución de la pala, así será un poco más dificil acertar con las bolas\n-Resta 50 puntos, así podrás conseguir una puntuación negativa\n-Aumento de refuerzo, todos los bloques ganan un refuerzo haciendo que sea\nmás dificil terminar el nivel", "Bonificacións:\n\n-Ao romper un bloque existe a posibilidade de que apareza unha bonificación,\n son bolas de cores diferentes. Para collelos só tes que facer que caian na pa.\nHai bonos positivos e negativos, son aleatorios polo que a única forma de\n saber cal é a bonificación que tocaches é collelo\n\nPositivo Bonificacións:\n-Aumenta o tamaño da pala, polo que será máis fácil golpear a pelota\n-Engade 50 puntos, para que poidas situarte na parte superior de cada\nclasificación\n-Recupera a vida, esta bonificación só será aparecer se se perdeu unha vida,\n será unha segunda oportunidade\n\n-Cambio de música\n\nBonificacións negativas:\n-Diminuír a paleta, polo que será un pouco máis difícil golpear as bolas\n -Resta 50 puntos, para que poidas obter unha puntuación negativa\n-Aumenta o reforzo, todos os bloques gañan un impulso facendo\nmáis difícil rematar o nivel");
        espanolGallego.put("Creditos:\n\n-Desarrollado por:\n -Matias Garcia Corral\n -Diego Garcia Santos\n -Andres Garcia De Pablos\n -Laura Bertolo Gomez\n -Daniel Diaz Pache\n\n-Testers:\n -Alonso Martin Diez {Jugabilidad}\n -Gianluca Spalina {Jugabilidad}\n -Alonso Castro Hernandez {Jugabilidad}\n -Samuel Jadelegend {Daltonismo (Daltonico diagnosticado)}\n\n\n-Gracias por jugar a nuestro juego.", "Creditos:\n\n-Desenvolvido por:\n -Matias Garcia Corral\n -Diego Garcia Santos\n -Andres Garcia De Pablos\n -Laura Bertolo Gomez\n -Daniel Diaz Pache\n\n-Testers:\n -Alonso Martin Diez {Xogabilidade}\n -Gianluca Spalina {Xogabilidade}\n -Alonso Castro Hernandez {Xogabilidade}\n -Samuel Jadelegend {Daltonismo (Daltonico diagnosticado)}\n\n\n-Grazas por xogar ao noso xogo.");
        espanolGallego.put("Puntos: ", "Puntos: ");
        espanolGallego.put("Pulsa <Enter> para lanzar la bola o <Esc> para salir", "Prema <Enter> para lanzar a bola ou <Esc> para sair");
        espanolGallego.put("¡¡Has perdido!! <Enter> para volver al menu", "Perdeches!! <Enter> para volver ao menú");
        espanolGallego.put("¡¡Has ganado!! <Enter> para volver al menu", "Gañaches!! <Enter> para volver ao menú");
    }

    public String translate(String key){
        if(DatosSerialiazados.getInstancia().getIdioma().equals("en")){
            if(espanolIngles.get(key) == null){
                return key;
            }
            return espanolIngles.get(key);
        }
        else if(DatosSerialiazados.getInstancia().getIdioma().equals("pt")){
            if(espanolPortugues.get(key) == null){
                return key;
            }
            return espanolPortugues.get(key);
        }
        else if(DatosSerialiazados.getInstancia().getIdioma().equals("gl")){
            if(espanolGallego.get(key) == null){
                return key;
            }
            return espanolGallego.get(key);
        }
        else{
            return key;
        }
    }
}
