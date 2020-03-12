package ForFun;

import java.util.Arrays;
import java.util.Scanner;

        /*
        Input
        The input contains several test cases. Each test case is described in one line, containing four integers H1,
        M1, H2 and M2, with H1 : M1 representing the current hour and minute, and H2 : M2 representing the
        time (hour and minute) when the alarm clock is set to ring (0 ≤ H1 ≤ 23, 0 ≤ M1 ≤ 59, 0 ≤ H2 ≤ 23,
        0 ≤ M2 ≤ 59).
        The end of the input is indicated by a line containing only four zeros, separated by blank spaces.

        Output
        For each test case, your program must print one line, containing a single integer, indicating the number
        of minutes Daniela has to sleep.
        Sample Input
        1 5 3 5
        23 59 0 34
        21 33 21 10
        0 0 0 0
        Sample Output
        120
        35
        1417
        */


public class AlarmClock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {

            String data = scanner.nextLine();
            if (data.equals("0 0 0 0")) {
                System.exit(0);
            }
            if (data.equals("")){
                continue;
            }
            String[] dataArray = data.split(" ");
            int[] numArray = new int[4];
            for (int i = 0; i < dataArray.length; i++) {
                numArray[i] = Integer.parseInt(dataArray[i]);
            }

            int min = numArray[3] - numArray[1];
            int hour = ((numArray[2] == 0) ? 24 : numArray[2]) - numArray[0];

            if (min < 0) {
                min = 60 + min;
                hour--;
            }
            int time = hour * 60 + min;

            System.out.println((time < 0) ? time + 1440 : time);
        }
    }
}
