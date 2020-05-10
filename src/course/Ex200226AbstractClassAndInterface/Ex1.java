package course.Ex200226AbstractClassAndInterface;

abstract class Caaa {
    protected int num;

    // 請在此處撰寫類別Caaa的建構元
    public Caaa(int n){
        num = n;
    }
    public abstract void show();
}

class Cbbb extends Caaa {

    public Cbbb(int n){
        super(n);
    }

    public void show() {
        System.out.printf("num = %d", num);
    }
}

public class Ex1 {
    public static void main(String args[]) {
        Cbbb bb = new Cbbb(2); // 此行可設定num成員的值為2
        bb.show(); // 此行可印出 "num=2" 字串
    }
}

