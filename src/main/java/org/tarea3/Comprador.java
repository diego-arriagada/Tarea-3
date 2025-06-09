package org.tarea3;

import javax.swing.*;

/**
 * Clase Comprador que representa a un comprador en el sistema de expendedor.
 *
 * Esta clase maneja el inventario de productos del comprador y su monedero.
 * Tiene un controlador dedicado que le permite interactuar con la GUI mediante botones para ver su inventario y monedero.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 2.0
 */
public class Comprador {
    private String sonidoProducto;
    private int vueltoTotal;
    private Wallet w;
    private Deposito<Producto> inventario;
    private DefaultListModel<Producto> modeloInventario = new DefaultListModel<>();
    private DefaultListModel<Moneda> modeloMonedero = new DefaultListModel<>();

    /**
     * Constructor de la clase Comprador.
     * Inicializa el inventario y el monedero del comprador con monedas predeterminadas, además de sincronizar el modelo de inventario y monedero.
     *
     * @param w Wallet del comprador que contiene las monedas.
     */
    public Comprador(Wallet w) {
        this.inventario = new Deposito<Producto>();
        this.w = w;
        w.addMoneda(new Moneda1000());
        w.addMoneda(new Moneda1000());
        w.addMoneda(new Moneda1000());
        w.addMoneda(new Moneda1000());
        w.addMoneda(new Moneda500());
        w.addMoneda(new Moneda500());
        w.addMoneda(new Moneda500());
        w.addMoneda(new Moneda500());
        w.addMoneda(new Moneda100());
        w.addMoneda(new Moneda100());
        w.addMoneda(new Moneda100());
        w.addMoneda(new Moneda100());
        w.addMoneda(new Moneda100());

        sincronizarModelo();
    }

    /**
     * Metodo para sincronizar el modelo de inventario y monedero con los depósitos actuales.
     */
    public void sincronizarModelo() {
        modeloInventario.clear();
        modeloMonedero.clear();
        for (Producto p : inventario.getDeposito()) {
            modeloInventario.addElement(p);
        }
        for(Moneda m : w.getDepositoMoneda().getDeposito()){
            modeloMonedero.addElement(m);
        }
    }
    public DefaultListModel<Producto> getModeloInventario(){
        return modeloInventario;
    }
    public DefaultListModel<Moneda> getModeloMonedero(){
        return modeloMonedero;
    }

    /**
     * Metodo para ingresar una moneda al expendedor.
     *
     * @param m Moneda a ingresar.
     * @param exp Expendedor donde se ingresará la moneda.
     */
    public void ingresarMoneda(Moneda m,Expendedor exp){
        exp.compradorMoneda(m);
    }

    public void comprarProducto(Expendedor exp) throws NoHayProductoException, PagoInsuficienteException, DepositoLlenoException, DepositoVacioException{
        exp.compraDeProducto();
        this.añadirProducto(exp,exp.getProductoComprado());
    }

    /**
     * Metodo para añadir un producto al inventario del comprador.
     *
     * @param exp Expendedor desde donde se añade el producto.
     * @param producto Producto a añadir al inventario.
     * @throws DepositoVacioException Si el depósito de productos está vacío.
     */
    public void añadirProducto(Expendedor exp,Producto producto) throws DepositoVacioException {
        getInventario().addObjeto(producto);
        getModeloInventario().addElement(producto);
    }
    public void consumirProducto(Producto p){
        inventario.eliminarObjeto(p);
        modeloInventario.removeElement(p);
    }

    /**
     * Metodo para sacar el vuelto del expendedor y añadirlo al monedero del comprador.
     *
     * @param exp Expendedor desde donde se saca el vuelto.
     */
    public void sacarVuelto(Expendedor exp){
        while(exp.hayVuelto()){
            Moneda m = exp.getVuelto();
            this.w.addMoneda(m);
            modeloMonedero.addElement(m);

        }
    }

    public void stonks(){
        getWallet().getDepositoMoneda().addObjeto(new Moneda1000());
        getWallet().getDepositoMoneda().addObjeto(new Moneda500());
        getWallet().getDepositoMoneda().addObjeto(new Moneda100());
        System.out.println("comprador STONKS");
    }


    public String queBebiste() {
        return sonidoProducto;    }

    public Deposito<Producto> getInventario(){
        return inventario;
    }
    public Wallet getWallet(){
        return w;
    }
}
