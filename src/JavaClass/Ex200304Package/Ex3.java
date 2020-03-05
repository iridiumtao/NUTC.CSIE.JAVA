package JavaClass.Ex200304Package;

public class Ex3 {
    public static void main(String[] args) {
        String string = "Stanford";
        String string2 = reverse(string);
        System.out.println(string2);
    }

    public static String reverse(String string) {

        String result = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            result = result + string.charAt(i);
        }
        return result;
    }
}
