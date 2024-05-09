public class BuffMusica extends BuffGenerico
{
    public BuffMusica(int x, int y, ModeloDaltonicos mDalt, ModeloNivel mNivel)
    {
        super(x, y, mDalt, mNivel);
    }

    public void ejecutarAccion()
    {
        if(!mNivel.getBuffMusica())
        {
            mNivel.setMusicaFondo(1);
            mNivel.controlarMusica();
            mNivel.setBuffMusica(true);
            playPowerDownSound();
        }
    }
}