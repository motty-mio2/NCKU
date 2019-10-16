
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.management.JMException;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Lab4i extends JFrame implements ActionListener {
    public static void main(String[] args) {
        Lab4i frame = new Lab4i();
        frame.setVisible(true);

    }

    public Lab4i() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JTextField input = new JTextField(50);
        input.setLocation(100, 100);
        input.setSize(input.getPreferredSize());
        input.setText("<input yout name here>");
        add(input);
    }

    public void actionPerformed(ActionEvent e) {
    }
}

/*
 * public class MyButtonListener implements ActionListener { public void
 * actionPerformed(ActionEvent e) { String command = e.getActionCommand();
 * 
 * if (command.equals("MenuItem1")) {
 * System.out.println("You pressed menuitem1"); } else if
 * (command.equals("MenuItem2")) { System.out.println("You pressed menuitem2");
 * } } }
 */