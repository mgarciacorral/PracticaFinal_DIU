public class BuffAumentarRefuerzos extends BuffGenerico
{
    public BuffAumentarRefuerzos(int x, int y, ModeloDaltonicos mDalt, ModeloNivel mNivel)
    {
        super(x, y, mDalt, mNivel);
    }

    public void ejecutarAccion()
    {
        mNivel.getNivel().buffoLadrillos();
        playPowerDownSound();
    }
}
