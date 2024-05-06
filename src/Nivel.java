import java.util.ArrayList;

public class Nivel {

    /************************/
    /* 0 no hay ladrillo    */
    /* 1 ladrillo normal    */
    /* 2 ladrillo reforzado */
    /************************/

    public String nivel;

    public ArrayList<Ladrillo> ladrillos = new ArrayList<>();


    public Nivel(String nivel){
        this.nivel = nivel;
        configNivel();
    }

    public void configNivel(){
        int row = 0;
        int col = 0;
        for(int i = 0; i < nivel.length(); i++){
            if(nivel.charAt(i) == '1'){
                if(col == 6){
                    row++;
                    col = 0;
                }
                ladrillos.add(new Ladrillo(col * 117, (row * 28) + 50, 117, 28 ,0));
                col++;


            }else if(nivel.charAt(i) == '2'){
                if(col == 6){
                    row++;
                    col = 0;
                }
                ladrillos.add(new Ladrillo(col * 117, (row * 28) + 50, 117, 28 ,1));
                col++;
            }else if(nivel.charAt(i) == '0'){
                if(col == 6){
                    row++;
                    col = 0;
                }
                col++;
            }
        }
    }

    public void eliminarLadrillo(int indice){
        ladrillos.remove(indice);
    }
}
