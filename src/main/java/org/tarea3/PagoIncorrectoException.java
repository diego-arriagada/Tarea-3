/**
 * Excepción que se lanza cuando se ingresa un pago incorrecto.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */

public class PagoIncorrectoException extends Exception{
    public PagoIncorrectoException(){
        super("Pago Incorrecto, ingrese moneda valida");
    }
}

