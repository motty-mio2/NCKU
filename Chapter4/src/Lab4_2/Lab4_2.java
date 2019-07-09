package Lab4_2;

import java.awt.event.*;
import java.awt.Color;
import java.awt.BorderLayout;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.*;

public class Lab4_2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Simle Calc");
        int wi = 300;
        int hi = 500;
        int windowW = wi - 16;
        int windowH = hi - 39;
        int spacer = 6;
        int btnW = (windowW - 10 * spacer) / 4;
        int btnH = (windowH - 15 * spacer) / 7;
        frame.setSize(wi, hi);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.getContentPane().setBackground(new Color(224,223,229,250));
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);

        int[] rows = { spacer * 3 + btnW * 0, spacer * 4 + btnW * 1, spacer * 5 + btnW * 2, spacer * 7 + btnW * 3 };
        int[] clms = { spacer * 3 + btnH * 0, spacer * 5 + btnH * 1, spacer * 6 + btnH * 2, spacer * 7 + btnH * 3,
                spacer * 8 + btnH * 4, spacer * 9 + btnH * 5, spacer * 12 + btnH * 6 };

        JTextField input = new JTextField(50);
        input.setLocation(rows[0], clms[0]);
        input.setSize(windowW - 6 * spacer, btnH);
        input.setHorizontalAlignment(JTextField.RIGHT);
        input.setText("");
        frame.add(input);

        ActionListener listen = new MyButtonListener(input);

        JButton btn7 = new JButton();
        btn7.setLocation(rows[0], clms[1]);
        btn7.setSize(btnW, btnH);
        btn7.setText("7");
        btn7.addActionListener(listen);
        frame.add(btn7);

        JButton btn8 = new JButton();
        btn8.setLocation(rows[1], clms[1]);
        btn8.setSize(btnW, btnH);
        btn8.setText("8");
        btn8.addActionListener(listen);
        frame.add(btn8);

        JButton btn9 = new JButton();
        btn9.setLocation(rows[2], clms[1]);
        btn9.setSize(btnW, btnH);
        btn9.setText("9");
        btn9.addActionListener(listen);
        frame.add(btn9);

        JButton btn4 = new JButton();
        btn4.setLocation(rows[0], clms[2]);
        btn4.setSize(btnW, btnH);
        btn4.setText("4");
        btn4.addActionListener(listen);
        frame.add(btn4);

        JButton btn5 = new JButton();
        btn5.setLocation(rows[1], clms[2]);
        btn5.setSize(btnW, btnH);
        btn5.setText("5");
        btn5.addActionListener(listen);
        frame.add(btn5);

        JButton btn6 = new JButton();
        btn6.setLocation(rows[2], clms[2]);
        btn6.setSize(btnW, btnH);
        btn6.setText("6");
        btn6.addActionListener(listen);
        frame.add(btn6);

        JButton btn1 = new JButton();
        btn1.setLocation(rows[0], clms[3]);
        btn1.setSize(btnW, btnH);
        btn1.setText("1");
        btn1.addActionListener(listen);
        frame.add(btn1);

        JButton btn2 = new JButton();
        btn2.setLocation(rows[1], clms[3]);
        btn2.setSize(btnW, btnH);
        btn2.setText("2");
        btn2.addActionListener(listen);
        frame.add(btn2);

        JButton btn3 = new JButton();
        btn3.setLocation(rows[2], clms[3]);
        btn3.setSize(btnW, btnH);
        btn3.setText("3");
        btn3.addActionListener(listen);
        frame.add(btn3);

        JButton btn0 = new JButton();
        btn0.setLocation(rows[1], clms[4]);
        btn0.setSize(btnW, btnH);
        btn0.setText("0");
        btn0.addActionListener(listen);
        frame.add(btn0);

        JButton btnPls = new JButton();
        btnPls.setLocation(rows[3], clms[1]);
        btnPls.setSize(btnW, btnH);
        btnPls.setText("+");
        btnPls.addActionListener(listen);
        frame.add(btnPls);

        JButton btnMis = new JButton();
        btnMis.setLocation(rows[3], clms[2]);
        btnMis.setSize(btnW, btnH);
        btnMis.setText("-");
        btnMis.addActionListener(listen);
        frame.add(btnMis);

        JButton btnMlt = new JButton();
        btnMlt.setLocation(rows[3], clms[3]);
        btnMlt.setSize(btnW, btnH);
        btnMlt.setText("*");
        btnMlt.addActionListener(listen);
        frame.add(btnMlt);

        JButton btnDiv = new JButton();
        btnDiv.setLocation(rows[3], clms[4]);
        btnDiv.setSize(btnW, btnH);
        btnDiv.setText("/");
        btnDiv.addActionListener(listen);
        frame.add(btnDiv);

        JButton btnEql = new JButton();
        btnEql.setLocation(rows[3], clms[5]);
        btnEql.setSize(btnW, btnH);
        btnEql.setText("=");
        btnEql.addActionListener(listen);
        frame.add(btnEql);

        JButton btnClr = new JButton();
        btnClr.setLocation(rows[1] + spacer * 1, clms[6]);
        btnClr.setSize(btnW * 2 - spacer * 3, btnH);
        btnClr.setText("Clear");
        btnClr.addActionListener(listen);
        frame.add(btnClr);

        frame.setVisible(true);
        /*
         * try { Scanner fileread = new Scanner(new FileInputStream("tmp.txt")); String
         * line; while (true) { line = fileread.nextLine(); input.setText(line); } }
         * catch (Exception g) { g.printStackTrace(); }
         */
    }
}

public class MyButtonListener implements ActionListener {
    private JTextField input;

    public MyButtonListener(JTextField input) {
        this.input = input;
    }

    public void actionPerformed(ActionEvent e) {
        String nowwrite = input.getText();
        String command = e.getActionCommand();

        if (nowwrite.equals("error")) {
            nowwrite = "";
        }
        switch (command) {
        case "Clear":
            input.setText("");
            break;
        case "=":
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            String code = "tmp";
            try {
                code = (engine.eval(nowwrite)).toString();
            } catch (ScriptException ex) {
                // ex.printStackTrace();
                code = "error";
            }

            input.setText(code);
            // input.setText(code);
            break;
        default:
            input.setText(nowwrite + command);
        }
        /*
         * try { PrintWriter filewrite = new PrintWriter(new
         * FileOutputStream("tmp.txt"));
         *
         * filewrite.print(command); } catch (FileNotFoundException f) {
         * f.printStackTrace(); }
         */

        // System.out.println(command);

        /*
         * switch (command) { case "1": // Lab4_2.input.setText("1");
         * System.out.println(1); // System.out.println(Lab4_2.main.btnW); break; case
         * "2": System.out.println(2); break; case "3": System.out.println(3); break;
         * case "4": System.out.println(4); break; case "5": System.out.println(5);
         * break; case "6": System.out.println(6); break; case "7":
         * System.out.println(7); break; case "8": System.out.println(8); break; case
         * "9": System.out.println(9); break; case "0": System.out.println(0); break;
         * case "+": System.out.println("+"); break; case "-": System.out.println("-");
         * break; case "*": System.out.println("*"); break; case "/":
         * System.out.println("/"); break; case "=": System.out.println("="); break;
         * case "Clear": System.out.println("C"); break; default:
         * System.out.println("other"); }
         */
    }
}
