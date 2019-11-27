package JavaClass.Ex191127ClassConception3;

public class Ex4 {
    public static void main(String args[]){
        Cbbb bb=new Cbbb();
        bb.set_num(5,10);
        bb.show();
    }
}

class Cbbb extends Caaa{
    void set_num(int a, int b){
        setNum1(a);
        setNum2(b);
    }
}

class Caaa {
    private int num1;
    private int num2;

    void show(){
        System.out.printf("num1 = %d, num2 = %d",num1,num2);
    }
    void setNum1(int num){
        num1 = num;
    }
    void setNum2(int num){
        num2 = num;
    }
}


