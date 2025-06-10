package aed;
import java.util.*;

public class Berretacoin {
/* 

private Usuarios [] usuarios;
private Bloque bloque;
private Transaccion transacciones;
private int longitud;

*/
    private Usuarios[] usuarios;
    private ListaEnlazada bloques;
    private int maxTenedorId;
    private int maxTenedorSaldo;

    
    public Berretacoin(int n_usuarios){
        usuarios = new Usuarios[n_usuarios];
        for (int i = 0; i < n_usuarios; i++) {
            usuarios[i] = new Usuarios(i + 1);
        }
        bloques = new ListaEnlazada();
        maxTenedorId = 1;
        maxTenedorSaldo = 0;
        }
    /*
    public int longitud() {
        return longitud;
    }
     */

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
        return maxTenedorId;
    }

    public int montoMedioUltimoBloque(){
        throw new UnsupportedOperationException("Implementar!");
    }

    public void hackearTx(){
        throw new UnsupportedOperationException("Implementar!");
    }
}
////////////////////////////////////////////////////////////////////////////////////ARCHIVOS SEPARADOS EN CADA UNO ESTA SU PROPIO INICIALIZADOR