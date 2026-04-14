import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo extends Frame{

    private Label label = new  Label();
    private Button button = new  Button("OK");
    private TextField nameTextField = new  TextField();
    private TextField surnameTextField = new  TextField();


    public FrameDemo(){
        setTitle("Formularz");
        setSize(300,300);
        setVisible(true);

        addWindowListener(new  WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        add(label, BorderLayout.NORTH);
        Panel panel = new Panel(new GridLayout(2,2));
        panel.add(new Label("Imię:"));
        panel.add(nameTextField);
        panel.add(new Label("Surname:"));
        panel.add(surnameTextField);
        add(panel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        add(new  Panel(), BorderLayout.EAST);
        add(new  Panel(), BorderLayout.WEST);

        button.addActionListener(e-> {
            label.setText("Witaj:" + nameTextField.getText() + "-" + surnameTextField.getText());

        });

        nameTextField.addActionListener(e->{
            button.getActionListeners()[0].actionPerformed(e);
        });
        surnameTextField.addActionListener(e->{
            button.getActionListeners()[0].actionPerformed(e);
        });


    }

    public static void main(String[] args){
        FrameDemo f = new FrameDemo();
    }
}
