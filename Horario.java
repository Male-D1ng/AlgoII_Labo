package aed;

public class Horario {
    private int Hora;
    private int Minutos;

    public Horario(int hora, int minutos) {
        Hora = hora;
        Minutos = minutos;
    }

    public int hora() {
        return Hora;
    }

    public int minutos() {
        return Minutos;
    }

    @Override
    public String toString() {
        String hora_str = Integer.toString(Hora);
        String min_str = Integer.toString(Minutos);
        return hora_str + ":" + min_str;
    }

    @Override
    public boolean equals(Object otro) {
        boolean otroEsNull = (otro == null);
        boolean claseDistinta = otro.getClass() != this.getClass();
        if (otroEsNull || claseDistinta){
            return false;
        }
        else {
            Horario otroHorario = (Horario) otro;
            return (Hora == otroHorario.Hora) && (Minutos == otroHorario.Minutos);
        }
    }

}