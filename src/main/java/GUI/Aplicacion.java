package GUI;

import Controladores.ControladorExpendedor;
import org.tarea3.*;

import java.time.*;

public class Aplicacion {
    public static void main(String[] args) throws InterruptedException{
        Ventana v = new Ventana();
        Wallet w = new Wallet();
        Moneda m = new Moneda500();
        w.addMoneda(m);
        Expendedor exp = new Expendedor(5);
        Comprador hRey = new Comprador(w);
        ControladorExpendedor controlador = new ControladorExpendedor(exp,v.getpE());
        Thread.sleep(4000);
        exp.compradorMoneda(m);
        try{
            hRey.comprarProducto(1,exp);

        }catch (Exception ex){
            if (ex instanceof NoHayProductoException){
                System.out.println("nohay");
            }
            else if (ex instanceof PagoIncorrectoException){
                System.out.println("Pago malo");
            }
            else if (ex instanceof PagoInsuficienteException){
                System.out.println("nohayplata");
            }
        }


    }

}
