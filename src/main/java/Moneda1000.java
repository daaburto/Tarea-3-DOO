/**
 * Clase moneda que representa una moneda de 1000 pesos, subclase de Moneda
 */
public class Moneda1000 extends Moneda{
    /**
     * Constructor de Moneda1000, hereda de Moneda
     */
    public Moneda1000(){
        super();
    }

    /**
     * Método heredado, obtiene el valor de la moneda
     * @return valor de la moneda
     */
    public int getValor(){
        return 1000;
    }
}