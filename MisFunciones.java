package aed;

class Funciones {
    int cuadrado(int x) {
        int res = x*x;
        return res;
    }

    double distancia(double x, double y) {
        double res = Math.sqrt(x*x + y*y);
        return res;
    }
    boolean divideA(int n, int d) {
        boolean res = ((n%d) == 0); 
        return res; 
    }
    boolean esPar(int n) {
        boolean res = divideA (n,2);
        return res;
    }

    boolean esBisiesto(int n) {
        boolean res = (divideA(n,4) && !(divideA(n,100)) || divideA(n,400));
        return res;
    }

    int factorialIterativo(int n) {
        // COMPLETAR
        int res = 1;
        while (n > 0) {
           // int variable = (n-1);
            res = res*n;
            n = n-1;
        }
        return res;
        }
       /* if n == 0 {
            res = res*1;
        }
        else n>0 {
            res = res*n;
            n-=1;
        }
        return res */ 

    int factorialRecursivo(int n) {
        // COMPLETAR
        int res = 1;
        if (n == 0) {
            res = res*1;
        }
        else {
            res = n*factorialRecursivo(n-1);
        }
        return res;
    }

    int primo (int n) {
        int res = 0;
        if (n==0 || n==1) {
            res = 1;
        }
        int divisor = n;
        while (divisor>=1 && n>1) { 
            if (divideA(n, divisor)== true) {
                res += 1;
                divisor-=1;
            }
            else {
                divisor-=1;
            }
        }
        return res;

    }

    boolean esPrimo(int n) {
        // COMPLETAR
        boolean res;
        if (primo (n) == 2){
            res = true;
        }
        else {
            res = false;
        }
        return res;
    }

 


    int sumatoria(int[] numeros) {
        // COMPLETAR
        return 0;
    }

    int busqueda(int[] numeros, int buscado) {
        // COMPLETAR
        return 0;
    }

    boolean tienePrimo(int[] numeros) {
        // COMPLETAR
        return false;
    }

    boolean todosPares(int[] numeros) {
        // COMPLETAR
        return false;
    }

     boolean esPrefijo(String s1, String s2) {
        // COMPLETAR
        int numero = 0;
        int largo1 = s1.length();
        int largo2 = s2.length();
        boolean res = true;
        if (largo1 > largo2){
        res = false;
        return res;
        }
        while (numero < largo1){
        if (s1.charAt(numero) == (s2.charAt(numero))){
        numero += 1;
        }
        else {
        res = false;
        numero += 1;
        }
        }
        return res;
    }

    String inversa (String s1) {
        String res = new String();
        int largo1 = s1.length();
        for (int i = largo1 - 1 ;i >= 0; i--) {
            res += s1.charAt(i);
        }
        return res;
    }

    boolean esSufijo(String s1, String s2) {
        // COMPLETAR
        boolean res = true;
        if (esPrefijo(inversa(s1), inversa(s2))) {
            return res;
        
        }    else {
            res = false;
        }
            return res;
    }    
}
