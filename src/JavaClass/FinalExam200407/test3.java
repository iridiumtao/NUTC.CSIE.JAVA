package JavaClass.FinalExam200407;

import java.awt.*;

public class test3 extends Frame {
    static test3 frame = new test3();
    static Ball[] balls = new Ball[8];
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

    public void paint(Graphics g) {
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
            Color.blue, Color.cyan,
            Color.green, Color.magenta,
            Color.orange, Color.pink, Color.red, Color.yellow};

    public Ball(int n) {
        id = n;
        x = (int) (Math.random() * width);
        direction = Math.abs(n - 2);
        d = (int) (Math.random() * 5) + 1;
        size = (int) (Math.random() * 5 + 5) * 10;
        //colorIndex = (int) (Math.random() * color.length);
        colorIndex = n;
        sleep = 16;
        System.out.println(direction);
        //System.out.println(0 % 255);
    }

    public void run() {
        while (true) {
            switch (direction) {
                case 0:
                    //左下到右上
                    x = (x + d) % width;
                    y = (y + d) % height;
                    break;
                case 1:
                    //左上到右下
                    x = (x - d + width) % width;
                    y = (y + d) % height;
                    break;
                case 2:
                    //右上到左下
                    x = (x - d + width) % width;
                    y = (y - d + height) % height;
                    break;
                case 3:
                    //右下到左上
                    x = (x + d) % width;
                    y = (y - d + height) % height;
                    break;
                case 4:
                    //左到右
                    x = (x > width) ? (-size) : (x + d);
                    break;
                case 5:
                    //上到下
                    y = (y > height) ? 0 : (y + d);
                    break;
            }
            frame.repaint();
            try {
                sleep(sleep);
            } catch (InterruptedException ignored) {
            }
        }
    }

    public void draw(Graphics g) {
        g.setColor(color[colorIndex]);
        g.fillOval(x, y, size, size);
    }
}

