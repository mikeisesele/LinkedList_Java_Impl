package com.company.mine;

import java.util.Objects;

public class Holiday {

    private String name;
    private int day;
    private String month;

    public Holiday(String name, int day, String month) {
        this.name = name;
        this.day = day;
        this.month = month;
    }


    public boolean inSameMonth( Holiday h){
        if (this.month.equals(h.getMonth())) return true;
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Holiday)) return false;
        Holiday holiday = (Holiday) o;
        return getDay() == holiday.getDay() && getName().equals(holiday.getName()) && getMonth().equals(holiday.getMonth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDay(), getMonth());
    }
}
