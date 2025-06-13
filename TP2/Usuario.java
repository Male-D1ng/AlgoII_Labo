package aed;
public class Usuario implements Comparable<Usuario> {
    int id;
    int saldo;
    int cantTransacciones; // NUEVO
    int handler;
    int maxTenedor;

    public Usuario(int id) {
        this.id = id;
        this.saldo = 0;
        this.cantTransacciones = 0;
        handler = id;
        maxTenedor = id;
    }

    public int obtenerId(){
        return id;
    }

    public int obtenerHandler(){
        return handler;
    }

    public void modificarHandlerUsuario(int nuevo){
        handler = nuevo;
    }

    public void modificarMaxId(int id){
        maxTenedor = id;
    }

    public int obtenerSaldo() {
        return saldo;
    }

    public int obtenerCantTransacciones() {
        return cantTransacciones;
    }


    // Setters
    public void modificarSaldo(int delta) {
        this.saldo += delta;
    }

    public void incrementarTransacciones() {
        this.cantTransacciones++;
    }

    public void decrementarTransacciones() {
        if (this.cantTransacciones > 0) {
            this.cantTransacciones--;
        }
    }

    public void resetearHandler() {
        this.handler = -1;

    }

    @Override
    public int compareTo(Usuario otro) {
        if (this.saldo != otro.saldo)
            return Integer.compare(this.saldo, otro.saldo);
        return Integer.compare(otro.id, this.id); // para desempatar con el id menor
    }

}

