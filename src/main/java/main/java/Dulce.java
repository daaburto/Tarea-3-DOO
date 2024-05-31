package main.java;

/**
 * La clase abstracta Dulce representa un tipo genérico de dulce que puede ser consumida.
 * @author Joaquín Sandoval
 * @see Producto
 */
public abstract class Dulce extends Producto{
    /**
     * Constructor de la clase Dulce que inicializa el número de serie.
     * @param s Hereda el numero de serie
     */
    public Dulce(int s){
        super(s);
    }

    /**
     * Método abstracto que simula el acto de consumir el dulce.
     * @return un String que representa lo consumido
     */
    public abstract String consumir();
}