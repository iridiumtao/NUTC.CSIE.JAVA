package course.Ex200325Multithreading;

class CTest implements Runnable {
    private String id;

    public CTest(String str) {
        id = str;
    }

    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep((int) (1000 * Math.random()));

            } catch (InterruptedException ignored) {
            }
            System.out.println(id + " is running..");
        }
    }
}

public class Ex2 {
    public static void main(String[] args) {
        Thread dog = new Thread(new CTest("doggy"));
        Thread cat = new Thread(new CTest("kitty"));
        dog.start();
        cat.start();
    }
}
