package JavaClass.Ex200325Multithreading;

import java.awt.*;

public class MovingBallTeacherVer extends Frame {
    static MovingBallTeacherVer frame = new MovingBallTeacherVer();
    static Ball[] balls = new Ball[20];
    final static int BALL_WIDTH = 800;
    final static int BALL_HEIGHT = 550;

    public static void main(String[] args) {
        frame.setTitle("Moving balls");
        frame.setSize(BALL_WIDTH, BALL_HEIGHT);
        frame.setVisible(true);
        Ball.width = BALL_WIDTH;
        Ball.height = BALL_HEIGHT;
        Ball.frame = frame;
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball(i);
        }
        for (int i = 0; i < balls.length; i++) {
            balls[i].start();
        }
    }
    public void paint(Graphics g){
        for (int i = 0; i < balls.length; i++) {
            balls[i].draw(g);
        }
    }
}

class Ball extends Thread {
    int id;
    int x, y;
    int direction, d;
    int size, colorIndex, sleep;
    static int width, height;
    static Frame frame;
    static Color[] color = {
            Color.black, Color.blue, Color.cyan, Color.darkGray,
            Color.gray, Color.green, Color.lightGray, Color.magenta,
            Color.orange, Color.pink, Color.red, Color.white, Color.yellow};

    public Ball(int n) {
        id = n;
        x = (int) (Math.random() * width);
        direction = (int) (Math.random() * 4);
        d = (int) (Math.random() * 5) + 1;
        size = (int) (Math.random() * 5 + 5) * 10;
        colorIndex = (int) (Math.random() * color.length);
        sleep = (int) (Math.random() * 100) * 10;
    }

    public void run() {
        while (true) {
            switch (direction) {
                case 0:
                    x = (x + d) % width;
                    y = (y + d) & height;
                    break;
                case 1:
                    x = (x - d + width) % width;
                    y = (y + d) % height;
                    break;
                case 2:
                    x = (x - d + width) % width;
                    y = (y - d + height) % height;
                    break;
                case 3:
                    x = (x + d) % width;
                    y = (y - d + height) % height;
                    break;
            }
            frame.repaint();
            try {
                sleep(sleep);
            } catch (InterruptedException ignored) {
            }
        }
    }
    public void draw(Graphics g){
        g.setColor(color[colorIndex]);
        g.fillOval(x, y, size, size);
    }
}

