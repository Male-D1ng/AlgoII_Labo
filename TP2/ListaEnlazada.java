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
        if (cola != null){
            return cola.valor; 
        }
        else {
            return null;
        }
    }

    public Iterador<T> iterador() {
    return new Iterador<T>() {
        private Nodo<T> actual = cabeza;

        public boolean haySiguiente() {
            return actual != null;
        }

        public T siguiente() {
            T valor = actual.valor;
            actual = actual.siguiente;
            return valor;
        }
    };
}

}
