public class BuffMas50Puntos extends BuffGenerico
{
    public BuffMas50Puntos(int x, int y, ModeloDaltonicos mDalt, ModeloNivel mNivel)
    {
        super(x, y, mDalt, mNivel);
    }

    public void ejecutarAccion() {
        mNivel.setPuntos(mNivel.getPuntos() + 50);
        playPowerUpSound();
    }
}
