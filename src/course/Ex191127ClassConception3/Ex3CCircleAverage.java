package course.Ex191127ClassConception3;

public class Ex3CCircleAverage {
    public static void main(String args[]) {
        CCircleEx3[] cir;
        cir = new CCircleEx3[3];
        cir[0] = new CCircleEx3(1.0);
        cir[1] = new CCircleEx3(4.0);
        cir[2] = new CCircleEx3(2.0);

        System.out.println("The largest radius = " + CCircleEx3.compare(cir));
        System.out.println("Average radius = " + CCircleEx3.average(cir));
    }

}

class CCircleEx3 // 定義類別CCircle
{
    private static double pi = 3.14;
    private double radius;

    public CCircleEx3(double r) {
        radius = r;
    }

    public static double compare(CCircleEx3 c[]) // compare() method
    {
        double max = 0.0;
        for (int i = 0; i < c.length; i++)
            if (c[i].radius > max)
                max = c[i].radius;
        return max;
    }

    static int sum(CCircleEx3 c[]) {
        int sum = 0;
        for (int i = 0; i < c.length; i++) {
            sum += c[i].radius;
        }
        return sum;
    }

    public static double average(CCircleEx3 c[]) {
        return (double) sum(c) / (double) (c.length);
    }
}