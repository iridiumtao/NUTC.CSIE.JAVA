package JavaClass.FinalExam200407;

import java.util.Scanner;
import java.math.BigInteger;

class Plus {
    String ans;

    Plus(String input1, String input2) {
        BigInteger x = new BigInteger(input1);
        BigInteger y = new BigInteger(input2);
        ans = x.add(y).toString();
    }

    void print() {
        System.out.println(ans);
    }
}

class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入一個超過30位的數值");
        String input1 = scanner.nextLine();
        System.out.println("請輸入一個超過30位的數值");
        String input2 = scanner.nextLine();

        Plus plus = new Plus(input1, input2);

        System.out.println("結果");
        plus.print();

    }
}
