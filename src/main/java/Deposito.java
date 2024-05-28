import java.util.ArrayList;

/**
 * La clase genérica Depósito representa el lugar donde se guardarán los productos y las monedas
 * @author Joaquín Sandoval
 * @param <T> Clase Genérica, puede tomar el valor de Producto o Moneda
 * @see Moneda
 * @see Producto
 */
public class Deposito<T>{
    /**ArrayList genérica usada para guardar los productos o las monedas*/
    private ArrayList<T> lista;

    /**
     * Constructor de la clase Depósito, donde se inicializa la lista ArrayList dependiendo de la clase ingresada
     */
    public Deposito(){
        lista = new ArrayList<>();
    }

    /**
     *
     * @param p Es una clase genérica, la cual puede ser Producto o Moneda
     */
    public void addList(T p){
        lista.add(p);
    }

    /**
     * Permite retirar una moneda de la ArrayList de monedas
     * @return Devuelve la primera moneda del depósito de monedas
     */
    public T getMoneda() {
        if (lista.isEmpty())
            return null;
        return lista.removeFirst();
    }

    /**
     * Permite retirar un producto de la ArrayList de productos
     * @return Devuelve el primer producto del depósito de productos
     */
    public T getProducto(){
        if (!lista.isEmpty()){
            return lista.removeFirst();
        }else {
            return null;
        }
    }
}