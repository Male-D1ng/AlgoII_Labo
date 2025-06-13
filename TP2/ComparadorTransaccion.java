package aed;

import java.util.Comparator;

public class ComparadorTransaccion implements Comparator<Transaccion> {
    @Override
    public int compare(Transaccion c1, Transaccion c2){
        int id1 = c1.obtenerId();
        int id2 = c2.obtenerId();
        int comparacion = Integer.compare(id1, id2);
        if (comparacion == 0){
            return comparacion;
        }
        else if (id1 < id2){
            comparacion = 1;
        }
        else{
            comparacion = -1;
        }
    
        return comparacion;
    }
}

