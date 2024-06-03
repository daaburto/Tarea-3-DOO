package main.visual;

import javax.swing.*;
import java.awt.*;

/**
 * MonedaButton es una clase personalizada que representa un botón que muestra una imagen de moneda
 * y mantiene un contador de la cantidad de monedas.
 * @see PanelDepositoMonedas
 * @author Joaquín Sandoval
 */
public class MonedaButton extends JButton{
    /**
     * Cantidad de monedas.
     */
    private int cantidad;

    /**
     * Imagen de la moneda.
     */
    private Image image;

    /**
     * Constructor de MonedaButton.
     * @param img El icono que representa la imagen de la moneda.
     */
    public MonedaButton(Icon img){
        this.image = ((ImageIcon) img).getImage();
        this.cantidad = 0;

        this.setVisible(true);
        this.setOpaque(true);
        this.setBackground(Color.LIGHT_GRAY);
    }

    /**
     * @return cantidad de monedas.
     */
    public int getCantidad(){
        return cantidad;
    }

    /**
     * Aumenta la cantidad de monedas en uno.
     */
    public void AumentarCantidad(){
        cantidad++;
        repaint();
    }

    /**
     * Sobrescribe el método paintComponent para dibujar la imagen de la moneda según la cantidad.
     * @param g donde se dibuja el componente.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < cantidad; i++) {
            if (i < 12) {
                g.drawImage(image, 37, (i * 10), this);
            } else if (i < 24){
                g.drawImage(image, 80, ((i-12) * 10), this);
            }else if (i < 36){
                g.drawImage(image, -3, ((i-24) * 10), this);
            } else if (i < 48) {
                g.drawImage(image, 120, ((i-36) * 10), this);
            }
        }
    }

    }