package org.tarea3;

public class DepositoVacioException extends Exception {
    public DepositoVacioException() {
        super("Realice una compra antes de intentar retirar un producto");
    }
}
