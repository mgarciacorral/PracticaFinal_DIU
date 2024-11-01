import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Ball extends ImageIcon{

    private int ballX = 325;
    private int ballY = 562;
    private int ballW, ballH;
    private float speedX, speedY;
    private int intialSpeedY = -6;
    private Rectangle ballRect = new Rectangle(250, 600, 36, 36);
    private ModeloDaltonicos mDalt;
    private Clip ballSound;

    public Ball(ModeloDaltonicos mDalt, int intialSpeedX){
        this.mDalt = mDalt;
        setSkin();
        setClip();
        speedX = intialSpeedX;
        speedY = intialSpeedY;
        ballW = getIconWidth();
        ballH = getIconHeight();
    }

    public void move(){
        ballX += speedX;
        ballY += speedY;
        ballRect.setLocation(ballX, ballY);
    }

    public void setSkin()
    {
        this.setImage(mDalt.getBola().getImage());
    }
    public void setClip(){
        try {
            File soundFile = new File("src/resources/Sonidos/p_1.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            ballSound = AudioSystem.getClip();
            ballSound.open(audioIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playSound(){
        ballSound.setFramePosition(0);
        ballSound.start();
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public int getBallX() {
        return ballX;
    }

    public int getBallY() {
        return ballY;
    }

    public float getSpeedX() {
        return speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public Rectangle getBallRect() {
        return ballRect;
    }

    public int getBallW() {
        return ballW;
    }

    public int getBallH() {
        return ballH;
    }
}
