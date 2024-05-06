import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class Tutorial extends Plantilla{
    private JPanel panelLabel = new JPanel();
    private VistaLabel label;
    private VistaBotonAtras atras;
    private JTabbedPane panelTexto = new JTabbedPane();
    private VistaTabAyuda[] textArea = new VistaTabAyuda[3];
    private String textoComoJugar = "Tutorial:\n\n-El objetivo del juego es romper todos los bloques de la pantalla\n con la bola.\n\n-Para mover la pala, utiliza las flechas izquierda y derecha del\n teclado o arrastrala con el raton.\n\n-El juego cuenta con bonificadores que caeran aleatoriamente al romper\n un bloque, puede ser bueno o perjudicial. Consular en pestaña: Bonificadores.\n\n-Si la bola cae al suelo, perderas una vida.\n\n-Si rompes todos los bloques, pasaras al siguiente nivel.\n\n-Si pierdes todas las vidas, perderas la partida.";
    private String textoBonificadores = "";
    private String textoCreditos = "Creditos:\n\n-Desarrollado por:\n -Matias Garcia Corral\n -Diego Garcia Santos\n -Andres Garcia De Pablos\n -Laura Bertolo Gomez\n -Daniel Diaz Pache\n\n-Testers:\n -Alonso Martin Diez {Jugabilidad}\n -Gianluca Spalina {Jugabilidad}\n -Alonso Castro Hernandez {Jugabilidad}\n -Samuel Jadelegend {Daltonismo (Daltonico diagnosticado)}\n\n\n-Gracias por jugar a nuestro juego.";
    private String[] texto = {textoComoJugar, textoBonificadores, textoCreditos};

    public Tutorial(ModeloDaltonicos mDalt, ModeloIdiomas mIdiomas, ModeloControladorGeneral mContr){
        super(mDalt, mIdiomas);
        setLayout(new BorderLayout());

        atras = new VistaBotonAtras(mDalt);

        label = new VistaLabel(mDalt, mIdiomas, "Ayuda");
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 45));

        panelLabel.setLayout(new BorderLayout());
        panelLabel.add(label, BorderLayout.CENTER);
        panelLabel.add(atras, BorderLayout.WEST);
        panelLabel.setOpaque(false);
        panelLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 70, 0));

        add(panelLabel, BorderLayout.NORTH);

        for (int i = 0; i < textArea.length; i++) {
            textArea[i] = new VistaTabAyuda(mDalt, mIdiomas, texto[i]);
        }
        panelTexto.add(mIdiomas.translate("Como Jugar"), textArea[0]);
        panelTexto.add(mIdiomas.translate("Bonificadores"), textArea[1]);
        panelTexto.add(mIdiomas.translate("Creditos"), textArea[2]);

        panelTexto.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        panelTexto.setBackground(Color.GRAY);
        add(panelTexto, BorderLayout.CENTER);

        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mContr.setVistaActual("Configuracion");
            }
        });


    }
    public void update(Observable o, Object arg) {
        super.update(o, arg);
        panelTexto.add(mIdiomas.translate("Como Jugar"), textArea[0]);
        panelTexto.add(mIdiomas.translate("Bonificadores"), textArea[1]);
        panelTexto.add(mIdiomas.translate("Creditos"), textArea[2]);
    }
}
