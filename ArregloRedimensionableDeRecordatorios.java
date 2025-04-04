package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio [] recordatorios;
    private int longitud;

    public ArregloRedimensionableDeRecordatorios() {
        recordatorios = new Recordatorio [0];
        longitud = 0;
    }

    public int longitud() {
        return longitud;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio [] nuevos = new Recordatorio [longitud+1];

        for (int j=0; j<longitud; j++){
            nuevos[j] = recordatorios[j]; 
        }

        longitud=1+longitud;
        nuevos[longitud-1]=i;

        recordatorios = nuevos;
    }

    public Recordatorio obtener(int i) {
        return recordatorios[i];
    }

    public void quitarAtras() {
        Recordatorio [] nuevos = new Recordatorio [longitud-1];
        longitud=longitud-1;

        for (int j=0; j<longitud; j++){
            nuevos[j] = recordatorios[j]; 
        }

        recordatorios = nuevos;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        recordatorios[indice] = valor;

    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {

        longitud = vector.longitud();
        recordatorios = new Recordatorio[longitud];

        for (int i=0; i<longitud; i++){
            recordatorios[i] = vector.obtener(i);
        }
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios nuevo = new ArregloRedimensionableDeRecordatorios(this);
        return nuevo;
    }
}
