import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;


public class test2 {
    public static void main(String[] args) {
        // write your code here
        //3x4
        int[][] array = {{1, 2, 3, 4},
                {4, 5, 6, 3},
                {8, 6, 3, 1}};


        for (int i =0 ; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = array[(i + 5) % 3][(j + 2) % 4];
            }
        }

        System.out.println(Math.random()*10 % 11);

    }


}
