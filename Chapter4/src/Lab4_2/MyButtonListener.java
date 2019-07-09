package Lab4_2;

import java.awt.event.*;

public class MyButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
        case "1":
            // Lab4_2.input.setText("1");
            System.out.println(1);
            // System.out.println(Lab4_2.main.btnW);
            break;
        case "2":
            System.out.println(2);
            break;
        case "3":
            System.out.println(3);
            break;
        case "4":
            System.out.println(4);
            break;
        case "5":
            System.out.println(5);
            break;
        case "6":
            System.out.println(6);
            break;
        case "7":
            System.out.println(7);
            break;
        case "8":
            System.out.println(8);
            break;
        case "9":
            System.out.println(9);
            break;
        case "0":
            System.out.println(0);
            break;
        case "+":
            System.out.println("+");
            break;
        case "-":
            System.out.println("-");
            break;
        case "*":
            System.out.println("*");
            break;
        case "/":
            System.out.println("/");
            break;
        case "=":
            System.out.println("=");
            break;
        case "Clear":
            System.out.println("C");
            break;

        default:
            System.out.println("other");
        }

    }
}
