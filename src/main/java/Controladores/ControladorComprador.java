package Controladores;

import GUI.VentanaInventario;
import GUI.VentanaMonedero;
import GUI.panelComprador;
import org.tarea3.Comprador;
import org.tarea3.Expendedor;
import org.tarea3.Wallet;
import org.tarea3.Producto;
import GUI.Ventana;

import javax.swing.*;

/**
 * ControladorComprador es la clase encargada de manejar las interacciones del comprador con la interfaz gráfica, permitiendo acceder a su inventario y monedero.
 *
 * Al igual que el ControladorExpendedor, este controlador se encarga de vincular los botones en el panel del comprador
 * con la lógica general del sistema, permitiendo al comprador ver su inventario y monedero.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class ControladorComprador {
    private Comprador comp;
    private panelComprador pComp;

    /**
     * Constructor de ControladorComprador.
     *
     * @param ventana Ventana principal de la aplicación.
     * @param comprador Instancia del comprador que interactúa con el sistema.
     * @param panelComp Panel del comprador donde se encuentran los botones de interacción.
     * @param wComp Wallet del comprador que contiene las monedas.
     * @param exp Expendedor asociado al comprador.
     */
    public ControladorComprador(Ventana ventana,Comprador comprador, panelComprador panelComp, Wallet wComp, Expendedor exp){
        this.comp = comprador;
        this.pComp = panelComp;

        pComp.getBotonInventario().addActionListener(e -> {
            VentanaInventario inventario = new VentanaInventario(ventana,comp,comp.getModeloInventario());
            inventario.setVisible(true);
        });

        pComp.getBotonMonedero().addActionListener(e -> {
            VentanaMonedero monedero = new VentanaMonedero(ventana,comp,comp.getWallet(),comp.getModeloMonedero(),exp);
            monedero.setVisible(true);
        });
        pComp.getBotonTarjeta().addActionListener(e -> {
            comp.stonks();
            comp.sincronizarModelo();
        });
    }
    public Comprador getComprador(){
        return comp;
    }

}
