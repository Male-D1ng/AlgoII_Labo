package aed;

public class ListaEnlazada<T> implements Secuencia<T> {
    // Completar atributos privados
    private Nodo primerElem;
    private Nodo ultimoElem;
    private int longitud;

    private class Nodo {
        // Completar
        T valor;
        Nodo siguiente;
        Nodo anterior;

        Nodo(T v){valor = v;}
        //Nodo(de cierto elemento de tipo T){elemento;}
    }

    public ListaEnlazada() {
        //throw new UnsupportedOperationException("No implementada aun")
        primerElem = null;
        ultimoElem = null;
        longitud = 0 ;
    }

    public int longitud() {
        //throw new UnsupportedOperationException("No implementada aun")
        return longitud;
    }

    public void agregarAdelante(T elem) {
        //throw new UnsupportedOperationException("No implementada aun")
        Nodo nuevo = new Nodo(elem);
        if (longitud == 0) {
            primerElem = nuevo;
            ultimoElem = nuevo;
        }
        else {
            nuevo.siguiente = primerElem;
            primerElem.anterior = nuevo;
            primerElem = nuevo;

        }
        longitud ++;
    }

    public void agregarAtras(T elem) {
        //throw new UnsupportedOperationException("No implementada aun")
        Nodo nuevo = new Nodo(elem);
        if (primerElem == null) {
            primerElem = nuevo;
            ultimoElem = nuevo;
        } 
        else {
            Nodo actual = primerElem;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
        }
            actual.siguiente = nuevo;
            actual.anterior = ultimoElem; 
        }
        longitud++;
    }

    public T obtener(int i) {
        //throw new UnsupportedOperationException("No implementada aun") 
        Nodo actual = primerElem;
        Nodo prev = primerElem;
        for (int j = 0; j < i; j++) {
            prev = actual;
            actual = actual.siguiente;
        }
        if (i == 0) {
            return actual.valor;
        } else {
            prev.siguiente = actual.siguiente;
        }
        return actual.valor;
    }

    public void eliminar(int i) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
