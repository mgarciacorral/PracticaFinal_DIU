import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BuffGenerico extends ImageIcon {
    protected int ballX;
    protected int ballY;
    protected int ballW, ballH;
    protected Rectangle ballRect;
    protected ModeloDaltonicos mDalt;
    protected ModeloNivel mNivel;

    public BuffGenerico(int x, int y, ModeloDaltonicos mDalt, ModeloNivel mNivel)
    {
        this.ballX = x;
        this.ballY = y;
        this.mDalt = mDalt;
        this.mNivel = mNivel;

        setSkin();

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
}
