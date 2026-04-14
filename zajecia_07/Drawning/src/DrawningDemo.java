import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DrawningDemo extends Frame {


    List<Point> points = new ArrayList<Point>();
    Image buffer;

    public DrawningDemo() {

        setTitle("Drawning Demo");
        setSize(400,400);
        setVisible(true);

        addWindowListener(new  WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addMouseMotionListener(new  MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                points.add(new Point(e.getX(),e.getY()));
                repaint();
            }
        });
    }

    public static void main(String[] args) {
        DrawningDemo demo = new DrawningDemo();
    }

    public void paint(Graphics g) {

        Graphics gtmp = g;
        if(buffer==null || buffer.getWidth(this) != getWidth()
        | buffer.getHeight(this) != getHeight()) {
            buffer = createImage(getWidth(), getHeight());

        }

        g = buffer.getGraphics();

        g.drawLine(0,0,400,400);
        g.setColor(Color.RED);
        g.drawOval(100, 100, 20, 20);
        g.setColor(Color.GREEN);
        g.fillRect(20, 20, 30, 30);

        for(var Point:points){
            g.fillOval(Point.x-3,Point.y-3,6,6);
        }

        gtmp.drawImage(buffer, 0, 0, null);

    }

    public void update(Graphics g) {
        paint(g);
    }
}
