package org.tarea3;

import javax.swing.*;

/**
 * Clase Comprador que sirve para simular la compra de un producto en la máquina expendedora.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class Comprador {
    private String sonidoProducto;
    private int vueltoTotal;
    private Wallet w;
    private Deposito<Producto> inventario;
    private DefaultListModel<Producto> modeloInventario = new DefaultListModel<>();
    private DefaultListModel<Moneda> modeloMonedero = new DefaultListModel<>();



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

    private void sincronizarModelo() {
        modeloInventario.clear();
        modeloMonedero.clear();
        for (Producto p : inventario.getDeposito()) {
            modeloInventario.addElement(p);
            System.out.println("Elemento nuevo en inventario");
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

    public void ingresarMoneda(Moneda m,Expendedor exp){
        exp.compradorMoneda(m);
    }

    public void comprarProducto(Expendedor exp) throws NoHayProductoException, PagoInsuficienteException, DepositoLlenoException, DepositoVacioException{
        exp.compraDeProducto();
        this.añadirProducto(exp,exp.getProductoComprado());
    }

    public void añadirProducto(Expendedor exp,Producto producto) throws DepositoVacioException {
        getInventario().addObjeto(producto);
        getModeloInventario().addElement(producto);
    }
    public void consumirProducto(Producto p){
        inventario.eliminarObjeto(p);
        modeloInventario.removeElement(p);
    }

    public void sacarVuelto(Expendedor exp){
        while(exp.hayVuelto()){
            Moneda m = exp.getVuelto();
            this.w.addMoneda(m);
            modeloMonedero.addElement(m);



        }
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
