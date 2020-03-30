package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
    NOT WORKING PROPERLY!!!
 */

public class TimeCalculator {
    private Date date;
    private long timeMillis;

    public TimeCalculator(){
        date = new Date();
        timeMillis = System.currentTimeMillis();
        System.out.println(timeMillis);

    }

    public long getCurrentTimeMillis(){
        return timeMillis;
    }

    public void showCurrentTimeMillis(){
        System.out.println(timeMillis);
    }

    public void showCurrentHHmmssSSS(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        System.out.println(dateFormat.format(date));
    }

    public static void showTimeDifference(TimeCalculator tCal1, TimeCalculator tCal2){

        System.out.println(tCal2.timeMillis - tCal1.timeMillis + "ms");
    }
}
