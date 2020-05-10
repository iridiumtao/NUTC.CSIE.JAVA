import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class test3 extends Thread {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        //String input = scanner.nextLine();
        String input = "9 +++ 10 -- 8";
        double answer = 0;

        String inputWithoutSpace = input.replaceAll("\\s", "");

        String[] operators = inputWithoutSpace.split("([1-9]\\d*|0)([.,]((\\d*[^0])|0))*");
        if (inputWithoutSpace.charAt(0) == '-') {
            inputWithoutSpace = inputWithoutSpace.substring(1);
        }
        String[] numbers = inputWithoutSpace.split("(\\++|-+)");

        System.out.println("sssss"+ Arrays.toString(operators));
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].length() != 1) {
                operators[i] = (operators[i].matches("\\++")) ? "+" :
                        ((operators[i].length() % 2 == 0) ? "+" : "-");
            }
        }

        System.out.println(input);
        System.out.println();
        System.out.println("operators = " + Arrays.toString(operators));
        System.out.println("numbers   = "+ Arrays.toString(numbers));

        // 加總
        for (int i = 0; i < operators.length; i++) {
            answer += Double.parseDouble(operators[i] + numbers[i]);
        }

        // 利用format使double的「.0」去除掉
        DecimalFormat format = new DecimalFormat("0.#");
        // 直接印出答案
        System.out.println(format.format(answer));


    }
}
