package GUI;

import Controladores.ControladorComprador;
import Controladores.ControladorExpendedor;
import org.tarea3.*;

import java.time.*;

public class Aplicacion {
    public static void main(String[] args){
        Ventana v = new Ventana();
        Wallet w = new Wallet();
        Moneda m = new Moneda1000();
        w.addMoneda(m);
        Expendedor exp = new Expendedor(3);
        Comprador hRey = new Comprador(w);
        ControladorComprador controladorComprador = new ControladorComprador();
        ControladorExpendedor controlador = new ControladorExpendedor(exp,v.getpE());
        exp.compradorMoneda(m);



    }

}
