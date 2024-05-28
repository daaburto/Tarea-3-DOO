/**
 * Clase moneda que representa una moneda de 1500 pesos, subclase de Moneda
 */
public class Moneda1500 extends Moneda{
    /**
     * Constructor de Moneda1500, hereda de Moneda
     */
    public Moneda1500(){
        super();
    }

    /**
     * Método heredado, obtiene el valor de la moneda
     * @return valor de la moneda
     */
    public int getValor(){
        return 1500;
    }
}