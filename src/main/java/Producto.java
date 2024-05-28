/**
 * La clase abstracta Producto representa un tipo genérico de algo que puede ser consumido.
 * Las clases concretas que extienden Producto deben proporcionar una implementación del método consumir().
 * @author Joaquín Sandoval
 */
abstract public class Producto {
    /**Constructor por defecto*/
    public Producto(){
    }

    /**Método que actúa como si consumiese algo
     * @return un String que representa lo consumido
     */
    public abstract String consumir();
}
