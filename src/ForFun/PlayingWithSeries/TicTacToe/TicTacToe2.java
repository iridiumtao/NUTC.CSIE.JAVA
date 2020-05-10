package ForFun.PlayingWithSeries.TicTacToe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe2 {
    static int x = 0, o = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Custom starting condition
        /*System.out.print("Enter cells: ");
        String input = scanner.nextLine();*/
        String input = "_________";

        int xCoordinate;
        int yCoordinate;
        Character[][] ttt = new Character[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ttt[i][j] = input.charAt(i * 3 + j);
            }
        }

        String result = resultIdentifier(ttt);
        //System.out.println("xx_result: " + result);
        while (result.equals("Game not finished")) {
            System.out.print("Enter the coordinates: ");

            boolean validInput = false;
            while (!validInput) {
                try {
                    /*String fuckingShit = scanner.nextLine();

                    xCoordinate = Character.getNumericValue(fuckingShit.charAt(0));
                    yCoordinate = Character.getNumericValue(fuckingShit.charAt(2));*/
                    xCoordinate = scanner.nextInt();
                    yCoordinate = scanner.nextInt();

                    char nextSymbol = (x - o == 1) ? 'O' : 'X';

                    if (ttt[3 - yCoordinate][xCoordinate - 1] == '_') {

                        ttt[3 - yCoordinate][xCoordinate - 1] = nextSymbol;
                        validInput = true;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        System.out.print("Enter the coordinates: ");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("You should enter numbers!");
                    System.out.print("Enter the coordinates: ");
                    scanner.nextLine();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.print("Enter the coordinates: ");
                    scanner.nextLine();
                }
            }


            result = resultIdentifier(ttt);
        }
        System.out.println(result);

    }

    static String resultIdentifier(Character[][] ttt) {
        String result = "";
        boolean isUnderLineContains = false;

        //print and find how many x or o it has.
        x = 0;
        o = 0;
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(ttt[i][j] + " ");
                if (ttt[i][j] == 'X') {
                    x++;
                } else if (ttt[i][j] == 'O') {
                    o++;
                }
                if (ttt[i][j] == '_') {
                    isUnderLineContains = true;
                }
            }
            System.out.println("|");
        }
        System.out.println("---------");

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


        if (Math.abs(x - o) > 1) {
            return "Impossible";
        } else if (result.equals("")) {
            if (isUnderLineContains) {
                return "Game not finished";
            } else {
                return "Draw";
            }
        } else if (result.length() > 8) {
            return "Impossible";
        } else {
            return result;
        }

    }
}
