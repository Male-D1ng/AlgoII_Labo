package aed;
import java.util.Comparator;

public class ComparadorUsuarios implements Comparator<Usuario> {
    @Override
    public int compare(Usuario u1, Usuario u2) {
        if (u1.obtenerSaldo() != u2.obtenerSaldo()) {
            return Integer.compare(u2.obtenerSaldo(), u1.obtenerSaldo()); // saldo DESC
        } else {
            return Integer.compare(u2.obtenerId(), u1.obtenerId()); // id DESC
        }
    }
}

