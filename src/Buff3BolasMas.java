public class Buff3BolasMas extends BuffGenerico
{
    public Buff3BolasMas(int x, int y, ModeloDaltonicos mDalt, ModeloNivel mNivel)
    {
        super(x, y, mDalt, mNivel);
    }

    public void ejecutarAccion()
    {
        mNivel.setNumCrearPelotas(mNivel.getNumCrearPelotas() + 3);
        playPowerUpSound();

    }
}
