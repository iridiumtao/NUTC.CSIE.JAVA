package course.FinalExam200407;

interface ITest {
    public void show();

    public int GCD();
}

class CTest {
    public int inputOne;
    public int inputTwo;
}

class CNumber extends CTest implements ITest {
    int ans;

    CNumber(int x, int y) {
        inputOne = x;
        inputTwo = y;
    }

    public int GCD() {
        int smallerNum = (inputOne > inputTwo) ? inputOne : inputTwo;

        for (int i = 2; i < smallerNum; i++) {
            if (inputOne % i == 0 && inputTwo % i == 0) {
                ans = i;
            }
        }


        return ans;
    }

    public void show() {
        System.out.println("最大公因數 = " + GCD());
    }
}

class test1 {
    public static void main(String[] args) {
        //CNumber c = new CNumber(33932, 28443);
        CNumber c = new CNumber(33932, 820);
        c.show();
    }
}
