import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase Main, se hacen las pruebas de compras exitosas con distintos vueltos y productos, se testean las compras fallidas
 * utilizando las excepciones, y se hace uso de la interfaz Comparable y su metodo compareTo para usar .sort en un arraylist de
 * monedas
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */

public class Main {
    public static void main(String[] args){

        //COMPRAS EXITOSAS
        Expendedor e1 = new Expendedor(10);

        Moneda m1 = new Moneda1000();
        Comprador c1 = new Comprador(m1,1,e1);

        Moneda m2 = new Moneda500();
        Comprador c2 = new Comprador(m2,2,e1);

        Moneda m3 = new Moneda1000();
        Comprador c3 = new Comprador(m3,3,e1);

        Moneda m4 = new Moneda500();
        Comprador c4 = new Comprador(m4,4,e1);

        Moneda m5 = new Moneda100();
        Comprador c5 = new Comprador(m5,5,e1);

        //Excepciones
        Expendedor e2 = new Expendedor(10);

        Moneda m6 = null;
        Comprador c6 = new Comprador(m6,1,e2);

        Moneda m7 = new Moneda100();
        Comprador c7 = new Comprador(m7,2,e2);

        Expendedor vacio = new Expendedor(0);
        Moneda m8 = new Moneda1000();
        Comprador c8 = new Comprador(m8,4,vacio);

        Moneda m9 = new Moneda500();
        Comprador c9 = new Comprador(m9,99,e2);


        //Ordenamiento de monedas
        ArrayList<Moneda> arM = new ArrayList<>();
        arM.add(new Moneda500());
        arM.add(new Moneda1000());
        arM.add(new Moneda100());
        arM.add(new Moneda1000());
        System.out.println("Orden de monedas antes de sort: ");
        for(int i = 0;i<4;i++){
            System.out.print(arM.get(i) + " ");
        }
        Collections.sort(arM);
        System.out.println();
        System.out.println("Orden de monedas despues de sort: ");
        for(int i = 0;i<4;i++){
            System.out.print(arM.get(i) + " ");
        }
    }
}
