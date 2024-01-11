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
                    retirada();
                    break;
                case 2:
                    ingreso();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no valida, inserte nueva opción");
            }
        } while (opcion != 3);
    }

    private void verif_saldo() {
        System.out.println("Su saldo actual es de " + saldo +" €");
    }

    private void verif_tope() {
        System.out.println("Tiene establecido un tope de " + max_retirada + " €");
    }

    private void retirada(){
        Scanner teclado = new Scanner(System.in);
        verif_saldo();
        System.out.println("Teclee dinero a retirar: ");
        double dinero = teclado.nextDouble();
        if(dinero > max_retirada || dinero > saldo) {
            System.out.println("Intenta retirar " + dinero + " €");
            verif_tope();
            verif_saldo();
        } else {
            saldo -= dinero;
            max_retirada -= dinero;
            System.out.println("Usted retiró " + dinero + " €");
            verif_saldo();
        }
    }

    private void ingreso(){
        Scanner teclado2 = new Scanner(System.in);
        verif_saldo();
        System.out.println("Teclee dinero a ingresar: ");
        double dinero = teclado2.nextDouble();
        saldo += dinero;
        System.out.println("Usted ingresó " + dinero + " €");
        verif_saldo();

    }

    public static void main(String[] args) {
        PEP2T_1_JCR p = new PEP2T_1_JCR(Float.parseFloat(args[0]), Float.parseFloat(args[1]));
        p.menu();
    }
}
