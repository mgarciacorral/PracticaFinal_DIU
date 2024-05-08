import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observer;

class VistaNivel extends JPanel implements Observer {
    private ModeloNivel mNivel;
    private ModeloDaltonicos mDalt;
    private ModeloIdiomas mIdioma;
    private ImageIcon bar;
    private ArrayList<ImageIcon> vidas = new ArrayList<ImageIcon>();

    public VistaNivel(ModeloNivel mNivel, ModeloDaltonicos mDalt, ModeloIdiomas mIdioma) {
        this.mNivel = mNivel;
        this.mDalt = mDalt;
        this.mIdioma = mIdioma;
        setImages();
        mNivel.setBarH(bar.getIconHeight());
        mNivel.setBarW(bar.getIconWidth());
        this.setPreferredSize(new Dimension(700, 800));
        setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(mDalt.getColorFondo());
        g.fillRect(0, 0, 700, 50);

        bar = mDalt.getBarra();
        bar.paintIcon(this, g, mNivel.getBarX(), 600);

        for(Ball ball : mNivel.getBalls()){
            ball.paintIcon(this, g, ball.ballX, ball.ballY);
        }

        for(Ladrillo ladrillo : mNivel.getLadrillos()){
            ladrillo.getLadrilloImg().paintIcon(this, g, ladrillo.ladrilloX, ladrillo.ladrilloY);
        }

        for(int i = 0; i < mNivel.getVidas(); i++){
            vidas.get(i).paintIcon(this, g, 0 + (i * 50), 0);
        }

        for(BuffGenerico buff : mNivel.getBuffs()){
            buff.paintIcon(this, g, buff.getBallX(), buff.getBallY());
        }

        g.setFont(new Font("Arial", Font.BOLD, 20));

        FontMetrics metrics = g.getFontMetrics();
        int x = (getWidth() - metrics.stringWidth(mNivel.getTexto())) / 2;
        int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setColor(mDalt.getColorTexto());
        g.drawString(mNivel.getTexto(), x, y);
        g.drawString(mIdioma.translate("Puntos: ") + mNivel.getPuntos(), 500, 30);
        for(Ladrillo ladrillo : mNivel.getLadrillosGolpeados()){
            if(ladrillo.getChocado())
            {
                g.drawString("+10", ladrillo.ladrilloX, ladrillo.ladrilloY);
                if(!ladrillo.getMostrandoPuntos())
                {
                    ladrillo.setMostrandoPuntos(true);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            ladrillo.setChocado(false);
                            ladrillo.setMostrandoPuntos(false);
                            mNivel.getLadrillosGolpeados().remove(ladrillo);
                        }
                    }).start();
                }
            }
        }
    }

    public void setImages(){
        bar = mDalt.getBarra();

        vidas.add(mDalt.getCorazon());
        vidas.add(mDalt.getCorazon());
        vidas.add(mDalt.getCorazon());

        Image scaleImage = vidas.get(0).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        vidas.set(0, new ImageIcon(scaleImage));

        vidas.set(1, new ImageIcon(scaleImage));

        vidas.set(2, new ImageIcon(scaleImage));
    }

    public void update(java.util.Observable o, Object arg) {
        repaint();
    }
}