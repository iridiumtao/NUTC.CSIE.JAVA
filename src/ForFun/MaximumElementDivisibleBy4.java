package ForFun;

import java.util.Scanner;

public class MaximumElementDivisibleBy4 {
    public static void main(String[] args) {
        /*
          Given a sequence of natural numbers, not exceeding 30000.
          Find the maximum element divisible by 4.
          The program receives the number of elements in the sequence
          and then the elements themselves as input.
          In the sequence, there is always an element divisible by 4.
          The number of elements does not exceed 1000.
          The program should print a single number:
          the maximum element of the sequence divisible by 4.

          Try to solve this problem by using a for-loop.
        */
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int maxNumThatIsDivisibleBy4 = 0;
        int numOfElements = scanner.nextInt();
        for (int i = 0; i < numOfElements; i++) {
            int num = scanner.nextInt();
            maxNumThatIsDivisibleBy4 = (num % 4 == 0) ?
                    Math.max(num, maxNumThatIsDivisibleBy4) : maxNumThatIsDivisibleBy4;
        }
        System.out.println(maxNumThatIsDivisibleBy4);
    }
}
