package ForFun.PlayingWithSeries.TicTacToe;

import java.util.Scanner;

public class TicTacToe1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Character[][] ttt = new Character[3][3];
        String result = "";
        int x = 0, o = 0;
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                ttt[i][j] = input.charAt(i * 3 + j);
                System.out.print(ttt[i][j] + " ");
                if (ttt[i][j] == 'X') {
                    x++;
                } else if (ttt[i][j] == 'O') {
                    o++;
                }
            }
            System.out.println("|");
        }
        for (int i = 0; i < 3; i++) {
            if (ttt[i][0] == ttt[i][1] && ttt[i][0] == ttt[i][2]) {
                if (ttt[i][0] == 'O') {
                    result += "O wins";
                } else if (ttt[i][0] == 'X') {
                    result += "X wins";
                }
            }
            if (ttt[0][i] == ttt[1][i] && ttt[0][i] == ttt[2][i]) {
                if (ttt[0][i] == 'O') {
                    result += "O wins";
                } else if (ttt[0][i] == 'X') {
                    result += "X wins";
                }
            }
        }
        if ((ttt[0][0] == ttt[1][1] && ttt[0][0] == ttt[2][2]) ||
                (ttt[2][0] == ttt[1][1] && ttt[2][0] == ttt[0][2])) {
            if (ttt[1][1] == 'O') {
                result += "O wins";
            } else if (ttt[1][1] == 'X') {
                result += "X wins";
            }
        }
        System.out.println("---------");

        if (Math.abs(x - o) > 1) {
            System.out.println("Impossible");
        } else if (result.equals("")) {
            if (input.contains("_")) {
                System.out.println("Game not finished");
            } else {
                System.out.println("Draw");
            }
        } else if (result.length() > 8) {
            System.out.println("Impossible");
        } else {
            System.out.println(result);
        }


    }
}
