import java.util.Scanner;

public class PEP2T_1_JCR {

    // Atributos
    private double saldo;
    private double max_retirada;

    // Constructor
    public PEP2T_1_JCR(double saldo, double max_retirada) {
        this.saldo = saldo;
        this.max_retirada = max_retirada;
    }

    // Menu
    public void menu(){
        // Introducir por teclado la opción
        Scanner teclado = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("PROGRAMA CAJERO AUTOMÁTICO");
            System.out.println("Menú de Opciones");
            System.out.println("================");
            System.out.println("1) Retirada de dinero");
            System.out.println("2) Ingreso de dinero");
            System.out.println("3) Salir");
            System.out.println("Opción: ");
            opcion = teclado.nextInt();
            // Elegir la opción a usar
            switch (opcion) {
                case 1:
                    retirada();
                    break;
                case 2:
                    ingreso();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no valida, inserte nueva opción");
                    break;
            }
        } while (opcion != 3);
    }

    // Valor del saldo actual
    private void verif_saldo() {
        System.out.println("Su saldo actual es de " + saldo +" €");
    }

    // Valor del tope actual
    private void verif_tope() {
        System.out.println("Tiene establecido un tope de " + max_retirada + " €");
    }

    // Retirar dinero
    private void retirada(){
        // Introducir por teclado dinero a retirar
        Scanner teclado = new Scanner(System.in);
        verif_saldo();
        System.out.println("Teclee dinero a retirar: ");
        double dinero = teclado.nextDouble();
        // Averiguar si cumple el dinero a retirar
        if(dinero > max_retirada || dinero > saldo) {
            System.out.println("Intenta retirar " + dinero + " €");
            verif_tope();
            verif_saldo();
        // Realizar operación de retirada
        } else {
            saldo -= dinero;
            max_retirada -= dinero;
            System.out.println("Usted retiró " + dinero + " €");
            verif_saldo();
        }
    }

    // Ingresar dinero
    private void ingreso(){
        // Introducir por teclado dinero a ingresar
        Scanner teclado2 = new Scanner(System.in);
        verif_saldo();
        System.out.println("Teclee dinero a ingresar: ");
        double dinero = teclado2.nextDouble();
        // Realizar operación de ingresado
        saldo += dinero;
        System.out.println("Usted ingresó " + dinero + " €");
        // Verificar si el saldo aumentó
        verif_saldo();

    }

    // Comprobar el funcionamiento de los métodos
    public static void main(String[] args) {
        // Insertar argumentos de saldo y tope a retirar
        PEP2T_1_JCR p = new PEP2T_1_JCR(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        // Llamada al menu
        p.menu();
    }
}
