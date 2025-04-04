package aed;

public class Fecha {
    private int Dia;
    private int Mes;
    
    public Fecha(int dia, int mes) {
        Dia = dia;
        Mes = mes;
    }
    public Fecha(Fecha fecha) {
        int nuevoDia = fecha.Dia;
        int nuevoMes = fecha.Mes;
        Dia = nuevoDia;
        Mes = nuevoMes;
    }
    public Integer dia() {
        return Dia;}
    public Integer mes() {
        return Mes;}

    public String toString() {
        return Dia+"/"+Mes;}
///////////////////////////////////////////////////////
    @Override
    public boolean equals(Object otra) {
        boolean otraEsNull = (otra == null);
        boolean claseDistinta = otra.getClass() != this.getClass();
        if (otraEsNull || claseDistinta){
            return false;
        }
        Fecha otraFecha = (Fecha) otra;
        return (Dia == otraFecha.Dia) && (Mes == otraFecha.Mes);}
        public void incrementarDia() {
            if (diasEnMes(Mes)< Dia + 1){ // si el mes tiene 31 dias, y el dia es 31, dia + 1 va a ser 32, osea el pirmero del mes siguiente.
                Dia = 1;
                if (Mes < 12){
                    Mes += 1;
                }
                else{
                    Mes = 1;
                }
            }
            else{
                Dia += 1;
            }
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