
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

public class Lab4h {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenu diner = new JMenu("Menu");
        JMenuItem item1 = new JMenuItem("MenuItem1");
        JMenuItem item2 = new JMenuItem("MenuItem2");
        item1.addActionListener(new MyButtonListener());
        item2.addActionListener(new MyButtonListener());
        diner.add(item1);
        diner.add(item2);
        JMenuBar bar = new JMenuBar();
        bar.add(diner);

        frame.setJMenuBar(bar);
        frame.setVisible(true);

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
