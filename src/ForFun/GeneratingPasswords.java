package ForFun;

import java.util.Scanner;

public class GeneratingPasswords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder password = new StringBuilder();
        int uppercase = scanner.nextInt();
        int lowercase = scanner.nextInt();
        int number = scanner.nextInt();
        int total = scanner.nextInt();

        char pwChar = 'A';
        for (int i = 0; i < uppercase; i++) {
            if (pwChar >= 'Z') {
                pwChar = 'A';
            }
            password.append(pwChar++);
        }

        pwChar = 'a';
        for (int i = 0; i < lowercase; i++) {
            if (pwChar >= 'z') {
                pwChar = 'a';
            }
            password.append(pwChar++);
        }

        pwChar = '0';
        for (int i = 0; i < number; i++) {
            if (pwChar >= '9') {
                pwChar = '0';
            }
            password.append(pwChar++);
        }

        pwChar = 'A';
        for (int i = password.length(); i < total; i++) {
            if (password.length() > 0 && password.charAt(password.length()-1) == pwChar){
                pwChar++;
            }
            if (pwChar >= 'Z') {
                pwChar = 'A';
            }
            password.append(pwChar++);
        }
        System.out.println(password.toString());
    }
}
