package ForFun;

import java.util.Scanner;

/*
    必須包含：
    1 大寫字母
    1 小寫字母
    1 數字
    12 字元
 */
public class SafePasswordChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        System.out.println(password.matches(".*[a-z].*") &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".{12,}") ? "YES" : "NO");
    }
}
