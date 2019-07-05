
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JButton;

public class Lab4c {
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
}

public class MyButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        System.out.println(e.getSource());
    }
}
