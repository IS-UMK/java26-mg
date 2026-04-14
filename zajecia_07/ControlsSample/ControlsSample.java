import java.awt.*;
import java.awt.event.*;

/**
 * Demo kontrolek AWT
 */
public class ControlsSample {

    public static void main(String[] args) {
        Frame frame = new Frame("Przykład użycia kontrolek - Layout");
        frame.setSize(900, 650);
        frame.setLayout(new BorderLayout(10, 10));

        // Zamknięcie okna
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        // ===== LEWA KOLUMNA: podstawowe kontrolki =====
        Panel leftColumn = new Panel(new GridLayout(0, 1, 10, 10));
        leftColumn.setBackground(new Color(245, 245, 245));

        Button button = new Button("Kliknij mnie!");
        leftColumn.add(wrap("Button", button));

        Label label = new Label("To jest etykieta!");
        label.setBackground(Color.orange);
        label.setForeground(Color.red);
        leftColumn.add(wrap("Label", label));

        TextField textField = new TextField("To jest pole tekstowe!");
        leftColumn.add(wrap("TextField", textField));

        Checkbox checkBox1 = new Checkbox("CheckBox niezaznaczony");
        Checkbox checkBox2 = new Checkbox("CheckBox zaznaczony", true);
        Panel checkPanel = new Panel(new GridLayout(0, 1));
        checkPanel.add(checkBox1);
        checkPanel.add(checkBox2);
        leftColumn.add(wrap("Checkbox", checkPanel));

        CheckboxGroup group = new CheckboxGroup();
        Checkbox rb1 = new Checkbox("Zaznaczony", group, true);
        Checkbox rb2 = new Checkbox("Niezaznaczony", group, false);
        Panel radioPanel = new Panel(new GridLayout(0, 1));
        radioPanel.add(rb1);
        radioPanel.add(rb2);
        leftColumn.add(wrap("CheckboxGroup", radioPanel));

        Choice choice = new Choice();
        for (int i = 1; i <= 5; i++) {
            choice.add("Opcja " + i);
        }
        leftColumn.add(wrap("Choice", choice));

        java.awt.List list = new java.awt.List(5, true);
        for (int i = 1; i <= 5; i++) {
            list.add("Opcja " + i);
        }
        leftColumn.add(wrap("List", list));

        frame.add(leftColumn, BorderLayout.WEST);

        // ===== ŚRODEK: canvas + panel z przyciskami + pole edycyjne + scrollbar =====
        Panel centerArea = new Panel(new BorderLayout(8, 8));

        Canvas canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.ITALIC, 24));
                g.drawString("HELLO FROM CANVAS", 30, 75);
                g.setFont(new Font("Arial", Font.PLAIN, 14));
                g.drawString("Kliknij prawym przyciskiem, aby otworzyc PopupMenu", 30, 100);
            }
        };
        canvas.setBackground(Color.lightGray);
        canvas.setPreferredSize(new Dimension(320, 180));
        centerArea.add(canvas, BorderLayout.CENTER);


        TextArea textArea = new TextArea("To jest wieloliniowe pole tekstowe!", 10, 25,
                TextArea.SCROLLBARS_VERTICAL_ONLY);
        centerArea.add(wrap("TextArea", textArea),  BorderLayout.NORTH);

        Panel greenPanel = new Panel(new GridLayout(3, 3));
        greenPanel.setBackground(Color.GREEN);
        for (int i = 1; i <= 9; i++) {
            greenPanel.add(new Button("" + i));
        }
        centerArea.add(wrap("Grid Layout (3x3)", greenPanel), BorderLayout.SOUTH);

        Scrollbar scrollbar = new Scrollbar(Scrollbar.VERTICAL, 0, 20, 0, 120);
        centerArea.add(scrollbar, BorderLayout.EAST);

        frame.add(centerArea, BorderLayout.CENTER);

        // ===== DÓŁ: przycisk do dialogu =====
        Button dialogToggler = new Button("Pokaż okno dialogowe");
        Panel bottomPanel = new Panel(new FlowLayout(FlowLayout.RIGHT));

        bottomPanel.add(dialogToggler);
        for (int i = 1; i <= 9; i++) {
            bottomPanel.add(new Button("Przycisk " + i));
        }

        frame.add(wrap("Flow Layout", bottomPanel), BorderLayout.SOUTH);

        // ===== MenuBar, Menu i submenu =====
        MenuBar menubar = new MenuBar();
        Menu menu1 = new Menu("Menu");
        Menu menu2 = new Menu("Menu 2");
        Menu submenu = new Menu("SubMenu");

        menu1.add(new MenuItem("Menu 1"));
        menu1.add(new MenuItem("Menu 2"));
        submenu.add(new MenuItem("Submenu 1"));
        submenu.add(new MenuItem("Submenu 2"));
        menu1.add(submenu);

        menubar.add(menu1);
        menubar.add(menu2);
        frame.setMenuBar(menubar);

        // ===== PopupMenu =====
        PopupMenu popupmenu = new PopupMenu("PopUp Menu");
        popupmenu.add("Pozycja 1");
        popupmenu.add("Pozycja 2");
        popupmenu.add("Pozycja 3");
        popupmenu.add("Pozycja 4");
        popupmenu.add("Pozycja 5");
        canvas.add(popupmenu);

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON3) {
                    popupmenu.show(canvas, e.getX(), e.getY());
                }
            }
        });

        // ===== Dialog =====
        Dialog dialog = new Dialog(frame, "Okno dialogowe", true);
        dialog.setSize(280, 140);
        dialog.setLayout(new BorderLayout(8, 8));
        dialog.add(new Label("To jest okno dialogowe.", Label.CENTER), BorderLayout.CENTER);

        Button okBtn = new Button("OK");
        okBtn.addActionListener(e -> dialog.setVisible(false));
        Panel dialogBottom = new Panel(new FlowLayout());
        dialogBottom.add(okBtn);
        dialog.add(dialogBottom, BorderLayout.SOUTH);

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.setVisible(false);
            }
        });

        dialogToggler.addActionListener(e -> {
            dialog.setLocationRelativeTo(frame);
            dialog.setVisible(true);
        });

        frame.setVisible(true);
    }

    /** Opakowanie kontrolek z dodaniem etykiety. */
    private static Panel wrap(String title, Component component) {
        Panel panel = new Panel(new BorderLayout(4, 4));
        panel.add(new Label(title), BorderLayout.NORTH);
        panel.add(component, BorderLayout.CENTER);
        return panel;
    }
}
