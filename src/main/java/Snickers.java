/**
 * Snickers es una subclase de Dulce que representa un Dulce específico.
 * @author Joaquín Sandoval
 * @see Dulce
 */
public class Snickers extends Dulce{
    /**
     * Constructor que llama al constructor de la superclase Dulce
     * @param s número de serie del Snickers
     */
    public Snickers(int s){
        super(s);
    }

    /**
     * Devuelve un String que representa el consumo de un Snickers.
     * @return "snickers" como String
     */
    public String consumir(){
        return "snickers";
    }
}