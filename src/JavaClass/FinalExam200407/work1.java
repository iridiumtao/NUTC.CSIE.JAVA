package JavaClass.FinalExam200407;

import java.util.Scanner;

class Multiply {
    protected static int input;

    static void show(int i) {
        System.out.printf("%4d", i);
    }

    static void show() {
        System.out.print("    ");
    }
}

class work1 extends Multiply {
    public static void main(String[] args) {
        System.out.print("請輸入一個大於1的奇數：");
        Scanner scanner = new Scanner(System.in);

        int input = 0;
        try {
            input = scanner.nextInt();
            if (input % 2 != 1 || input < 2) {
                System.out.println("輸入條件錯誤");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("輸入條件錯誤");
            System.exit(0);
        }

        for (int i = 1; i <= input; i++) {
            for (int j = 1; j <= input; j++) {
                int half = (input + 1) / 2;
                if (i + j > half && Math.abs(i - j) < half && i + j < input + half + 1) {
                    Multiply.show();
                } else {
                    Multiply.show(i * j);
                }
            }
            System.out.println("");
        }
    }
}
