
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

public class Lab4_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        int wi = 500;
        int hi = 200;
        frame.setSize(wi, hi);
        frame.setTitle("Lab 4-1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        int windowW = wi - 16;
        int windowH = hi - 39;

        int edge_space = 2;
        System.out.println(windowW + ", " + windowH + ", " + edge_space);

        frame.getContentPane().setBackground(Color.PINK);

        JTextArea message_board = new JTextArea();
        message_board.setLocation(0,0);
        //message_board.setSize(message_board.getPreferredSize());
        message_board.setSize(windowW, windowH / 2-20);
        //message_board.setCaretPosition(2);
        message_board.setText("\nEnter your name here:");
        frame.add(message_board);

        JTextField input = new JTextField(50);
        input.setLocation(edge_space/2, message_board.getSize().height );
        // input.setSize((windowW - 2 * edge_space, windowH / 3));
        input.setSize(windowW - edge_space, 20);
        input.setText("Hello Josephine Student");
        frame.add(input);

        int btn_high = message_board.getSize().height +20+ edge_space * 3;

          JButton btn1 = new JButton("Click me");
          btn1.setLocation(windowW/2-edge_space/2 - btn1.getPreferredSize().width,btn_high);
           // btn1.setLocation(100, btn_high);
          btn1.setSize(btn1.getPreferredSize().width, btn1.getPreferredSize().height);
          frame.add(btn1);

          JButton btn2 = new JButton("Cancel");
          btn2.setLocation(windowW/2+edge_space/2,btn_high);
          //btn2.setLocation(200, btn_high);
          btn2.setSize(btn2.getPreferredSize());
          frame.add(btn2);

        frame.setVisible(true);
    }
}
/*
 * public class MyButtonListener implements ActionListener { public void
 * actionPerformed(ActionEvent e) { int seed = 1; if (seed == 1) {
 * System.out.println("Seed == 1"); } else {
 * System.out.println("Seed == Othre"); } } }
 */