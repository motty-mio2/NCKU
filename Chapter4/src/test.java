import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Dimension;
import javax.swing.*;

@SuppressWarnings("serial")
public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 350);
        // frame.add(endButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                int nowwidth = frame.getContentPane().getSize().width;
                int nowheight = frame.getContentPane().getSize().height;
                System.out.println("window seze wide=" + nowwidth + ",high=" + nowheight);
                int spacer = 2;

                JTextField input = new JTextField();
                input.setLocation(spacer, spacer);
                input.setPreferredSize(new Dimension((int) nowwidth - 2 * spacer, (int) nowheight / 3));
                input.setSize(input.getPreferredSize());
                input.setText("Enter yout name here:");
                frame.add(input);

                JTextArea output = new JTextArea();
                output.setLocation(spacer, input.getSize().height + 2);
                output.setPreferredSize(new Dimension((int) nowwidth - 2 * spacer, (int) nowheight / 5));
                output.setSize(output.getPreferredSize());
                output.setText("This is Output Area");
                frame.add(output);

            }
        });

        int oldw = frame.getContentPane().getSize().width;
        int oldh = frame.getContentPane().getSize().height;

        int neww = frame.getContentPane().getSize().width;
        int newh = frame.getContentPane().getSize().height;

        // if (oldw != neww || oldh != newh) {
        System.out.println("now width = " + neww + "now height = " + newh);
        neww = oldw;
        newh = oldh;
        // }

    }
}
/*
 * public class SizeManager implements ComponentAdapter { public Dimension
 * componentResized; }
 */