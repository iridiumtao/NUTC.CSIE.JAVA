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


        for (int i = 0; i < 35; i++) {
            if (i % 10 == 1){
                switch (i){
                    case 11:
                        System.out.println("11");
                        break;
                    case 21:
                        System.out.println("21");
                        break;
                    case 31:
                        System.out.println("31");
                        break;
                    default:
                        System.out.println();
                }
            }
        }
    }
}
