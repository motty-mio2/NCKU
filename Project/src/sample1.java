package Lab4_2;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
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

public class sample1 /* implements /*ActionListener */ {

    public static int gamemode = 0;
    public static int score;

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
        // timer.setFont(,default,defau24);

        timer.setText("Let's Challenge !!");
        timer.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(timer);

        JTextField scoreboard = new JTextField(50);
        scoreboard.setLocation(windowW * 2 / 3, windowW);
        scoreboard.setSize(windowW * 1 / 3, windowH - windowW);
        scoreboard.setText(String.valueOf(score));
        scoreboard.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(scoreboard);

        ActionListener listen = new MyButtonListener1(scoreboard);

        JButton btn1 = new JButton();
        btn1.addActionListener(listen);
        frame.add(btn1);

        JButton btnstt = new JButton();
        btnstt.addActionListener(new Modechanger());
        btnstt.setHorizontalAlignment(JButton.CENTER);
        int sttw = 100;
        int stth = 62;
        btnstt.setSize(sttw, stth);
        btnstt.setText("Start !");
        frame.add(btnstt);

        frame.setLayout(null);
        frame.setVisible(true);

        timer.setFont(new Font("Arial", Font.PLAIN, 30));
        scoreboard.setFont(new Font("Arial", Font.PLAIN, 30));

        int targS, targX, targY;
        long staT;
        long nowT;
        long flgT;
        int oldscore;

        while (true) {
            if (gamemode == 1) {
                score = 0;
                oldscore = score;
                scoreboard.setText(String.valueOf(score));
                staT = System.currentTimeMillis();
                nowT = System.currentTimeMillis();
                flgT = System.currentTimeMillis();
                btnstt.setLocation(windowH, windowH);
                btn1.setLocation(windowH, windowH);
                while (nowT - staT < 30000) {
                    gamemode = 1;
                    nowT = System.currentTimeMillis();
                    timer.setText("Last " + (30 - (nowT - staT) / 1000) + "s");

                    if (System.currentTimeMillis() - flgT > 1000 || oldscore != score) {
                        oldscore = score;
                        do {
                            targS = rand.nextInt(150);
                        } while (targS < 30);
                        targX = rand.nextInt(windowW - targS);
                        targY = rand.nextInt(windowW - targS);
                        int setscore;
                        do {
                            setscore = rand.nextInt(9);
                        } while (setscore == 0);
                        btn1.setText(String.valueOf(setscore));
                        btn1.setLocation(targX, targY);
                        btn1.setSize(targS, targS);
                        flgT = System.currentTimeMillis();
                    }
                }
                gamemode = 0;
            } else {
                btnstt.setLocation((windowW - sttw) / 2, (windowW - stth) / 2);
                btn1.setLocation(windowH, windowH);
            }
        }
    }
}

public class MyButtonListener1 implements ActionListener {
    private JTextField scoreboard;

    public MyButtonListener1(JTextField scoreget) {
        this.scoreboard = scoreget;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        // score += Integer.parseInt(command);

        sample1.score += Integer.parseInt(command);
        scoreboard.setText(String.valueOf(sample1.score));
    }
}

public class Modechanger implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        sample1.gamemode = 1;
    }
}
