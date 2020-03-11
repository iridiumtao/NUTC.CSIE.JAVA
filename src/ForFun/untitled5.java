package ForFun;

import java.util.Arrays;
import java.util.Scanner;

public class untitled5 {
    public static void main(String[] args) {
        //https://target.com/index.html?pass=12345&port=8080&cookie=&host=localhost

        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        String[] split = url.substring(url.indexOf("?")+1).split("&");
        String password = null;
        for (String s :
                split) {
            //System.out.println(s);
            if (s.contains("=")) {
                String[] split2 = s.split("=");
                if (split2.length > 1) {
                    System.out.println(split2[0] + " : " + split2[1]);
                }else {
                    System.out.println(split2[0] + " : not found");
                }
                if (s.contains("pass")){
                    password = split2[1];
                }
            }
        }
        if (password != null){
            System.out.println("password : " + password);
        }

    }
}
