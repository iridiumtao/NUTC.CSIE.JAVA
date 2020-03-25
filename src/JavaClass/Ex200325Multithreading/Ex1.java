package JavaClass.Ex200325Multithreading;

class TimingTread extends Thread {
    private int timeInMillis;
    private String id;
    private int times;

    TimingTread(String id, int timeInMillis, int times) {
        this.id = id;
        this.timeInMillis = timeInMillis;
        this.times = times;
    }

    public void run() {
        try {
            for (int i = 0; i < times; i++) {
                sleep(timeInMillis);
                System.out.println(id + " is running.");
            }
        } catch (InterruptedException ignored) {
        }
    }
}

public class Ex1 {
    public static void main(String[] args) {
        TimingTread t1 = new TimingTread("Thread 1", 1000, 5);
        TimingTread t2 = new TimingTread("Thread 2", 2500, 10);
        TimingTread t3 = new TimingTread("Thread 3", 3500, 5);
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException ignored) {
        }
        t3.start();
    }
}

