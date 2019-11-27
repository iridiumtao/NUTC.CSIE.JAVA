package JavaClass.Ex191127ClassConception3;

public class Ex2 {
    public static void main(String[] args) {
        CCircleEx2 cir1=new CCircleEx2(1.0);
        CCircleEx2 cir2=new CCircleEx2(2.0);
        compare(cir1,cir2); // 比較cir1與cir2的radius是否相等

    }
    private static void compare(CCircleEx2 a, CCircleEx2 b){
        if(a.radius==b.radius) // 判別物件的radius成員是否相等
            System.out.println("radius are equal");
        else
            System.out.println("radius are not equal");
    }

}
class CCircleEx2
{
    private static double pi=3.14;
    public double radius;

    public CCircleEx2(double r) // CCircle()建構元
    {
        radius=r;
    }


}