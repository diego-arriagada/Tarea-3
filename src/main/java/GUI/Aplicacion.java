package GUI;

import Controladores.ControladorComprador;
import Controladores.ControladorExpendedor;
import org.tarea3.*;

import java.time.*;

public class Aplicacion {
    public static void main(String[] args){
        Ventana v = new Ventana();
        Wallet w = new Wallet();

        Expendedor exp = new Expendedor(2);
        Comprador hRey = new Comprador(w);
        ControladorComprador controladorComprador = new ControladorComprador(hRey,v.getpC(),w,exp);
        ControladorExpendedor controlador = new ControladorExpendedor(exp,hRey,v.getpE(),controladorComprador);




    }

}
