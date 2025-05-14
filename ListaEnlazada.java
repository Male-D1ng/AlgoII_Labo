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
        longitud ++;
    }

    public void agregarAtras(T elem) {
        
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
        Nodo actual = primerElem;
        for (int j = 0; j < longitud; j++) {
            if (j == i) {
                return actual.valor;
        }   
            else {
                actual = actual.siguiente;
            }
        }
        return actual.valor;
    }

    public void eliminar(int i) {
        Nodo actual = primerElem;
        Nodo anterior = primerElem;
        for (int j = 0; j < i; j++) {
            anterior = actual;
            actual = actual.siguiente;
        }
            if (i == 0) {
                primerElem = actual.siguiente;
                longitud--;
        } 
            else {
                anterior.siguiente = actual.siguiente;
                longitud--;
    }
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = primerElem;
        Nodo sigNodo = actual.siguiente;
        Nodo nuevo = new Nodo(elem); 
        if (indice==0){ 
            sigNodo = primerElem;
            primerElem = nuevo;
            nuevo.siguiente = sigNodo; 
            sigNodo.anterior = nuevo;
        }
        for (int j = 0; j < longitud; j++) {
            Nodo antNodo = actual.anterior;
            if(j == indice && j == longitud-1){
                antNodo.siguiente = nuevo; 
            }
            else if(j == indice){
                sigNodo = actual.siguiente; 
                actual = nuevo;
                nuevo.anterior = antNodo;
                nuevo.siguiente = sigNodo;
                antNodo.siguiente = nuevo;
                sigNodo.anterior = nuevo; 
            }
            else{
                actual = actual.siguiente;
   
            }
        }
    }

    /*  {
        Nodo actual = this.primero;
        Nodo sig = actual.sig;
        Nodo nuevoNodo = new Nodo(elem);
        if(indice == 0){
                sig = this.primero;
                this.primero = nuevoNodo;
                nuevoNodo.sig = sig;
                sig.prev = nuevoNodo;
        }
        for(int j = 0; j<this.longitud; j++){
            Nodo prev = actual.prev;
            if(j == indice && j == this.longitud-1){
                prev.sig = nuevoNodo; 
            }else if(j == indice){
                sig = actual.sig; 
                actual = nuevoNodo;
                nuevoNodo.prev = prev;
                nuevoNodo.sig = sig;
                prev.sig = nuevoNodo;
                sig.prev = nuevoNodo; 
            }else{
                actual = actual.sig;
            }
        }
    } */

    public ListaEnlazada(ListaEnlazada<T> lista) {
        primerElem = lista.primerElem;
        longitud = lista.longitud;
    }
    
    @Override
    public String toString() {
        StringBuffer string = new StringBuffer(); 
        string.append("[");
        for(int j = 0; j< longitud; j++){
            string.append(primerElem.valor);
            primerElem = primerElem.siguiente; 
            if(j != longitud-1){
                string.append(", ");
            }
        }
        string.append("]");
        return string.toString();
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados
        Nodo anterior;
        Nodo actual;

        public ListaIterador() {
            anterior = null;
            actual = primerElem;
        
        }

        public boolean haySiguiente() {
	        return actual != null;
        }
        
        public boolean hayAnterior() {
	        return anterior != null;
        }

        public T siguiente() {
	    Nodo nuevo = actual;
            anterior = actual;
            actual = actual.siguiente;
            return nuevo.valor;
        }
        
        public T anterior() {
	    Nodo actual = anterior;
            actual = anterior;
            anterior = anterior.anterior;
            return actual.valor;
        }
    }

/* public T anterior() {
            Nodo actual = this.prev;
            this.act = this.prev;
            this.prev = this.prev.prev;
            return actual.valor; */

    public Iterador<T> iterador() {
	    return new ListaIterador();
    }

}
