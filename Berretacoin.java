package aed;
import java.util.*;
public class Berretacoin {

    
    public Berretacoin(int n_usuarios){
        throw new UnsupportedOperationException("Implementar!");
    }

    public void agregarBloque(Transaccion[] transacciones){
        throw new UnsupportedOperationException("Implementar!");
    }

    public Transaccion txMayorValorUltimoBloque(){
        throw new UnsupportedOperationException("Implementar!");
    }

    public Transaccion[] txUltimoBloque(){
        throw new UnsupportedOperationException("Implementar!");
    }

    public int maximoTenedor(){
        throw new UnsupportedOperationException("Implementar!");
    }

    public int montoMedioUltimoBloque(){
        throw new UnsupportedOperationException("Implementar!");
    }

    public void hackearTx(){
        throw new UnsupportedOperationException("Implementar!");
    }

////////////////////////////////////////////////////////////////////////////////////ARCHIVOS SEPARADOS EN CADA UNO ESTA SU PROPIO INICIALIZADOR
    private class es_Berretacoin implements Bloque { //lista enlazada 

     // inicializador/constructor

        public ListadeBloques(int id, int id_comprador, int id_vendedor, int monto) {
        this.id = id;
        this.id_comprador = id_comprador;
        this.id_vendedor = id_vendedor;
        this.monto = monto;
    }
        
        // Metodo = agrandar la lista
        // Metodo = cardinal del conjunto == longitud de la lista 
        // Metodo = acceder al ultimo  

    }
    private class es_Berretacoin implements Usuarios { //arreglo ordenado --> se guarda en un heap

    // inicializador/constructor

        public Usuarios(int id, int id_comprador, int id_vendedor, int monto) {

        this.id = id;
        this.id_comprador = id_comprador;
        this.id_vendedor = id_vendedor;
        this.monto = monto;

        // Metodo = agregarAdelante
        // Metodo = necesito que vengan a ayudarnos o a saber si lo que pensamos esta bien ejecutado
        }
        
    }

    private class es_Berretacoin implements Transaccion { // heap 
// inicializador/constructor

        public Transaccion(int id, int id_comprador, int id_vendedor, int monto) {

        this.id = id;
        this.id_comprador = id_comprador;
        this.id_vendedor = id_vendedor;
        this.monto = monto;
        // Metodo = Cardinal == cantidad de transacciones un bloque
        }

    }

    private class es_Berretacoin implements Heap {

        // inicializador/constructor

        public Heap(int id, int id_comprador, int id_vendedor, int monto) {

        this.id = id;
        this.id_comprador = id_comprador;
        this.id_vendedor = id_vendedor;
        this.monto = monto;
        }
    }


    private class es_Berretacoin implements ListaEnlazada {
        // inicializador/constructor

        public ListaEnlazada(int id, int id_comprador, int id_vendedor, int monto) {

        this.id = id;
        this.id_comprador = id_comprador;
        this.id_vendedor = id_vendedor;
        this.monto = monto;
        }


}
