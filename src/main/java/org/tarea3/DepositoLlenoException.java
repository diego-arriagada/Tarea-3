package org.tarea3;

/**
 * Excepción que se lanza cuando se intenta realizar una compra sin haber retirado el producto del panelOut.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class DepositoLlenoException extends Exception {
    public DepositoLlenoException() {
        super("Retire el producto del deposito antes de realizar otra compra");
    }
}
