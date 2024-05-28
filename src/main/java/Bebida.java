/**
 * La clase abstracta Bebida representa un tipo genérico de bebida que puede ser consumida.
 * @see Producto
 */
abstract public class Bebida extends Producto{
    /** int para almacenar el número de serie*/
    private int serie;

    /**
     * Constructor de la clase Bebida que inicializa el número de serie.
     * @param numSerie el número de serie de la bebida
     */
    public Bebida(int numSerie){
        super();
        serie = numSerie;
    }

    /**
     * Método abstracto que simula el acto de consumir la bebida.
     * @return un String que representa lo consumido
     */
    public abstract String consumir();
}