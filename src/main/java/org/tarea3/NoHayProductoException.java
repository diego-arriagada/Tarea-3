package org.tarea3;

/**
 * Excepción que se lanza cuando no hay un producto solicitado.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class NoHayProductoException extends Exception{
    public NoHayProductoException(){
        super("No hay o no existe el producto solicitado");
    }
}
