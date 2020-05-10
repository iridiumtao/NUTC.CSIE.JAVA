package ForFun;

import java.util.Scanner;

public class RegexValidNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^[-+]?([1-9]\\d*|0)([.,]((\\d*[^0])|0))*$";

        String number = scanner.nextLine();
        System.out.println(number.matches(regex) ? "YES" : "NO");

    }
}
