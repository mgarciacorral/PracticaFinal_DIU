public class Bonificadores extends Ball{
    private int velocidad = 3;
    private int tipo;
    public void move(){
        ballY += velocidad;
        ballRect.setLocation(ballX, ballY);
    }
}
