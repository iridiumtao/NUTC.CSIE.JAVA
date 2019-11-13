package ForFun;

import java.util.Scanner;

public class untitled1 {
    public static double print(double[] a) {

        double b = 0;

        for (int i = 0; i < a.length; i++) {
            b += a[i];
        }
        return b;
    }

    static int print(int[] a){
        int b = 0;

        for (int i = 0; i < a.length; i++) {
            b += a[i];
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] a = new double[10];
        int[] a1 = new int[10];

        System.out.println("請輸入十個值:");
        for (int i = 0; i < 10; i++) {
            a[i] = input.nextDouble();
            a1[i] = (int) a[i];
        }

        System.out.println(print(a));
        System.out.println(print(a1));
    }
}
