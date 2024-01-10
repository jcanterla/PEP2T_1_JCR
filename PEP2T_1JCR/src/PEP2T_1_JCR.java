import java.util.Scanner;

public class PEP2T_1_JCR {

    private double saldo;
    private double max_retirada;

    public PEP2T_1_JCR(double saldo, double max_retirada) {
        this.saldo = saldo;
        this.max_retirada = max_retirada;
    }

    public void menu(){
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
            switch (opcion) {
                case 1:
                    retirarDinero();
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no valida, inserte nueva opción");
            }
        } while (opcion != 3);

    }

    private void retirarDinero(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Su saldo actual es de " + saldo +" €");
        System.out.println("Teclee dinero a retirar: ");
        double dinero = teclado.nextDouble();

        if (dinero > saldo){
            System.out.println("Saldo insuficiente");
        } else if (dinero > max_retirada) {
            System.out.println("Intenta retirar " + dinero + " €");
            System.out.println("Tiene establecido un tope de " + max_retirada + " €");
            System.out.println("Su saldo actual es de " + saldo +" €");
        } else {
            saldo -= dinero;
            max_retirada -= dinero;
            System.out.println("Usted retiró " + dinero + " €");
            System.out.println("Su saldo actual es de " + saldo +" €");
        }
    }


    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Saldo inicial: ");
        Double saldoInicial = teclado.nextDouble();
        System.out.println("Máximo retirada inicial: ");
        Double max_retiradaInicial = teclado.nextDouble();

        PEP2T_1_JCR p = new PEP2T_1_JCR(saldoInicial, max_retiradaInicial);
        p.menu();
    }
}
