package JavaClass.Ex191002ForLoop;

public class ForLoop2 {
    public static void main(String[] args) {
        int inputNum = 25;
        inputNum++;
        System.out.printf("%4s","");
        for (int k = 1; k < inputNum ; k++) {
            System.out.printf("%4d",k);
        }
        System.out.println();
        for (int i = 1; i < inputNum; i++){
            System.out.printf("%4d",i);
            for (int j = 1; j < inputNum; j++){

                /*if ((i > 7 && i < 17) &&
                        (j > 7 && j < 18)){
                    System.out.printf("%4s","");
                }else {
                    System.out.printf("%4d",i * j);
                }*/
                System.out.printf("%4d",i * j);
            }
            System.out.println();
        }
    }
}
