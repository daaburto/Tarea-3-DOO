/**
 * Fanta es una subclase de Bebida que representa una bebida específica.
 * @see Bebida
 */
public class Fanta extends Bebida{
    /**
     * Constructor que llama al constructor de la superclase Bebida
     * @param s número de serie de la Fanta
     */
    public Fanta(int s){
        super(s);
    }

    /**
     * Devuelve un String que representa el consumo de una Fanta.
     * @return "fanta" como String
     */
    public String consumir(){
        return "fanta";
    }
}