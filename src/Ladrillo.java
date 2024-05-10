import javax.swing.*;
import java.awt.*;

public class Ladrillo extends Rectangle{

    private int ladrilloX, ladrilloY;
    private int ladrilloW, ladrilloH;
    private int refuerzo;
    private Rectangle ladrilloRectXUp, ladrilloRectXDown;
    private Rectangle ladrilloRectYLeft, ladrilloRectYRight;
    private ImageIcon ladrilloImg;
    private ModeloDaltonicos mDalt;
    private boolean chocado = false;
    private boolean mostrandoPuntos = false;


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

    public boolean getMostrandoPuntos() {
        return mostrandoPuntos;
    }

    public void setMostrandoPuntos(boolean mostrandoPuntos) {
        this.mostrandoPuntos = mostrandoPuntos;
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

    public Rectangle getLadrilloRectXUp() {
        return ladrilloRectXUp;
    }

    public Rectangle getLadrilloRectXDown() {
        return ladrilloRectXDown;
    }

    public Rectangle getLadrilloRectYLeft() {
        return ladrilloRectYLeft;
    }

    public Rectangle getLadrilloRectYRight() {
        return ladrilloRectYRight;
    }

    public int getRefuerzo() {
        return refuerzo;
    }

    public void setRefuerzo(int refuerzo) {
        this.refuerzo = refuerzo;
    }

    public int getLadrilloX() {
        return ladrilloX;
    }

    public int getLadrilloY() {
        return ladrilloY;
    }

    public int getLadrilloW() {
        return ladrilloW;
    }

    public int getLadrilloH() {
        return ladrilloH;
    }

    public void setLadrilloX(int ladrilloX) {
        this.ladrilloX = ladrilloX;
    }

    public void setLadrilloY(int ladrilloY) {
        this.ladrilloY = ladrilloY;
    }

    public void setLadrilloW(int ladrilloW) {
        this.ladrilloW = ladrilloW;
    }

    public void setLadrilloH(int ladrilloH) {
        this.ladrilloH = ladrilloH;
    }

    public void setLadrilloImg(ImageIcon ladrilloImg) {
        this.ladrilloImg = ladrilloImg;
    }

    public void setLadrilloRectXUp(Rectangle ladrilloRectXUp) {
        this.ladrilloRectXUp = ladrilloRectXUp;
    }

    public void setLadrilloRectXDown(Rectangle ladrilloRectXDown) {
        this.ladrilloRectXDown = ladrilloRectXDown;
    }

    public void setLadrilloRectYLeft(Rectangle ladrilloRectYLeft) {
        this.ladrilloRectYLeft = ladrilloRectYLeft;
    }

    public void setLadrilloRectYRight(Rectangle ladrilloRectYRight) {
        this.ladrilloRectYRight = ladrilloRectYRight;
    }




}
