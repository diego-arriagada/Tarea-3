package GUI;

import Controladores.ControladorExpendedor;
import org.tarea3.Expendedor;
import org.tarea3.Moneda;
import org.tarea3.Moneda500;

import java.time.*;

public class Aplicacion {
    public static void main(String[] args) throws InterruptedException{
        Ventana v = new Ventana();
        Expendedor exp = new Expendedor(5);
        ControladorExpendedor controlador = new ControladorExpendedor(exp,v.getpE());
        Thread.sleep(4000);
        Moneda m = new Moneda500();
        exp.compradorMoneda(m);
    }

}
