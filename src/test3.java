import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test3 extends Thread {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        //String input = scanner.nextLine();
        String input = "-2 + 4 ---- 5 --- 6";
        String addOrMinus;
        String test ="";

        Pattern pattern = Pattern.compile("-+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {

            addOrMinus = (matcher.group().length() % 2) == 0 ? "p" : "m";
            System.out.println(addOrMinus);
            test = matcher.replaceAll(addOrMinus);
        }
        System.out.println(input);
        System.out.println("test= "+ test);
    }
}
