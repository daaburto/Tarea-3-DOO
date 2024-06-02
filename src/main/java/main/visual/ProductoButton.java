package main.visual;

import javax.swing.*;
import java.awt.*;

/**
 * ProductoButton representa un botón personalizado para un producto en PanelExpendedor.
 * @see PanelExpendedor
 * @author Daniel Aburto
 */
public class ProductoButton extends JButton {
    /**
     * Cantidad disponible del producto.
     */
    private int cantidad;

    /**
     * Imagen del producto.
     */
    private Image image;

    /**
     * Crea un nuevo ProductoButton.
     * @param icon icono que representa la imagen del producto.
     * @param cantidad cantidad disponible del producto.
     */
    public ProductoButton(Icon icon, int cantidad) {
        this.cantidad = cantidad;
        this.image = ((ImageIcon) icon).getImage();
    }

    /**
     * @return cantidad disponible del producto.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad disponible del producto.
     * @param cantidad nueva cantidad disponible.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Reduce la cantidad disponible del producto en uno.
     */
    public void reducirCantidad() {
        if (cantidad > 0) {
            cantidad--;
            repaint();
        }
    }

    /**
     * Sobrescribe paintComponent para dibujar la imagen del producto y su cantidad disponible.
     * @param g El contexto gráfico en el que se dibuja el componente.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int yOffset = 150 - (cantidad - 1) * 30;
        for (int i = 0; i < cantidad; i++) {
            g.drawImage(image, 22, yOffset + (i * 30), this);
        }
    }
}