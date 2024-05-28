/**
 * Expendedor de bebidas y dulces
 * @author Daniel Aburto
 * @author Joaquín Sandoval
 */
public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(7);
        Moneda m = new Moneda500();
        Comprador c;

        // NoHayProductoException
        try {
            c = new Comprador(m, 77, exp);
            System.out.println("Consumiste: "+ c.queConsumiste() + ". Se te dió $" + c.cuantoVuelto() + " de vuelto.");
        }
        catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }


        // PagoIncorrectoException
        try {
            c = new Comprador(null,4,exp);
            System.out.println("Consumiste: "+ c.queConsumiste() + ". Se te dió $" + c.cuantoVuelto() + " de vuelto.");
        }
        catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }


        // PagoInsuficienteException
        try {
            m = new Moneda100();
            c = new Comprador(m,40,exp);
            System.out.println("Consumiste: "+ c.queConsumiste() + ". Se te dió $" + c.cuantoVuelto() + " de vuelto.");
        }
        catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }


        try {
            m = new Moneda500();
            c = new Comprador(m, 1, exp);
            System.out.println("Consumiste: "+ c.queConsumiste() + ". Se te dió $" + c.cuantoVuelto() + " de vuelto.");
        }
        catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            m = new Moneda1500();
            c = new Comprador(m, 2, exp);
            System.out.println("Consumiste: "+ c.queConsumiste() + ". Se te dió $" + c.cuantoVuelto() + " de vuelto.");
        }
        catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            m = new Moneda1000();
            c = new Comprador(m, 40, exp);
            System.out.println("Consumiste: "+ c.queConsumiste() + ". Se te dió $" + c.cuantoVuelto() + " de vuelto.");
        }
        catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            m = new Moneda1000();
            c = new Comprador(m, 74, exp);
            System.out.println("Consumiste: "+ c.queConsumiste() + ". Se te dió $" + c.cuantoVuelto() + " de vuelto.");
        }
        catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            m = new Moneda100();
            c = new Comprador(m, 5, exp);
            System.out.println("Consumiste: "+ c.queConsumiste() + ". Se te dió $" + c.cuantoVuelto() + " de vuelto.");
        }
        catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}