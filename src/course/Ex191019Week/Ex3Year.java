package course.Ex191019Week;

import java.util.Scanner;

public class Ex3Year {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] lastDayOfTheMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        do {
            System.out.println("請輸入一個年份(需大於1920年)");
            int year = scanner.nextInt();

            //1920年1月1日是星期四
            int days = 4;

            for (int i = 1920; i < year; i++) {
                days += leapYear(i) ? 366 : 365;
            }
            System.out.println("請輸入" + year + "的月份");
            int month = scanner.nextInt();

            //調整本年2月的天數
            lastDayOfTheMonth[1] = (leapYear(year)) ? 29 : 28;

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
    private static boolean leapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0 && year % 3200 != 0);
    }
}
