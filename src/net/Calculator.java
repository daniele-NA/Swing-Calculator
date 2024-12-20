package net;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Calculator extends JFrame implements ActionListener {
    private final View buttonPanel = new View();
    private final JTextField display = new JTextField();  //stampa dei numeri
    private final JTextArea history = new JTextArea();
    private final String[] number = new String[2];  //è final,perchè saranno sempre 2 numeri
    private static int ndx = 0;
    private String sign="";

    Calculator() throws IOException {
        super("Calculator Java Swing");
        BufferedImage imageLogoBI= ImageIO.read(Objects.requireNonNull(getClass().getResource("/Logo_Calcolatrice.jpg")));  //logo dell'app
        ImageIcon icon=new ImageIcon(imageLogoBI);
        setIconImage(icon.getImage());
        number[0] = "";
        number[1] = "";
        start();
    }

    private void start() {
        setLayout(new BorderLayout(5, 5));

        //aggiune tutti i bottoni alla gestione eventi

        buttonPanel.one.addActionListener(this);
        buttonPanel.two.addActionListener(this);
        buttonPanel.three.addActionListener(this);
        buttonPanel.four.addActionListener(this);
        buttonPanel.five.addActionListener(this);
        buttonPanel.six.addActionListener(this);
        buttonPanel.seven.addActionListener(this);
        buttonPanel.eight.addActionListener(this);
        buttonPanel.nine.addActionListener(this);
        buttonPanel.zero.addActionListener(this);
        buttonPanel.dot.addActionListener(this);
        buttonPanel.clear.addActionListener(this);
        buttonPanel.pow.addActionListener(this);
        buttonPanel.percentage.addActionListener(this);
        buttonPanel.over.addActionListener(this);
        buttonPanel.addition.addActionListener(this);
        buttonPanel.subtraction.addActionListener(this);
        buttonPanel.multiplication.addActionListener(this);
        buttonPanel.division.addActionListener(this);
        buttonPanel.confirm.addActionListener(this);

        display.setFont(View.fontButton);
        display.setForeground(Color.blue);
        display.setEditable(false);
        display.setPreferredSize(new Dimension(50, 38));
        history.setPreferredSize(new Dimension(120, 0));
        history.setFont(View.fontNumber);
        history.setEditable(false);


        add(new JScrollPane(history), BorderLayout.LINE_END);
        add(display, BorderLayout.PAGE_START);
        add(buttonPanel, BorderLayout.CENTER);
        setSize(600, 350);
        getContentPane().setBackground(Color.BLUE);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String s = e.getActionCommand();
            if (!s.equals("=")) {
                display.setText(display.getText() + s);
            }
            if (s.charAt(0) >= 48 && s.charAt(0) <= 57 && ndx < number.length) {  // <-- è un numero , il controllo dell'indice serve per vedere se sono stati inseriti 2 simboli
                String r = (s.charAt(0)) + "";
                number[ndx] += r; //aggiunge un numero
            } else {        //controllo del segno e del bottone
                switch (s) {
                    case ".":
                        number[ndx] = number[ndx] + ".";
                        break;
                    case "Clear":
                        number[0] = "";
                        number[1] = "";
                        display.setText("");
                        ndx = 0;
                        sign = "";
                        break;
                    case "^":
                        sign = "^";
                        ndx++;
                        break;
                    case "%":
                        sign = "%";
                        number[1] = "2";
                        break;    //si assegna un valore di 2 anche se non viene usato
                    case "1/x":
                        sign = "1/x";
                        number[1] = "2";
                        break;  //si assegna un valore di 2 anche se non viene usato
                    case "+":
                        sign = "+";
                        ndx++;
                        break;
                    case "-":
                        sign = "-";
                        ndx++;
                        break;
                    case "*":
                        sign = "*";
                        ndx++;
                        break;
                    case "/":
                        sign = "/";
                        ndx++;
                        break;

                    case "=":
                        if (!number[1].isEmpty()) {  // se ancora il secondo numero non è stato inserito
                            float first = Float.parseFloat(number[0]);
                            float second = Float.parseFloat(number[1]);
                            switch (sign) {                                          //a seconda del segno,effettua un'operazione
                                case "^":
                                    number[0] = "" + Math.pow(first, second);
                                    break;
                                case "%":
                                    number[0] = "" + (first / 100);
                                    break;
                                case "1/x":
                                    number[0] = "" + (1 / first);
                                    break;
                                case "+":
                                    number[0] = "" + (first + second); //addizione
                                    break;
                                case "-":
                                    number[0] = "" + (first - second); //sottrazione
                                    break;
                                case "*":
                                    number[0] = "" + (first * second); //moltiplicazione
                                    break;
                                case "/":
                                    number[0] = "" + (first / second); //divisione
                                    break;
                            }
                            display.setText(display.getText() + "= " + number[0]);
                            history.setText(display.getText() + "\n");
                            number[1] = "";
                            sign = "";
                            ndx = 0;
                        }
                        break;
                }
            }

        }catch (Exception _){

        }
    }

    public static void main(String[] args) throws IOException {
        new Calculator();

    }
}
