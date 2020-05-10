package course.Ex191113ClassConception;

public class Ex4CCircle {
    public static void main(String[] args) {
        CCircle obj = new CCircle();
        System.out.println(obj.area(2));
        System.out.println(obj.area(2.2f));
        System.out.println(obj.area(2.2));

    }
}

class CCircle{
    double pi = 3.14;

    double area(double r){
        return r * r * pi;
    }

    float area(float r){
        return r * r * (float)pi;
    }

    double area(int r){
        return r * r * pi;
    }
}
