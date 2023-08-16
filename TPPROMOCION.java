package tp.promocion;

import Utiles.TecladoIn;

/**
 *
 * @author gasto
 */
public class TPPROMOCION {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Este algoritmo muestra un menu al usuario y le permite realizar diferentes acciones en funcion de el modulo que elija y las patentes que ingrese

        //Declaracion de variables
        String patente, patente2, continuar = "si";
        boolean seguir = true;
        int cantOcurrencias;

        //Asignacion de variables y ejecucion
        while (seguir) {
            switch (menu()) {
                case 1:
                    System.out.println("Ingrese la patente");
                    patente = TecladoIn.readLine();
                    if (verificaPatenteValida(patente)) {
                        System.out.println("La patente es valida");
                    } else {
                        System.out.println("La patente no es valida");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese la patente");
                    patente = TecladoIn.readLine();
                    porquePatenteEsInvalida(patente);
                    break;
                case 3:
                    System.out.println("Ingrese la patente n°1");
                    patente = TecladoIn.readLine();
                    System.out.println("Ingrese la patente n°2");
                    patente2 = TecladoIn.readLine();
                    if ((verificaPatenteValida(patente)) && (verificaPatenteValida(patente2))) {
                        if (siPatenteEsMenor(patente, patente2)) {
                            System.out.println("La patente n°1 es menor que la patente n° 2");
                        } else {
                            System.out.println("La patente n°1 no es menor que la patente n°2");
                        }
                    } else {
                        System.out.println("Patente/s invalida/s");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese la patente n°1");
                    patente = TecladoIn.readLine();
                    System.out.println("Ingrese la patente n°2");
                    patente2 = TecladoIn.readLine();
                    if (verificaPatenteValida(patente) && verificaPatenteValida(patente2)) {
                        if (verifPatentesIguales(patente, patente2)) {
                            System.out.println("Ambas patentes son iguales");
                        } else {
                            System.out.println("Las patentes no son iguales");
                        }
                    } else {
                        System.out.println("Patente/s invalida/s");
                    }
                    break;
                case 5:

                    System.out.println("La patente menor es " + patenteMenor());

                    break;
                case 6:
                    cantOcurrencias = patenteDuplicada();
                    if (cantOcurrencias > 0) {
                        System.out.println("La patente ingresada inicialmente esta duplicada " + cantOcurrencias + " veces");
                    } else {
                        System.out.println("La patente ingresada incialmente no esta duplicada");
                    }
                    break;
                case 7:
                    System.out.println("Ingrese una patente");
                    patente = TecladoIn.readLine();
                    if (verificaPatenteValida(patente)) {
                        if (patenteSiguiente(patente).equals("")) {
                            System.out.println("La patente ingresada ya esta en el limite maximo y no tiene una siguiente");
                        } else {
                            System.out.println("La patente siguiente incrementada en una unidad es: " + patenteSiguiente(patente));
                        }
                    } else {
                        System.out.println("Patente/s invalida");
                    }
                    break;
                case 8:
                    while (continuar.equalsIgnoreCase("si")) {
                        System.out.println("Ingrese un conjunto de patentes");
                        patente = TecladoIn.readLine();

                        if (validaConjuntoPatentes(patente)) {
                            System.out.println("La patente con el mayor numero es " + patenteMayorDelConjunto(patente));
                            System.out.println("Desea continuar? (si/no)");
                            continuar = TecladoIn.readLine();
                        }
                    }
                    continuar = "si";
                    break;
                case 9:
                    while (continuar.equalsIgnoreCase("si")) {
                        System.out.println("Ingrese la patente de la cual desea hallar las ocurrencias");
                        patente = TecladoIn.readLine();
                        if (verificaPatenteValida(patente)) {
                            System.out.println("Ingrese el conjunto de patentes con el cual desea buscar las ocurrencias");
                            patente2 = TecladoIn.readLine();
                            if (validaConjuntoPatentes(patente2)) {
                                if (patenteDuplicadaEnConjunto(patente, patente2) > 0) {
                                    System.out.println("El conjunto de  patentes ingresado inicialmente esta duplicado " + patenteDuplicadaEnConjunto(patente, patente2) + " veces");
                                } else {
                                    System.out.println("El conjunto de patenteS ingresado incialmente no esta duplicado");
                                }
                            }
                        } else {
                            System.out.println("La patente ingresada es invalida ya que:");
                            porquePatenteEsInvalida(patente);
                        }
                        System.out.println("Desea continuar? (si/no)");
                        continuar = TecladoIn.readLine();
                    }
                    continuar = "si";
                    break;
                case 10:
                    seguir = false;
                    break;
            }
        }
        //MODULOS
    }

    //MODULO 10
    public static int menu() {
        //Este modulo muestra un menu por pantalla y llama a otro modulo segun la eleccion del usuario.
        //No recibe parametros

        //Declaracion de variables
        int opcion;

        //Asignacion de variables y ejecucion
        do {
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("                                            MENU                                                    ");
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("1-Verificar una patente valida.");
            System.out.println("2-Determinar porque una patente no es valida.");
            System.out.println("3-Verificar si una patente es menor que otra.");
            System.out.println("4-Verificar si una patente es igual a otra.");
            System.out.println("5-Ingresar una secuencia de patente y obtener la patente menor.");
            System.out.println("6-Ingresar una secuencia de patente y una patente determinada A, y hallar cantidad de ocurrencias de A.");
            System.out.println("7-Incrementar el numero de una patente en una unidad.");
            System.out.println("8-Dada una secuencia de patentes (recibido por parametro en un String) obtener la patente mayor.");
            System.out.println("9-Dada una secuencia de patentes (recibido por parametro en un String) y una patente determinada A, hallar cantidad de ocurrencias de A.");
            System.out.println("10-Terminar.");
            System.out.println("----------------------------------------------------------------------------------------------------");

            opcion = TecladoIn.readLineInt();
        } while (opcion > 10 || opcion == 0);
        return opcion;
    }

    //MODULO 1
    public static boolean verificaPatenteValida(String patente) {
        //Este modulo verifica si la patente recibida es valida segun su formato
        //patente: Se refiere a la patente ingresada por el usuario
        //Tomamos la patente como valida solo si posee las letras mayusculas
        //El metodo isUpperCase de Character, que se escribe Character.isUpperCase(), lo representare en pseudocodigo como esMayuscula()

        //Declaraion de variables
        boolean patenteValida = false;

        //Asignacion de variables y ejecucion
        if (patente.length() == 7) {
            if (Character.isUpperCase(patente.charAt(0)) && Character.isUpperCase(patente.charAt(1))) {
                if (Character.isDigit(patente.charAt(2)) && Character.isDigit(patente.charAt(3)) && Character.isDigit(patente.charAt(4))) {
                    if (Character.isUpperCase(patente.charAt(5)) && Character.isUpperCase(patente.charAt(6))) {
                        patenteValida = true;
                    }
                }
            }
        }
        return patenteValida;
    }

    //MODULO 2
    public static void porquePatenteEsInvalida(String patente) {
        //Este modulo determina porque una patente ingresada no es valida
        //patente: Se refiere a la patente ingresada por el usuario
        //El metodo isLowerCase de Character, que se escribe Character.isLowerCase(), lo representare en pseudocodigo como esMinuscula()

        //Ejecucion
        if (Character.isDigit(patente.charAt(0)) || Character.isLowerCase(patente.charAt(0)) || Character.isDigit(patente.charAt(1)) || Character.isLowerCase(patente.charAt(1)) || Character.isLowerCase(patente.charAt(5)) || Character.isDigit(patente.charAt(5)) || Character.isLowerCase(patente.charAt(6)) || Character.isDigit(patente.charAt(6))) {
            System.out.println("Los primeros y ultimos dos caracteres de la patente deben ser letras en mayuscula");
        }
        if (Character.isLetter(patente.charAt(2)) || Character.isLetter(patente.charAt(3)) || Character.isLetter(patente.charAt(4))) {
            System.out.println("Los numeros de la patente son invalidos");
        }
        if ((patente.length() > 7) || patente.length() < 7) {
            System.out.println("La patente tiene una longitud incorrecta");
        }
    }

    //MODULO 3
    public static boolean siPatenteEsMenor(String patente, String patente2) {
        //Este modulo verifica si la patente es menor a la patente2, segun su orden lexicografico
        //patente: Se refiere a la primer patente ingresada por el usuario
        //patente2: Se refiere a la segunda patente ingresada por el usuario

        //Declaracion de variables
        boolean esMenor;

        //Ejecucion
        if (patente.compareTo(patente2) < 0) {
            esMenor = true;
        } else {
            esMenor = false;
        }
        return esMenor;
    }

    //MODULO 4
    public static boolean verifPatentesIguales(String patente, String patente2) {
        //Este modulo verifica si las patentes recibidas son iguales lexicograficamente
        //patente: Se refiere a la primer patente ingresada por el usuario
        //patente2: Se refiere a la segunda patente ingresada por el usuario

        //Declaracion de variables
        boolean sonIguales;

        //Ejecucion
        if (patente.equals(patente2)) {
            sonIguales = true;
        } else {
            sonIguales = false;
        }
        return sonIguales;
    }

    //MODULO 5
    public static String patenteMenor() {
        //Este modulo le pide al usuario que ingrese tantas patentes como desee y al final muestra la de menor numero
        //Este modulo no recibe parametros
        //El metodo parseInt de Integer, que se escribe Integer.parseInt(), lo representare en pseudocodigo como Entero.transformarAEntero()

        //Declaracion de variables
        String patenteMenor = "", seguir = "si", patente;
        int numMenor = 999, numPatente;

        //Asignacion de variables y ejecucion
        while (seguir.equalsIgnoreCase("si")) {
            System.out.println("Ingrese una patente");
            patente = TecladoIn.readLine();
            if (verificaPatenteValida(patente)) {
                numPatente = Integer.parseInt(patente.substring(2, 5));
                if (numPatente <= numMenor) {
                    patenteMenor = patente;
                    numMenor = numPatente;
                }
            } else {
                System.out.println("Esta patente es invalida ya que:");
                porquePatenteEsInvalida(patente);
            }
            System.out.println("Desea continuar? (si/no)");
            seguir = TecladoIn.readLine();
        }
        return patenteMenor;
    }

    //MODULO 6
    public static int patenteDuplicada() {
        //Este modulo le pide al usuario que ingrese tantas patentes como el quiera y al final muestra si esa patente se repitio y si fue asi, cuantas veces.
        //Este modulo no recibe parametros

        //Declaracion de variables
        String patente, patente2, seguir = "si";
        int cantOcurrencias = 0;
        boolean patenteValida = true;

        //Asignacion de variables y ejecucion
        while (patenteValida) {
            System.out.println("Ingrese la patente");
            patente = TecladoIn.readLine();
            if (verificaPatenteValida(patente)) {

                while (seguir.equalsIgnoreCase("si")) {

                    System.out.println("Ingrese nuevamente una patente");
                    patente2 = TecladoIn.readLine();
                    if (verificaPatenteValida(patente2)) {
                        if (patente.equals(patente2)) {
                            cantOcurrencias++;

                        }
                        System.out.println("Desea continuar? (si/no)");
                        seguir = TecladoIn.readLine();
                    } else {
                        System.out.println("Patente no valida");
                    }
                }
                patenteValida = false;
            }
            System.out.println("Patente invalida");
        }
        return cantOcurrencias;
    }
    //MODULO 7

    public static String patenteSiguiente(String patente) {
        //Este modulo crea una patente similar a la recibida como parametro pero con su numero aumentado en una unidad
        //patente: Es la patente ingresada por el usuario

        //Declaracion de variables
        String patente2 = "";
        int numPatente;

        //Asignacion de variables y ejecucion
        numPatente = Integer.parseInt(patente.substring(2, 5));
        if (numPatente <= 998) {
            numPatente++;
            if (numPatente > 99) {
                patente2 = "" + patente.substring(0, 2) + numPatente + patente.substring(5, 7);
            }
            if (numPatente < 10) {
                patente2 = "" + patente.substring(0, 2) + "00" + numPatente + patente.substring(5, 7);
            }
            if (numPatente > 9 && numPatente < 100) {
                patente2 = "" + patente.substring(0, 2) + "0" + numPatente + patente.substring(5, 7);
            }
        } else {
            patente2 = patenteSiguienteCaso999(patente);
        }
        return patente2;
    }
    //MODULO 7 AUXILIAR

    public static String patenteSiguienteCaso999(String patente) {
        //Este modulo se utilizara en caso de que el numero de la patente que fue ingresada en el modulo patenteSiguiente sea 999.
        //Este modulo aumenta una letra para mostrar la patente siguiente, ya que el numero al ser 999, no puede ser aumentado.
        //Este modulo crea la patente siguiente en caso de que el numero fuera 999
        //patente: Se refiere a la patente ingresada por el usuario
        //El metodo codePointAt de String, que se escribe patente.codePointAt(), lo representare en pseudocodigo como patente.numeroDeCodigoEn()

        //Declaracion de variables
        int codepoint;
        char caracter;
        String ceros = "000", patente2 = "";

        //Ejecucion
        if (patente.codePointAt(6) <= 89) {
            codepoint = (patente.charAt(6)) + 1;
            caracter = (char) codepoint;
            patente2 = ("" + patente.charAt(0) + patente.charAt(1) + ceros + patente.charAt(5) + caracter);
        } else {
            if (patente.codePointAt(5) <= 89) {
                codepoint = (patente.charAt(5)) + 1;
                caracter = (char) codepoint;
                patente2 = ("" + patente.charAt(0) + patente.charAt(1) + ceros + caracter + "A");
            } else {
                if (patente.codePointAt(1) <= 89) {
                    codepoint = (patente.charAt(1)) + 1;
                    caracter = (char) codepoint;
                    patente2 = ("" + patente.charAt(0) + caracter + ceros + "AA");
                } else {
                    if (patente.codePointAt(0) <= 89) {
                        codepoint = (patente.charAt(0)) + 1;
                        caracter = (char) codepoint;
                        patente2 = (caracter + "A000AA");
                    }
                }
            }
        }
        return patente2;
    }

    //MODULO 8
    public static String patenteMayorDelConjunto(String conjuntoPatente) {
        //Este modulo recibe un conjunto de patentes y muestra la de mayor numero
        //conjuntoPatente: Se refiere al conjunto de patentes ingresadas por el usuario

        //Declaracion de variables
        String patenteMayor = "", patente;
        int numMayor = 0, numPatente, cantPatentes, i, limInf = 0, limSup = 7;

        //Asignacion de variables y ejecucion
        cantPatentes = (conjuntoPatente.length() / 7);
        for (i = 0; i < cantPatentes; i++) {
            patente = conjuntoPatente.substring(limInf, limSup);
            numPatente = Integer.parseInt(patente.substring(2, 5));
            if (numPatente >= numMayor) {
                patenteMayor = patente;
                numMayor = numPatente;
            }
            limInf = limInf + 7;
            limSup = limSup + 7;
        }

        return patenteMayor;
    }

    //MODULO 9
    public static int patenteDuplicadaEnConjunto(String patente, String conjuntoPatentes) {
        //Este modulo verifica la cantidad de ocurrencias de la primer patente ingresada, dentro del conjunto de patentes
        //patente: Se refiere a la patente ingresada por el usuario, de la cual se deben contar la cantidad de ocurrencias
        //conjuntoPatentes: Se refiere al conjunto de patentes, el cual hay que recorrer y verificar la cantidad de ocurrencias de la primer patente

        //Declaracion de variables
        int cantOcurrencias = 0, limInf = 0, limSup = 7, i, cantPatentes;
        String patenteAComparar;

        //Asignacion de variables y ejecucion
        cantPatentes = conjuntoPatentes.length() / 7;
        for (i = 0; i < cantPatentes; i++) {
            patenteAComparar = conjuntoPatentes.substring(limInf, limSup);
            if (verifPatentesIguales(patente, patenteAComparar)) {
                cantOcurrencias++;
            }
            limInf = limInf + 7;
            limSup = limSup + 7;
        }
        return cantOcurrencias;
    }

    public static boolean validaConjuntoPatentes(String conjuntoPatente) {
        //Este modulo verifica si todas las patentes dentro del conjunto de patentes son validas
        //conjuntoPatente: Se refiere al conjunto de patentes a verificar

        //Declaracion de variables
        int i = 1, limInf = 0, limSup = 7, cantPatentes;
        String patente;
        boolean conjuntoValido = true;

        //Asignacion de variables y ejecucion
        cantPatentes = conjuntoPatente.length() / 7;
        if ((conjuntoPatente.length() % 7) == 0) {
            while (conjuntoValido == true && (i <= cantPatentes)) {

                patente = conjuntoPatente.substring(limInf, limSup);
                if (verificaPatenteValida(patente)) {
                    conjuntoValido = true;
                } else {
                    System.out.println("La patente n°" + i + " del conjunto no es valida ya que:");
                    porquePatenteEsInvalida(patente);
                    conjuntoValido = false;
                }
                limInf = limInf + 7;
                limSup = limSup + 7;
                i++;
            }
        } else {
            System.out.println("La longitud del conjunto de patentes es invalido");
            conjuntoValido = false;
        }
        return conjuntoValido;
    }

}
