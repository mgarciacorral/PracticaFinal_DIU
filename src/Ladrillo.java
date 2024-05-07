import javax.swing.*;
import java.awt.*;

public class Ladrillo extends Rectangle{

    public int ladrilloX, ladrilloY;
    public int ladrilloW, ladrilloH;
    public int refuerzo;
    public Rectangle ladrilloRectXUp, ladrilloRectXDown;
    public Rectangle ladrilloRectYLeft, ladrilloRectYRight;
    private ImageIcon ladrilloImg;
    private ModeloDaltonicos mDalt;
    private boolean chocado = false;


    public Ladrillo(int ladrilloX, int ladrilloY, int ladrilloW, int ladrilloH, int refuerzo, ModeloDaltonicos mDalt){
        this.mDalt = mDalt;
        this.ladrilloX = ladrilloX;
        this.ladrilloY = ladrilloY;
        this.ladrilloW = ladrilloW;
        this.ladrilloH = ladrilloH;
        this.refuerzo = refuerzo;

        setLadrilloImg(refuerzo);
        setRectangle();
    }

    public void setLadrilloImg(int refuerzo){
        Image scaleImage;
        switch(refuerzo){
            case 0:
                ladrilloImg = mDalt.getLadrillo1();
                scaleImage = ladrilloImg.getImage().getScaledInstance(117, 28, Image.SCALE_DEFAULT);
                ladrilloImg = new ImageIcon(scaleImage);
                break;
            case 1:
                ladrilloImg = mDalt.getLadrillo2();
                scaleImage = ladrilloImg.getImage().getScaledInstance(117, 28, Image.SCALE_DEFAULT);
                ladrilloImg = new ImageIcon(scaleImage);
                break;
            case 2:
                ladrilloImg = mDalt.getLadrillo3();
                scaleImage = ladrilloImg.getImage().getScaledInstance(117, 28, Image.SCALE_DEFAULT);
                ladrilloImg = new ImageIcon(scaleImage);
                break;
            case 3:
                ladrilloImg = mDalt.getLadrillo4();
                scaleImage = ladrilloImg.getImage().getScaledInstance(117, 28, Image.SCALE_DEFAULT);
                ladrilloImg = new ImageIcon(scaleImage);
                break;
            case -1:
                ladrilloImg = mDalt.getLadrilloUB();
                scaleImage = ladrilloImg.getImage().getScaledInstance(117, 28, Image.SCALE_DEFAULT);
                ladrilloImg = new ImageIcon(scaleImage);
                break;
        }

    }

    public ImageIcon getLadrilloImg(){
        return ladrilloImg;
    }

    public void setRectangle(){
        ladrilloRectXUp = new Rectangle(ladrilloX + 6, ladrilloY, 105 , 1);
        ladrilloRectXDown = new Rectangle(ladrilloX + 6, ladrilloY + 27, 105 , 1);
        ladrilloRectYLeft = new Rectangle(ladrilloX, ladrilloY + 3, 6, 23);
        ladrilloRectYRight = new Rectangle(ladrilloX + 114, ladrilloY + 3, 6, 23);
    }

    public boolean getChocado(){
        return chocado;
    }

    public void setChocado(boolean chocado){
        this.chocado = chocado;
    }
}
