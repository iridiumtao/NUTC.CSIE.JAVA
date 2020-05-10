package course.Ex191120ClassConception2;

public class Ex3CCount {
    public static void main(String[] args) {
        System.out.println(CCount.count());
        CCount count1 = new CCount();
        System.out.println(CCount.count());
        CCount count2 = new CCount();
        CCount count3 = new CCount();
        System.out.println(count3.count());
    }
}
class CCount{
    private static int cnt = 0;
    CCount(){
        cnt++;
    }
    static int count(){
        return cnt;
    }
    void setContZero(){
        cnt = 0;
    }
    void setValue(int value){
        cnt = value;
    }
}
