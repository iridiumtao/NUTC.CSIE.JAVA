package JavaClass.ExForLoop191002;

import java.math.BigInteger;
import java.util.Scanner;

public class ForLoopPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //a的n次方
        System.out.println("請輸入一個數字");
        int inputNum = scanner.nextInt();

        System.out.printf("%4s","");
        for (int k = 1; k < inputNum ; k++) {
            System.out.printf("%4d",k);
        }
        System.out.println();

        for (int i = 1; i < inputNum; i++){
            System.out.printf("%4d",i);
            for (int j = 1; j < inputNum; j++){
                /*if (i * j < inputNum){
                    System.out.printf("%3s","");
                }*/
                System.out.printf("%4d",i * j);


            }
            System.out.println();
        }

    }
}
