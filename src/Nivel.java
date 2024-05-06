import java.util.ArrayList;

public class Nivel {

    /************************/
    /* 0 no hay ladrillo    */
    /* 1 ladrillo normal    */
    /* 2 ladrillo reforzado */
    /************************/

    public String nivel;
    public ArrayList<Ladrillo> ladrillos = new ArrayList<>();
    private ModeloDaltonicos mDalt;


    public Nivel(String nivel, ModeloDaltonicos mDalt){
        this.mDalt = mDalt;
        this.nivel = nivel;
        configNivel();
    }

    public void configNivel(){
        int row = 0;
        int col = 0;
        for(int i = 0; i < nivel.length(); i++){
            if(col == 6){
                col = 0;
                row++;
            }
            switch(nivel.charAt(i)) {
                case '1':
                    ladrillos.add(new Ladrillo(col * 117, (row * 28) + 50, 117, 28, 0, mDalt));
                    col++;
                    break;
                case '2':
                    ladrillos.add(new Ladrillo(col * 117, (row * 28) + 50, 117, 28, 1, mDalt));
                    col++;
                    break;
                case '3':
                    ladrillos.add(new Ladrillo(col * 117, (row * 28) + 50, 117, 28, 2, mDalt));
                    col++;
                    break;
                case '4':
                    ladrillos.add(new Ladrillo(col * 117, (row * 28) + 50, 117, 28, 3, mDalt));
                    col++;
                    break;
                case '5':
                    ladrillos.add(new Ladrillo(col * 117, (row * 28) + 50, 117, 28, -1, mDalt));
                    col++;
                    break;
                case '0':
                    col++;
                    break;
            }
        }
    }

    public boolean restarVidaLadrillo(int indice){
        boolean romper = false;
        if(ladrillos.get(indice).refuerzo != 0)
        {
            ladrillos.get(indice).refuerzo--;
            ladrillos.get(indice).setLadrilloImg(ladrillos.get(indice).refuerzo);
        }
        else
        {
            ladrillos.remove(indice);
            romper = true;
        }

        return romper;
    }
}
