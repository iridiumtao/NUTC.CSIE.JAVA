import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


public class test2 {
    public static void main(String[] args) {
        //this is a test for Lambda expression and Method References

        int max = -1*Integer.MIN_VALUE;
        max+=Integer.MIN_VALUE*10;

        long bigNum = Long.MAX_VALUE;

        System.out.println(max);


        System.out.println(bigNum%(long)Integer.MIN_VALUE);
    }
}
