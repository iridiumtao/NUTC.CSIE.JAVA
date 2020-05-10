package course.Ex191120ClassConception2;

public class Ex2CRectangle {
    public static void main(String[] args) {
        CRectangle rectangle = new CRectangle();
        rectangle.showParameter();
    }
}
class CRectangle{
    int width;
    int height;

    public CRectangle(int w, int h) {
        width = w;
        height = h;
    }
    CRectangle(){
        //width = 10;
        //height = 8;
        this(10,8);
    }
    void showParameter(){
        System.out.printf("Width: %d Height: %d", width, height);
    }
}
