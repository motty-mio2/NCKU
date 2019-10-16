
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.net.URL;

import javax.swing.*;

/*
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.management.JMException;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
*/

public class Lab4k extends JFrame {
    public static void main(String[] args) {
        Lab4k frame = new Lab4k();
        frame.setVisible(true);

    }

    public Lab4k() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        try {
            ImageIcon icon = new ImageIcon(
                    new URL("https://media.tenor.com/images/c674ba98c40f6793eaf10a1356c1c36a/tenor.gif"));
            JLabel lb = new JLabel(icon);
            lb.setText("Hello");
            add(lb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class MyButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("MenuItem1")) {
            System.out.println("You pressed menuitem1");
        } else if (command.equals("MenuItem2")) {
            System.out.println("You pressed menuitem2");
        }
    }
}
