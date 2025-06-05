package org.tarea3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * La clase `Expendedor` representa una máquina expendedora que gestiona la lógica
 * para dispensar productos y manejar pagos.
 *
 * Contiene múltiples depósitos de productos y un depósito para monedas devueltas.
 * La clase permite comprar productos y calcular el vuelto.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class Expendedor {
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> snicker;
    private Deposito<Producto> super8;
    private Deposito<Moneda> monVu;
    private Wallet walletDeposito;
    private int valorMonedasIngresadas;
    private PropertyChangeSupport escuchador;
    private Producto ultimaCompra;
    private int cantCoca;
    private int cantSprite;
    private int cantFanta;
    private int cantSnickers;
    private int cantSuper8;
    /**
     * Construye un `Expendedor` con el número especificado de productos para cada tipo.
     *
     * @param numProductos el número de productos a inicializar en cada depósito
     */
    public Expendedor(int numProductos) {
        coca = new Deposito<>();
        sprite = new Deposito<>();
        fanta = new Deposito<>();
        snicker = new Deposito<>();
        super8 = new Deposito<>();
        monVu = new Deposito<>();
        this.ultimaCompra = null;
        this.walletDeposito = new Wallet();
        this.escuchador = new PropertyChangeSupport(this);
        for (int i = 0; i < numProductos; i++) {
            coca.addObjeto(new CocaCola(100 + i));
            sprite.addObjeto(new Sprite(200 + i));
            fanta.addObjeto(new Fanta(300 + i));
            snicker.addObjeto(new Snickers(400 + i));
            super8.addObjeto(new Super8(500 + i));
        }
        cantCoca = coca.deposito.size();
        cantFanta = fanta.deposito.size();
        cantSprite = sprite.deposito.size();
        cantSnickers = snicker.deposito.size();
        cantSuper8 = super8.deposito.size();
    }

    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int FANTA = 3;
    public static final int SNICKERS = 4;
    public static final int SUPER8 = 5;

    /**
     * Intenta comprar un producto de la máquina expendedora.
     *
     * Si el pago es insuficiente, el producto está agotado o el tipo de producto
     * es inválido, la moneda se devuelve al depósito de monedas.
     *
     * @param  walletDeposito  el almacen de monedas ingresadas del expendedor
     * @param cual el tipo de producto a comprar (por ejemplo, `COCA`, `SPRITE`)
     * @return el producto comprado, o `null` si la compra falla
     */

    public void compradorMoneda(Moneda m){
        walletDeposito.addMoneda(m);
        int valorViejo = this.valorMonedasIngresadas;
        this.valorMonedasIngresadas = walletDeposito.getvalorWallet();
        escuchador.firePropertyChange("Valor Monedas",valorViejo, this.valorMonedasIngresadas);
    }

    public int getValorMonedasIngresadas(){
        return this.valorMonedasIngresadas;
    }
    public void restarCompra(int valor){
        this.valorMonedasIngresadas = this.valorMonedasIngresadas - valor;
    }

    public Producto compraDeProducto(int cual) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        int dinero = getValorMonedasIngresadas();

        Deposito<Producto> depositoSeleccionado = null;
        int precioProducto = 0;

        switch (cual) {
            case COCA:
                depositoSeleccionado = coca;
                precioProducto = PreciosProductos.COCA.getPrecio();
                break;
            case SPRITE:
                depositoSeleccionado = sprite;
                precioProducto = PreciosProductos.SPRITE.getPrecio();
                break;
            case FANTA:
                depositoSeleccionado = fanta;
                precioProducto = PreciosProductos.FANTA.getPrecio();
                break;
            case SNICKERS:
                depositoSeleccionado = snicker;
                precioProducto = PreciosProductos.SNICKERS.getPrecio();
                break;
            case SUPER8:
                depositoSeleccionado = super8;
                precioProducto = PreciosProductos.SUPER8.getPrecio();
                break;
            default:
                throw new NoHayProductoException();
        }
        if (dinero<precioProducto){
            throw new PagoInsuficienteException();
        }

        Producto producto = depositoSeleccionado.getObjeto();
        if (producto == null){
            throw new NoHayProductoException();
        }


        Producto productoAnterior = this.ultimaCompra;
        this.ultimaCompra = producto;
        restarCompra(precioProducto);
        this.walletDeposito.vaciarWallet();
        escuchador.firePropertyChange("Producto en Deposito", productoAnterior, producto);
        return producto;
    }

    /**
     * Recupera una moneda del depósito de monedas (vuelto).
     *
     * @return una moneda del depósito de monedas, o `null` si no hay monedas disponibles
     */

    public void crearVuelto(){
        while (this.valorMonedasIngresadas > 0) {
            if (this.valorMonedasIngresadas >= 1000) {
                monVu.addObjeto(new Moneda1000());
                this.valorMonedasIngresadas -= 1000;
            } else if (this.valorMonedasIngresadas >= 500) {
                monVu.addObjeto(new Moneda500());
                this.valorMonedasIngresadas -= 500;
            } else if (this.valorMonedasIngresadas >= 100) {
                monVu.addObjeto(new Moneda100());
                this.valorMonedasIngresadas -= 100;
            }
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        escuchador.addPropertyChangeListener(listener);
    }

    public Boolean hayVuelto(){
        return !(monVu.deposito.isEmpty());
    }
    public Moneda getVuelto() {
        return monVu.getObjeto();
    }
}