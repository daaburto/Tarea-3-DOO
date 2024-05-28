/**
 * Excepción para cuando no se está entregando ninguna moneda.
 * @author Daniel Aburto
 */
public class PagoIncorrectoException extends Exception{
    /**
     * Constructor que crea una instancia de PagoIncorrectoException.
     * @param errmsg mensaje de error
     */
    public PagoIncorrectoException(String errmsg){
        super(errmsg);
    }
}