package ForFun;

import java.util.Arrays;
import java.util.Scanner;

public class checkIpIsValid {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();

        System.out.println((checkIp(ip)) ? "YES" : "NO");
    }

    static boolean checkIp(String ip) {
        try {
            String[] splitIp = ip.split("\\.");
            if (splitIp.length != 4 || ip.endsWith(".")) {
                return false;
            }
            for (int i = 0; i < 4; i++) {
                if (Integer.parseInt(splitIp[i]) > 255 || Integer.parseInt(splitIp[i]) < 0) {
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    static boolean checkIpWithRegex(String ip) {
        // 0~199 or 200~249 or 250~255
        // or == |
        String bytePattern = "(1?\\d?\\d|2[0-4]\\d|25[0-5])";
        String ipPattern = String.join(
                "\\.", bytePattern, bytePattern, bytePattern, bytePattern
        );
        return ip.matches(ipPattern);
    }

}
