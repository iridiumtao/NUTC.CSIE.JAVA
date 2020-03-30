package JavaClass.Ex200325Multithreading.Ex4MovingBall;

public class BallParameters {
    private static boolean isFirstTime = true;
    private static int[] xCoordinate = new int[21];
    private static int[] yCoordinate = new int[21];
    private static float[] red = new float[21];
    private static float[] green = new float[21];
    private static float[] blue = new float[21];

    static boolean isFirstTime() {
        return isFirstTime;
    }

    static void setIsFirstTimeToFalse() {
        isFirstTime = false;
    }

    static void setXCoordinate(int xCoordinate, int index) {
        BallParameters.xCoordinate[index] = xCoordinate;
    }

    static int getXCoordinate(int index) {
        return xCoordinate[index];
    }

    static void setYCoordinate(int yCoordinate, int index) {
        BallParameters.yCoordinate[index] = yCoordinate;
    }

    static int getYCoordinate(int index) {
        return yCoordinate[index];
    }

    static float getRed(int index) {
        return red[index];
    }

    static void setRed(float red, int index) {
        BallParameters.red[index] = red;
    }

    static float getGreen(int index) {
        return green[index];
    }

    static void setGreen(float green, int index) {
        BallParameters.green[index] = green;
    }

    static float getBlue(int index) {
        return blue[index];
    }

    static void setBlue(float blue, int index) {
        BallParameters.blue[index] = blue;
    }

    static int getXDirection(int index) {
        switch(index){
            case 1:
            case 4:
                return 1;
            default:
                return -1;
        }
    }

    static int getYDirection(int index) {
        switch(index){
            case 1:
            case 2:
                return 1;
            default:
                return -1;
        }
    }
}
