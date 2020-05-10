package ForFun.PlayingWithSeries.SmartCalculator;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 題目網址：https://hyperskill.org/projects/42/stages/223/implement
 重點：利用regex進行字串處理
 */

public class SmartCalculator1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            try {
                input = scanner.nextLine();
                double answer = 0;

                //包含任意數字及正負號
                if (input.matches(".*\\d\\s*[+-].*")) {

                    // 無空格版本的輸入
                    String inputWithoutSpace = input.replaceAll("\\s", "");

                    // 提取運算子
                    String[] operators = inputWithoutSpace.split("([1-9]\\d*|0)([.,]((\\d*[^0])|0))*");

                    // 刪除會造成numbers有問題的首負號
                    if (inputWithoutSpace.charAt(0) == '-') {
                        inputWithoutSpace = inputWithoutSpace.substring(1);
                    }

                    // 提取數值部分
                    String[] numbers = inputWithoutSpace.split("(\\++|-+)");

                    // 將 正號變成空白、負號則判斷出現次數
                    for (int i = 0; i < operators.length; i++) {
                        if (operators[i].length() != 1) {
                            operators[i] = (operators[i].matches("\\++")) ? "" :
                                    ((operators[i].length() % 2 == 0) ? "" : "-");
                        }
                    }

                    if (operators.length != numbers.length) {
                        throw new NumberFormatException("Input : " + input + "is invalid");
                    }

                    // 加總
                    for (int i = 0; i < operators.length; i++) {
                        answer += Double.parseDouble(operators[i] + numbers[i]);
                    }

                    // 利用format使double的「.0」去除掉
                    DecimalFormat format = new DecimalFormat("0.#");
                    // 直接印出答案
                    System.out.println(format.format(answer));
                } else if (input.matches("-?([1-9]\\d*|0)([.,]((\\d*[^0])|0))*")){
                    // 若輸入僅唯一數
                    System.out.println(input);
                } else if (input.equals("/help")) {
                    System.out.println("The program calculates the sum of numbers");
                }
            } catch (NumberFormatException e) {
                input = "";
                System.out.println("Error: " + e);
         }
        } while (!input.equals("/exit"));

        System.out.println("Bye!");
    }
}
