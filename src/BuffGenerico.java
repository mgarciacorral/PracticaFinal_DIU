import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

public class BuffGenerico extends ImageIcon {
    protected int ballX;
    protected int ballY;
    protected int ballW, ballH;
    protected Rectangle ballRect;
    protected ModeloDaltonicos mDalt;
    protected ModeloNivel mNivel;
    protected Clip powerUpSound;
    protected Clip powerDownSound;

    public BuffGenerico(int x, int y, ModeloDaltonicos mDalt, ModeloNivel mNivel)
    {
        this.ballX = x;
        this.ballY = y;
        this.mDalt = mDalt;
        this.mNivel = mNivel;

        setSkin();
        setClip();

        ballW = getIconWidth();
        ballH = getIconHeight();
        ballRect = new Rectangle(ballX, ballY, ballW, ballH);
    }

    public void setSkin()
    {
        this.setImage(mDalt.getBuff(new Random().nextInt(3)).getImage());
    }

    public void move(){
        ballY += 2;
        ballRect.setLocation(ballX, ballY);
    }

    public Rectangle getBallRect() {
        return ballRect;
    }

    public int getBallX() {
        return ballX;
    }

    public int getBallY() {
        return ballY;
    }

    public void ejecutarAccion()
    {

    }
    public void setClip(){
        try {
            powerUpSound = AudioSystem.getClip();
            powerUpSound.open(AudioSystem.getAudioInputStream(new File("src/resources/Sonidos/Rise03.wav")));
            powerDownSound = AudioSystem.getClip();
            powerDownSound.open(AudioSystem.getAudioInputStream(new File("src/resources/Sonidos/Downer01.wav")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playPowerUpSound(){
        powerUpSound.setFramePosition(0);
        powerUpSound.start();
    }

    public void playPowerDownSound(){
        powerDownSound.setFramePosition(0);
        powerDownSound.start();
    }
}
