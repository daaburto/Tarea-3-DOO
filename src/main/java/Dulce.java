/**
 * La clase abstracta Dulce representa un tipo genérico de dulce que puede ser consumida.
 * @author Joaquín Sandoval
 * @see Producto
 */
public abstract class Dulce extends Producto{
    /** int para almacenar el número de serie*/
    private int serie;

    /**
     * Constructor de la clase Dulce que inicializa el número de serie.
     * @param numSerie el número de serie del dulce
     */
    public Dulce(int numSerie){
        super();
        serie = numSerie;
    }

    /**
     * Método abstracto que simula el acto de consumir el dulce.
     * @return un String que representa lo consumido
     */
    public abstract String consumir();
}