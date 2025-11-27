package com.cinema_ticket.model;

import java.io.Serializable;
import java.util.*;

public class Ticket implements Serializable{
    private String name;
    private TicketType type;
    private int price;
    private Film movie;
    private List<Seat> seats = new ArrayList<>();

    public Ticket(TicketType type, Film movie, List<Seat> seats){
        this.type = type;
        this.price = type.getPrice();
        this.movie = movie;
        this.seats = seats;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
        this.price = type.getPrice();
    }

    public int getPrice() {
        return price;
    }

    public Film getMovie() {
        return movie;
    }

    public void setMovie(Film movie) {
        this.movie = movie;
    }

    public List<Seat> getSeat(){
        return this.seats;
    }

    public void setSeat(List<Seat> seat){
        this.seats = seat;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}
