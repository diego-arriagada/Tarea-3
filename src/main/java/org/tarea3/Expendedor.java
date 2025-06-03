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
class Expendedor {
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> snicker;
    private Deposito<Producto> super8;
    private Deposito<Moneda> monVu;

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

        for (int i = 0; i < numProductos; i++) {
            coca.addObjeto(new CocaCola(100 + i));
            sprite.addObjeto(new Sprite(200 + i));
            fanta.addObjeto(new Fanta(300 + i));
            snicker.addObjeto(new Snickers(400 + i));
            super8.addObjeto(new Super8(500 + i));
        }
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
     * @param m    la moneda utilizada para el pago
     * @param cual el tipo de producto a comprar (por ejemplo, `COCA`, `SPRITE`)
     * @return el producto comprado, o `null` si la compra falla
     */
    public Producto comprarProducto(Moneda m, int cual) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        if (m == null){
            throw new PagoIncorrectoException();
        }


        Deposito<Producto> depositoSeleccionado = null;
        double precioProducto = 0;

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
                monVu.addObjeto(m); // Devuelve la moneda si no existe el producto
                throw new NoHayProductoException();
        }
        if (m.getValor()<precioProducto){
            monVu.addObjeto(m); //Devuelve la moneda si no alcanza
            throw new PagoInsuficienteException();
        }

        Producto producto = depositoSeleccionado.getObjeto();
        if (producto == null){
            monVu.addObjeto(m); //Devuelve la moneda si no hay stock
            throw new NoHayProductoException();
        }

        
        // Calcula el vuelto
        int vuelto = (int)(m.getValor() - precioProducto);

        while (vuelto > 0) {
            monVu.addObjeto(new Moneda100());
            vuelto -= 100;
        }

        return producto;
    }

    /**
     * Recupera una moneda del depósito de monedas (vuelto).
     *
     * @return una moneda del depósito de monedas, o `null` si no hay monedas disponibles
     */
    public Moneda getVuelto() {
        return monVu.getObjeto();
    }
}