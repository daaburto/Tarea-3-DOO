/**
 * Super8 es una subclase de Dulce que representa un Dulce específico.
 * @author Joaquín Sandoval
 * @see Dulce
 */
public class Super8 extends Dulce{
    /**
     * Constructor que llama al constructor de la superclase Dulce
     * @param s número de serie del Super8
     */
    public Super8(int s){
        super(s);
    }

    /**
     * Devuelve un String que representa el consumo de un Super8.
     * @return "super8" como String
     */
    public String consumir(){
        return "super8";
    }
}