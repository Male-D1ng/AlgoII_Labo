package aed;

public class Bloque implements Comparable<Bloque> {

    private int id;
    private int id_comprador;
    private int id_vendedor;
    private int monto;
    public Bloque anterior;

     //lista enlazada 

     // inicializador/constructor

        public Bloque(Transaccion transaccion) {
        Transaccion = new Transaccion transaccion; //cómo lo escribo
        }
        // Metodo = agrandar la lista
        // Metodo = cardinal del conjunto == longitud de la lista 
        // Metodo = acceder al ultimo  

    @Override
    public int compareTo(Bloque otro) {
        throw new UnsupportedOperationException("Implementar!");
    }

    @Override
    public boolean equals(Object otro){
        throw new UnsupportedOperationException("Implementar!");
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

}
