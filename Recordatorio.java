package aed;

public class Recordatorio {
    private String Mensaje;
    private Fecha Fecha;
    private Horario Horario;
    private Fecha nuevaFecha;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        Mensaje = mensaje;
        Fecha = new Fecha (fecha);
        Horario = horario;
    }

    public Horario horario() {
        return Horario;
    }

    public Fecha fecha() {
        nuevaFecha = new Fecha (Fecha);
        return nuevaFecha;
    }

    public String mensaje() {
        return Mensaje;
    }

    @Override
    public String toString() {
        return Mensaje + " " + "@" + " " + Fecha + " " + Horario;
    }

    //////////////////////////////////////////////////REVUSAR EQUALS
    @Override
    public boolean equals(Object otro) {
        boolean otroEsNull = (otro == null);
        boolean claseDistinta = otro.getClass() != this.getClass();
        if (otroEsNull || claseDistinta){
            return false;
        }
        else {
            Recordatorio otroRecordatorio = (Recordatorio) otro;
            return ((Mensaj.equals(otroRecordatorio.Mensaje)) && (Fecha.equals(otroRecordatorio.Fecha)) && (Horario.equals(otroRecordatorio.Horario)));
    }

}
}
