package sample.DataCenter;

import java.util.Calendar;


public class SunRiseSet {


    static int year,month,date;
    static double lat,lng;
    static Calendar calendar;
    static SunPosition sunPosition;

    public static void main(String[] args) {

        calendar = Calendar.getInstance();

        SunPosition.Sun sun ;
        sun=sunPosition.calc(calendar);
        System.out.println(sun.getAltitude());
    }

}
