import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入學生人數");
        int NumberOfStudents = scanner.nextInt();
        String[] student = new String[NumberOfStudents];
        String tempName;
        Integer[] score = new Integer[NumberOfStudents];
        int temp;

        for (int i = 0; i < NumberOfStudents; i++){
            System.out.println("請輸入學生名字及成績("+(i+1)+"/"+NumberOfStudents+")");
            student[i] = scanner.next();
            score[i] = scanner.nextInt();
        }

        for (int i = 0; i < score.length; i++){
            for (int j = 0; j < (score.length - i - 1); j++){
                if(score[j] > score[j+1]){
                    temp = score[j];
                    score[j] = score[j+1];
                    score[j+1] = temp;

                    tempName = student[j];
                    student[j] = student[j+1];
                    student[j+1] = tempName;
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(student[i] + " = " + score[i]);
        }
    }
}
