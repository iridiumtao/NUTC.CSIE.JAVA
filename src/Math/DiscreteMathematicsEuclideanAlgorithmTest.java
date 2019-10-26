package Math;

import java.util.Scanner;

public class DiscreteMathematicsEuclideanAlgorithmTest {
    public static int gcdExtended(int a, int b, int x, int y)
    {
        // Base Case
        if (a == 0) {
            x = 0;
            y = 1;
            return b;
        }

        int x1 = 1, y1 = 1; // To store results of recursive call
        int gcd = gcdExtended(b % a, a, x1, y1);

        // Update x and y using results of recursive
        // call
        x = y1 - (b / a) * x1;
        y = x1;
        return gcd;
    }
    // Driver Program
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int x = 1, y = 1;
        System.out.println("請輸入第一個數(a)");
        int a = scanner.nextInt();
        System.out.println("請輸入第二個數(b)");
        int b = scanner.nextInt();
        int g = gcdExtended(a, b, x, y);
        System.out.print("gcd(" + a + ", " + b + ") = " + g);
    }
}

