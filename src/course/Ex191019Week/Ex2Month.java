package course.Ex191019Week;

import java.util.Scanner;

public class Ex2Month {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] lastDayOfTheMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //2019/01/01為星期二
        //2019任一天日期+該月之前所有的天數-1
        //除7的餘數-1即為星期
        do {
            System.out.println("請輸入2019年的月份");
            int month = scanner.nextInt();
            int date = 1;
            for (int i = 0; i < month - 1; i++) {
                date += lastDayOfTheMonth[i];
            }
            int firstDay = date % 7;

            int newLineTick = 0;
            System.out.println("=============================");
            System.out.println(" Sun Mon Tue Wed Thu Fri Sat ");
            System.out.println("=============================");
            if (firstDay != 6) {
                for (int i = 0; i < firstDay + 1; i++) {
                    System.out.printf("%4s", "");
                    newLineTick++;
                }
            }
            for (int i = 1; i <= lastDayOfTheMonth[month - 1]; i++) {
                System.out.printf("%4d", i);
                newLineTick++;
                if (newLineTick == 7) {
                    System.out.println();
                    newLineTick = 0;
                }
            }
            System.out.println();
            System.out.println();

        } while (true);
    }
}
