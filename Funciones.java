package aed;

class Funciones {
    int cuadrado(int x) {
        // COMPLETAR
        int res = x * x;
        return res;
    }

    double distancia(double x, double y) {
        // COMPLETAR
        double res = Math.sqrt((x * x) + (y * y));
        return res;
    }

    boolean esPar(int n) {
        // COMPLETAR
        boolean res = false;
        if ((n % 2) == 0) {
            res = true;
        }
        return res;
    }

    boolean esBisiesto(int n) {
        // COMPLETAR
        boolean res = false;
        if ((n % 400) == 0) {
            res = true;
        } else if (((n % 4) == 0) && ((n % 100) != 0)) {
            res = true;
        }
        return res;
    }

    int factorialIterativo(int n) {
        // COMPLETAR
        int i;
        int res = 1;
        for (i = n; i >= 1; i--) { // cuando ya NO cumple NO entra (en el segundo)
            if (i == 0) {
                res *= 1;
            } else {
                res *= i; // ya habia puesto n y estaba mal porque n era siempre n
            }
        }
        return res;
    }

    int factorialRecursivo(int n) {
        // COMPLETAR
        int res = 1;
        if ((n == 0) || (n == 1)) {
            res *= 1;
        } else if (n > 1) {
            res *= n * factorialRecursivo(n - 1);
        }

        return res;
    }

    boolean esPrimo(int n) {
        // COMPLETAR
        boolean res = false;
        int numero = 2;
        if (n <= 1) {
            return res;
        } else {
            while (numero < n) {
                if ((n % numero) == 0) {
                    return res;
                }
                numero += 1;
            }

        }
        res = true;
        return res;
    }

    int sumatoria(int[] numeros) {
        // COMPLETAR
        int total = 0;
        for (int i = 0; i < numeros.length; i++) {
            total += numeros[i];
        }
        return total;
    }

    int busqueda(int[] numeros, int buscado) {
        // COMPLETAR
        for (int i = 0; i < numeros.length; i++) {
            if (buscado == numeros[i]) {
                return i;
            }
        }
        return 0; // si lo saco me da mal, porque el programa no sabe que hacer si
        // el n no entra en el for
    }

    boolean tienePrimo(int[] numeros) {
        // COMPLETAR
        boolean res = true;
        for (int i = 0; i < numeros.length; i++) {
            if (esPrimo(numeros[i]) == true) {
                return res;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        // COMPLETAR
        for (int i = 0; i < numeros.length; i++) {
            if ((numeros[i] % 2) != 0) {
                return false;
            }
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        // COMPLETAR
        int posicion = 0;
        if (s1.length() <= s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(posicion)) {
                    posicion += 1;
                } else {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    boolean esSufijo(String s1, String s2) {
        // COMPLETAR
        int posicion = s2.length() - 1;
        if (s1.length() <= s2.length()) {
            //while (posicion >= 0) {
                for (int i = ((s1.length()) - 1); i >= 0; i--) {
                    if (s1.charAt(i) != s2.charAt(posicion)) {
                       return false;
                    } 
                     posicion -= 1;
                }
            return true;
        }
        return false;
    }
}

// valen     len