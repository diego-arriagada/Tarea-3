package org.tarea3;

/**
 * Clase Wallet que representa una billetera que contiene monedas.
 *
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class Wallet{
    private Deposito<Moneda> deposito;
    private int ValorWallet;

    public Wallet(){
        this.ValorWallet = 0;
        this.deposito = new Deposito<Moneda>();

    }

    /**
     * Elimina una moneda del depósito.
     *
     * @param m la moneda a eliminar
     */
    public void eliminarMoneda(Moneda m) {
        deposito.eliminarObjeto(m);

    }

    /**
     * Vacía el depósito de monedas.
     * Este metodo elimina todas las monedas del depósito.
     */
    public void vaciarWallet(){
        deposito.deposito.clear(); // Asumiendo que deposito.deposito es LinkedList o similar
    }

    /**
     * Agrega una moneda al depósito.
     *
     * @param m la moneda a agregar
     */
    public void addMoneda(Moneda m){
        deposito.addObjeto(m);
    }

    public Deposito<Moneda> getDepositoMoneda(){
        return deposito;
    }

}
