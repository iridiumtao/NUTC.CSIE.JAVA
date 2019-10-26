package ForFun;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Please a large number:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("Reverse: " + reverse(num));
        System.out.println("This number is " + (isPalindrome(num)? "" : "not ") + "palindrome");
    }
    public static int reverse(int number){
        int n1 = (int)Math.log10(number);
        String n2="";
        for (int i = 0; i < n1 + 1; i++) {
            n2 += number%10;
            number /= 10;
        }

        return Integer.parseInt(n2);
    }
    public static boolean isPalindrome(int number){
        return (number == reverse(number));
    }

}
