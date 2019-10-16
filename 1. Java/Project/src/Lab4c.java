
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Lab4c extends JApple {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btn = new JButton("Click me!");
        MyButtonListener mblistener = new MyButtonListener();
        btn.addActionListener(mblistener);
        // frame.add(btn);

        frame.setLayout(new BorderLayout());
        frame.add(btn, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
            System.out.println(e.getSource());
        }
    }
}
