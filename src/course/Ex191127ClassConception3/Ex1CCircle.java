package course.Ex191127ClassConception3;

public class Ex1CCircle {
    public static void main(String[] args) {
        CCircle cir1=new CCircle(1.0);
        CCircle cir2=new CCircle(2.0);
        CCircle.compare(cir1,cir2); // 比較cir1與cir2的radius是否相等
    }

}
class CCircle
{
    private static double pi=3.14;
    private double radius;

    public CCircle(double r) // CCircle()建構元
    {
        radius=r;
    }

    public static void compare(CCircle a, CCircle b){
        if(a.radius==b.radius) // 判別物件的radius成員是否相等
            System.out.println("radius are equal");
        else
            System.out.println("radius are not equal");
    }
}