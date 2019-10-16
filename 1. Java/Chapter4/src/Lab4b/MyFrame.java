package Lab4b;

import javax.swing.JFrame;
import javax.swing.JButton;

public class MyFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btn = new JButton("Click me!");
        MyButtonListener mblistener = new MyButtonListener();
        btn.addActionListener(mblistener);
        frame.add(btn);

        frame.setVisible(true);
    }
}
