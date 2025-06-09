package GUI;

import Controladores.ControladorComprador;
import Controladores.ControladorExpendedor;
import org.tarea3.*;

import java.time.*;

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
