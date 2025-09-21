import java.awt.*;
import java.time.*;
import java.util.*;

import javax.swing.*;

import lib.*;

public class app {
    public static void main(String[] args) {
        // RoomSystem system = new RoomSystem();
        // Room room1 = new Room("1-5", 101, 150);
        // User user1 = new User(1);
        // system.addBookRoom(room1, user1, LocalDateTime.of(2025, 10, 1, 12, 0, 0),
        // LocalDateTime.of(2025, 10, 1, 13, 0, 0));
        // system.addBookRoom(room1, user1, LocalDateTime.of(2025, 10, 1, 12, 0, 0),
        // LocalDateTime.of(2025, 10, 1, 14, 0, 0));
        // system.addBookRoom(room1, user1, LocalDateTime.of(2025, 10, 1, 12, 0, 0),
        // LocalDateTime.of(2025, 10, 1, 15, 0, 0));
        // system.removeBookRoom(room1, user1, LocalDateTime.of(2025, 10, 1, 12, 0, 0),
        // LocalDateTime.of(2025, 10, 1, 15, 0, 0));
        // Java program to illustrate the GridLayout
        
        JFrame frame = new JFrame("Scroll Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null); // ใช้ layout แบบ null
        panel.setPreferredSize(new java.awt.Dimension(800, 600)); // ต้องกำหนดเอง

        JButton b1 = new JButton("Button 1");
        b1.setBounds(50, 50, 100, 30);
        panel.add(b1);

        JButton b2 = new JButton("Button 2");
        b2.setBounds(700, 500, 100, 30); // เลยขอบ จะทำให้ scrollbar โผล่
        panel.add(b2);

        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane);

        frame.setSize(400, 300);
        frame.setVisible(true);

    }
}
