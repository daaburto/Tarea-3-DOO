/**
 * Excepción para cuando el valor de la moneda no es suficiente.
 * @author Daniel Aburto
 */
public class PagoInsuficienteException extends Exception{
    /**
     * Constructor que crea una instancia de PagoInsuficienteException.
     * @param errmsg mensaje de error
     */
    public PagoInsuficienteException(String errmsg){
        super(errmsg);
    }
}