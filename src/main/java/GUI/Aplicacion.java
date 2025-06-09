package GUI;

import Controladores.ControladorComprador;
import Controladores.ControladorExpendedor;
import org.tarea3.*;

import java.time.*;

/**
 * La clase Aplicacion es el punto de entrada principal de la aplicación.
 *
 * Esta clase inicializa el expendedor, la ventana principal y los controladores necesarios para manejar las interacciones entre el comprador y el expendedor.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class Aplicacion {
    public static void main(String[] args){
        Expendedor exp = new Expendedor(2);
        Ventana v = new Ventana(exp.getMonedasAlmacenadasWallet());

        Wallet w = new Wallet();
        Comprador hRey = new Comprador(w);
        ControladorComprador controladorComprador = new ControladorComprador(v,hRey,v.getpC(),w,exp);
        ControladorExpendedor controlador = new ControladorExpendedor(exp,hRey,v.getpE(),controladorComprador);
    }

}
