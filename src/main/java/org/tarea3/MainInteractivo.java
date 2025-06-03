import java.util.Scanner;
/**
 * La clase `MainInteractivo` es una clase donde se puede utilizar
 * las funciones de la máquina expendedora casi sin limitaciones, hasta que el
 * usuario decida detenerse
 *
 * La unica limitación de este main interactivo son los productos disponibles dentro
 * de la maquina expendedora, que se limita a 10 productos por tipo de producto para poder
 * testear también que sucede en caso de que se acabe el stock de algún deposito
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class MainInteractivo {
    public static void main(String[] args) {
        boolean a = true;
        Expendedor exp = new Expendedor(99);
        Scanner scan = new Scanner(System.in);
        while (a){
            System.out.println("Indique el numero del producto que desea comprar, si desea finalizar ingrese 0");
            System.out.println("Op: 1 -> COCA, 2 -> SPRITE, 3 -> FANTA, 4 -> SNICKERS, 5 -> SUPER8, 0 -> SALIR");
            System.out.println("Precios: Coca->500, Sprite->400, Fanta->300, Snickers->200, Super8->100");
            String prod = scan.nextLine();
            int producto = Integer.parseInt(prod);
            if (producto == 0){
                System.out.println("Prueba Finalizada");
                break;
            }
            System.out.println("Indique el valor de la moneda a utilizar");
            System.out.println("Op: 100, 500, 1000");
            String mon = scan.nextLine();
            int mone = Integer.parseInt(mon);
            Moneda m = null;
            if (mone == 100){
                m = new Moneda100();
            } else if (mone == 500) {
                m = new Moneda500();
            } else if (mone == 1000) {
                m = new Moneda1000();
            }
            Comprador c = new Comprador(m, producto,exp);


        }
    }
}