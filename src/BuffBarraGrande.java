import javax.swing.*;
import java.awt.*;

public class BuffBarraGrande extends BuffGenerico
{
    public BuffBarraGrande(int x, int y, ModeloDaltonicos mDalt, ModeloNivel mNivel)
    {
        super(x, y, mDalt, mNivel);
    }

    public void ejecutarAccion() {
        if(!mNivel.getBuffTamanoBarra())
        {
            ImageIcon barra = mDalt.getBarra();
            Image scaleImage = barra.getImage().getScaledInstance(barra.getIconWidth() + 100, barra.getIconHeight(), Image.SCALE_DEFAULT);

            mNivel.setBuffTamanoBarra(true);
            new Thread(new Runnable() {
                public void run() {
                    mDalt.setBarra(new ImageIcon(scaleImage));
                    mNivel.setBarW(mDalt.getBarra().getIconWidth());
                    try {
                        Thread.sleep(8000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mDalt.setBarra(barra);
                    mNivel.setBarW(mDalt.getBarra().getIconWidth());
                    mNivel.setBuffTamanoBarra(false);
                }
            }).start();

            playPowerUpSound();
        }
    }
}
