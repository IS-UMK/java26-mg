import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIDemo {
    private JButton wciśnijMnieButton;
    private JPanel mainPanel;
    private JRadioButton radioButton1;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JComboBox comboBox1;
    private JTree tree1;
    private JTable table1;
    private JList list1;


    public GUIDemo() {

       // label1.setText("To jest inny tekst");

        wciśnijMnieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = JOptionPane.showInputDialog(null, "Podaj Imię");
                label1.setText("Witaj " + message);
            }
        });
    }

    static void main() {



        JFrame frame = new JFrame("GUIDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new GUIDemo().mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
