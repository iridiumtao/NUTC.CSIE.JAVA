import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;


public class test2 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.print("<td>");
            for (int j = 1; j < 10; j++) {
                System.out.println(i + " * " + j + " = " + i * j+"<br>");
            }
            System.out.print("</td>");
            System.out.println();
        }

    }

}
