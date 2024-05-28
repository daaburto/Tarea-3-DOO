/**
 * La clase Comprador representa a alguien que realiza una compra utilizando un expendedor.
 * Esta clase maneja la compra de un producto, la obtención del vuelto y da información sobre el producto consumido.
 * @see Expendedor
 * @see Moneda
 */
public class Comprador{
    /** Sonido del producto consumido */
    private String sonido;

    /** Cantidad de vuelto obtenido */
    private int vuelto;

    /**
     * Constructor de la clase Comprador.
     * @param m moneda utilizada para la compra
     * @param cualProducto  id del producto a comprar
     * @see Enum
     * @param exp expendedor que procesará la compra
     * @throws NoHayProductoException Excepción para cuando el depósito no tiene el producto deseado
     * @throws PagoIncorrectoException Excepción para cuando no se está entregando ninguna moneda
     * @throws PagoInsuficienteException Excepción para cuando el valor de la moneda no es suficiente
     */
    public Comprador(Moneda m, int cualProducto, Expendedor exp)throws NoHayProductoException,PagoIncorrectoException,PagoInsuficienteException{
        int total;

        Producto ProductoComprado = exp.comprarProducto(m, cualProducto);
        Moneda monedaVuelto;

        if (ProductoComprado != null) {
            sonido = ProductoComprado.consumir();
        }else {
            sonido = null;

        }

        total = 0;

        while ((monedaVuelto =exp.getVuelto()) != null) {
            total += monedaVuelto.getValor();
        }

        vuelto = total;

    }

    /**
     * Obtiene la cantidad de vuelto obtenido en la compra.
     * @return La cantidad de vuelto.
     */
    public int cuantoVuelto(){
        return vuelto;
    }

    /**
     * Obtiene el sonido del producto al ser consumido.
     * @return sonido de producto consumido
     */
    public String queConsumiste(){
        return sonido;
    }
}