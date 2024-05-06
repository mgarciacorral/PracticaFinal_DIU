import java.awt.*;

public class Ladrillo {

    public int ladrilloX, ladrilloY;
    public int ladrilloW, ladrilloH;

    public int refuerzo;

    public Rectangle ladrilloRectXUp, ladrilloRectXDown;
    public Rectangle ladrilloRectYLeft, ladrilloRectYRight;


    public Ladrillo(int ladrilloX, int ladrilloY, int ladrilloW, int ladrilloH, int refuerzo){
        this.ladrilloX = ladrilloX;
        this.ladrilloY = ladrilloY;
        this.ladrilloW = ladrilloW;
        this.ladrilloH = ladrilloH;
        this.refuerzo = refuerzo;

        setRectangle();
    }

    public void setRectangle(){
        ladrilloRectXUp = new Rectangle(ladrilloX + 6, ladrilloY, 105 , 3);
        ladrilloRectXDown = new Rectangle(ladrilloX + 6, ladrilloY + 25, 105 , 3);
        ladrilloRectYLeft = new Rectangle(ladrilloX, ladrilloY + 3, 3, 23);
        ladrilloRectYRight = new Rectangle(ladrilloX + 114, ladrilloY + 3, 3, 23);
    }


}
