import java.util.*;

public class QUIZ {
    public static void main(String[] args) {

        int numeroElegido;
        String[] preguntasSeleccionadas;
        int preguntasAleatorias;
        char[] respuestasPreguntas;
        int randomArray;
        String[] preguntas;
        int[] pRandom;
        int puntuacionPosicion = 0;
        boolean exit = false;
        boolean aciertos;
        char respuesta = 0;
        int numAciertos = 0;

        explicacionQuiz();
        numeroElegido = respuestaQuiz();
        preguntas = preguntasArray();
        respuestasPreguntas = respuestasPreguntasArray();
        pRandom = preguntasRandom(numeroElegido);
        do {
            preguntas = ensenarPreguntas(preguntas, pRandom, puntuacionPosicion);
            respuesta = responderPreguntas(respuesta);
            aciertos = comprobarAciertosPretegunta(respuesta, respuestasPreguntas, pRandom, puntuacionPosicion);
            numAciertos = sumarAciertos(aciertos, numAciertos);
            puntuacionPosicion = puntuacion(puntuacionPosicion);
            exit = mostrarAciertos(numAciertos, exit, numeroElegido, puntuacionPosicion);

        } while (!exit);

    }

    private static boolean mostrarAciertos(int aciertos, boolean exit, int numeroElegido, int puntuacionPosicion) {
        if (puntuacionPosicion == numeroElegido) {
            float porcentajeAciertos = (float) aciertos / numeroElegido * 100;
            float porcentajeFallos = 100 - porcentajeAciertos;

            System.out.println("El usuario ha respondido desde " + porcentajeFallos + "% hasta " + porcentajeAciertos + "%");

            exit = true;

        }

        return exit;
    }

    private static int sumarAciertos(boolean aciertos, int numAciertos) {
        if (aciertos == true) {
            numAciertos++;
        }

        return numAciertos;
    }

    private static boolean comprobarAciertosPretegunta(char respuesta, char[] respuestasPreguntas, int[] pRandom, int puntuacionPosicion) {
        boolean acierto = false;
        if (respuesta == respuestasPreguntas[pRandom[puntuacionPosicion]]) {
            acierto = true;
        } else {
            acierto = false;
        }

        return acierto;
    }

    private static char responderPreguntas(char respuesta) {
        boolean salir = false;

        respuesta = Teclat.llegirChar();

        do {
            if (respuesta == ('s') || respuesta == ('n')) {
                salir = true;
            } else {
                System.out.println("Responde con un 's' o 'n'");
                respuesta = Teclat.llegirChar();
            }
        } while (!salir);

        return respuesta;
    }

    private static int puntuacion(int puntuacionPosicion) {
        puntuacionPosicion++;

        return puntuacionPosicion;
    }

    private static String[] ensenarPreguntas(String[] preguntas, int[] pRandom, int puntuacionPosicion) {
        System.out.println(preguntas[pRandom[puntuacionPosicion]]);

        return preguntas;
    }

    private static int[] preguntasRandom(int numeroElegido) {
        int[] pRandom = new int[numeroElegido];

        Random random = new Random();
        int preguntaRandom = 0;

        Set<Integer> preguntasSeleccionadas = new HashSet<>();

        for (int i = 0; i < numeroElegido; i++) {
            do {
                preguntaRandom = random.nextInt(20);
            } while (preguntasSeleccionadas.contains(preguntaRandom));

            preguntasSeleccionadas.add(preguntaRandom);
            pRandom[i] = (preguntaRandom);
        }

        return pRandom;
    }

    private static char[] respuestasPreguntasArray() {
        char[] respuestas = new char[20];
        respuestas[0] = 's';
        respuestas[1] = 's';
        respuestas[2] = 's';
        respuestas[3] = 's';
        respuestas[4] = 's';
        respuestas[5] = 's';
        respuestas[6] = 'n';
        respuestas[7] = 's';
        respuestas[8] = 's';
        respuestas[9] = 'n';
        respuestas[10] = 's';
        respuestas[11] = 's';
        respuestas[12] = 's';
        respuestas[13] = 's';
        respuestas[14] = 's';
        respuestas[15] = 's';
        respuestas[16] = 's';
        respuestas[17] = 's';
        respuestas[18] = 's';
        respuestas[19] = 's';

        return respuestas;
    }

    private static String[] preguntasArray() {
        String[] preguntas = new String[20];
        preguntas[0] = "El futbol es un deporte de equipo?";
        preguntas[1] = "La natación es un deporte individual?";
        preguntas[2] = "El tenis es un deporte de raqueta?";
        preguntas[3] = "El rugby es un deporte de contacto?";
        preguntas[4] = "Ciclismo es de resistencia?";
        preguntas[5] = "En el atletismo es importante la velocidad?";
        preguntas[6] = "En el boxeo se pueden dar golpes detras de la cabeza?";
        preguntas[7] = "En el beisbol es importante un lanzador fuerte?";
        preguntas[8] = "El futbol es un deporte de equipo?";
        preguntas[9] = "El yoga es un deporte?";
        preguntas[10] = "En el gimnasio se puede trabajar pesado?";
        preguntas[11] = "En el gimnasio se gana masa muscular?";
        preguntas[12] = "El entrenador personal entiende de deportes?";
        preguntas[13] = "El surf es un deporte acuatico?";
        preguntas[14] = "El golf es un deporte?";
        preguntas[15] = "Estar sentado es un deporte?";
        preguntas[16] = "Dormir es un deporte?";
        preguntas[17] = "Hacer la siesta deberia ser un deporte dentro de Andalucia?";
        preguntas[18] = "Comer proteina nos ayuda?";
        preguntas[19] = "Cagar es un deporte nacional?";

        return preguntas;
    }

    private static int respuestaQuiz() {
        int numeroPreguntas = 0;
        boolean exit = false;

        System.out.println("Cuantas preguntas quieres responder? ");
        numeroPreguntas = Teclat.llegirInt();

        do {
            if (numeroPreguntas > 20) {
                System.out.println("El numero maximo de preguntas son 20.");
                System.out.println("Pon un numero entro 5 y 20: ");
                numeroPreguntas = Teclat.llegirInt();
            } else if (numeroPreguntas < 5) {
                System.out.println("El numero minimo de preguntas son 5.");
                System.out.println("Pon un numero entre 5 y 20");
                numeroPreguntas = Teclat.llegirInt();
            } else {
                exit = true;
            }
        } while (!exit);

        return numeroPreguntas;
    }

    private static void explicacionQuiz() {
        System.out.println("Bienvenido al Quizz!");
        System.out.println("Como se juega?");
        System.out.println("Despues de esta introducción tendras que elegir cuantas preguntas intentaras responder" +
                "El minimo son de 5 y seran preguntas aleatorias, no seran siempre las mismas y solo se puede responder " +
                "con S(s) o N(n), Suerte!");
    }
}
