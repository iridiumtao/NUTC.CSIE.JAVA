package ForFun;

import Utilities.TimeCalculator;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

    /**
     *
     * A user inputs a long number M.
     * You need to find out what is the smallest int number n such that n! > M.
     *
     */
public class untitled6 {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        long inputNum = Long.parseLong(scanner.next());

        long start = System.currentTimeMillis( );
        System.out.println(new Date( ) + "\n");

        TimeCalculator tCal1 = new TimeCalculator();
        //tCal1.showCurrentHHmmssSSS();

        int loopNum = 1;

        while (inputNum >= factorials(loopNum)){
            loopNum++;
        }

        System.out.println(loopNum);

        System.out.println(new Date( ) + "\n");
        long end = System.currentTimeMillis( );
        long diff = end - start;
        System.out.println("Difference is : " + diff);

        TimeCalculator tCal2 = new TimeCalculator();
        //tCal2.showCurrentHHmmssSSS();
        TimeCalculator.showTimeDifference(tCal1, tCal2);
    }

    static long factorials(long number){
        if (number < 2){
            return 1;
        }
        return number * factorials(number-1);
    }
}
