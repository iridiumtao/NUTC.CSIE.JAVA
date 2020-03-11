package ForFun;

import java.util.Scanner;

public class untitled2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        if (string.toLowerCase().contains("the")){
            String[] split = string.split("the");
            if (split.length<2){
                System.out.println("0");
            }else{
                System.out.println(split[0].length());
            }
        }else{
            System.out.println("-1");
        }

    }

}
