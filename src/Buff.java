import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Buff extends ImageIcon {
    private int ballX;
    private int ballY;
    private int ballW, ballH;
    private Rectangle ballRect;
    private ModeloDaltonicos mDalt;
    private ModeloNivel mNivel;

    public Buff(int x, int y, ModeloDaltonicos mDalt, ModeloNivel mNivel)
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
        mNivel.setCrearPelota(true);
    }
}
