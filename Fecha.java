package aed;


public class Fecha {
    private int Dia;
    private int Mes;

    public Fecha(int dia, int mes) {
        Dia = dia;
        Mes = mes;
        // Implementar
    }

    public Fecha(Fecha fecha) {
        // Implementar
        int NuevoDia = fecha.Dia;
        int NuevoMes = fecha.Mes;
        Dia = NuevoDia;
        Mes = NuevoMes;

    }

    public Integer dia() {
        // Implementar
        return Dia;
    }

    public Integer mes() {
        // Implementar
        return Mes;
    }
    
    @Override
    public String toString() {;
        // Implementar
        //String d_string = Integer.toString(Dia);
        //String m_string = Integer.toString(Mes);
        return Dia +"/"+ Mes;
    }

    @Override
    public boolean equals(Object otra) {
        // Implementar
        boolean otraEsNull = (otra == null);
        boolean claseDistinta = otra.getClass() != this.getClass();
        if (otraEsNull || claseDistinta) {
            return false;
            }

            Fecha otraFecha = (Fecha) otra;
            return Dia == otraFecha.Dia && Mes == otraFecha.Mes;
    }

    public void incrementarDia() {
        // Implementar
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
