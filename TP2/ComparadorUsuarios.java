package aed;
import java.util.Comparator;

public class ComparadorUsuarios implements Comparator<Usuario> {
    @Override
    public int compare(Usuario c1, Usuario c2){
        int id1 = c1.obtenerId();
        int id2 = c2.obtenerId();
        int comparacion = Integer.compare(c1.obtenerId(), c2.obtenerId());
        if (comparacion == 0){
            if (id1 < id2){
                comparacion = 1;
            }
            else{
                comparacion = -1;
            }
        }
        return comparacion;
    }
}
