package ForFun.PlayingWithSeries.PlayingWithMultiDimensionalArray;

import java.util.Scanner;

public class PlayingWithStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int half = (length / 2);
        String[][] matrix = new String[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == half || j == half || i == j || i == length-j-1) {
                    matrix[i][j] = "*";
                    System.out.print("* ");
                }
                else {
                    matrix[i][j] = ".";
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
