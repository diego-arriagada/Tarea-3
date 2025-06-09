package Controladores;

import GUI.panelExpendedor;
import org.tarea3.*;

import javax.swing.*;

/**
 * ControladorExpendedor es la clase encargada de conectar la lógica del expendedor con el panel de expendedor en la interfaz gráfica.
 *
 * Escucha los eventos de la máquina y actualiza la interfaz gráfica en consecuencia.
 * En particular, permite seleccionar productos, realizar compras, retirar productos y manejar el vuelto.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class ControladorExpendedor {
    private Expendedor exp;
    private panelExpendedor panelExp;

    /**
     * Constructor de ControladorExpendedor.
     *
     * @param expend Instancia del expendedor que interactúa con el sistema.
     * @param comp Instancia del comprador que interactúa con el expendedor.
     * @param panelExpend Panel del expendedor donde se encuentran los botones de interacción.
     * @param conCompr Controlador del comprador para manejar las interacciones del comprador.
     */
    public ControladorExpendedor(Expendedor expend,Comprador comp, panelExpendedor panelExpend,ControladorComprador conCompr) {
        this.exp = expend;
        this.panelExp = panelExpend;
        this.panelExp.getPanSelProd().setStockInicial(exp.getNumProductosInicial());

        exp.addPropertyChangeListener(evt -> {
            switch (evt.getPropertyName()) {
                case "Valor Monedas":
                    panelExp.getPanelInput().mostrarCambios(evt.getNewValue());
                    break;
                case "Producto en Deposito":
                    panelExp.getPanelOut().mostrarCambios(evt.getNewValue());
                    break;
                case "Hay Vuelto":
                    panelExp.getPanelInput().mostrarVuelto(evt.getNewValue());
                    break;
                case "Producto para Retiro":
                    panelExp.getPanelOut().mostrarCambios(evt.getNewValue());
                    break;
                case "vuelto":
                    panelExp.getPanelInput().mostrarCambios(evt.getNewValue());
                    break;
                case "Monedas Almacenadas":
                    panelExp.getPanelInput().actualizarMonedasAlmacenadas();
            }
        });
        panelExp.getPanSelProd().getBotonCoca().addActionListener(e -> {
            exp.setProductoSeleccionado(0);
            panelExp.getPanelInput().getProducto().setText("COCA COLA ($500)");
        });
        panelExp.getPanSelProd().getBotonSprite().addActionListener(e -> {
            exp.setProductoSeleccionado(1);
            panelExp.getPanelInput().getProducto().setText("SPRITE ($400)");
        });
        panelExp.getPanSelProd().getBotonFanta().addActionListener(e -> {
            exp.setProductoSeleccionado(2);
            panelExp.getPanelInput().getProducto().setText("FANTA ($300)");
        });
        panelExp.getPanSelProd().getBotonSnickers().addActionListener(e -> {
            exp.setProductoSeleccionado(3);
            panelExp.getPanelInput().getProducto().setText("SNICKERS ($200)");
        });
        panelExp.getPanSelProd().getBotonSuper8().addActionListener(e -> {
            exp.setProductoSeleccionado(4);
            panelExp.getPanelInput().getProducto().setText("SUPER 8 ($100)");
        });
        panelExp.getPanelInput().getBotonComprar().addActionListener(e -> {
            try{
                exp.compraDeProducto();
                panelExpend.getPanSelProd().setStock(exp.getProductoSeleccionado(),exp.getCantidad(exp.getProductoSeleccionado()));
                panelExp.getPanelInput().getNotificacion().setText("COMPRA EXITOSA");

            }catch (Exception ex) {
                if (ex instanceof NoHayProductoException) {
                    panelExp.getPanelInput().getNotificacion().setText("PRODUCTO AGOTADO");
                } else if (ex instanceof PagoInsuficienteException) {
                    panelExp.getPanelInput().getNotificacion().setText("DINERO INSUFICIENTE");
                } else if (ex instanceof DepositoLlenoException) {
                    panelExp.getPanelInput().getNotificacion().setText("RETIRE PRODUCTO ANTES DE HACER OTRA COMPRA");
                } else{
                    ex.printStackTrace();
                }
            }
        });

        panelExp.getPanelOut().getProductoComprado().addActionListener(e -> {
            try {
                comp.añadirProducto(exp,exp.getProductoComprado());
                panelExp.getPanelInput().getNotificacion().setText("PRODUCTO RETIRADO");
            }catch (Exception ex){
                if (ex instanceof DepositoVacioException){
                    panelExp.getPanelInput().getNotificacion().setText("NO HAY PRODUCTO PARA RETIRAR");
                }

            }
        });
        panelExp.getPanelInput().getBotonDevolverMonedas().addActionListener(e -> {
            panelExp.getPanelInput().getDinero().setText("$0");
            exp.getWallet().vaciarWallet();
            exp.crearVuelto();
            if (!exp.getMonVu().getDeposito().isEmpty()){
                panelExp.getPanelInput().getBotonSacarMonedas().setIcon(new ImageIcon(getClass().getResource("/img/monedasLleno.png")));

            }
        });
        panelExp.getPanelInput().getBotonSacarMonedas().addActionListener(e -> {
            //implementar metodo para pasar el vuelto al comprador
            panelExp.getPanelInput().getBotonSacarMonedas().setIcon(new ImageIcon(getClass().getResource("/img/monedasVacio.png")));
            if (!exp.getMonVu().getDeposito().isEmpty()){
                panelExp.getPanelInput().getNotificacion().setText("VUELTO RETIRADO");
                while (!exp.getMonVu().getDeposito().isEmpty()){
                    comp.sacarVuelto(exp);

                }
            } else {
                panelExp.getPanelInput().getNotificacion().setText("NO HAY VUELTO");
            }
        });
        panelExp.getPanelInput().getBotonAgregarStock().addActionListener(e -> {
            expend.agregarStock();
            panelExpend.getPanSelProd().setStock(0, exp.getCantidad(0));
            panelExpend.getPanSelProd().setStock(1, exp.getCantidad(1));
            panelExpend.getPanSelProd().setStock(2, exp.getCantidad(2));
            panelExpend.getPanSelProd().setStock(3, exp.getCantidad(3));
            panelExpend.getPanSelProd().setStock(4, exp.getCantidad(4));

        });
    }
}