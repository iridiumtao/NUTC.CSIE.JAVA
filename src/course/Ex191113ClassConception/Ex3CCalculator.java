package course.Ex191113ClassConception;

public class Ex3CCalculator {
    public static void main(String[] args) {
        CCalculator obj = new CCalculator();
        obj.setValue(25,3,7);
        obj.show();
        System.out.println("Add: " + obj.add());
        System.out.println("Sub: " + obj.sub());
        System.out.println("Mul: " + obj.mul());
        System.out.println("Avg: " + obj.avg());
    }
}

class CCalculator{
    int a, b, c;

    void setValue(int x, int y, int z){
        a = x;
        b = y;
        c = z;
    }

    void show(){
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
    }

    int add(){
        return a + b + c;
    }

    int sub(){
        return a - b - c;
    }

    int mul(){
        return a * b * c;
    }

    double avg(){
        return (a + b + c) / 3.0;
    }
}
