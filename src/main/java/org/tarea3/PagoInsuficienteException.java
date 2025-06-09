package org.tarea3;

/**
 * Excepción que se lanza cuando el pago realizado por el cliente es insuficiente.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class PagoInsuficienteException extends Exception{
    public PagoInsuficienteException(){
        super("Pago insuficiente para el producto solicitado");
    }
}
