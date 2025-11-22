package com.cinema_ticket.modell;
import java.util.*;
import java.io.Serializable;
import java.time.*;



public class Film implements Serializable{
    private DayOfWeek day;
    private List<LocalTime> dates = new ArrayList<>(); 
    private String title;
    private int age_limit;
    private String type;
    private int length;
    private int dimension;

    public Film(){
        day = DayOfWeek.MONDAY;
        dates = null;
        title = null;
        age_limit = 0;
        type = null;
        length = 0;
        dimension = 0;
    }

    public Film(DayOfWeek d, List<LocalTime> ti, String tit, int al, String ty, int le, int dim){
        day = d;
        dates = ti;
        title = tit;
        age_limit = al;
        type = ty;
        length = le;
        dimension = dim;
    }

     public DayOfWeek getDay() {
        return day;
    }

    public List<LocalTime> getDates() {
        return dates;
    }

    public String getTitle() {
        return title;
    }

    public int getAgeLimit() {
        return age_limit;
    }

    public String getType() {
        return type;
    }

    public int getLength() {
        return length;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public void setDates(List<LocalTime> dates) {
        this.dates = dates;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAgeLimit(int age_limit) {
        this.age_limit = age_limit;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
}