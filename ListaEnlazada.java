package aed;

public class ListaEnlazada<T> implements Secuencia<T> {
    // Completar atributos privados
    private Nodo primerElem;
    private Nodo ultimoElem;
    private int longitud;

    private class Nodo {
        
        T valor;
        Nodo siguiente;
        Nodo anterior;

        Nodo(T v){valor = v;}
        //Nodo(de cierto elemento de tipo T){elemento;}
    }

    public ListaEnlazada() {
        
        primerElem = null;
        ultimoElem = null;
        longitud = 0 ;
        
    }

    public int longitud() {
        
        return longitud;
    }

    public void agregarAdelante(T elem) {

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
        longitud++;
    }

    public void agregarAtras(T elem) {

        Nodo nuevo = new Nodo(elem);
        if (longitud == 0) {
            primerElem = nuevo;
            ultimoElem = nuevo;
        } else {
            ultimoElem.siguiente = nuevo;  // El nodo último apunta al nuevo
            nuevo.anterior = ultimoElem;   // El nuevo apunta hacia atrás al último
            ultimoElem = nuevo;            // Actualizo último nodo
        }
        longitud++;
    }

    public T obtener(int i) {

        if (i < 0 || i >= longitud) return null;

        Nodo actual = primerElem;
        for (int j = 0; j < i; j++) {
            actual = actual.siguiente;
        }
        return actual.valor;
    }

    public void eliminar(int i) {

        Nodo actual = primerElem;

        for (int j = 0; j < i; j++) {
            actual = actual.siguiente;
        }

        if (actual.anterior != null) {
            actual.anterior.siguiente = actual.siguiente;
        } else {
            // Si es el primer nodo, actualizo primerElem
            primerElem = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente.anterior = actual.anterior;
        } else {
            // Si es el último nodo, actualizo ultimoElem
            ultimoElem = actual.anterior;
        }

        longitud--;
        }

    public void modificarPosicion(int indice, T elem) {
        if (indice < 0 || indice >= longitud) {
        // Si no se permiten excepciones, simplemente no hacer nada
        return;
    }

        Nodo actual = primerElem;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }

        actual.valor = elem;

    }


    public ListaEnlazada(ListaEnlazada<T> lista) {
        primerElem = null;
        ultimoElem = null;
        longitud = 0;

        Nodo actual = lista.primerElem;
        while (actual != null) {
            this.agregarAtras(actual.valor);
            actual = actual.siguiente;
        }
    }
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Nodo actual = primerElem;
        while (actual != null) {
            sb.append(actual.valor);
            actual = actual.siguiente;
            if (actual != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
  
    private class ListaIterador implements Iterador<T> {
        Nodo siguienteNodo;   // Nodo que será retornado con siguiente()
        Nodo anteriorNodo;    // Nodo que será retornado con anterior()

        public ListaIterador() {
            siguienteNodo = primerElem;  // Al inicio, siguiente es el primer nodo
            anteriorNodo = null;         // No hay nodo anterior al inicio
        }

        public boolean haySiguiente() {
            return siguienteNodo != null;
        }

        public boolean hayAnterior() {
            return anteriorNodo != null;
        }

        public T siguiente() {
            if (!haySiguiente()) return null;

            T valor = siguienteNodo.valor;
            anteriorNodo = siguienteNodo;       // Ahora el anterior será el que acabamos de devolver
            siguienteNodo = siguienteNodo.siguiente; // Avanzamos el siguiente
            return valor;
        }

        public T anterior() {
            if (!hayAnterior()) return null;

            T valor = anteriorNodo.valor;
            siguienteNodo = anteriorNodo;          // Ahora el siguiente es el nodo que acabamos de devolver
            anteriorNodo = anteriorNodo.anterior;  // Retrocedemos el anterior
            return valor;
    }
    }
        public Iterador<T> iterador() {
            return new ListaIterador();
    }
    
}
