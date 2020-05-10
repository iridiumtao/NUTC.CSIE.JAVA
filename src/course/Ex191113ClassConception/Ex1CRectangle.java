package course.Ex191113ClassConception;

public class Ex1CRectangle {
    public static void main(String[] args) {
        Caaa obj = new Caaa();

        obj.a = 5;
        obj.b = 3;
        obj.c = obj.a * obj.b;
        System.out.println("a: " + obj.a + ", b: " + obj.b + ", c: " + obj.c);



    }
}

class Caaa {
    int a;
    int b;
    int c;
}
