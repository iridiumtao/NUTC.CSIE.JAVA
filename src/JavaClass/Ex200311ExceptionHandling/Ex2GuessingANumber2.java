package JavaClass.Ex200311ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2GuessingANumber2 {
    /**
     * 請利用Math.random(), if/else, and for()寫一個猜數字遊戲程式，
     * 數字範圍為1-100。使用者如果猜中了就顯示「猜中子」，然後結束程式；
     * 如果沒有猜中，應顯示「猜大了」或「猜小了」，然後請使用者再猜一次。
     * 請注意：使用者可以自由輸入任何文數字，程式不可銚出。
     * 另外，使用者可以沒有猜中就放棄、猜中後放棄or猜中再玩一次
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            guessingANumber();
            System.out.println("遊戲結束 是否在玩一次？");
            String continueOrNot = scanner.next();
            if (continueOrNot.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    static void guessingANumber() {
        Scanner scanner = new Scanner(System.in);
        int ans = (int) (Math.random() * 100) + 1;
        int input;
        int min = 0;
        int max = 100;
        while (true) {
            try {
                System.out.println("請猜一個" + min + "~" + max + "的數字");
                input = scanner.nextInt();
                if (input == ans) {
                    System.out.println("猜中了");
                    break;
                } else if (input > ans) {
                    System.out.println("猜大了");
                    max = input;
                } else {
                    System.out.println("猜小了");
                    min = input;
                }
                System.out.println("是否在猜一次？(Y/N)");
                String continueOrNot = scanner.next();
                if (continueOrNot.equalsIgnoreCase("n")) {
                    break;
                }
            } catch (InputMismatchException ignored) {
                System.out.println("請輸入有效數值!!");
                scanner.next();
            }
        }
    }
}
