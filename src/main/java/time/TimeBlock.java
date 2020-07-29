package time;

import java.util.Objects;

public class TimeBlock {
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;


    public TimeBlock() {
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }


    @Override
    public String toString() {
        return "Timer{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }



}
