import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class HelloAWT implements WindowListener {

    public HelloAWT() {

        Frame frame = new Frame();
        frame.setTitle("HelloAWT");
        frame.setSize(400,400);
        // frame.setLayout(new FlowLayout());
        Label label = new Label("Hello World",  Label.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBackground(Color.GREEN);

        frame.add(label,  BorderLayout.CENTER);

        Button button = new Button("OK");
        frame.add(button,  BorderLayout.NORTH);
        frame.setVisible(true);

        frame.addWindowListener(this);

    }

    public static void main(String[] args) {
        new HelloAWT();
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
