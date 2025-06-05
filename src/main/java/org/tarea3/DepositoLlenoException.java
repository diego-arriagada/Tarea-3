package org.tarea3;

public class DepositoLlenoException extends Exception {
    public DepositoLlenoException() {
        super("Retire el producto del deposito antes de realizar otra compra");
    }
}
