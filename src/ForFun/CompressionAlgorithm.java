package ForFun;

import java.util.Scanner;

public class CompressionAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rawData = scanner.nextLine();
        StringBuilder compressedData = new StringBuilder();
        int repeat = 1;
        for (int i = 0; i < rawData.length(); i++) {
            if (((i + 1 < rawData.length()) && rawData.charAt(i) != rawData.charAt(i + 1)) ||
                    (i + 1 == rawData.length())) {
                compressedData.append(rawData.charAt(i)).append(repeat);
                repeat = 1;
            } else {
                repeat++;
            }
        }
        System.out.println(compressedData);
    }
}
