package BTSocket_Bai2;

import java.io.*;
import java.net.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class TimeClient extends JFrame {
    private JLabel clockLabel;

    public TimeClient() {
        setTitle("Clock Client");
        setSize(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        clockLabel = new JLabel();
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
        clockLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        add(clockLabel, BorderLayout.CENTER);

        setVisible(true);

        new Thread(this::updateClockUI).start();
    }

    private void updateClockUI() {
        while (true) {
            LocalTime currentTime = LocalTime.now();
            String timeString = String.format("%02d:%02d:%02d", currentTime.getHour(), currentTime.getMinute(), currentTime.getSecond());
            SwingUtilities.invokeLater(() -> clockLabel.setText("Current time: " + timeString));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TimeClient::new);
    }
}


