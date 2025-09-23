package GUI;

import javax.swing.*;

import lib.*;

import java.awt.*;

public class Mainframe extends JFrame {
    private CardLayout cardLayout;
    private JPanel container;
    private User user = new User(1, 150);
    private RoomSystem system;
    private int hourStart = 13;
    private int hourEnd = 4;
    private int minuteStartEnd = 00;
    public Mainframe() {
        system = new RoomSystem();
        for (int i = 0; i < 10; i++) {
            Room a = new Room("1-5", 301 + i, 150);
            system.addRoom(a);
        }
        system.addRoom(new Room("5+", 201, 200));

        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);

        // ใส่ panel ต่าง ๆ
        container.add(new login1(this), "login");
        container.add(new book(this), "book");

        add(container);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(440, 664));
        setLocationRelativeTo(null);

        showPanel("book");
        setVisible(true);
    }

    // เมธอดใช้สลับหน้า
    public void showPanel(String name) {
        cardLayout.show(container, name);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public RoomSystem getSystem() {
        return system;
    }
    public int getHourStart() {
        return hourStart;
    }
    public int getHourEnd() {
        return hourEnd;
    }
    public int getMinuteStartEnd() {
        return minuteStartEnd;
    }
    public static void main(String[] args) {
        new Mainframe();
    }
}
