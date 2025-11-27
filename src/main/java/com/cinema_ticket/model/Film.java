package com.cinema_ticket.model;
import java.util.*;
import java.io.Serializable;
import java.time.*;



public class Film implements Serializable{
    private Map<DayOfWeek,List<LocalTime>> dates;
    private String title;
    private int age_limit;
    private MovieType type;
    private int length;
    private Integer dimension;

    public Film(){
        dates = new HashMap<>();
        title = null;
        age_limit = 0;
        type = null;
        length = 0;
        dimension = 0;
    }

    public Film(Map<DayOfWeek, List<LocalTime>> d, String tit, int al, MovieType ty, int le, int dim){
        dates = d;
        title = tit;
        age_limit = al;
        type = ty;
        length = le;
        dimension = dim;
    }

    public Map<DayOfWeek,List<LocalTime>> getDates() {
        return dates;
    }

    public String getTitle() {
        return title;
    }

    public int getAgeLimit() {
        return age_limit;
    }

    public MovieType getType() {
        return type;
    }

    public int getLength() {
        return length;
    }

    public Integer getDimension() {
        return dimension;
    }

    //kilistázza hogy parameterkent kapott napon milyen idopontban vetitik a filmet
    public List<LocalTime> getDatesByDay(DayOfWeek day){
        return dates.get(day);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAgeLimit(int age_limit) {
        this.age_limit = age_limit;
    }

    public void setType(MovieType type) {
        this.type = type;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
}