package main.visual;

import main.java.Moneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDepositoMonedas extends JDialog implements ActionListener {
    private static MonedaButton[] monedas;
    private String[] imagenes = {
            "src/main/resources/moneda100.png",
            "src/main/resources/moneda500.png",
            "src/main/resources/moneda1000.png",
            "src/main/resources/moneda1500.png"
    };
    PanelDepositoMonedas(JFrame frame){
        super(frame, "Monedero", ModalityType.MODELESS);
        ImageIcon logo = new ImageIcon("src/main/resources/moneda100.png");

        monedas = new MonedaButton[4];

        this.setIconImage(logo.getImage());
        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        this.setLayout(new GridLayout(2,2));
        this.setResizable(false);

        // Botones
        for (int i = 0; i < 4; i++){
            ImageIcon icon = new ImageIcon(imagenes[i]);
            Image img = icon.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
            monedas[i] = new MonedaButton(new ImageIcon(img));
            monedas[i].addActionListener(this);
            this.add(monedas[i]);
        }

        this.setSize(350,350);
        this.setVisible(false);
    }

    public static void AumentarCantidad(int num_moneda){
        if (num_moneda == 100) {
            monedas[0].AumentarCantidad();
        }else if (num_moneda == 500){
            monedas[1].AumentarCantidad();
        }else if (num_moneda == 1000){
            monedas[2].AumentarCantidad();
        }else if (num_moneda == 1500){
            monedas[3].AumentarCantidad();
        }
    }


    @Override
    public void actionPerformed(ActionEvent button_down) {
        if (button_down.getSource() == monedas[0]) {
            JOptionPane.showMessageDialog(null, "Has gastado " + monedas[0].getCantidad() + " monedas de 100$ en este depósito, lo que son " + monedas[0].getCantidad() * 100 + "$" + "\ngasto total: " + ((monedas[0].getCantidad()*100) + (monedas[1].getCantidad()*500) + (monedas[2].getCantidad()*1000) + (monedas[3].getCantidad()*1500)) + "$", "Monedas en depósito", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(imagenes[0]));
        }else if (button_down.getSource() == monedas[1]){
            JOptionPane.showMessageDialog(null, "Has gastado " + monedas[1].getCantidad() + " monedas de 500$ en este depósito, lo que son " + monedas[1].getCantidad() * 500 + "$" + "\ngasto total: " + ((monedas[0].getCantidad()*100) + (monedas[1].getCantidad()*500) + (monedas[2].getCantidad()*1000) + (monedas[3].getCantidad()*1500)) + "$", "Monedas en depósito", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(imagenes[1]));
        }else if (button_down.getSource() == monedas[2]){
            JOptionPane.showMessageDialog(null, "Has gastado " + monedas[2].getCantidad() + " monedas de 1000$ en este depósito, lo que son " + monedas[2].getCantidad() * 1000 + "$" + "\ngasto total: " + ((monedas[0].getCantidad()*100) + (monedas[1].getCantidad()*500) + (monedas[2].getCantidad()*1000) + (monedas[3].getCantidad()*1500)) + "$", "Monedas en depósito", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(imagenes[2]));
        }else if (button_down.getSource() == monedas[3]){
            JOptionPane.showMessageDialog(null, "Has gastado " + monedas[3].getCantidad() + " monedas de 1500$ en este depósito, lo que son " + monedas[3].getCantidad() * 1500 + "$" + "\ngasto total: " + ((monedas[0].getCantidad()*100) + (monedas[1].getCantidad()*500) + (monedas[2].getCantidad()*1000) + (monedas[3].getCantidad()*1500)) + "$", "Monedas en depósito", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(imagenes[3]));
        }
    }
}
