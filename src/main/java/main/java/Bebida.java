package main.java;
/**
 * La clase abstracta Bebida representa un tipo genérico de bebida que puede ser consumida.
 * @see Producto
 */
abstract public class Bebida extends Producto{
    /**
     * Constructor de Bebida
     * @param s Hereda numero de serie
     */
    public Bebida(int s){
        super(s);
    }

    /**
     * Método abstracto que simula el acto de consumir la bebida.
     * @return un String que representa lo consumido
     */
    public abstract String consumir();
}