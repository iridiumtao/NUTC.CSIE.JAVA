package course.FinalExam200407;

import java.util.Scanner;

public class work3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] lastDayOfTheMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        do {
            System.out.print("請輸入一個年份(需大於1920年):");
            int year = scanner.nextInt();
            if (year < 1920) {
                System.out.println("輸入條件錯誤");
                break;
            }
            //1920年1月1日是星期四
            int days = 4;

            for (int i = 1920; i < year; i++) {
                days += CY.checkYear(i) == 1 ? 366 : 365;
            }
            System.out.print("請輸入月份:");
            int month = scanner.nextInt();

            //調整本年2月的天數
            lastDayOfTheMonth[1] = (CY.checkYear(year) == 1) ? 29 : 28;

            for (int i = 0; i < month - 1; i++) {
                days += lastDayOfTheMonth[i];
            }
            int firstDay = days % 7;
            int newLineTick = 0;
            System.out.println("=============================");
            System.out.println(" Sun Mon Tue Wed Thu Fri Sat ");
            System.out.println("=============================");
            for (int i = 0; i < firstDay; i++) {
                System.out.printf("%4s", "");
                newLineTick++;
            }
            for (int i = 1; i <= lastDayOfTheMonth[month - 1]; i++) {
                System.out.printf("%4d", i);
                newLineTick++;
                if (newLineTick >= 7) {
                    System.out.println();
                    newLineTick = 0;
                }
            }
            System.out.println();
            System.out.println();

        } while (true);
    }

}

class CY {
    static int checkYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0 && year % 3200 != 0))
            return 1;
        else
            return 0;
    }
}