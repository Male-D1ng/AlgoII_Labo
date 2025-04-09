package aed;

public class Agenda {
    private Fecha fecha;
    private ArregloRedimensionableDeRecordatorios recordatorios;


    public Agenda(Fecha fechaActual) {
        fecha = new Fecha(fechaActual);
        recordatorios = new ArregloRedimensionableDeRecordatorios();
        // Implementar
        //otro comentario

    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        // Implementar
        recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        // Implementar
        String mensaje = fechaActual() + "\n" + ("=====\n"); 
        for (int i = 0; i<recordatorios.longitud();i++ ){
            if (recordatorios.obtener(i).fecha().equals(fechaActual())) {
            mensaje += recordatorios.obtener(i) + "\n";
                    }}
        return mensaje;
    }

    public void incrementarDia() {
        // Implementar
        fecha.incrementarDia();
    }

    public Fecha fechaActual() {
        // Implementar
        return fecha;
    }

}