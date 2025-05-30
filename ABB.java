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
        T minimo = raiz.valor;
        while(raiz.izq != null){
            minimo = raiz.izq.valor;
            raiz = raiz.izq;
        }
        return minimo;
    }

    public T maximo(){
        T maximo = raiz.valor;
        while(raiz.der != null){
            maximo = raiz.der.valor;
            raiz = raiz.der;
        }
        return maximo;
    }
    
    public void insertar(T elem){
        //Nodo nuevo = new Nodo (elem);
        if (pertenece(elem)){
            cardinal--;
        }
        if (raiz != null && elem == raiz.valor) { //caso raiz ya es 8
        }
        else {
            raiz = insertar_recursivo(raiz, elem);
            cardinal++;
        }
    }

    Nodo insertar_recursivo (Nodo raiz,  T elem) {
        if (raiz == null){
            raiz = new Nodo (elem);
            return raiz;
        }
        if (raiz.valor.compareTo(elem)== -1){
                        raiz.der = insertar_recursivo(raiz.der, elem);
                        }
        else {
                raiz.izq = insertar_recursivo(raiz.izq, elem);
            }

        return raiz;
            
    }


    public boolean pertenece(T elem){
        Nodo actual = busqueda_recursiva(raiz, elem);
        if (actual != null){
            return true;
        }
        else {
            return false;
        }
    }

    Nodo busqueda_recursiva (Nodo raiz, T elem){
        if (raiz == null || raiz.valor == elem){
            return raiz;
        } //raiz < elem 
        if (raiz.valor.compareTo(elem)== -1){
            return busqueda_recursiva(raiz.der, elem);
        }
        else{
            return busqueda_recursiva(raiz.izq, elem);
        }

    }

    public void eliminar(T elem){
        Nodo actual = raiz;

        busqueda_recursiva(actual, elem);
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;
        private Nodo _anterior;

        public ABB_Iterador() {
        _anterior = null;
        _actual = null ;

        }

        public boolean haySiguiente() {            
            return haySiguiente();
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }


}
