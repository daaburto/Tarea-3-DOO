/**
 * Sprite es una subclase de Bebida que representa una bebida específica.
 * @see Bebida
 */
public class Sprite extends Bebida{
    /**
     * Constructor que llama al constructor de la superclase Bebida
     * @param s número de serie de la Sprite
     */
    public Sprite(int s){
        super(s);
    }

    /**
     * Devuelve un String que representa el consumo de una Sprite.
     * @return "sprite" como String
     */
    public String consumir(){
        return "sprite";
    }
}