package main.java;
/**
 * Chokita es una subclase de Dulce que representa un dulce específico.
 * @see Dulce
 */
public class Chokita extends Dulce{
    /**
     * Constructor que llama al constructor de la superclase Dulce
     * @param s número de serie de la Chokita
     */
    public Chokita(int s){
        super(s);
    }

    /**
     * Devuelve un String que representa el consumo de una CocaCola.
     * @return "chokita" como String
     */
    public String consumir(){
        return "chokita";
    }
}