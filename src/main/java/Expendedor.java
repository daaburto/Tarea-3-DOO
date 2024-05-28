/**
 * La clase expendedor representa el objeto que nos entregará los productos y el vuelto
 * @author Joaquin Sandoval
 * @author Daniel Aburto
 */

public class Expendedor{
    /**
     * Deposito que almacenará el producto CocaCola
     * @see Deposito
     * @see CocaCola
     */
    private Deposito<Producto> coca;

    /**
     * Deposito que almacenará el producto Sprite
     * @see Deposito
     * @see Sprite
     */
    private Deposito<Producto> sprite;

    /**
     * Deposito que almacenará el producto Fanta
     * @see Deposito
     * @see Fanta
     */
    private Deposito<Producto> fanta;

    /**
     * Deposito que almacenará el producto Snickers
     * @see Deposito
     * @see Snickers
     */
    private Deposito<Producto> snickers;

    /**
     * Deposito que almacenará el producto Super8
     * @see Deposito
     * @see Super8
     */
    private Deposito<Producto> super8;

    /**
     * Deposito que almacenará las monedas del vuelto, para luego entregárselas al momento.
     * @see Deposito
     * @see Moneda
     */
    private Deposito<Moneda> monVu;

    /**
     * Constructor que crea los depósitos para cada producto, además del depósito de monedas para el vuelto.
     * @param numProductos Valor entero que indica la cantidad de productos que se almacenarán en el depósito
     */
    public Expendedor(int numProductos){
        monVu = new Deposito<>();

        coca = new Deposito<>();
        for (int i = 0; i < numProductos; i++){
            Producto p = new CocaCola(100+i);
            coca.addList(p);
        }

        sprite = new Deposito<>();
        for (int i = 0; i < numProductos; i++){
            Producto p = new Sprite(200+i);
            sprite.addList(p);
        }

        fanta = new Deposito<>();
        for (int i = 0; i < numProductos; i++){
            Producto p = new Fanta(300+i);
            fanta.addList(p);
        }

        snickers = new Deposito<>();
        for (int i = 0; i < numProductos; i++){
            Producto p = new Snickers(400+i);
            snickers.addList(p);
        }

        super8 = new Deposito<>();
        for (int i = 0; i < numProductos; i++){
            Producto p = new Super8(500+i);
            super8.addList(p);
        }
    }

    /**
     *
     * @param m Es la moneda con la cual compraremos el producto
     * @param type Es un entero que nos indica el producto que queremos comprar
     * @return Retorna el producto que se compró, siempre y cuando el valor de la moneda sea suficiente
     * @see Enum
     * @throws NoHayProductoException Excepción para cuando el depósito no tiene el producto deseado
     * @throws PagoIncorrectoException Excepción para cuando no se está entregando ninguna moneda
     * @throws PagoInsuficienteException Excepción para cuando el valor de la moneda no es suficiente
     */
    public Producto comprarProducto(Moneda m, int type) throws NoHayProductoException,PagoIncorrectoException,PagoInsuficienteException {
        Producto p;

        int vuelto;

        if (m == null) {
            throw new PagoIncorrectoException("Pago incorrecto: No se ingresó ninguna moneda. No hay vuelto");
        }

        if (!(type == Enum.COCA.getId()|| type == Enum.SPRITE.getId()|| type == Enum.FANTA.getId()|| type == Enum.SNICKERS.getId()|| type == Enum.SUPER8.getId())){
            throw new NoHayProductoException("No existe el producto solicitado. Se le devolverá su moneda de $"+m.getValor());
        }

        int j = 0;
        for (int i = 0; i < Enum.values().length; i++){
            if (type == Enum.values()[i].getId())
                j = i;
        }

        switch (Enum.values()[j]) {
            case COCA:
                if (m.compareTo(Enum.COCA) == 1 || m.compareTo(Enum.COCA) == 0) {
                    p = coca.getProducto();
                    if (p != null)
                        vuelto = m.getValor() - Enum.COCA.getValor();
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    return p;
                } else {
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto. Se le devolverá su moneda de $"+ m.getValor());
                }

            case SPRITE:
                if (m.compareTo(Enum.SPRITE) == 1 || m.compareTo(Enum.SPRITE) == 0) {
                    p = sprite.getProducto();
                    if (p != null)
                        vuelto = m.getValor() - Enum.SPRITE.getValor();
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    return p;
                } else {
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto. Se le devolverá su moneda de $"+ m.getValor());
                }

            case FANTA:
                if (m.compareTo(Enum.FANTA) == 1 || m.compareTo(Enum.FANTA) == 0) {
                    p = fanta.getProducto();
                    if (p != null)
                        vuelto = m.getValor() - Enum.FANTA.getValor();
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    return p;
                } else {
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto. Se le devolverá su moneda de $"+ m.getValor());
                }

            case SNICKERS:
                if (m.compareTo(Enum.SNICKERS) == 1 || m.compareTo(Enum.SNICKERS) == 0) {
                    p = snickers.getProducto();
                    if (p != null)
                        vuelto = m.getValor() - Enum.SNICKERS.getValor();
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    return p;
                } else {
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto. Se le devolverá su moneda de $"+ m.getValor());
                }

            case SUPER8:
                if (m.compareTo(Enum.SUPER8) == 1 || m.compareTo(Enum.SUPER8) == 0) {
                    p = super8.getProducto();
                    if (p != null)
                        vuelto = m.getValor() - Enum.SUPER8.getValor();
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    return p;
                } else {
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto. Se le devolverá su moneda de $"+ m.getValor());
                }

            default:
                vuelto = m.getValor();
                while (vuelto > 0) {
                    monVu.addList(new Moneda100());
                    vuelto -= 100;
                }
                throw new NoHayProductoException("No existe el producto solicitado. Se le devolverá su moneda de $"+m.getValor());
        }
    }

    /**
     * Devuelve el vuelto en monedas de 100
     * @return Saca una moneda de 100 del depósito de monedas
     */
    public Moneda getVuelto(){
        return monVu.getMoneda();
    }
}