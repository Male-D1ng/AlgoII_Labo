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


    //Borrado recursivo
     Nodo borrar_Recursivo(Nodo raiz, int clave) {
     //Si el Arbol está vacio
         if (raiz == null) {
             return raiz;}
    
     //Recorrer el árbol
         if (clave < raiz.clave) //Recorrer el sub árbol izquierdo
             {raiz.izq = borrar_Recursivo(raiz.izq, clave);}
    
         else if (clave > raiz.clave) //Recorrer el sub árbol derecho
             {raiz.der = borrar_Recursivo(raiz.der, clave);}
         else {
    
     // El nodo contiene solo un hijo
             if (raiz.izq == null)
                 {return raiz.der;}
             else if (raiz.der == null)
                 {return raiz.izq;}
    
     // El Nodo Tiene 2 hijos;
     //Obtener el sucesor inorder (Valor mínimo del subarbol derecho)
         raiz.valor = ValorMinimo(raiz.der);
    
     // Borrar el sucesor inorder
         raiz.der = borrar_Recursivo(raiz.der, raiz.valor);
     }
     return raiz;
     }
    
     private String stringInOrder(Nodo actual){
        if (actual == null){
            return "";
        }

        String izquierda = stringInOrder(actual.izq);
        String derecha = stringInOrder(actual.der);

        return izquierda + (izquierda.isEmpty() ? "" : ",") + actual.valor.toString() + (derecha.isEmpty() ? "" : ",") + derecha;
    }

    public String toString(){ 
        Nodo aux = raiz;
        String res = "{";
        res = res + stringInOrder(aux);
        res = res + "}";
        return res;

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
            Nodo actualViejo = _actual;
            _anterior = actualViejo;
            Nodo siguiente = hallarNodoSiguiente(_actual);
            _actual = siguiente;
            return actualViejo.valor;
        }

        public Nodo hallarNodoSiguiente(Nodo arbol) {
            if (arbol == null) return null;
            if (arbol.der != null) return hallarNodoConMinimo(arbol.der);
            return hallarSiguienteNodoPadre(arbol);
    }

        private Nodo hallarSiguienteNodoPadre(Nodo arbol) {
            Nodo nodoPadre = arbol.padre;
            if (arbol == null || nodoPadre == null || arbol == nodoPadre.izq) return nodoPadre;
            return hallarSiguienteNodoPadre(nodoPadre);
    }

        public Nodo hallarNodoConMinimo(Nodo arbol){
            if(arbol.izq == null) return arbol; 
            else return hallarNodoConMinimo(arbol.izq);
    }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }


}
