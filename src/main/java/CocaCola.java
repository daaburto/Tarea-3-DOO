/**
 * CocaCola es una subclase de Bebida que representa una bebida específica.
 * @see Bebida
 */
public class CocaCola extends Bebida{
    /**
     * Constructor que llama al constructor de la superclase Bebida
     * @param s número de serie de la CocaCola
     */
    public CocaCola(int s){
        super(s);
    }

    /**
     * Devuelve un String que representa el consumo de una CocaCola.
     * @return "cocacola" como String
     */
    public String consumir(){
        return "cocacola";
    }
}