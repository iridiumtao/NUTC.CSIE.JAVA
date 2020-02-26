package JavaClass.Ex200226AbstractClassAndInterface;

interface iShape {
    public void show();

    public int area(); // 計算面積
}

class CColor {
    public String color;

    public CColor(String s) {
        color = s;
    }
}

// 請於此處定義CWin類別
class CWin extends CColor implements iShape{
    int width;
    int height;

    public CWin(int w, int h, String color){
        super(color);
        width = w;
        height = h;
    }

    public void show(){
        System.out.printf("width = %d \n", width);
        System.out.printf("height = %d \n", height);
        System.out.printf("color = %s \n", color);
        System.out.printf("area = %d \n", area());
    }

    public int area() {
        return width * height;
    }

}

public class Ex2ClassExtendAndImplement {
    public static void main(String args[]) {
        CWin win = new CWin(5, 7, "Red"); // 建立CWin類別的物件
        win.show();
    }
}
