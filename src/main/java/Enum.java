/**
 * Enum representa una lista de productos disponibles con sus respectivos identificadores y valores.
 * @author Daniel Aburto
 */
public enum Enum {
    COCA(1,500),
    SPRITE(2,1000),
    FANTA(40,700),
    SNICKERS(74,400),
    SUPER8(5,100);

    /** Identificador único del producto*/
    private final int id;

    /** Valor del producto*/
    private final int valor;

    /**
     * Constructor de Enum.
     * @param id identificador único del producto.
     * @param valor valor del producto en la moneda correspondiente.
     */
    Enum(int id, int valor) {
        this.id = id;
        this.valor = valor;
    }

    /**
     * Obtiene el identificador del producto.
     * @return identificador del producto.
     */
    public int getId(){
        return id;
    }

    /**
     * Obtiene el valor del producto.
     * @return valor del producto.
     */
    public int getValor(){
        return valor;
    }
}
