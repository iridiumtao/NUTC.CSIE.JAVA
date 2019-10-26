package Math;

import java.math.BigInteger;
import java.util.Scanner;

public class DiscreteMathematicsPowerTest {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner scanner = new Scanner(System.in);

        //a的n次方
        System.out.println("請輸入底數A");
        BigInteger userInputA = new BigInteger(scanner.nextLine());



        BigInteger a = new BigInteger("1");
        System.out.println("請輸入對數N");
        int userInputN = scanner.nextInt();
        String aToBinary = Integer.toBinaryString(userInputN);
        System.out.println("對數的二進位為：" + aToBinary);
        for (int i = 0; i < aToBinary.length(); i++){
            System.out.println("**charAt：" + i +" "+ aToBinary.charAt(i));
            switch (aToBinary.charAt(i)) {
                case '0':
                    a = a.multiply(a);
                    break;
                case '1':
                    a = a.multiply(a).multiply(userInputA);
                    break;
            }
            System.out.println("**a：" + a);
        }
        System.out.println("演算法的答案為：" + a);
        System.out.println("直接計算答案為：" + userInputA.pow(userInputN));

        String userBook2 = "hello";

        System.out.println(userBook2);
    }
}
