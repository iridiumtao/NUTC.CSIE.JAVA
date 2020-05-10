package course.Ex191113ClassConception;

public class Ex2CBox {
    public static void main(String[] args) {
        CBox box = new CBox();

        box.length = 1;
        box.width = 1;
        box.height = 1;

        box.showAll();
    }
}

class CBox{
    int length;
    int width;
    int height;

    int volume(){
        return length * width * height;
    }

    int surfaceArea(){
        return length * width * 2 + length * height * 2 + width * height * 2;
    }

    void showData(){
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
    }

    void showAll(){
        showData();
        System.out.println("Volume: " + volume());
        System.out.println("Surface area: " + surfaceArea());
    }
}
