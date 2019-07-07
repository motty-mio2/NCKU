
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Lab4d {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btn = new JButton("Click me!");
        MyButtonListener mblistener = new MyButtonListener();
        btn.addActionListener(mblistener);
        btn.setLocation(250, 100);
        btn.setSize(200, 50);

        JLabel lb = new JLabel("Welcome to the world!");
        lb.setLocation(100, 100);
        lb.setSize(200, 50);

        frame.setLayout(null);
        frame.add(btn);
        frame.add(lb);

        frame.setVisible(true);
    }
}

public class MyButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        System.out.println(e.getSource());
    }
}
