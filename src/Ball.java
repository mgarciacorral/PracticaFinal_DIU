import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;

public class Ball {

    public int ballX = 325;
    public int ballY = 562;
    public int ballW, ballH;
    public float speedX, speedY;
    public int intialSpeedX = 6;
    public int intialSpeedY = -6;
    public Rectangle ballRect = new Rectangle(250, 600, 36, 36);
    private Clip choqueSonido;

    public Ball(){
        speedX = intialSpeedX;
        speedY = intialSpeedY;
        setSonidoChoque();
    }

    public void move(){
        ballX += speedX;
        ballY += speedY;
        ballRect.setLocation(ballX, ballY);
    }

    public void setSonidoChoque()
    {
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/resources/Sonidos/musicaFondo.wav").getAbsoluteFile());
            choqueSonido = AudioSystem.getClip();
            choqueSonido.open(audioInputStream);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sonidoChoque()
    {
        choqueSonido.start();
    }
}
