package org.tarea3;

/**
 * Excepción que se lanza al intentar retirar un producto del panelOut cuando el depósito está vacío.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class DepositoVacioException extends Exception {
    public DepositoVacioException() {
        super("Realice una compra antes de intentar retirar un producto");
    }
}
