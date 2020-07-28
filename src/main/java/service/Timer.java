package service;

import java.util.Objects;

public class Timer {
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;
    private long microseconds = 0;

    public Timer() {
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

    public long getMicroseconds() {
        return microseconds;
    }

    public void setMicroseconds(long microseconds) {
        this.microseconds = microseconds;
    }

    @Override
    public String toString() {
        return "Timer{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                ", microseconds=" + microseconds +
                '}';
    }
}
