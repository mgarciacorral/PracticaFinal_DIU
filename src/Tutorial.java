import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tutorial extends Plantilla{
    private JPanel panelLabel = new JPanel();
    private JLabel label = new JLabel(translate("Ayuda"));
    private JButton atras = new JButton();
    private JTabbedPane panelTexto = new JTabbedPane();
    private JTextArea[] textArea = new JTextArea[3];
    private String textoComoJugar = "Tutorial:\n\n-El objetivo del juego es romper todos los bloques de la pantalla\n con la bola.\n\n-Para mover la pala, utiliza las flechas izquierda y derecha del\n teclado o arrastrala con el raton.\n\n-El juego cuenta con bonificadores que caeran aleatoriamente al romper\n un bloque, puede ser bueno o perjudicial. Consular en pestaña: Bonificadores.\n\n-Si la bola cae al suelo, perderas una vida.\n\n-Si rompes todos los bloques, pasaras al siguiente nivel.\n\n-Si pierdes todas las vidas, perderas la partida.";
    private String textoBonificadores = "";
    private String textoCreditos = "Creditos:\n\n-Desarrollado por:\n -Matias Garcia Corral\n -Diego Garcia Santos\n -Andres Garcia De Pablos\n -Laura Bertolo Gomez\n -Daniel Diaz Pache\n\n-Testers:\n -Alonso Martin Diez {Jugabilidad}\n -Gianluca Spalina {Jugabilidad}\n -Alonso Castro Hernandez {Jugabilidad}\n -Samuel Jadelegend {Daltonismo (Daltonico diagnosticado)}\n\n\n-Gracias por jugar a nuestro juego.";

    public Tutorial(){
        setLayout(new BorderLayout());

        atras.setIcon(botonAtras);
        atras.setContentAreaFilled(false);
        atras.setBorderPainted(false);
        atras.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        label.setFont(new Font("Showcard Gothic", Font.BOLD, 45));
        label.setForeground(colorLabel);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 45));

        panelLabel.setLayout(new BorderLayout());
        panelLabel.add(label, BorderLayout.CENTER);
        panelLabel.add(atras, BorderLayout.WEST);
        panelLabel.setOpaque(false);
        panelLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 70, 0));

        add(panelLabel, BorderLayout.NORTH);

        for (int i = 0; i < textArea.length; i++) {
            textArea[i] = new JTextArea();
            textArea[i].setFont(new Font("Arial", Font.BOLD, 15));
            textArea[i].setForeground(colorTexto);
            textArea[i].setOpaque(true);
            textArea[i].setEditable(false);
            textArea[i].setLineWrap(false);
            textArea[i].setWrapStyleWord(true);
            textArea[i].setBorder(BorderFactory.createEmptyBorder(50, 50, 0, 50));
            textArea[i].setBackground(colorFondo);
        }

        actualizarTexto();

        panelTexto.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        panelTexto.setBackground(Color.GRAY);
        add(panelTexto, BorderLayout.CENTER);

        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) ControladorGeneral.instancia.getContentPane().getLayout();
                cl.show(ControladorGeneral.instancia.getContentPane(), "Configuracion");
            }
        });
    }

    public void actualizarVista()
    {
        super.actualizarVista();
        for (int i = 0; i < textArea.length; i++) {
            textArea[i].setForeground(colorTexto);
            textArea[i].setBackground(colorFondo);
        }
        label.setForeground(colorLabel);
        atras.setIcon(botonAtras);
    }

    public void actualizarTexto()
    {
        label.setText(translate("Ayuda"));
        textArea[0].setText(translate(textoComoJugar));
        textArea[1].setText(translate(textoBonificadores));
        textArea[2].setText(translate(textoCreditos));
        panelTexto.removeAll();
        panelTexto.addTab(translate("Como Jugar"), textArea[0]);
        panelTexto.addTab(translate("Bonificadores"), textArea[1]);
        panelTexto.addTab(translate("Creditos"), textArea[2]);
    }

}
