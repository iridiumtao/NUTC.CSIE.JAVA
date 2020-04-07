import java.awt.*;

class test3 extends Thread {
    int id;
    int x, y, dir, size, clr, slp, d;
    static int width, height;
    static Frame f;
    static Color cc[] = {Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green, Color.lightGray, Color.magenta, Color.orange, Color.yellow};

    public test3(int n) {
        id = n;
        x = (int) (Math.random() * width);
        y = (int) (Math.random() * width);
        dir = (int) (Math.random() * 4);
        d = (int) (Math.random() * 5) + 1;
        size = (int) (Math.random() * 5 + 5) * 10;
        clr = (int) (Math.random() * cc.length);
        slp = (int) (Math.random() * 100) * 10;
    }

    public void run() {
        while (true) {
            switch (dir) {
                case 0:
                    x = (x + d) % width;
                    y = (y + d) % height;
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
            f.repaint();
            try {
                sleep(slp);
            } catch (InterruptedException e) {
            }
        }
    }

    public void draw(Graphics g) {
        g.setColor(cc[clr]);
        g.fillOval(x, y, size, size);
    }
}

class MovingBalls extends Frame {
    static MovingBalls frm = new MovingBalls();
    static test3[] balls = new test3[20];
    final static int WIDTH = 800, HEIGHT = 550;
    boolean sf = false;

    public static void main(String args[]) {
        frm.setTitle("MovingBalls");
        frm.setSize(WIDTH, HEIGHT);
        frm.setVisible(true);
        test3.width = WIDTH;
        test3.height = HEIGHT;
        test3.f = frm;
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new test3(i);
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