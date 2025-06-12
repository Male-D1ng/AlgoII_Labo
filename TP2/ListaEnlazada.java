package aed;


public class ListaEnlazada<T> {
    private static class Nodo<T> {
        T valor;
        Nodo<T> siguiente;

        Nodo(T valor) {
            this.valor = valor;
        }
    }

    private Nodo<T> cabeza;
    private Nodo<T> cola;

    public void agregar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
        }
    }

    public T ultimo() {
        return cola != null ? cola.valor : null;
    }

    public Iterable<T> iterable() {
        return () -> new java.util.Iterator<T>() {
            Nodo<T> actual = cabeza;

            public boolean hasNext() {
                return actual != null;
            }

            public T next() {
                T val = actual.valor;
                actual = actual.siguiente;
                return val;
            }
        };
    }
}
