package aed;

import java.util.ArrayList;
import java.util.Comparator;

public class Heap <T> {
    private ArrayList<T> elementos;
    private int size;
    private Comparator<T> comparador;

    // Constructor vacío
    public Heap (Comparator<T> comparador, ArrayList<T> elementos){
        this.comparador = comparador;
        this.elementos = elementos;
        size = elementos.size();  
        if (size!= 0){
            heapify();  //O(size)
        }
    }

    private void heapify(){ //O(size)
        int posPadre = elementos.size() - 1;
        while (posPadre >= 0){  
            bajar(posPadre);    
            posPadre--;
        }
    }

    public void encolar(T elemento) {
        elementos.add(elemento);
        size++;
        int pos = size-1;
        
        //Inicializo handler transaccion
        if (elementos.get(0).getClass() == Transaccion.class){
            Transaccion transaccion = (Transaccion) elemento;

            transaccion.modificarHandlerTransaccion(pos);
    
        }
        //Inicializo handler usuario
        else if(elementos.get(0).getClass() == Usuario.class){
            Usuario usuarios = (Usuario) elemento;

            usuarios.modificarHandlerUsuario(pos);
        }

        subir(pos); //elemento está en la ultima posicion, es decir size-1
    }

    public void eliminarTransaccion(Transaccion transaccion){    //O(log(size)) porque buscar es O(1)
        int posicion;
        int posUltimo = size-1;

        if (comparador.getClass() == ComparadorTransaccion.class){
            posicion = transaccion.obtenerHandler();
            swap(posicion, posUltimo); 
            elementos.remove(posUltimo);
            size--;
            int posPadre = posPadre(posicion);
            if (posicion!=size){
            if (posicion != 0 && posMayorPrioridad(posicion, posPadre) == posicion){
                subir(posicion);
            }
            else{
                bajar(posicion);
            }
        }
    }
    }

    public Transaccion desencolarTransaccion(){   //O(log(size))
        T raiz = verRaiz();
        Transaccion res = (Transaccion) raiz;
        eliminarTransaccion(res);  //O(log(size))
        return res;
    }

    public int obtenerTamano(){
        return size;
    }

    public T verRaiz(){ 
        if (size == 0) return null;
        return elementos.get(0);
    }

    private int posPadre(int posHijo){
        return (posHijo - 1) / 2;
    }

    private int posMayorPrioridad(int pos1, int pos2) {
    if (pos1 >= size || pos2 >= size) {
        // Si alguno de los dos está fuera de rango, devolvemos el válido
        if (pos1 < size) return pos1;
        if (pos2 < size) return pos2;
        return 0; // Fallback seguro
    }
    if (comparador.compare(elementos.get(pos1), elementos.get(pos2)) > 0) {
        return pos1;
    } else {
        return pos2;
    }
    }


    public void actualizar(T elemento) {
    int pos = -1;
    if (elemento.getClass() == Transaccion.class) {
        pos = ((Transaccion) elemento).obtenerHandler();
    } else if (elemento.getClass() == Usuario.class) {
        pos = ((Usuario) elemento).obtenerHandler();
    }

    if (pos == -1) {
        encolar(elemento);
    } else {
        int posPadre = posPadre(pos);
        if (pos != 0 && posMayorPrioridad(pos, posPadre) == pos) {
            subir(pos);
        } else {
            bajar(pos);
        }
    }
}

    private void subir(int posicion) {
        int posPadre = posPadre(posicion);
        if (posicion != 0 && posMayorPrioridad(posicion, posPadre) == posicion) {
            swap(posicion, posPadre);
            posicion = posPadre;
        }
  }





    private void bajar(int i) {
        int n = size;
        while (true) {
            int izq = 2 * i + 1;
            int der = 2 * i + 2;
            int mayor = i;

            if (izq < n && comparador.compare(elementos.get(izq), elementos.get(mayor)) > 0)
                mayor = izq;
            if (der < n && comparador.compare(elementos.get(der), elementos.get(mayor)) > 0)
                mayor = der;

            if (mayor != i) {
                swap(i, mayor);
                i = mayor;
            } else break;
        }
    }

    private void swap(int i, int j) {
        T e1 = elementos.get(i);
        T e2 = elementos.get(j);
        elementos.set(i, e2);
        elementos.set(j, e1);

        if (e1.getClass() == Transaccion.class) {
            ((Transaccion) e1).modificarHandlerTransaccion(j);
        } else if (e1.getClass() == Usuario.class) {
            ((Usuario) e1).modificarHandlerUsuario(j);
        }

        if (e2.getClass() == Transaccion.class) {
            ((Transaccion) e2).modificarHandlerTransaccion(i);
        } else if (e2.getClass() == Usuario.class) {
            ((Usuario) e2).modificarHandlerUsuario(i);
        }
    }

    public boolean estaVacio() {
        return size == 0;
    }

    public int tamaño() {
        return size;
    }


}

























/* 
 * 
 import java.util.ArrayList;
 import java.util.Comparator;
 import java.util.List;
 
 public class Heap<T> {
    private ArrayList<T> datos;
    private Comparator<T> comparador;
    private int[] posicion; // posicion[id] = índice en datos, -1 si no está
    private PosicionCallback<T> getId; // interfaz para obtener id único de T
    
    public interface PosicionCallback<T> {
        int getId(T elem);
    }
    
    public Heap(Comparator<T> comparador, PosicionCallback<T> getId, int maxId) {
        this.comparador = comparador;
        this.datos = new ArrayList<>();
        this.posicion = new int[maxId + 1];
        for (int i = 0; i <= maxId; i++) posicion[i] = -1;
        this.getId = getId;
    }

    public void insertar(T elem) {
        datos.add(elem);
        int i = datos.size() - 1;
        posicion[getId.getId(elem)] = i;
        subir(i);
    }

    public T maximo() {
        return datos.isEmpty() ? null : datos.get(0);
    }

    public T extraerMax() {
        if (datos.isEmpty()) return null;
        T max = datos.get(0);
        int idMax = getId.getId(max);
        posicion[idMax] = -1;

        T ultimo = datos.remove(datos.size() - 1);
        if (!datos.isEmpty()) {
            datos.set(0, ultimo);
            posicion[getId.getId(ultimo)] = 0;
            bajar(0);
        }
        return max;
    }

    public boolean estaVacio() {
        return datos.isEmpty();
    }

    //Actualiza la posición del elemento elem en el heap 
    public void actualizar(T elem) {
        int id = getId.getId(elem);
        int i = posicion[id];
        if (i == -1) {
            // No está en el heap, insertarlo
            insertar(elem);
        } else {
            // Intentar subir y bajar para ajustar posición
            if (!subir(i)) bajar(i);
        }
    }

    public void reconstruir(List<T> elems) {
        datos.clear();
        datos.addAll(elems);
        for (int i = 0; i < datos.size(); i++) {
            posicion[getId.getId(datos.get(i))] = i;
        }
        for (int i = datos.size() / 2 - 1; i >= 0; i--) {
            bajar(i);
        }
    }

    // Devuelve true si flotó, false si no
    private boolean subir(int i) {
        boolean arriba = false;
        while (i > 0) {
            int padre = (i - 1) / 2;
            if (comparador.compare(datos.get(i), datos.get(padre)) > 0) {
                intercambiar(i, padre);
                i = padre;
                arriba = true;
            } else {
                break;
            }
        }
        return arriba;
    }
    
    private void bajar(int i) {
        int n = datos.size();
        while (true) {
            int hijoIzq = 2 * i + 1;
            int hijoDer = 2 * i + 2;
            int mayor = i;
            
            if (hijoIzq < n && comparador.compare(datos.get(hijoIzq), datos.get(mayor)) > 0)
                mayor = hijoIzq;
            if (hijoDer < n && comparador.compare(datos.get(hijoDer), datos.get(mayor)) > 0)
                mayor = hijoDer;
                
            if (mayor != i) {
                intercambiar(i, mayor);
                i = mayor;
            } else {
                break;
            }
        }
    }

    private void intercambiar(int i, int j) {
        T tmp = datos.get(i);
        datos.set(i, datos.get(j));
        datos.set(j, tmp);
        posicion[getId.getId(datos.get(i))] = i;
        posicion[getId.getId(datos.get(j))] = j;
    }
}

*/
















/*
public class Heap<T> {
    private ArrayList<T> datos;
    private Comparator<T> comparador;

    public Heap(Comparator<T> comparador) {
        this.comparador = comparador;
        this.datos = new ArrayList<>();
    }

    // Nuevo constructor para crear heap a partir de lista existente
    public Heap(Comparator<T> comparador, List<T> elementos) {
        this.comparador = comparador;
        this.datos = new ArrayList<>(elementos);
        heapify();
    }

    public void insertar(T elem) {
        datos.add(elem);
        subir(datos.size() - 1);
    }

    public T maximo() {
        return datos.get(0);
    }

    public T extraerMax() {
        if (datos.isEmpty()) return null;
        T max = datos.get(0);
        T ultimo = datos.remove(datos.size() - 1);
        if (!datos.isEmpty()) {
            datos.set(0, ultimo);
            bajar(0);
        }
        return max;
    }

    public boolean estaVacio() {
        return datos.isEmpty();
    }

    // Nuevo método para reconstruir el heap completo en O(n)
    public void heapify() {
        for (int i = (datos.size() / 2) - 1; i >= 0; i--) {
            bajar(i);
        }
    }

    private void subir(int i) {
        while (i > 0) {
            int padre = (i - 1) / 2;
            if (comparador.compare(datos.get(i), datos.get(padre)) > 0) {
                intercambiar(i, padre);
                i = padre;
            } else {
                break;
            }
        }
    }

    private void bajar(int i) {
        int hijoIzq = 2 * i + 1;
        int hijoDer = 2 * i + 2;
        int mayor = i;

        if (hijoIzq < datos.size() && comparador.compare(datos.get(hijoIzq), datos.get(mayor)) > 0)
            mayor = hijoIzq;
        if (hijoDer < datos.size() && comparador.compare(datos.get(hijoDer), datos.get(mayor)) > 0)
            mayor = hijoDer;

        if (mayor != i) {
            intercambiar(i, mayor);
            bajar(mayor);
        }
    }

    private void intercambiar(int i, int j) {
        T tmp = datos.get(i);
        datos.set(i, datos.get(j));
        datos.set(j, tmp);
    }
    
    // Opcional: método para vaciar y reconstruir heap desde lista externa
    public void reconstruir(List<T> elementos) {
        datos.clear();
        datos.addAll(elementos);
        heapify();
    }
}
*/

/*
public class Heap<T> {
    private ArrayList<T> datos;
    private Comparator<T> comparador;

    public Heap(Comparator<T> comparador) {
        this.comparador = comparador;
        this.datos = new ArrayList<>();
    }

    public void insertar(T elem) {
        datos.add(elem);
        subir(datos.size() - 1);
    }

    public T maximo() {
        return datos.get(0);
    }

    public T extraerMax() {
        if (datos.isEmpty()) return null;
        T max = datos.get(0);
        T ultimo = datos.remove(datos.size() - 1);
        if (!datos.isEmpty()) {
            datos.set(0, ultimo);
            bajar(0);
        }
        return max;
    }

    public boolean estaVacio() {
        return datos.isEmpty();
    }

    private void subir(int i) {
        while (i > 0) {
            int padre = (i - 1) / 2;
            if (comparador.compare(datos.get(i), datos.get(padre)) > 0) {
                intercambiar(i, padre);
                i = padre;
            } else {
                break;
            }
        }
    }

    private void bajar(int i) {
        int hijoIzq = 2 * i + 1;
        int hijoDer = 2 * i + 2;
        int mayor = i;

        if (hijoIzq < datos.size() && comparador.compare(datos.get(hijoIzq), datos.get(mayor)) > 0)
            mayor = hijoIzq;
        if (hijoDer < datos.size() && comparador.compare(datos.get(hijoDer), datos.get(mayor)) > 0)
            mayor = hijoDer;

        if (mayor != i) {
            intercambiar(i, mayor);
            bajar(mayor);
        }
    }

    private void intercambiar(int i, int j) {
        T tmp = datos.get(i);
        datos.set(i, datos.get(j));
        datos.set(j, tmp);
    }
}
*/