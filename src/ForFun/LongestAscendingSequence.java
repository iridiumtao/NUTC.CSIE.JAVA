package ForFun;

import java.util.Scanner;

public class LongestAscendingSequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int lastNum = 0;
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < length; i++) {
            int num = scanner.nextInt();
            if (lastNum < num) {
                lastNum = num;
                count++;
            } else {
                lastNum = num;
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
//            System.out.println("num "+ num);
//            System.out.println("count " + count);
//            System.out.println("maxCount " + maxCount);
        }
        maxCount = Math.max(maxCount, count);
        System.out.println(maxCount);


    }
}
