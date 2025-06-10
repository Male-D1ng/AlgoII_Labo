package aed;

public class Heap implements Comparable<Heap> {

        private int id;
        private int id_comprador;
        private int id_vendedor;
        private int monto;

        // inicializador/constructor

        public Heap(int id, int id_comprador, int id_vendedor, int monto) {

        this.id = id;
        this.id_comprador = id_comprador;
        this.id_vendedor = id_vendedor;
        this.monto = monto;
        }

        @Override
        public int compareTo(Heap otro) {
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
