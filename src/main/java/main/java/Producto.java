package main.java;

/**
 * La clase abstracta Producto representa un tipo genérico de algo que puede ser consumido.
 * Las clases concretas que extienden Producto deben proporcionar una implementación del método consumir().
 * @author Joaquín Sandoval
 */
abstract public class Producto {
    /** int para almacenar el número de serie*/
    private int serie;


    /**
     * Constructor de la clase Producto que inicializa el número de serie.
     * @param numSerie el número de serie del producto
     */
    public Producto(int numSerie){
        serie = numSerie;
    }

    /**Método que actúa como si consumiese algo
     * @return un String que representa lo consumido
     */
    public abstract String consumir();

    /**
     * @return serie del producto
     */
    public int getSerie(){
        return serie;
    }

}
