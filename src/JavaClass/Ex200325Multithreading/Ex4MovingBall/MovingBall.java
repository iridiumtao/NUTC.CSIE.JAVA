package JavaClass.Ex200325Multithreading.Ex4MovingBall;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;


public class MovingBall extends JFrame {

    public MovingBall() {
        initUI();
    }

    private void initUI() {

        var drawPanel = new DrawPanel();
        add(drawPanel);

        ActionListener listener = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {

                drawPanel.repaint();

            }
        };
        Timer timer = new Timer(100, listener);
        timer.start();
        add(drawPanel);

        setSize(800, 800);
        setTitle("Moving Ball");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new MovingBall();
            ex.setVisible(true);
        });
    }
}

