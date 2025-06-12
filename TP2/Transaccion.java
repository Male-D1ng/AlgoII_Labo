package aed;
public class Transaccion implements Comparable<Transaccion> {
    private int id;
    private int id_comprador;
    private int id_vendedor;
    private int monto;
    private int handler;

    public Transaccion(int id, int comprador, int vendedor, int monto) {
        this.id = id;
        this.id_comprador = comprador;
        this.id_vendedor = vendedor;
        this.monto = monto;
        handler = -1;
    }

    @Override
    public int compareTo(Transaccion otra) {
        if (this.monto != otra.monto)
            return Integer.compare(this.monto, otra.monto);
        return Integer.compare(this.id, otra.id);
    }

    public int monto() {
        return monto;
    }

    public int id_comprador() {
        return id_comprador;
    }
    
    public int id_vendedor() {
        return id_vendedor;
    }

    public int obtenerId(){
        return id;
    }

    public int obtenerHandler(){
        return handler;
    }

    public void modificarHandlerTransaccion(int nuevo){
        handler = nuevo;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Transaccion that = (Transaccion) obj;
        return id == that.id &&
            id_comprador == that.id_comprador &&
            id_vendedor == that.id_vendedor &&
            monto == that.monto;

}

}




