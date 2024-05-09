public class BuffRecuperarVida extends BuffGenerico
{
    public BuffRecuperarVida(int x, int y, ModeloDaltonicos mDalt, ModeloNivel mNivel)
    {
        super(x, y, mDalt, mNivel);
    }

    public void ejecutarAccion()
    {
        if(mNivel.getVidas() < 3)
        {
            mNivel.setVidas(mNivel.getVidas() + 1);
            playPowerUpSound();
        }
    }
}
