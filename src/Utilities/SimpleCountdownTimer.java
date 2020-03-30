package Utilities;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class SimpleCountdownTimer {
    static int interval;
    static Timer timer;

    SimpleCountdownTimer(int seconds){
        interval = seconds;
    }

    public void run(){
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        System.out.println(interval);
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                System.out.println(setInterval());

            }
        }, delay, period);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input seconds => : ");
        String secs = sc.nextLine();
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = Integer.parseInt(secs);
        System.out.println(secs);
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                System.out.println(setInterval());

            }
        }, delay, period);
    }

    private static final int setInterval() {
        if (interval == 1)
            timer.cancel();
        return --interval;
    }
}
