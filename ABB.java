package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto

        private Nodo raiz;
        private int cardinal;
        private int altura;

    private class Nodo {
        // Agregar atributos privados del Nodo
        T valor ;
        Nodo izq;
        Nodo der;
        Nodo padre;

        Nodo (T v) {
            valor = v;
            izq = null;
            der = null;
            padre = null;
        }

        // Crear Constructor del nodo
    }

    public ABB() {
        raiz = null;
        cardinal = 0;
        altura = 0;

    }

    public int cardinal() { //la cantidad de elem en el conjunto
        return cardinal;
    }

    public T minimo(){
        return minimo();
    }

    public T maximo(){
        return maximo();
    }

    public void insertar(T elem){
        Nodo nuevo = new Nodo(elem) ;
        if (raiz.valor == null){
            raiz = nuevo;
        }
        
        if (nuevo==raiz) { //caso raiz ya es 8
            return; 
        }
        else {
            Nodo actual = new Nodo(elem);
            if (nuevo.valor.compareTo(raiz.valor)== -1){
                        actual = raiz.izq;
                        }
                }
                
        cardinal++;
    }

    public boolean pertenece(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;
        private Nodo _anterior;

        public ABB_Iterador() {
        _anterior = null;
        _actual =  ;

        }

        public boolean haySiguiente() {            
            return ;
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
