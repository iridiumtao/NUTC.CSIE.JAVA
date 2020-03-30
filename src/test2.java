import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;


public class test2 {
    public static void main(String[] args) {
        // write your code here
        for (int i = 0; i < 10; i++) {
            Random randColor = new Random();
            float red = (float) (randColor.nextFloat() / 2f + 0.5);
            //System.out.println(red);
            System.out.println(randColor.nextInt()%20);
        }

    }
}
