package fr.toxio.uhc.api.utils;


public class TimeUtils {

    public static String simpleBeautifulTime(int second){
        int hours = second/3600;
        int minAndSec = second%3600;
        int min = minAndSec/60;
        int sec = minAndSec%60;

        if(hours == 0){
            if(min == 0) return (sec > 9 ?  sec : "0" + sec) + "s";
            return (min > 9 ?  min : "0" + min) + "m" + (sec > 9 ?  sec : "0" + sec) + "s";
        }
        return  hours + "h" + (min > 9 ?  min : "0" + min) + "m" + (sec > 9 ?  sec : "0" + sec) + "s";
    }

    public static String beautifulTime(int seconds){
        int hours = seconds/3600;
        int minAndSec = seconds%3600;
        int min = minAndSec/60;
        int sec = minAndSec%60;

        if(hours == 0 && min == 0){
            return sec + " seconde(s)";
        }

        if(hours == 0){
            return min + " minute(s)";
        }

        if(min == 0){
            return  hours + " heure(s) ";
        }

        if(sec == 0){
            return  hours + " heure(s) " + min + " minute(s)";
        }
        return  hours + " heure(s) " + min + " minute(s) " + sec + " seconde(s)";
    }

}
