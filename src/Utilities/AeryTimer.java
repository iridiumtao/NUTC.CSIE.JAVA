package Utilities;

import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AeryTimer extends Timer {
    private long unitTime = 0; // 單位時間, 每次執行TimerTask.run()的時間, 單位毫秒
    private long timeStep = 0; // 步進動作時間, 必須為unitTime倍數, 單位:毫秒
    private long timeOut = 0; // 結束計時時間, 必須為unitTime倍數, 單位:毫秒
    private long timeCount = 0; // 累計單位時間, 用以判斷是否達timeout時間

    private List<String> errorMessage = new ArrayList<String>(); // 記錄參數檢查之錯誤訊息

    private TimerTask tt = null;

    private TimerWorker aeryTL = null;

    public interface TimerWorker {
        /**
         * 每個step time要做的動作
         * @param _timeCount unit time
         */
        public void doTimeStep(long _timeCount); // 單位時間動作

        /**
         * 時間倒數結束要做的動作
         */
        public void doTimeOut(); // 計時結束動作
    }

    /**
     * 建構子, 因為unitTime與timeStep一定要設定, 所以就沒有寫空的建構子, 逼迫建立物件時就要給予設定
     * @param _unitTime 單位時間, 每次執行TimerTask.run()的時間, 單位毫秒
     * @param _timeStep 步進動作時間, 必須為unitTime倍數, 單位:毫秒
     */
    public AeryTimer(long _unitTime, long _timeStep) {
        constructor(_unitTime, _timeStep, 0);
    }

    /**
     * 建構子, 結束時間未設定或是設定為0, 計數器將會執行到呼叫cancel()時才會結束
     * @param _unitTime 單位時間, 每次執行TimerTask.run()的時間, 單位毫秒
     * @param _timeStep 步進動作時間, 必須為unitTime倍數, 單位:毫秒
     * @param _timeOut  結束計時時間, 必須為unitTime倍數, 單位:毫秒
     */
    public AeryTimer(long _unitTime, long _timeStep, long _timeOut) {
        constructor(_unitTime, _timeStep, _timeOut);
    }

    private void constructor(long _unitTime, long _timeStep, long _timeOut) {
        this.aeryTL = new AeryTimer.TimerWorker() {
            @Override
            public void doTimeStep(long _timeCount) {

            }

            @Override
            public void doTimeOut() {

            }
        };

        this.unitTime = _unitTime;
        this.timeStep = _timeStep;
        this.timeOut = _timeOut;
    }

    /**
     * 設定 單位時間, 每次執行TimerTask.run()的時間
     * @param _unitTime 單位毫秒
     */
    public void setUnitTime(long _unitTime) {
        this.unitTime = _unitTime;
    }

    /**
     * 設定 步進動作時間, 必須為unitTime倍數
     * @param _timeStep 單位:毫秒
     */
    public void setTimeStep(long _timeStep) {
        this.timeStep = _timeStep;
    }

    /**
     * 設定 結束計時時間, 必須為unitTime倍數
     * @param _timeOut  單位:毫秒
     */
    public void setTimeOut(long _timeOut) {
        this.timeOut = _timeOut;
    }

    /**
     * 設定欲執行的動作
     * @param _aeryTL 請creat一個TimerWorker, 並實作doTimeStep & doTimeOut
     */
    public void setTimerWorker(TimerWorker _aeryTL) {
        this.aeryTL = _aeryTL;
    }

    /**
     * 參數檢查
     * @return true:參數有誤; false:參數無誤
     */
    private boolean checker() {
        if (this.aeryTL == null) {
            this.errorMessage.add("‧欲執行計時前，必須先setTimerWorker()。");
            return true;
        }

        if (checkTimeParamater(this.unitTime, "單位") |
                checkTimeParamater(this.timeStep, "步進動作") |
                checkTimeParamater(this.timeOut, "結束計時")) {
            return true;
        }

        return false;
    }

    /**
     * 檢查 步進、單位動作、結束時間
     * @param time 單位 or 結束 時間
     * @param title "單位" or "時間"
     * @return true:參數有誤; false:參數無誤
     */
    private boolean checkTimeParamater(long time, String title) {
        if (time < 0) {
            this.errorMessage.add("‧" + title + "時間不可小於0。");
            return true;
        }

        if (time == 0) {
            if ("結束計時".equals(title)) { // 結束計時時間可為0
                return false;
            } else {
                this.errorMessage.add("‧" + title + "時間不可為0。");
                return true;
            }
        }

        if ("單位".equals(title)) { // 單位時間不須做倍數檢查
            return false;
        }

        if (time % this.unitTime != 0) {
            this.errorMessage.add("‧" + title + "時間需為單位時間" + this.unitTime + "的倍數。");
            return true;
        }

        return false;
    }

    /**
     * 初始參數
     */
    private void initial() {
        this.timeCount = 0;
        this.errorMessage.clear();
    }

    /**
     * 開始計時
     * @return 是否開始成功計時
     */
    public boolean start() {
        initial();

        if (checker()) {
            return false;
        }

        this.tt = new TimerTask() {
            public void run() {
                timeCount += unitTime;

                if (timeCount % timeStep == 0) {
                    aeryTL.doTimeStep(getProcessTime());
                }

                if (timeOut != 0 && timeCount >= timeOut) {
                    aeryTL.doTimeOut();
                    stop();
                }
            }
        };

        this.schedule(tt, this.unitTime, this.unitTime);

        return true;
    }

    /**
     * 停止計時器
     */
    public void stop() {
        this.cancel();
        this.tt.cancel();
    }

    /**
     * 取得過程時間
     * @return 過程時間
     */
    public long getProcessTime() {
        return this.timeCount;
    }

    /**
     * 取得錯誤訊息
     * @return 錯誤訊息啦
     */
    public List<String> getErrorMessage() {
        return this.errorMessage;
    }


    /**
     * 123
     * @param args 123
     * @throws IOException 123
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("請選擇要執行的例子(1/2/3): ");
        String controller = br.readLine();

        if ("1".equals(controller)) {
            Example1();
        } else if ("2".equals(controller)) {
            Example2();
        } else if ("3".equals(controller)) {
            Example3();
        }
    }

    private static void Example1() {
        AeryTimer aeryTimer = new AeryTimer(10, 100, 3000);

        aeryTimer.setTimerWorker(new AeryTimer.TimerWorker() {
            @Override
            public void doTimeStep(long _timeCount) {
                System.out.println("..." + _timeCount + "毫秒...");
            }

            @Override
            public void doTimeOut() {
                System.out.println("...碰!");
            }
        });

        if (!aeryTimer.start()) {
            for (String s : aeryTimer.getErrorMessage()) {
                System.out.println(s);
            }
            System.exit(0);
        }
    }

    private static void Example2() {
        AeryTimer aeryTimer = new AeryTimer(1, 10);

        aeryTimer.setTimerWorker(new AeryTimer.TimerWorker() {
            @Override
            public void doTimeStep(long _timeCount) {
                System.out.println("..." + _timeCount + "毫秒...");
            }

            @Override
            public void doTimeOut() {
                System.out.println("因為timeOut時間沒設定(0)，所以我不會執行喔^.<");
            }
        });

        if (!aeryTimer.start()) {
            for (String s : aeryTimer.getErrorMessage()) {
                System.out.println(s);
            }
            System.exit(0);
        }

        int kerker = 0;
        while (true) {
            kerker = (int) (Math.random() * 10000) + 1;

            if (kerker == 9527) {
                aeryTimer.stop();
                break;
            }

            System.out.println(kerker);
        }

        System.out.println("謝謝你~" + kerker);

        System.out.println("總共經過了" + aeryTimer.getProcessTime() + "毫秒...");
    }

    private static void Example3() throws IOException {
        AeryTimer aeryTimer = new AeryTimer(100, 100);

        if (!aeryTimer.start()) {
            for (String s : aeryTimer.getErrorMessage()) {
                System.out.println(s);
            }
            System.exit(0);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("請按ENTER結束計時...");
        br.readLine();

        aeryTimer.stop();

        System.out.println("總共經過了" + aeryTimer.getProcessTime() + "毫秒...");
    }
}
