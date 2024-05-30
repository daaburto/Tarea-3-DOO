package main.visual;

import main.java.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComprador extends JPanel implements ActionListener{

    private JButton pushbutton;
    private JButton paybutton;
    //JButton resetbutton;
    private JButton moneda100;
    private JButton moneda500;
    private JButton moneda1000;
    private JButton moneda1500;
    private JLabel labelprecio;
    private int precio;
    private int cualproducto;
    private Comprador comprador;
    private Moneda monedacomprador;
    PanelComprador(){
        super();
        precio = 0;
        cualproducto = 2;
        monedacomprador = null;
        // Imagenes
        ImageIcon img_moneda100 = new ImageIcon("src/main/resources/moneda100.png");
        ImageIcon img_moneda500 = new ImageIcon("src/main/resources/moneda500.png");
        ImageIcon img_moneda1000 = new ImageIcon("src/main/resources/moneda1000.png");
        ImageIcon img_moneda1500 = new ImageIcon("src/main/resources/moneda1500.png");


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
        pushbutton.addActionListener(this);

        // Boton Pay
        paybutton = new JButton("PAY");
        paybutton.setBounds(0,120,300,80);
        paybutton.addActionListener(this);

        // Boton Reset
        /*
        resetbutton = new JButton("RESET");
        resetbutton.setBounds(150,120,150,80);
        resetbutton.addActionListener(this);

         */

        // Boton Monedas
        moneda100 = new JButton(img_moneda100);
        moneda100.setBackground(Color.PINK);
        moneda100.addActionListener(this);

        moneda500 = new JButton(img_moneda500);
        moneda500.setBackground(Color.GREEN);
        moneda500.addActionListener(this);

        moneda1000 = new JButton(img_moneda1000);
        moneda1000.setBackground(Color.CYAN);
        moneda1000.addActionListener(this);

        moneda1500 = new JButton(img_moneda1500);
        moneda1500.setBackground(Color.YELLOW);
        moneda1500.addActionListener(this);


         //                                   //
        /////////////// BOTONES ///////////////


        this.add(pushbutton);
        this.add(panelpago);
        this.add(panelmonedas);

        panelpago.add(paybutton);
        //panelpago.add(resetbutton);
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
            precio = 100;
            moneda100.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
            moneda500.setBorder(null);
            moneda1000.setBorder(null);
            moneda1500.setBorder(null);
        }
        else if(button_down.getSource() == moneda500)
        {
            precio = 500;
            moneda500.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
            moneda100.setBorder(null);
            moneda1000.setBorder(null);
            moneda1500.setBorder(null);
        }
        else if(button_down.getSource() == moneda1000)
        {
            precio = 1000;
            moneda1000.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
            moneda100.setBorder(null);
            moneda500.setBorder(null);
            moneda1500.setBorder(null);
        }
        else if(button_down.getSource() == moneda1500)
        {
            precio = 1500;
            moneda1500.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
            moneda100.setBorder(null);
            moneda500.setBorder(null);
            moneda1000.setBorder(null);
        }
        else if(button_down.getSource() == paybutton)
        {
            if (cualproducto != 0)
            {
                Expendedor exp = new Expendedor(5);

                if (precio == 100) {
                    monedacomprador = new Moneda100();
                } else if (precio == 500) {
                    monedacomprador = new Moneda500();
                } else if (precio == 1000) {
                    monedacomprador = new Moneda1000();
                } else if (precio == 1500) {
                    monedacomprador = new Moneda1500();
                }

                try {
                    comprador = new Comprador(monedacomprador, cualproducto, exp);
                    JOptionPane.showMessageDialog(null, "Se ha comprado el producto con exito", "Compra Exitosa!", JOptionPane.PLAIN_MESSAGE);
                } catch (NoHayProductoException e) {
                    JOptionPane.showMessageDialog(null, "No queda el producto que intentas comprar", "No hay producto", JOptionPane.INFORMATION_MESSAGE);
                } catch (PagoInsuficienteException e) {
                    JOptionPane.showMessageDialog(null, "No tienes dinero suficiente para comprar el producto", "Pago Insuficiente", JOptionPane.INFORMATION_MESSAGE);
                } catch (PagoIncorrectoException e) {
                    JOptionPane.showMessageDialog(null, "No has ingresado ninguna moneda", "Pago Incorrecto", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        }else if (button_down.getSource() == pushbutton)
        {
            JOptionPane.showMessageDialog(null,"Has comprado " + comprador.queConsumiste());
        }

        labelprecio.setText(String.valueOf(precio) + "$");
    }

}
