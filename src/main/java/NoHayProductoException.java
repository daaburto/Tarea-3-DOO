/**
 * Excepción para cuando el depósito no tiene el producto deseado.
 * @author Daniel Aburto
 */
public class NoHayProductoException extends Exception{
    /**
     * Constructor que crea una instancia de NoHayProductoException.
     * @param errmsg mensaje de error
     */
    public NoHayProductoException(String errmsg){
        super(errmsg);
    }
}