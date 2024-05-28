/**
 * Clase moneda que representa una moneda de 100 pesos, subclase de Moneda
 */
public class Moneda100 extends Moneda{
    /**
     * Constructor de Moneda100, hereda de Moneda
     */
    public Moneda100(){
        super();
    }

    /**
     * Método heredado, obtiene el valor de la moneda
     * @return valor de la moneda
     */
    public int getValor(){
        return 100;
    }
}