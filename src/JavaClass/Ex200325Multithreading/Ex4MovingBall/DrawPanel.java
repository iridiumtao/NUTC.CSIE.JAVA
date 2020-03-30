package JavaClass.Ex200325Multithreading.Ex4MovingBall;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

class DrawPanel extends JPanel {

    private void doDrawing(Graphics g) {

        var g2d = (Graphics2D) g;

        if (BallParameters.isFirstTime()) {
            for (int i = 0; i <= 20; i++) {

                var size = getSize();
                var insets = getInsets();

                int w = size.width - insets.left - insets.right;
                int h = size.height - insets.top - insets.bottom;

                var r = new Random();
                int x = Math.abs(r.nextInt()) % w;
                int y = Math.abs(r.nextInt()) % h;

                Random randColor = new Random();
                float red = (float) (randColor.nextFloat() / 5f + 0.8);
                float green = (float) (randColor.nextFloat() / 5f + 0.8);
                float blue = (float) (randColor.nextFloat() / 5f + 0.8);
                Color randomColor = new Color(red, green, blue);
                //Color randomColor = new Color(0.8f, 0.9f, 0.7f);

                g2d.setColor(randomColor);
                BallParameters.setXCoordinate(x, i);
                BallParameters.setYCoordinate(y, i);
                BallParameters.setRed(red, i);
                BallParameters.setGreen(green, i);
                BallParameters.setBlue(blue, i);

                g2d.fillOval(x, y, 100, 100);
            }
            BallParameters.setIsFirstTimeToFalse();
        } else {
            for (int i = 0; i <= 20; i++) {


                var r = new Random();
                //int x = BallParameters.getXCoordinate(i) + r.nextInt() % (2*(i+1));
                int x = BallParameters.getXCoordinate(i) + 20 * BallParameters.getXDirection(i);
                //int y = BallParameters.getYCoordinate(i) + r.nextInt() % (2*(i+1));
                int y = BallParameters.getYCoordinate(i) + i * BallParameters.getYDirection(i);


                Random randColor = new Random();
                float red = BallParameters.getRed(i);
                float green = BallParameters.getGreen(i);
                float blue = BallParameters.getBlue(i);
                Color randomColor = new Color(red, green, blue);
                //Color randomColor = new Color(0.8f, 0.9f, 0.7f);

                g2d.setColor(randomColor);

                g2d.fillOval(x, y, 100, 100);

                var size = getSize();
                var insets = getInsets();
                if (x > size.width - insets.left - insets.right+100) {
                    x = -100;
                } else if (x < -100) {
                    x = size.width - insets.left - insets.right+100;
                }
                if (y > size.height - insets.top - insets.bottom+100) {
                    y = -100;
                } else if (y < -100) {
                    y = size.height - insets.top - insets.bottom+100;
                }
                BallParameters.setXCoordinate(x, i);
                BallParameters.setYCoordinate(y, i);

            }
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
