public class Main{

    // Variables estáticas con los posibles valores para cada dígito romano
    static int[] valoresI = {1};  // 'I' se traduce a 1
    static int[] valoresV = {5};  // 'V' se traduce a 5
    static int[] valoresX = {0};  // 'X' se traduce a 0

    public static void main(String[] args) {
        // Entrada de ejemplo (números romanos)
        String[] numerosRomanos = {"I", "XX", "III", "IVII"};

        // Procesar cada número romano
        for (String numeroRomano : numerosRomanos) {
            int resultado = contarNumerosDistintos(numeroRomano);
            System.out.println(resultado); // Mostrar el resultado
        }
    }

    // Función que cuenta cuántos números distintos se pueden generar
    public static int contarNumerosDistintos(String numeroRomano) {
        // Lista para almacenar todas las combinaciones generadas
        String[] combinaciones = new String[1000];
        int contador = 0;

        // Empezamos con una combinación vacía
        combinaciones[0] = "";
        contador = 1;

        // Procesamos cada carácter del número romano
        for (int i = 0; i < numeroRomano.length(); i++) {
            char digito = numeroRomano.charAt(i);
            int[] valores;

            // Obtenemos los posibles valores del dígito
            if (digito == 'I') {
                valores = valoresI;
            } else if (digito == 'V') {
                valores = valoresV;
            } else { // Si es 'X'
                valores = valoresX;
            }

            // Generar nuevas combinaciones
            int combinacionesPrevias = contador;
            for (int j = 0; j < combinacionesPrevias; j++) {
                for (int valor : valores) {
                    combinaciones[contador] = combinaciones[j] + valor;
                    contador++;
                }
            }
        }

        // Contar las combinaciones únicas
        int unicas = 0;
        for (int i = 0; i < contador; i++) {
            boolean repetido = false;
            for (int j = 0; j < i; j++) {
                if (combinaciones[i].equals(combinaciones[j])) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                unicas++;
            }
        }

        return unicas; // Retorna la cantidad de combinaciones únicas
    }
}

