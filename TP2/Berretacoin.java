package aed;
import java.util.ArrayList;
import java.util.List;

public class Berretacoin {
    private Usuario[] usuarios; // arreglo indexado por id
    private Heap<Usuario> heapUsuarios; // max heap con handlers para actualizar usuarios
    private ListaEnlazada<Bloque> cadena;
    private int maxIdTx;
    private Bloque ultimoBloque;

    public Berretacoin(int n_usuarios) {
        this.usuarios = new Usuario[n_usuarios + 1];
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        for (int i = 1; i <= n_usuarios; i++) {
            usuarios[i] = new Usuario(i);
            listaUsuarios.add(usuarios[i]);
        }

        // Inicializo el heap con los usuarios y comparador correspondiente
        heapUsuarios = new Heap<>(new ComparadorUsuarios(), listaUsuarios); // O(P)
        this.cadena = new ListaEnlazada<>();
        this.maxIdTx = n_usuarios;
    }

    public void agregarBloque(Transaccion[] transacciones) {
        // Encontrar el id máximo de transacción
        int maxIdTx = 0;
        for (Transaccion tx : transacciones) {
            maxIdTx = Math.max(maxIdTx, tx.obtenerId());
        }

        Bloque bloque = new Bloque();

        for (Transaccion tx : transacciones) {
            int idComprador = tx.id_comprador();
            int idVendedor = tx.id_vendedor();
            int monto = tx.monto();

            if (idComprador != 0) {
                usuarios[idComprador].modificarSaldo(-monto);
                usuarios[idComprador].incrementarTransacciones();
                heapUsuarios.actualizar(usuarios[idComprador]);
            }

            if (idVendedor != 0) {
                usuarios[idVendedor].modificarSaldo(monto);
                usuarios[idVendedor].incrementarTransacciones();
                heapUsuarios.actualizar(usuarios[idVendedor]);
            }

            bloque.agregarTransaccion(tx);
        }

        this.ultimoBloque = bloque;
        cadena.agregar(bloque);
    }

    public Transaccion txMayorValorUltimoBloque() {
        return ultimoBloque != null ? ultimoBloque.obtenerMax() : null;
    }

    public Transaccion[] txUltimoBloque() {
        if (ultimoBloque == null) return new Transaccion[0];
        List<Transaccion> lista = ultimoBloque.transaccionesOrdenadasPorId();
        return lista.toArray(new Transaccion[0]);
    }

    public int maximoTenedor() {
        return heapUsuarios.maximo().obtenerId();
    }

    public int montoMedioUltimoBloque() {
        if (ultimoBloque == null) return 0;
        int cant = ultimoBloque.cantidadTransaccionesValidas();
        return cant == 0 ? 0 : ultimoBloque.sumaMontos() / cant;
    }

    public void hackearTx() {
        if (ultimoBloque == null) return;

        Transaccion tx = ultimoBloque.extraerMax();
        if (tx == null) return;

        int idComprador = tx.id_comprador();
        int idVendedor = tx.id_vendedor();
        int monto = tx.monto();

        if (idComprador != 0) {
            usuarios[idComprador].modificarSaldo(monto);
            usuarios[idComprador].decrementarTransacciones();
            heapUsuarios.actualizar(usuarios[idComprador]);
        }

        if (idVendedor != 0) {
            usuarios[idVendedor].modificarSaldo(-monto);
            usuarios[idVendedor].decrementarTransacciones();
            heapUsuarios.actualizar(usuarios[idVendedor]);
        }
    }
}





















/*
public class Berretacoin {
    private Usuario[] usuarios; // arreglo ordenado por id
    private Heap<Usuario> heapUsuarios; // max-heap de usuarios por saldo (desempate por id menor)
    private ListaEnlazada<Bloque> cadena;

    public Berretacoin(int n_usuarios) {
        this.usuarios = new Usuario[n_usuarios + 1]; // usuarios[0] no se usa
        this.heapUsuarios = new Heap<>((a, b) -> {
            if (a.saldo != b.saldo) return Integer.compare(a.saldo, b.saldo);
            return Integer.compare(b.id, a.id); // menor id primero en caso de empate
        });
        for (int i = 1; i <= n_usuarios; i++) {
            usuarios[i] = new Usuario(i);
            heapUsuarios.insertar(usuarios[i]); // O(P log P), aceptable por construcción
        }
        this.cadena = new ListaEnlazada<>();
    }

    public Berretacoin(ListaEnlazada cadena, Heap<Usuario> heapUsuarios, Usuario[] usuarios) {
        this.cadena = cadena;
        this.heapUsuarios = heapUsuarios;
        this.usuarios = usuarios;
    }

    

    public void agregarBloque(List<Transaccion> transacciones) {
    Bloque bloque = new Bloque();

    for (Transaccion tx : transacciones) {
        if (tx.id_comprador != 0) {
            usuarios[tx.id_comprador].saldo -= tx.monto;
            usuarios[tx.id_comprador].cantTransacciones++;
            heapUsuarios.insertar(usuarios[tx.id_comprador]);  // actualizar heap
        }
        if (tx.id_vendedor != 0) {
            usuarios[tx.id_vendedor].saldo += tx.monto;
            usuarios[tx.id_vendedor].cantTransacciones++;
            heapUsuarios.insertar(usuarios[tx.id_vendedor]);   // actualizar heap
        }
        bloque.agregarTransaccion(tx);
    }

    cadena.agregar(bloque);
     // Reconstruir heap para reflejar los cambios de saldo
    reconstruirHeapUsuarios();
}

    public void agregarBloque(Transaccion[] transacciones) {
    // Convertís el array a lista y llamás al original
    agregarBloque(java.util.Arrays.asList(transacciones));
}

    public Transaccion txMayorValorUltimoBloque() {
        Bloque ultimo = (Bloque) cadena.ultimo();
        return ultimo != null ? ultimo.obtenerMax() : null;
    }

    public Transaccion[] txUltimoBloque() {
        Bloque ultimo = (Bloque) cadena.ultimo();
        if (ultimo == null) return new Transaccion[0];
        List<Transaccion> lista = ultimo.transaccionesOrdenadasPorId();
        return lista.toArray(new Transaccion[0]);
    }   


    public int maximoTenedor() {
        return heapUsuarios.maximo().id;
    }

    public int montoMedioUltimoBloque() {
        Bloque ultimo = (Bloque) cadena.ultimo();
        if (ultimo == null) return 0;
        int cant = ultimo.cantidadTransaccionesValidas();
        return cant == 0 ? 0 : ultimo.sumaMontos / cant;
    }

    

    public void hackearTx() {
        Bloque ultimo = (Bloque) cadena.ultimo();
        if (ultimo == null) return;

        Transaccion tx = ultimo.extraerMax();
        if (tx == null) return;

        if (tx.id_comprador != 0) {
            usuarios[tx.id_comprador].saldo += tx.monto;
            usuarios[tx.id_comprador].cantTransacciones--;
        }
        if (tx.id_vendedor != 0) {
            usuarios[tx.id_vendedor].saldo -= tx.monto;
            usuarios[tx.id_vendedor].cantTransacciones--;
        }

        reconstruirHeapUsuarios();
}


    public int usuarioConMasTransacciones() {
    int maxTransacciones = -1;
    int mejorId = -1;
    for (int i = 1; i < usuarios.length; i++) {
        Usuario u = usuarios[i];
        if (u.cantTransacciones > maxTransacciones ||
            (u.cantTransacciones == maxTransacciones && u.id < mejorId)) {
            maxTransacciones = u.cantTransacciones;
            mejorId = u.id;
        }
    }
    return mejorId;
}

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public void reconstruirHeapUsuarios() {
    // Omití usuarios[0] porque no se usa
    List<Usuario> listaUsuarios = new ArrayList<>();
    for (int i = 1; i < usuarios.length; i++) {
        listaUsuarios.add(usuarios[i]);
    }
    heapUsuarios.reconstruir(listaUsuarios);
}

}

*/



/* 
     * 
     public void agregarBloque(List<Transaccion> transacciones) {
        Bloque bloque = new Bloque();
        for (Transaccion tx : transacciones) {
            // aplicar efectos de la transacción
            if (tx.id_comprador != 0) {
                usuarios[tx.id_comprador].saldo -= tx.monto;
                heapUsuarios.insertar(usuarios[tx.id_comprador]);
            }
            if (tx.id_vendedor != 0) {
                usuarios[tx.id_vendedor].saldo += tx.monto;
                heapUsuarios.insertar(usuarios[tx.id_vendedor]);
            }
            bloque.agregarTransaccion(tx);
        }
        cadena.agregar(bloque);
    }
    */

/*
     * 
     public void hackearTx() {
        Bloque ultimo = (Bloque) cadena.ultimo();
        if (ultimo == null) return;
        Transaccion tx = ultimo.extraerMax();
        if (tx != null) {
            // Revertir la transacción
            if (tx.id_comprador != 0) {
                usuarios[tx.id_comprador].saldo += tx.monto;
                heapUsuarios.insertar(usuarios[tx.id_comprador]);
            }
            if (tx.id_vendedor != 0) {
                usuarios[tx.id_vendedor].saldo -= tx.monto;
                heapUsuarios.insertar(usuarios[tx.id_vendedor]);
            }
        }
    }
    */
