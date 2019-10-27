package JavaClass.Ex190918GuessANumber;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ans = (int)(Math.random()*100)+1;

        while(true){
            //try{
                System.out.println("請猜一個0~100的數字");
                int input = scanner.nextInt();
                if (input == ans){
                    System.out.println("恭喜猜對");
                    break;
                }else if(input > ans){
                    System.out.println("數字太大了");
                }else {
                    System.out.println("數字太小了");
                }
            /*}catch (Exception ignored){
                System.out.println("請輸入有效數值!!");
                break;
            }*/

        }


    }
}
