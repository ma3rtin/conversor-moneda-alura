import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    public static void main(String[] args) throws IOException, InterruptedException {
        mostrarMenu();
    }

    public static void mostrarMenu() throws IOException, InterruptedException {
        int opcion;
        do{
            System.out.println("""
                Bienvenido a Money X Change
                1) Dolar a Peso Argentino
                2) Peso Argentino a Dolar
                3) Dolar a Real Brasileño
                4) Real Brasileño a Dolar
                5) Dolar a Peso Colombiano
                6) Peso Colombiano a Dolar
                7) Salir
                Elija una opción valida:
                """);
            opcion = scanner.nextInt();
            conversion(opcion);
        }while (opcion != 7);
    }

    private static void conversion(int opcion) throws IOException, InterruptedException {
        if (opcion < 1 || opcion > 7){
            System.out.println("Opción inválida. Intente nuevamente.");
            mostrarMenu();
        }else{
            if(opcion == 7){
                System.out.println("Saliendo del programa...");
            }else{
                System.out.println("Ingrese la cantidad a cambiar.");
                double cantidad = scanner.nextDouble();
                switch (opcion){
                    case 1:
                        Request.realizarCambio("USD", "ARS", cantidad);
                        break;
                    case 2:
                        Request.realizarCambio("ARS", "USD", cantidad);
                        break;
                    case 3:
                        Request.realizarCambio("USD", "BRL", cantidad);
                        break;
                    case 4:
                        Request.realizarCambio("BLR", "USD", cantidad);
                        break;
                    case 5:
                        Request.realizarCambio("USD", "COP", cantidad);
                        break;
                    case 6:
                        Request.realizarCambio("COP", "USD", cantidad);
                        break;
                }
            }

        }
    }
}