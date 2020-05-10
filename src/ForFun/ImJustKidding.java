package ForFun;

import java.util.ArrayList;

public class ImJustKidding {
    public static void main(String[] args) {
        String unicode = "\\u6211\\u4e0d\\u6703\\u97ff\\u61c9\\u8a0e" +
                "\\u4f10\\u6b66\\u5247\\u5929\\u3002\\u56e0\\u70ba\\u6211" +
                "\\u89ba\\u5f97\\u9019\\u7bc7\\u6587\\u7ae0\\u523b\\u610f" +
                "\\u62b9\\u9ed1\\u5979\\uff0c\\u4f86\\u9054\\u5230\\u4ec7" +
                "\\u6068\\u7684\\u76ee\\u7684\\u3002\\u4e14\\u82e5\\u8a0e" +
                "\\u6b66\\u5931\\u6557\\uff0c\\u53ef\\u80fd\\u6703\\u6709" +
                "\\u5f88\\u56b4\\u91cd\\u7684\\u5f8c\\u679c\\uff0c\\u56e0" +
                "\\u6b64\\u6211\\u9078\\u64c7\\u4fdd\\u5b88\\u4e00\\u4e9b" +
                "\\u3002";
        ArrayList string = unicode2String(unicode) ;
        int count = 0;
        int inputNum = 25;
        inputNum++;
        System.out.printf("%4s","");
        for (int k = 1; k < inputNum ; k++) {
            System.out.printf("%4d",k);
        }
        System.out.println();
        for (int i = 1; i < inputNum; i++){
            System.out.printf("%4d",i);
            for (int j = 1; j < inputNum; j++){
                if ((i > 7 && i < 18) &&
                        (j > 7 && j < 18)){
                    if (i == 8 || i == 17 || j == 8 || j == 17 ||
                            count >= string.size()){
                        System.out.printf("%4s","");
                    } else {
                        System.out.printf("%3s",string.get(count));
                        count++;
                    }
                }else if ((i == 3 || i == 22) &&
                        (j >= 3 && j <= 22) ||
                        (j == 3 || j == 22) &&
                                (i >= 3 && i <= 22)){
                    System.out.printf("%4s", "");
                }else if (i == j){
                    System.out.printf("%4s","");
                }else if(j == 25 - i) {
                    System.out.printf("%4s", "");
                }else {
                    System.out.printf("%4d",i * j);
                }
            }
            System.out.println();
        }
    }


    /**
     * unicode 轉字串
     */
    public static ArrayList unicode2String(String unicode) {

        ArrayList string = new ArrayList<String>();

        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++ ) {

            // 轉換出每一個程式碼點
            int data = Integer.parseInt(hex[i], 16);

            // 追加成string
            string.add((char) data);
            //string.append((char) data);
        }

        return string;
    }
}
