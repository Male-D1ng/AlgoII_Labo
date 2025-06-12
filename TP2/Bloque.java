package aed;
import java.util.ArrayList;
import java.util.List;

public class Bloque {
    private ArrayList<Transaccion> transacciones;
    private Heap<Transaccion> heapPorValor;
    private int sumaMontos;
    private int handler;
    private ComparadorTransaccion comparadorTransaccion;

    public Bloque() {
        comparadorTransaccion = new ComparadorTransaccion();
        this.transacciones = new ArrayList<Transaccion>();
        this.heapPorValor = new Heap<Transaccion>(comparadorTransaccion,transacciones);
        this.sumaMontos = 0;
        this.handler = -1;
    }


    public void agregarTransaccion(Transaccion tx) {
        transacciones.add(tx);
        heapPorValor.encolar(tx);
        if (tx.id_comprador() != 0 && tx.id_vendedor() != 0) {
            sumaMontos += tx.monto();
        }
    }

    public ArrayList<Transaccion> obtenerTransacciones (){
        return transacciones;
    }

    public Transaccion obtenerMax() {
        return heapPorValor.maximo();
    }

    public Transaccion extraerMax() {
        Transaccion tx = heapPorValor.desencolarTransaccion();
        if (tx != null && tx.id_comprador() != 0 && tx.id_vendedor() != 0) {
            sumaMontos -= tx.monto();
        }
        transacciones.remove(tx); // O(n)
        return tx;
    }

    public List<Transaccion> transaccionesOrdenadasPorId() {
    List<Transaccion> copia = new ArrayList<>(transacciones);  // copia para no alterar original

    for (int i = 1; i < copia.size(); i++) {
        Transaccion actual = copia.get(i);
        int j = i - 1;
        while (j >= 0 && copia.get(j).obtenerId() > actual.obtenerId()) {
            copia.set(j + 1, copia.get(j));
            j--;
        }
        copia.set(j + 1, actual);
    }

    return copia;
}


    public int cantidadTransaccionesValidas() {
        int count = 0;
        for (Transaccion tx : transacciones) {
            if (tx.id_comprador() != 0 && tx.id_vendedor() != 0) {
                count++;
            }
        }
        return count;
    }

    public int obtenerHandler() {
        return handler;
    }

    public void modificarHandler(int nuevo) {
        handler = nuevo;
    }

    public int sumaMontos() {
        return sumaMontos;
    }
}

























/*
 * 
 public class Bloque {
    ArrayList<Transaccion> transacciones;
    Heap<Transaccion> heapPorValor;
    int sumaMontos;
    
    public Bloque(int maxIdTx) {
        this.transacciones = new ArrayList<>();
        this.heapPorValor = new Heap<>(
            (a, b) -> {
                if (a.monto != b.monto)
                    return Integer.compare(a.monto, b.monto);
                return Integer.compare(a.id, b.id);
            },
            tx -> tx.id,
            maxIdTx
        );
        this.sumaMontos = 0;
    }

    public void agregarTransaccion(Transaccion tx) {
        transacciones.add(tx);
        heapPorValor.insertar(tx);
        if (tx.id_comprador != 0 && tx.id_vendedor != 0)
            sumaMontos += tx.monto;
    }
    
    public Transaccion obtenerMax() {
        return heapPorValor.maximo();
    }
    
    public Transaccion extraerMax() {
        Transaccion tx = heapPorValor.extraerMax();
        if (tx != null && tx.id_comprador != 0 && tx.id_vendedor != 0)
        sumaMontos -= tx.monto;
        transacciones.remove(tx); // O(n), aceptable si solo se hackea una vez
        return tx;
    }

    public List<Transaccion> transaccionesOrdenadasPorId() {
        List<Transaccion> copia = new ArrayList<>(transacciones);
        copia.sort(Comparator.comparingInt(t -> t.id));
        return copia;
    }
    
    public int cantidadTransaccionesValidas() {
        return (int) transacciones.stream().filter(tx -> tx.id_comprador != 0 && tx.id_vendedor != 0).count();
    }
}

*/













/*
public class Bloque {
    ArrayList<Transaccion> transacciones;
    Heap<Transaccion> heapPorValor;
    int sumaMontos;

    public Bloque() {
        this.transacciones = new ArrayList<>();
        this.heapPorValor = new Heap<>((a, b) -> {
            if (a.monto != b.monto)
                return Integer.compare(a.monto, b.monto);
            return Integer.compare(a.id, b.id);
        });
        this.sumaMontos = 0;
    }

    public void agregarTransaccion(Transaccion tx) {
        transacciones.add(tx);
        heapPorValor.insertar(tx);
        if (tx.id_comprador != 0 && tx.id_vendedor != 0)
            sumaMontos += tx.monto;
    }

    public Transaccion obtenerMax() {
        return heapPorValor.maximo();
    }

    public Transaccion extraerMax() {
        Transaccion tx = heapPorValor.extraerMax();
        if (tx != null && tx.id_comprador != 0 && tx.id_vendedor != 0)
            sumaMontos -= tx.monto;
        transacciones.remove(tx); // O(n), aceptable si solo se hackea una vez
        return tx;
    }

    public List<Transaccion> transaccionesOrdenadasPorId() {
        List<Transaccion> copia = new ArrayList<>(transacciones);
        copia.sort(Comparator.comparingInt(t -> t.id));
        return copia;
    }

    public int cantidadTransaccionesValidas() {
        return (int) transacciones.stream().filter(tx -> tx.id_comprador != 0 && tx.id_vendedor != 0).count();
    }
}

*/