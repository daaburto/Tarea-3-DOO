/**
 * Clase abstracta que implementa la interfaz comparable, para así comparar sus valores en expendedor
 * @see Expendedor
 * @author Joaquín Sandoval
 * @author Daniel Aburto
 */
abstract public class Moneda implements Comparable<Enum>{
    /**
     * Constructor de Moneda
     */
    public Moneda(){

    }

    /**
     * Método que devuelve la instancia de moneda
     * @return Retorna la instancia actual de moneda
     */
    public Moneda getSerie(){
        return this;
    }

    /**
     * Método abstracto para obtener el valor de la moneda, el cual es usado para comprar
     * @return retorna un entero que representa el valor de la moneda
     */
    public abstract int getValor();

    /**
     *
     * @param Producto El objeto a ser comparado
     * @return Retorna la comparación entre el valor de la moneda y el valor del producto
     */
    @Override
    public int compareTo(Enum Producto){
        return Integer.compare(this.getValor(), Producto.getValor());
    }
}