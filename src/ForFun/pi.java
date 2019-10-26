package ForFun;

public class pi {
    public static void main(String[] args) {
        System.out.println("  i    pi(i)\n-------------");
        for (int i = 1; i < 902; i+=100)
            System.out.printf("%3s" + "    " + "%.4f" + "\n",i,(4*pi(i)));
    }
    private static double pi(int i){
        if (i == 0)
            return 0;
        return pi(i - 1) + (Math.pow(-1,i+1))/(2 * i - 1);
    }
}