import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("นาฬิกา");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(timeLabel);

        // Timer อัปเดตทุกๆ 1000 ms (1 วินาที)
        Timer timer = new Timer(1000, e -> {
            String currentTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
            timeLabel.setText(currentTime);
        });
        timer.start();
        frame.setVisible(true);
    }
}
