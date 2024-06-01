package main.visual;

import main.java.Expendedor;

import javax.swing.*;
import java.awt.*;
public class ProductoButton extends JButton {
    private int cantidad;
    private Image image;

    public ProductoButton(Icon icon, int cantidad) {
        this.cantidad = cantidad;
        this.image = ((ImageIcon) icon).getImage();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void reducirCantidad() {
        if (cantidad > 0) {
            cantidad--;
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int yOffset = 150 - (cantidad - 1) * 30;
        for (int i = 0; i < cantidad; i++) {
            g.drawImage(image, 22, yOffset + (i * 30), this);
        }
    }
}