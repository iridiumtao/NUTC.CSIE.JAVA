package ForFun;

import java.util.Arrays;
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

        int loopNum = 1;

        while (inputNum >= factorials(loopNum)){
            loopNum++;
        }

        System.out.println(loopNum);
    }

    static long factorials(long number){
        if (number < 2){
            return 1;
        }
        return number * factorials(number-1);
    }
}
