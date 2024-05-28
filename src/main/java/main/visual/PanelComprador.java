package main.visual;

import main.java.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComprador extends JPanel implements ActionListener{

    JButton pushbutton;
    JButton paybutton;
    JButton resetbutton;
    JButton moneda100;
    JButton moneda500;
    JButton moneda1000;
    JButton moneda1500;
    JLabel labelprecio;
    int precio;
    PanelComprador(){
        super();
        precio = 0;
        // Imagenes
        ImageIcon img_moneda = new ImageIcon("src/main/resources/moneda.jpg");


        // Panel
        labelprecio = new JLabel();
        labelprecio.setText(String.valueOf(precio) + "$");
        labelprecio.setBounds(75, 30, 150, 50);
        labelprecio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        labelprecio.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        labelprecio.setVerticalAlignment(JLabel.CENTER);
        labelprecio.setHorizontalAlignment(JLabel.CENTER);


         /////////////// PANELES ///////////////
        //                                   //
        // Panel Principal
        JPanel panelcomprador = new JPanel();
        this.setBackground(Color.GRAY);
        this.setBounds(920,10,340,666);
        this.setLayout(null);
        this.setVisible(true);

        // Panel Pago
        JPanel panelpago = new JPanel();
        panelpago.setBackground((Color.WHITE));
        panelpago.setBounds(20,340,300,200);
        panelpago.setLayout(null);
        panelpago.setVisible(true);

        // Panel Monedas
        JPanel panelmonedas = new JPanel();
        panelmonedas.setBackground(Color.WHITE);
        panelmonedas.setBounds(20,20,300,300);
        panelmonedas.setLayout(new GridLayout(2,2));
        panelmonedas.setVisible(true);
         //                                   //
        /////////////// PANELES ///////////////

         /////////////// BOTONES ///////////////
        //                                   //

        // Boton Push
        pushbutton = new JButton("PUSH");
        pushbutton.setBounds(20,550,300,100);

        // Boton Pay
        paybutton = new JButton("PAY");
        paybutton.setBounds(0,120,150,80);

        // Boton Reset
        resetbutton = new JButton("RESET");
        resetbutton.setBounds(150,120,150,80);
        resetbutton.addActionListener(this);

        // Boton Monedas
        moneda100 = new JButton(img_moneda);
        moneda100.addActionListener(this);
        moneda500 = new JButton(img_moneda);
        moneda500.addActionListener(this);
        moneda1000 = new JButton(img_moneda);
        moneda1000.addActionListener(this);
        moneda1500 = new JButton(img_moneda);
        moneda1500.addActionListener(this);


         //                                   //
        /////////////// BOTONES ///////////////


        this.add(pushbutton);
        this.add(panelpago);
        this.add(panelmonedas);

        panelpago.add(paybutton);
        panelpago.add(resetbutton);
        panelpago.add(labelprecio);

        panelmonedas.add(moneda100);
        panelmonedas.add(moneda500);
        panelmonedas.add(moneda1000);
        panelmonedas.add(moneda1500);

    }

    @Override
    public void actionPerformed(ActionEvent button_down){
        if(button_down.getSource() == moneda100)
        {
            precio += 100;
        }
        else if(button_down.getSource() == moneda500)
        {
            precio += 500;
        }
        else if(button_down.getSource() == moneda1000)
        {
            precio += 1000;
        }
        else if(button_down.getSource() == moneda1500)
        {
            precio += 1500;
        }
        else if (button_down.getSource() == resetbutton)
        {
            precio = 0;
        }

        labelprecio.setText(String.valueOf(precio) + "$");
    }

}
