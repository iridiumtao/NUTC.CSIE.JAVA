package JavaClass.Ex200325Multithreading;

public class Ex3 {
    public static void main(String[] args) {
        Thread dog = new Thread(new CTest("doggy"));
        Thread cat = new Thread(new CTest("kitty"));
        dog.start();
        try {
            dog.join();
            cat.start();
            cat.join();
        } catch (InterruptedException ignored) {
        }
        System.out.println("main() method finished.");
    }
}
