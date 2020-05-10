package course.Ex191019Week;

import java.util.Scanner;

public class Ex1Week {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] lastDayOfTheMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //2019/01/01為星期二
        //2019任一天日期+該月之前所有的天數-1
        //除7的餘數-1即為星期
        do {
            System.out.println("請輸入2019年的月份(1/2)");
            int month = scanner.nextInt();
            System.out.println("請輸入2019年的日期(2/2)");
            int date = scanner.nextInt();
            int days = date;
            for (int i = 0; i < month - 1 ; i++) {
                days += lastDayOfTheMonth[i];
            }

            switch (days % 7) {
                case 0:
                    System.out.println("2019年" + month + "月" + date + "日 星期一");
                    break;
                case 1:
                    System.out.println("2019年" + month + "月" + date + "日 星期二");
                    break;
                case 2:
                    System.out.println("2019年" + month + "月" + date + "日 星期三");
                    break;
                case 3:
                    System.out.println("2019年" + month + "月" + date + "日 星期四");
                    break;
                case 4:
                    System.out.println("2019年" + month + "月" + date + "日 星期五");
                    break;
                case 5:
                    System.out.println("2019年" + month + "月" + date + "日 星期六");
                    break;
                case 6:
                    System.out.println("2019年" + month + "月" + date + "日 星期日");
                    break;
            }
            System.out.println();
        } while (true);
    }
}
