package org.tarea3;
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

    public Comprador(Wallet w) {
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
    }

    public void ingresarMoneda(Expendedor exp,int valorMoneda){
        switch(valorMoneda){
            case 1000:
                exp.compradorMoneda(w.obtenerMoneda(1000));
                break;
            case 500:
                exp.compradorMoneda(w.obtenerMoneda(500));
                break;
            case 100:
                exp.compradorMoneda(w.obtenerMoneda(100));
                break;
        }

    }

    public void comprarProducto(Expendedor exp) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        inventario.addObjeto(exp.compraDeProducto());
    }

    public void sacarVuelto(Expendedor exp){
        while(exp.hayVuelto()){
            this.w.addMoneda(exp.getVuelto());
        }
    }


    public String queBebiste() {
        return sonidoProducto;    }
}
