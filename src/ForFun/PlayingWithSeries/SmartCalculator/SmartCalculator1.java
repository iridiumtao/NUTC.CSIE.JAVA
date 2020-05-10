package ForFun.PlayingWithSeries.SmartCalculator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmartCalculator1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            input = scanner.nextLine();
            int answer = 0;
            //包含任意數字
            if (input.matches(".*\\d.*")) {
                input = input.replaceAll("\\s*", "")
                        .replaceAll("\\++", "+");

                Pattern pattern = Pattern.compile("-+");
                Matcher matcher = pattern.matcher(input);
                while(matcher.find()) {
                    System.out.println(matcher.group());

                    boolean minus = (matcher.group().length() % 2) == 0;
                    input = input.replaceAll("-+", minus?"+":"-");
                }

                String[] texts = input.split("\\s*");
                System.out.println(Arrays.toString(texts));
                for (String text : texts) {
                    answer += Integer.parseInt(text);
                }
                System.out.println(answer);

            } else if (input.equals("/help")) {
                System.out.println("The program calculates the sum of numbers");
            }
        } while (!input.equals("/exit"));

        System.out.println("Bye!");
    }
}
