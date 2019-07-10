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
    public static int highscore = 0;
    public static int targetmng = 0;
    public static int[] scorecng = { 0, 0 };

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Simple Game1");
        int wi = 900;
        int hi = 1000;
        int windowW = wi - 16;
        int windowH = hi - 39;
        frame.setSize(wi, hi);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);

        Random rand = new Random();

        JTextField timer = new JTextField(50);
        timer.setLocation(0, windowW);
        timer.setSize(windowW / 3, windowH - windowW);
        timer.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(timer);

        JTextField hscoremng = new JTextField(50);
        hscoremng.setLocation(windowW / 3, windowW);
        hscoremng.setSize(windowW * 1 / 3, windowH - windowW);
        hscoremng.setText("High Score \n" + highscore);
        hscoremng.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(hscoremng);

        JTextField scoreboard = new JTextField(50);
        scoreboard.setLocation(windowW * 2 / 3, windowW);
        scoreboard.setSize(windowW * 1 / 3, windowH - windowW);
        scoreboard.setText(String.valueOf(score));
        scoreboard.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(scoreboard);

        ActionListener listen = new MyButtonListener1();
        ActionListener listen2 = new MyButtonListener2();

        JButton btn1 = new JButton();
        btn1.addActionListener(listen);
        frame.add(btn1);

        JButton btn2 = new JButton();
        btn2.addActionListener(listen2);
        frame.add(btn2);

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

        btn1.setFont(new Font("Arial", Font.PLAIN, 20));
        btn2.setFont(new Font("Arial", Font.PLAIN, 20));
        timer.setFont(new Font("Arial", Font.PLAIN, 30));
        hscoremng.setFont(new Font("Arial", Font.PLAIN, 30));
        scoreboard.setFont(new Font("Arial", Font.PLAIN, 30));

        int[] targS = new int[2];
        int[] targX = new int[2];
        int[] targY = new int[2];
        long[] flgT = new long[2];
        long staT;
        long nowT;
        int oldscore;
        JButton[] btnlist = { btn1, btn2 };

        while (true) {
            if (gamemode == 1) {
                score = 0;
                oldscore = score;
                scoreboard.setText(String.valueOf(score));
                btnstt.setLocation(windowH, windowH);
                for (int i = 0; i < 2; i++) { // start up script
                    targS[i] = rand.nextInt(40) + 80;
                    targX[i] = rand.nextInt((windowW - targS[i]) / 2) * (i + 1);
                    targY[i] = rand.nextInt(windowW - targS[i]);
                    int setscore;
                    setscore = rand.nextInt(8) + 1;
                    btnlist[i].setText(String.valueOf(setscore));
                    scorecng[i] = rand.nextInt(9);
                    if (scorecng[i] == 0) {
                        btnlist[i].setBackground(Color.CYAN);
                    } else if (scorecng[i] == 7) {
                        btnlist[i].setBackground(Color.RED);
                    } else {
                        btnlist[i].setBackground(Color.WHITE);
                    }
                    btnlist[i].setLocation(targX[i], targY[i]);
                    btnlist[i].setSize(targS[i], targS[i]);
                    flgT[i] = System.currentTimeMillis();
                }
                staT = System.currentTimeMillis();
                nowT = System.currentTimeMillis();
                while (nowT - staT < 30000) {
                    gamemode = 1;
                    nowT = System.currentTimeMillis();
                    timer.setText("Last " + (30 - (nowT - staT) / 1000) + "s");

                    if (targetmng == 0) {
                        if (nowT - flgT[0] > 1000) {
                            targetmng += 1;
                        }
                        if (nowT - flgT[1] > 1000) {
                            targetmng += 2;
                        }
                    }
                    System.out.println(targetmng);

                    if (targetmng == 1 || targetmng == 2) {
                        int i = targetmng - 1;
                        do {
                            targS[i] = rand.nextInt(120);
                        } while (targS[i] < 80);
                        targX[i] = rand.nextInt((windowW - targS[i]) / 2) * (i + 1);
                        targY[i] = rand.nextInt(windowW - targS[i]);
                        int setscore;
                        do {
                            setscore = rand.nextInt(9);
                        } while (setscore == 0);
                        scorecng[i] = rand.nextInt(9);
                        if (scorecng[i] == 0) {
                            btnlist[i].setBackground(Color.CYAN);
                        } else if (scorecng[i] == 7) {
                            btnlist[i].setBackground(Color.RED);
                        } else {
                            btnlist[i].setBackground(Color.WHITE);
                        }
                        btnlist[i].setText(String.valueOf(setscore));
                        btnlist[i].setLocation(targX[i], targY[i]);
                        btnlist[i].setSize(targS[i], targS[i]);
                        flgT[i] = System.currentTimeMillis();
                    } else if (targetmng == 3) {
                        for (int i = 0; i < 2; i++) { // start up script
                            targS[i] = rand.nextInt(40) + 80;
                            targX[i] = rand.nextInt((windowW - targS[i]) / 2) * (i + 1);
                            targY[i] = rand.nextInt(windowW - targS[i]);
                            int setscore;
                            setscore = rand.nextInt(8) + 1;
                            scorecng[i] = rand.nextInt(9);
                            if (scorecng[i] == 0) {
                                btnlist[i].setBackground(Color.CYAN);
                            } else if (scorecng[i] == 7) {
                                btnlist[i].setBackground(Color.RED);
                            } else {
                                btnlist[i].setBackground(Color.WHITE);
                            }
                            btnlist[i].setText(String.valueOf(setscore));
                            btnlist[i].setLocation(targX[i], targY[i]);
                            btnlist[i].setSize(targS[i], targS[i]);
                            flgT[i] = System.currentTimeMillis();
                        }
                    }

                    targetmng = 0;

                    if (oldscore != score) {
                        scoreboard.setText(String.valueOf(score));

                        oldscore = score;
                    }
                    if (score >= highscore) {
                        highscore = score;
                        hscoremng.setText("High Score \n" + highscore);
                        scoreboard.setBackground(Color.ORANGE);
                        hscoremng.setBackground(Color.ORANGE);
                    } else {
                        scoreboard.setBackground(Color.WHITE);
                        hscoremng.setBackground(Color.WHITE);
                    }
                }
                gamemode = 0;
            } else {
                score = 0;
                timer.setText("Let's Challenge !!");
                btnstt.setLocation((windowW - sttw) / 2, (windowW - stth) / 2);
                btn1.setLocation(windowH, windowH);
                btn2.setLocation(windowH, windowH);
            }
        }
    }
}

public class MyButtonListener1 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        int rate;
        switch (sample1.scorecng[0]) {
        case 0:
            rate = -1;
            break;
        case 7:
            rate = 2;
            break;
        default:
            rate = 1;
        }
        sample1.score += Integer.parseInt(command) * rate;
        sample1.targetmng = 1;
    }
}

public class MyButtonListener2 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        int rate;
        switch (sample1.scorecng[1]) {
        case 0:
            rate = -1;
            break;
        case 7:
            rate = 2;
            break;
        default:
            rate = 1;
        }
        sample1.score += Integer.parseInt(command) * rate;
        sample1.targetmng = 2;
    }
}

public class Modechanger implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        sample1.gamemode = 1;
    }
}
