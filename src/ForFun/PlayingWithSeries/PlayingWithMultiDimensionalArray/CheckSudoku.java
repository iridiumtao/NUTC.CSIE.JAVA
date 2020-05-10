package ForFun.PlayingWithSeries.PlayingWithMultiDimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class CheckSudoku {
    private static int kkk = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int level = scanner.nextInt();
        int length = level * level;
        boolean solved = true;
        if (level == 1) {
            System.out.println(scanner.nextInt() == 1 ? "YES" : "NO");
        } else {

            int[][][][] sudoku = new int[level][level][level][level];
            int[][] x = new int[3][2];

            // read the sudoku
            for (int a = 0; a < level; a++) {
                for (int b = 0; b < level; b++) {
                    for (int c = 0; c < level; c++) {
                        for (int d = 0; d < level; d++) {
                            sudoku[a][c][b][d] = scanner.nextInt();
                            kkk++;
                        }
                    }
                }
            }

            //extract one line to check
            int[] row = new int[length];
            int[] column = new int[length];
            int[] cube = new int[length];
            for (int a = 0; a < level; a++) {
                for (int b = 0; b < level; b++) {
                    for (int c = 0; c < level; c++) {
                        for (int d = 0; d < level; d++) {
                            row[c * level + d] = sudoku[a][c][b][d];
                            column[c * level + d] = sudoku[c][a][d][b];
                            cube[c * level + d] = sudoku[b][a][c][d];

                        }
                    }
                    //change c(line)
                    //System.out.println("check: "+ (a * level + b + 1));
                    //System.out.println("row: " + repetitionCheck(length, row));
                    //System.out.println("row val: " +Arrays.toString(row));
                    //System.out.println();
                    //System.out.println("column: " + repetitionCheck(length, column));
                    //System.out.println("column val: " +Arrays.toString(column));
                    //System.out.println();
                    //System.out.println("cube: " + repetitionCheck(length, cube));
                    //System.out.println("cube val: " +Arrays.toString(cube));
                    //System.out.println();
                    if (!repetitionCheck(length, row) ||
                            !repetitionCheck(length, column) ||
                            !repetitionCheck(length, cube)) {
                        //System.out.println("NO");
                        solved = false;
                    }
                    //System.out.println();
                    row = new int[length];
                    column = new int[length];
                    cube = new int[length];
                }
                //change a
            }


            //print the sudoku
            /*for (int a = 0; a < level; a++) {
                for (int b = 0; b < level; b++) {
                    for (int c = 0; c < level; c++) {
                        for (int d = 0; d < level; d++) {
                            System.out.print(sudoku[a][c][b][d]+" ");
                        }
                        System.out.print(" ");
                    }
                    System.out.println();
                }
                System.out.println();
            }*/
            System.out.println(solved ? "YES" : "NO");
            System.out.println(kkk);
        }
    }

    private static boolean repetitionCheck(int length, int[] array) {
        int[] emptyArray = new int[length + 1];
        emptyArray[0] = 1;
        for (int value : array) {
            emptyArray[value] += 1;
            kkk++;
        }
        for (int i : emptyArray) {
            kkk++;
            if (i != 1)
                return false;
        }
        return true;

    }
}
