package aed;

import java.util.List;

public class ListaEnlazada implements Comparable<ListaEnlazada> {
        // inicializador/constructor
        private Bloque cabeza;
        

        public void agregarBloque(Bloque nuevo) {
                nuevo.anterior = cabeza;
                cabeza = nuevo;
        }

        public Bloque ultimoBloque() {
                return cabeza;
        }

        @Override
        public int compareTo(ListaEnlazada otro) {
                throw new UnsupportedOperationException("Implementar!");
        }

        @Override
        public boolean equals(Object otro){
                throw new UnsupportedOperationException("Implementar!");
        }

}
