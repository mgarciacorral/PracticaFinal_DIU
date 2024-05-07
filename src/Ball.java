import java.awt.*;

public class Ball {

    public int ballX = 325;
    public int ballY = 562;
    public int ballW, ballH;

    public float speedX, speedY;
    public int intialSpeedX = 4;
    public int intialSpeedY = -4;

    public Rectangle ballRect = new Rectangle(250, 600, 36, 36);

    public Ball(){
        speedX = intialSpeedX;
        speedY = intialSpeedY;
    }

    public void move(){
        ballX += speedX;
        ballY += speedY;
        ballRect.setLocation(ballX, ballY);
    }
}
