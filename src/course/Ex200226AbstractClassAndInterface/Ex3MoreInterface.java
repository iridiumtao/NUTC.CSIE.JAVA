package course.Ex200226AbstractClassAndInterface;

interface iShapeInEx3 {
    final double pi = 3.14;

    abstract void setColor(String str);
}

interface iShape2D extends iShapeInEx3 {
    abstract void area();
}

interface iShape3D extends iShapeInEx3 {
    abstract void volume();
}

class CCircle implements iShape2D {
    double radius;
    String color;

    public CCircle(double r) {
        radius = r;
    }

    public void setColor(String str) {
        color = str;
        System.out.println("color = " + color);
    }

    public void area() {
        System.out.println("area = " + pi * radius * radius);
    }
}

class CRectangle implements iShape2D {
    int width;
    int height;
    String color;

    public CRectangle(int w, int h) {
        width = w;
        height = h;
    }

    public void setColor(String str) {
        color = str;
        System.out.println("color = " + color);
    }

    public void area() {
        System.out.println("area = " + width * height);
    }
}

class CBox implements iShape3D {
    int length;
    int width;
    int height;
    String color;

    public CBox(int l, int w, int h) {
        length = l;
        width = w;
        height = h;
    }

    public void setColor(String str) {
        color = str;
        System.out.println("color = " + color);
    }

    public void volume() {
        System.out.println("area = " + length * width * height);
    }
}

class CSphere implements iShape3D {
    double radius;
    String color;

    public CSphere(double radius) {
        this.radius = radius;
    }

    public void setColor(String str) {
        color = str;
        System.out.println("color = " + color);
    }

    public void volume() {
        System.out.println("area = " + 4 * pi * radius * radius * radius / 3);
    }
}

public class Ex3MoreInterface {
    public static void main(String[] args) {
        CCircle cir;
        cir = new CCircle(2.0);
        cir.setColor("Blue");
        cir.area();

        CRectangle rec;
        rec = new CRectangle(5, 10);
        rec.setColor("Purple");
        rec.area();

        CBox box;
        box = new CBox(4, 10, 8);
        box.setColor("Orange");
        box.volume();

        CSphere sph;
        sph = new CSphere(2);
        sph.setColor("Pink");
        sph.volume();
    }
}
