import javax.swing.*;

public class HelloSwing extends JFrame {


    public HelloSwing() {
        setTitle("HelloSwing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        JLabel hello = new JLabel("HelloSwing",  JLabel.CENTER);
        add(hello);
        pack();
    }

    static void main() {
        // new HelloSwing();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HelloSwing();
            }
        });
    }


}
