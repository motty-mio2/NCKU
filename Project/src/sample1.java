package Lab4_2;

import java.awt.event.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.io.*;
import java.util.*;
import javax.swing.*;

//import com.sun.org.apache.bcel.internal.generic.INEG;

//import com.sun.java.swing.ui.CommonMenuBar;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.*;

public class sample1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Simple Game1");
        int wi = 600;
        int hi = 800;
        int windowW = wi - 16;
        int windowH = hi - 39;
        frame.setSize(wi, hi);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.getContentPane().setBackground(new Color(224,223,229,250));
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);

        Random rand = new Random();

        JTextField timer = new JTextField(50);
        timer.setLocation(0, windowW);
        timer.setSize(windowW * 2 / 3, windowH - windowW);
        timer.setText("Here Come a new Challenger!!");
        timer.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(timer);

        JTextField scoreboard = new JTextField(50);
        scoreboard.setLocation(windowW * 2 / 3, windowW);
        scoreboard.setSize(windowW * 1 / 3, windowH - windowW);
        scoreboard.setText("0");
        scoreboard.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(scoreboard);

        ActionListener listen = new MyButtonListener(scoreboard);

        JButton btn1 = new JButton();
        btn1.setText("3");
        btn1.addActionListener(listen);
        frame.add(btn1);

        frame.setLayout(null);
        frame.setVisible(true);

        long staT = System.currentTimeMillis();
        long nowT = System.currentTimeMillis();
        long flgT = System.currentTimeMillis();
        int targS, targX, targY;

        String score = scoreboard.getText();
        String oldscore = scoreboard.getText();

        while (nowT - staT < 30000) {
            nowT = System.currentTimeMillis();
            timer.setText("Last " + (30 - (nowT - staT) / 1000) + "s");

            score = scoreboard.getText();

            if (System.currentTimeMillis() - flgT > 1000 || !oldscore.equals(score)) {
                oldscore = score;
                do {
                    targS = rand.nextInt(50) * 3;
                } while (targS < 20);
                targX = rand.nextInt(windowW - targS);
                targY = rand.nextInt(windowW - targS);
                btn1.setLocation(targX, targY);
                btn1.setSize(targS, targS);
                flgT = System.currentTimeMillis();
            }

            //
            /*
             * JButton btnClr = new JButton(); btnClr.setLocation(rows[1] + spacer * 1,
             * clms[6]); btnClr.setSize(btnW * 2 - spacer * 3, btnH);
             * btnClr.setText("Clear"); btnClr.addActionListener(listen); frame.add(btnClr);
             */

        }
    }
}

public class MyButtonListener implements ActionListener {
    private JTextField score;
    private int point = 0;

    public MyButtonListener(JTextField score) {
        this.score = score;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        // score += Integer.parseInt(command);

        point += Integer.parseInt(command);
        score.setText(String.valueOf(point));
    }
}
