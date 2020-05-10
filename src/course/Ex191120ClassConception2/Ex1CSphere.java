package course.Ex191120ClassConception2;

public class Ex1CSphere {
    public static void main(String[] args) {
        CSphere sphere = new CSphere();
        sphere.setLocation(3,4,5);
        sphere.setRadius(1);
        System.out.println("Surface area: " + sphere.surfaceArea());
        System.out.println("Sphere volume: " + sphere.volume());
        sphere.showCenter();
    }
}

class CSphere{
    private int x; // 圓心的x座標
    private int y; // 圓心的y座標
    private int z; // 圓心的z座標
    private int radius; // 圓球的半徑
    void setLocation(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;

    }
    void setRadius(int radius){
        if (radius >= 0){
            this.radius = radius;
        }
    }
    double surfaceArea(){
        return 4 * Math.PI * radius * radius;
    }
    double volume(){
        return radius * radius * Math.PI * 4 / 3;
    }
    void showCenter(){
        System.out.printf("(x,y,z) = (%d,%d,%d)", x, y, z);
    }

}
