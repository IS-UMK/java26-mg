import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class TableModelDemo extends JFrame {

    JList<String>  list;
    JScrollPane scroll;


    DefaultListModel<String> model =  new DefaultListModel<>();
    JTextField textField;
    JButton buttonAdd;
    JButton buttonRemove;
    Action addAction;


    public TableModelDemo() {
        setTitle("Table Model");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        model.addElement("Element");
        list = new JList<>(model);
        scroll = new JScrollPane(list);
        add(scroll);

        addAction = new  AbstractAction("Dodaj") {
            public void actionPerformed(ActionEvent e) {
                model.addElement(textField.getText());
            };
        };
        addAction.putValue(Action.ACCELERATOR_KEY,
                KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        buttonAdd = new JButton(addAction);

        JMenuBar mb = new JMenuBar();
        JMenu mnu = new JMenu("Dane");
        JMenuItem mntmAdd = new JMenuItem(addAction);
        mnu.add(mntmAdd);
        mb.add(mnu);
        setJMenuBar(mb);


        buttonRemove = new JButton("Remove");
        add(buttonAdd);
        add(buttonRemove);



        buttonRemove.addActionListener(e -> {
            int idx  = list.getSelectedIndex();
            if(idx != -1) {
                model.remove(idx);
            }
            else  {
                JOptionPane.showMessageDialog(null, "Please select an element to remove");
            }
        });

        textField = new JTextField();
        textField.setColumns(20);
        add(textField);

        pack();




        setVisible(true);



    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TableModelDemo();
            }
        });
    }

}
