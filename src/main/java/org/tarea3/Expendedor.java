package org.tarea3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * La clase Expendedor representa una máquina expendedora que gestiona la lógica central de la aplicación.
 *
 * Está compuesta por depósitos de diferentes tipos de productos y monedas.
 * Permite realizar compras de productos, manejar el pago con monedas, y generar vuelto.
 * Similarmente a Comprador, cuenta con un controlador de eventos dedicado para notificar cambios en el estado de la máquina expendedora.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 2.0
 */
public class Expendedor {
    private int numProductosInicial;
    private int counterExtraProd;
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> snicker;
    private Deposito<Producto> super8;
    private Deposito<Moneda> monVu;
    private Wallet walletDeposito;
    private Wallet monedasAlmacenadas;
    private int valorMonedasIngresadas = 0;
    private PropertyChangeSupport escuchador;
    private Producto ultimaCompra;
    private int cantCoca;
    private int cantSprite;
    private int cantFanta;
    private int cantSnickers;
    private int cantSuper8;
    private int productoSeleccionado;
    private boolean hayVuelto;

    /**
     * Construye un Expendedor con el número especificado de productos para cada tipo.
     *
     * @param numProductos el número de productos a inicializar en cada depósito
     */
    public Expendedor(int numProductos) {
        this.numProductosInicial = numProductos;
        this.counterExtraProd = numProductos;
        this.monedasAlmacenadas = new Wallet();
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

    /**
     * Agrega una moneda al depósito de monedas del expendedor y actualiza el valor total de las monedas ingresadas.
     * Notifica a los escuchadores sobre el cambio en el valor de las monedas y las monedas almacenadas.
     *
     * @param m la moneda a agregar al depósito
     */
    public void compradorMoneda(Moneda m){
        walletDeposito.addMoneda(m);
        monedasAlmacenadas.addMoneda(m);
        int valorViejo = getValorMonedasIngresadas();
        this.valorMonedasIngresadas = this.valorMonedasIngresadas + m.getValor();
        escuchador.firePropertyChange("Valor Monedas",valorViejo, this.getValorMonedasIngresadas());
        escuchador.firePropertyChange("Monedas Almacenadas", null, monedasAlmacenadas); // <-- línea agregada
    }

    public int getValorMonedasIngresadas(){
        return this.valorMonedasIngresadas;
    }

    /**
     * Metodo para el escuchador de eventos que notifica el cambio en el valor de las monedas ingresadas al realizar una compra.
     *
     * @param valor el valor a restar de las monedas ingresadas
     */
    public void restarCompra(int valor){
        int valorViejo = getValorMonedasIngresadas();
        this.valorMonedasIngresadas = this.valorMonedasIngresadas - valor;
        escuchador.firePropertyChange("Valor Monedas",valorViejo, this.valorMonedasIngresadas);
    }

    /**
     * Realiza la compra de un producto seleccionado por el usuario.
     *
     * Verifica si hay suficiente dinero, si el depósito del producto seleccionado tiene stock, y actualiza el estado del expendedor y los depósitos correspondientes.
     * Hace uso del enum PreciosProductos para determinar el precio del producto seleccionado.
     * Notifica a los escuchadores sobre el cambio en el producto comprado y si hay vuelto disponible.
     *
     * @throws NoHayProductoException si no hay stock del producto seleccionado
     * @throws PagoInsuficienteException si el dinero ingresado es insuficiente para comprar el producto
     * @throws DepositoLlenoException si el depósito del producto está lleno
     */
    public void compraDeProducto() throws NoHayProductoException, PagoInsuficienteException, DepositoLlenoException{
            int dinero = getValorMonedasIngresadas();
            Deposito<Producto> depositoSeleccionado = null;
            int precioProducto = 0;
            boolean hayVueltoAnterior = hayVuelto();

            PreciosProductos[] productos = PreciosProductos.values();
            if (this.productoSeleccionado < 0 || this.productoSeleccionado >= productos.length) {
                throw new NoHayProductoException();
            }
            PreciosProductos productoEnum = productos[this.productoSeleccionado];

        depositoSeleccionado = switch (productoEnum) {
            case COCA -> coca;
            case SPRITE -> sprite;
            case FANTA -> fanta;
            case SNICKERS -> snicker;
            case SUPER8 -> super8;
            default -> throw new NoHayProductoException();
        };
        precioProducto = productoEnum.getPrecio();

        if (dinero<precioProducto){
            throw new PagoInsuficienteException();
        }

        Producto producto = depositoSeleccionado.getObjeto();
        if (producto == null){
            throw new NoHayProductoException();
        }
        if (this.ultimaCompra != null){
            depositoSeleccionado.addObjeto(producto);
            throw new DepositoLlenoException();

        }

        Producto productoAnterior = this.ultimaCompra;
        this.ultimaCompra = producto;
        restarCompra(precioProducto);
        if(productoSeleccionado == 0){
            cantCoca -= 1;
        }else if(productoSeleccionado == 1){
            cantSprite -= 1;
        }
        else if(productoSeleccionado == 2){
            cantFanta -=1;
        }
        else if(productoSeleccionado == 3){
            cantSnickers -=1;
        }
        else if(productoSeleccionado == 4){
            cantSuper8 -= 1;
        }

        this.hayVuelto = hayVuelto();
        escuchador.firePropertyChange("Producto en Deposito", productoAnterior, producto);
        escuchador.firePropertyChange("Hay Vuelto",hayVueltoAnterior, this.hayVuelto );

    }

    /**
     * Crea el vuelto correspondiente al valor de las monedas ingresadas.
     *
     * Descompone el valor en monedas de 1000, 500 y 100, y las agrega al depósito de vuelto en orden de mayor a menor valor
     * (ej: 3500 se convierten en 3 monedas de 1000, 1 de 500 y 0 de 100).
     * Ademas, resetea el valor de las monedas ingresadas a cero y notifica a los escuchadores sobre el cambio.
     */
    public void crearVuelto(){
        int valorViejo = getValorMonedasIngresadas();
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
        this.valorMonedasIngresadas = 0;
        escuchador.firePropertyChange("vuelto",valorViejo,this.valorMonedasIngresadas);
    }

    /**
     * Agrega un escuchador de cambios a la máquina expendedora.
     *
     * @param listener el escuchador que se desea agregar
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        escuchador.addPropertyChangeListener(listener);
    }

    /**
     * Verifica si hay vuelto en el depósito de vuelto.
     *
     * @return true si hay vuelto disponible, false en caso contrario.
     */
    public Boolean hayVuelto(){
        return !(monVu.deposito.isEmpty());
    }

    public Moneda getVuelto() {
        return monVu.getObjeto();
    }
    public Wallet getWallet(){
        return walletDeposito;
    }
    public int getProductoSeleccionado() {
        return productoSeleccionado;
    }
    public void setProductoSeleccionado(int productoElegido){
        this.productoSeleccionado = productoElegido;
    }
    public Producto getProductoComprado()throws DepositoVacioException{
        if (this.ultimaCompra == null){
            throw new DepositoVacioException();
        }
        Producto productoRetirado = this.ultimaCompra;
        this.ultimaCompra = null;
        escuchador.firePropertyChange("Producto para Retiro", productoRetirado, this.ultimaCompra);
        return productoRetirado;

    }
    public Deposito<Moneda> getMonVu() {
        return monVu;
    }
    public int getCantidad(int productoSeleccionado){
        if(productoSeleccionado == 0){
            return cantCoca;
        }else if(productoSeleccionado == 1){
            return cantSprite;
        }
        else if(productoSeleccionado == 2){
            return cantFanta;
        }
        else if(productoSeleccionado == 3){
            return cantSnickers;
        }
        else if(productoSeleccionado == 4){
            return cantSuper8;
        }
        else return -1;
    }
    public int getNumProductosInicial() {
        return numProductosInicial;
    }
    public Wallet getMonedasAlmacenadasWallet(){
        return monedasAlmacenadas;
    }

    /**
     * Agrega stock extra a los productos de la máquina expendedora.
     *
     * Incrementa el stock de cada tipo de producto en 1.
     */
    public void agregarStock(){
            System.out.println("expendedora STONKS");
            coca.addObjeto(new CocaCola(100 + getCounterExtraProd()));
            cantCoca++;
            sprite.addObjeto(new Sprite(200 + getCounterExtraProd()));
            cantSprite++;
            fanta.addObjeto(new Fanta(300 + getCounterExtraProd()));
            cantFanta++;
            snicker.addObjeto(new Snickers(400 + getCounterExtraProd()));
            cantSnickers++;
            super8.addObjeto(new Super8(500 + getCounterExtraProd()));
            cantSuper8++;
            setCounterExtraProd(getCounterExtraProd()+1);
        }

    public int getCounterExtraProd() {
        return counterExtraProd;
    }
    public void setCounterExtraProd(int n){
        this.counterExtraProd = n;
    }
}
