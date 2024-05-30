package main.java;

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
     * Deposito que almacenará el producto Chokita
     * @see Deposito
     * @see Chokita
     */
    private Deposito<Producto> chokita;

    /**
     * Deposito que almacenará las monedas del vuelto, para luego entregárselas al momento.
     * @see Deposito
     * @see Moneda
     */
    private Deposito<Moneda> monVu;

    /**
     * Deposito que almacenará las monedas de compras exitosas.
     * @see Deposito
     * @see Moneda
     */
    private Deposito<Moneda> monEx;

    /**
     * Deposito que almacenará el producto que se compra.
     * @see Deposito
     */
    private Deposito<Producto> depositoEspecial;

    /**
     * Constructor que crea los depósitos para cada producto, además del depósito de monedas para el vuelto.
     * @param numProductos Valor entero que indica la cantidad de productos que se almacenarán en el depósito
     */
    public Expendedor(int numProductos){
        monVu = new Deposito<>();
        monEx = new Deposito<>();

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

        chokita = new Deposito<>();
        for (int i = 0; i < numProductos; i++){
            Producto p = new Super8(600+i);
            chokita.addList(p);
        }
    }

    /**
     * @param producto Producto que va a ser rellenado en su depósito
     * @param cantidad Cantidad a rellenar
     * @see Enum
     */
    public void rellenarDeposito(Enum producto, int cantidad) {
        Deposito<Producto> deposito;
        Producto p;

        switch (producto) {
            case COCA:
                deposito = coca;
                for (int i = 0; i < cantidad; i++) {
                    p = new CocaCola(100 + i);
                    deposito.addList(p);
                }
            case SPRITE:
                deposito = sprite;
                for (int i = 0; i < cantidad; i++) {
                    p = new Sprite(200 + i);
                    deposito.addList(p);
                }
            case FANTA:
                deposito = fanta;
                for (int i = 0; i < cantidad; i++) {
                    p = new Fanta(300 + i);
                    deposito.addList(p);
                }
            case SNICKERS:
                deposito = snickers;
                for (int i = 0; i < cantidad; i++) {
                    p = new Snickers(400 + i);
                    deposito.addList(p);
                }
            case SUPER8:
                deposito = super8;
                for (int i = 0; i < cantidad; i++) {
                    p = new Super8(500 + i);
                    deposito.addList(p);
                }
            case CHOKITA:
                deposito = chokita;
                for (int i = 0; i < cantidad; i++) {
                    p = new Chokita(600 + i);
                    deposito.addList(p);
                }
        }
    }

    /**
     * @param m Es la moneda con la cual compraremos el producto
     * @param type Es un entero que nos indica el producto que queremos comprar
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

        if (!(type == Enum.COCA.getId()|| type == Enum.SPRITE.getId() || type == Enum.FANTA.getId() || type == Enum.SNICKERS.getId() || type == Enum.SUPER8.getId() || type == Enum.CHOKITA.getId())){
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
                    monEx.addList(m);
                    if (p != null)
                        vuelto = m.getValor() - Enum.COCA.getValor();
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    depositoEspecial.addList(p);
                } else {
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto. Se le devolverá su moneda de $"+ m.getValor());
                }

            case SPRITE:
                if (m.compareTo(Enum.SPRITE) == 1 || m.compareTo(Enum.SPRITE) == 0) {
                    p = sprite.getProducto();
                    monEx.addList(m);
                    if (p != null)
                        vuelto = m.getValor() - Enum.SPRITE.getValor();
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    depositoEspecial.addList(p);
                } else {
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto. Se le devolverá su moneda de $"+ m.getValor());
                }

            case FANTA:
                if (m.compareTo(Enum.FANTA) == 1 || m.compareTo(Enum.FANTA) == 0) {
                    p = fanta.getProducto();
                    monEx.addList(m);
                    if (p != null)
                        vuelto = m.getValor() - Enum.FANTA.getValor();
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    depositoEspecial.addList(p);
                } else {
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto. Se le devolverá su moneda de $"+ m.getValor());
                }

            case SNICKERS:
                if (m.compareTo(Enum.SNICKERS) == 1 || m.compareTo(Enum.SNICKERS) == 0) {
                    p = snickers.getProducto();
                    monEx.addList(m);
                    if (p != null)
                        vuelto = m.getValor() - Enum.SNICKERS.getValor();
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    depositoEspecial.addList(p);
                } else {
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto. Se le devolverá su moneda de $"+ m.getValor());
                }

            case SUPER8:
                if (m.compareTo(Enum.SUPER8) == 1 || m.compareTo(Enum.SUPER8) == 0) {
                    p = super8.getProducto();
                    monEx.addList(m);
                    if (p != null)
                        vuelto = m.getValor() - Enum.SUPER8.getValor();
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    depositoEspecial.addList(p);
                } else {
                    throw new PagoInsuficienteException("Pago insuficiente: El valor pagado es menor que el precio del producto. Se le devolverá su moneda de $"+ m.getValor());
                }

            case CHOKITA:
                if (m.compareTo(Enum.CHOKITA) == 1 || m.compareTo(Enum.CHOKITA) == 0) {
                    p = chokita.getProducto();
                    monEx.addList(m);
                    if (p != null)
                        vuelto = m.getValor() - Enum.CHOKITA.getValor();
                    else
                        vuelto = m.getValor();
                    while (vuelto > 0) {
                        monVu.addList(new Moneda100());
                        vuelto -= 100;
                    }
                    depositoEspecial.addList(p);
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

    /**
     * @return El depósito donde está producto comprado
     */
    public Deposito<Producto> getDepositoEspecial(){
        return depositoEspecial;
    }


}