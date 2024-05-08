import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Ball extends ImageIcon{

    public int ballX = 325;
    public int ballY = 562;
    public int ballW, ballH;
    public float speedX, speedY;
    public int intialSpeedX;
    public int intialSpeedY = -6;
    public Rectangle ballRect = new Rectangle(250, 600, 36, 36);
    private ModeloDaltonicos mDalt;

    public Ball(ModeloDaltonicos mDalt, int intialSpeedX){
        this.mDalt = mDalt;
        setSkin();
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
}
