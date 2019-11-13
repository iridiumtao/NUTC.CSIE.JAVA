import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


public class test2 {
    public static void main(String[] args) {
        //this is a test for Lambda expression and Method References

        int[] arr = {0,1,2,3,5,6,7,8,9,10};
        for (int i : arr) {
            System.out.println(i);
        }




        List<String> message = Arrays.asList("hi", "i", "want", "this", "all", "capitalized");
        message.forEach(word -> System.out.println(StringUtils.capitalize(word)));

        System.out.println();
    }
}
