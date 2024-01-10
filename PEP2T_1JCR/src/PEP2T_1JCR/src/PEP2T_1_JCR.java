public class PEP2T_1_JCR {

    private double saldo;
    private double max_retirada;

    public PEP2T_1_JCR(double saldo, double max_retirada) {
        this.saldo = saldo;
        this.max_retirada = max_retirada;
    }

    public void menu(){
        System.out.println("PROGRAMA CAJERO AUTOMÁTICO");
        System.out.println("Menú de Opciones");
        System.out.println("================");
        System.out.println("1) Retirada de dinero");
        System.out.println("2) Ingreso de dinero");
        System.out.println("3) Salir");
    }


    public static void main(String[] args) {

    }
}
