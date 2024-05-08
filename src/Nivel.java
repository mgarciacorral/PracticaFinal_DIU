import java.util.ArrayList;

public class Nivel {
    public String semilla;
    private ArrayList<Ladrillo> ladrillos = new ArrayList<>();
    private ModeloDaltonicos mDalt;


    public Nivel(String semilla, ModeloDaltonicos mDalt){
        this.mDalt = mDalt;
        this.semilla = semilla;
        configNivel();
    }

    public ArrayList<Ladrillo> getLadrillos(){
        return ladrillos;
    }

    public void configNivel(){
        int row = 0;
        int col = 0;
        for(int i = 0; i < semilla.length(); i++){
            if(col == 6){
                col = 0;
                row++;
            }
            switch(semilla.charAt(i)) {
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
            romper = true;
        }

        return romper;
    }

    public void buffoLadrillos()
    {
        for(Ladrillo ladrillo : ladrillos)
        {
            if(ladrillo.refuerzo < 4 && ladrillo.refuerzo != -1)
            {
                ladrillo.refuerzo++;
                ladrillo.setLadrilloImg(ladrillo.refuerzo);
            }
        }
    }
}
