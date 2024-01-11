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
            System.out.println("\t\t\t\t\033[1m\033[4mPROGRAMA CAJERO AUTOMÁTICO\033[0m");
            System.out.println("\t\t\t\t\t\033[1mMenú de Opciones\033[0m");
            System.out.println("\t\t\t\t\t\033[1m================\033[0m\n");
            System.out.println("\t\t1) Retirada de dinero");
            System.out.println("\t\t2) Ingreso de dinero");
            System.out.println("\t\t3) Salir");
            System.out.print("\t\t\t\t\tOpción: ");
            opcion = teclado.nextInt();
            System.out.println();
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
                    System.out.println("\t\tOpción no valida, inserte nueva opción");
                    break;
            }
        } while (opcion != 3);
    }

    // Valor del saldo actual
    private void verif_saldo() {
        System.out.println("\t\tSu saldo actual es de " + saldo +" €");
    }

    // Valor del tope actual
    private void verif_tope() {
        System.out.println("\t\tTiene establecido un tope de " + max_retirada + " €");
    }

    // Retirar dinero
    private void retirada(){
        // Introducir por teclado dinero a retirar
        Scanner teclado = new Scanner(System.in);
        verif_saldo();
        System.out.print("\t\tTeclee dinero a retirar: ");
        double dinero = teclado.nextDouble();
        // Averiguar si cumple el dinero a retirar
        if(dinero > max_retirada || dinero > saldo) {
            System.out.println("\t\tIntenta retirar " + dinero + " €");
            verif_tope();
            verif_saldo();
        // Realizar operación de retirada
        } else {
            saldo -= dinero;
            max_retirada -= dinero;
            System.out.println("\t\tUsted retiró " + dinero + " €");
            verif_saldo();
            System.out.println();
        }
    }

    // Ingresar dinero
    private void ingreso(){
        // Introducir por teclado dinero a ingresar
        Scanner teclado2 = new Scanner(System.in);
        verif_saldo();
        System.out.print("\t\tTeclee dinero a ingresar: ");
        double dinero = teclado2.nextDouble();
        // Realizar operación de ingresado
        saldo += dinero;
        System.out.println("\t\tUsted ingresó " + dinero + " €");
        // Verificar si el saldo aumentó
        verif_saldo();
        System.out.println();

    }

    // Comprobar el funcionamiento de los métodos
    public static void main(String[] args) {
        // Insertar argumentos de saldo y tope a retirar
        PEP2T_1_JCR p = new PEP2T_1_JCR(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        // Llamada al menu
        p.menu();
    }
}
