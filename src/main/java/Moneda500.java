/**
 * Clase moneda que representa una moneda de 500 pesos, subclase de Moneda
 */
public class Moneda500 extends Moneda{
    /**
     * Constructor de Moneda500, hereda de Moneda
     */
    public Moneda500(){
        super();
    }

    /**
     * Método heredado, obtiene el valor de la moneda
     * @return valor de la moneda
     */
    public int getValor(){
        return 500;
    }
}