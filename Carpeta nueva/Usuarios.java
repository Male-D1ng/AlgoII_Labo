package aed;

public class Usuarios implements Comparable<Usuarios>{ //arreglo ordenado --> se guarda en un heap

    // inicializador/constructor
    int id;
    int saldo;

    public Usuarios (int id) {
        this.id = id;
        this.saldo = 0;
    }
    

    public int getId() { return id; }
    public int getSaldo() { return saldo; }

    @Override
    public int compareTo(Usuarios otro) {
    throw new UnsupportedOperationException("Implementar!");
    }

    }
       
        /*
         
        
        }
        
        @Override
        public boolean equals(Object otro){
            throw new UnsupportedOperationException("Implementar!");
        }
        
        */

