package net;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel  {
    /**
     * tutta la gestione dei bottoni con stili etc etc
     */
    protected JButton one = new JButton("1");
    protected JButton two = new JButton("2");
    protected JButton three = new JButton("3");
    protected JButton four = new JButton("4");
    protected JButton five = new JButton("5");
    protected JButton six = new JButton("6");
    protected JButton seven = new JButton("7");
    protected JButton eight = new JButton("8");
    protected JButton nine = new JButton("9");
    protected JButton zero = new JButton("0");
    protected JButton dot = new JButton(".");
    protected JButton clear = new JButton("Clear");
    protected JButton pow = new JButton("^");
    protected JButton percentage = new JButton("%");
    protected JButton over = new JButton("1/x");
    protected JButton addition = new JButton("+");
    protected JButton subtraction = new JButton("-");
    protected JButton multiplication = new JButton("*");
    protected JButton division = new JButton("/");
    protected JButton confirm=new JButton("=");

    public static final Font fontNumber = new Font(Font.SANS_SERIF, Font.BOLD, 16); // Font numeri
    public static final Font fontButton = new Font(Font.SANS_SERIF, Font.BOLD, 22); // Font tasti

    View() {
        setLayout(new GridLayout(5,4));

        one.setBackground(Color.WHITE);one.setFont(fontNumber);
        two.setBackground(Color.WHITE);two.setFont(fontNumber);
        three.setBackground(Color.WHITE);three.setFont(fontNumber);
        four.setBackground(Color.WHITE);four.setFont(fontNumber);
        five.setBackground(Color.WHITE);five.setFont(fontNumber);
        six.setBackground(Color.WHITE);six.setFont(fontNumber);
        seven.setBackground(Color.WHITE);seven.setFont(fontNumber);
        eight.setBackground(Color.WHITE);eight.setFont(fontNumber);
        nine.setBackground(Color.WHITE);nine.setFont(fontNumber);
        zero.setBackground(Color.WHITE);zero.setFont(fontNumber);


        dot.setBackground(Color.LIGHT_GRAY);dot.setFont(fontButton);
        clear.setBackground(Color.LIGHT_GRAY);clear.setFont(fontNumber);  //porta il font dei numeri
        pow.setBackground(Color.LIGHT_GRAY);pow.setFont(fontButton);
        percentage.setBackground(Color.LIGHT_GRAY);percentage.setFont(fontButton);
        over.setBackground(Color.LIGHT_GRAY);over.setFont(fontButton);
        addition.setBackground(Color.LIGHT_GRAY);addition.setFont(fontButton);
        subtraction.setBackground(Color.LIGHT_GRAY);subtraction.setFont(fontButton);
        multiplication.setBackground(Color.LIGHT_GRAY);multiplication.setFont(fontButton);
        division.setBackground(Color.LIGHT_GRAY);division.setFont(fontButton);
        confirm.setBackground(Color.LIGHT_GRAY);confirm.setFont(fontButton);confirm.setForeground(Color.BLUE); //tasto colore blu

        add(one);add(two);add(three);add(addition);
        add(four);add(five);add(six);add(subtraction);
        add(seven);add(eight);add(nine);add(multiplication);
        add(zero);add(dot);add(clear);add(division);
        add(pow);add(percentage);add(over);add(confirm);



    }
}
