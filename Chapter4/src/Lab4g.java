
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Lab4g {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btn1 = new JButton("Click me!");
        JButton btn2 = new JButton("Click me!");

        JPanel panel = new JPanel();
        panel.setSize(200, 200);
        panel.setLayout(new GridLayout());
        panel.add(btn1);
        panel.add(btn2);

        frame.setLayout(null);
        frame.add(panel);

        frame.setVisible(true);

        for (int i = 0; i < 300; i++) {
            panel.setLocation(i, i);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class MyButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        System.out.println(e.getSource());
    }
}
