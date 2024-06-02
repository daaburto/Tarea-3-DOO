package main.visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonedaButton extends JButton{
    private int cantidad;

    private Image image;


    public MonedaButton(Icon img){
        this.image = ((ImageIcon) img).getImage();
        this.cantidad = 0;

        this.setVisible(true);
        this.setOpaque(true);
        this.setBackground(Color.LIGHT_GRAY);
    }

    public int getCantidad(){
        return cantidad;
    }

    public void AumentarCantidad(){
        cantidad++;
        repaint();
    }

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