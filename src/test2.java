import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;


public class test2 {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        double M = scanner.nextInt();
        int P = scanner.nextInt();
        int K = scanner.nextInt();
        int count = 0;

        while (M < K) {
            M *= 1 + (P / 100.0);
            count++;
            System.out.println(M);
        }

        System.out.println(count);
    }
}
