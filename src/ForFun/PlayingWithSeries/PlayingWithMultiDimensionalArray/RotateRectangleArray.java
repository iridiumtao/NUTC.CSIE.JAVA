package ForFun.PlayingWithSeries.PlayingWithMultiDimensionalArray;

import java.util.Scanner;

public class RotateRectangleArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length1 = scanner.nextInt();
        int length2 = scanner.nextInt();
        int[][] matrix = new int[length1][length2];
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < length2; i++) {
            for (int j = length1-1; j >= 0; j--) {
                System.out.print(matrix[j][i] +" ");
            }
            System.out.println();
        }
    }
}
