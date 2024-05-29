package main.visual;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    private ProductoButton[] productos;
    private JButton boton;
    private String[] imagenes = {"src/main/resources/coca.png", "src/main/resources/sprite.png", "src/main/resources/fanta.png",
    "src/main/resources/snickers.png", "src/main/resources/super8.png", "src/main/resources/chokita.png"};
    private int[] cantidades = {1, 2, 0, 5, 0, 6}; // Cantidades iniciales

    public PanelExpendedor() {
        super();
        this.setBackground(Color.GRAY);
        this.setLayout(new BorderLayout());
        this.setBounds(10, 10, 900, 666);

        productos = new ProductoButton[6];
        JPanel productosPanel = new JPanel();
        productosPanel.setLayout(new GridLayout(2, 3, 10, 10));
        productosPanel.setBackground(Color.GRAY);

        // Botones
        for (int i = 0; i < 6; i++) {
            ImageIcon icon = new ImageIcon(imagenes[i]);
            Image img = icon.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
            productos[i] = new ProductoButton(new ImageIcon(img), cantidades[i]);
            productos[i].setBackground(Color.LIGHT_GRAY);
            productos[i].setOpaque(true);
            productos[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            int aux = i;
            productos[i].addActionListener(e -> seleccionarProducto(aux));
            productosPanel.add(productos[i]);
        }

        boton = new JButton("RELLENAR");
        boton.addActionListener(e -> rellenarProductos());
        this.add(boton, BorderLayout.NORTH);
        this.add(productosPanel, BorderLayout.CENTER);
    }

    private void seleccionarProducto(int i) {
        // borde
        for (ProductoButton producto : productos) {
            producto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        // borde del producto seleccionado
        productos[i].setBorder(BorderFactory.createLineBorder(Color.RED, 5));
    }

    private void rellenarProductos() {
        for (ProductoButton producto : productos) {
            if (producto.getCantidad() == 0) {
                producto.setCantidad(6);
                producto.repaint();
            }
        }
    }
}

class ProductoButton extends JButton {
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < cantidad; i++) {
            g.drawImage(image, 22, i * 30, this);
        }
    }
}
