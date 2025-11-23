package com.cinema_ticket.model;

import java.io.Serializable;

public class Ticket implements Serializable{
    TicketType type;
    int price;
    Film movie;
    Seat seat;

    public Ticket(TicketType type, Film movie, Seat seat){
        this.type = type;
        this.price = type.getPrice();
        this.movie = movie;
        this.seat = seat;
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

    public Seat getSeat(){
        return this.seat;
    }

    public void setSeat(Seat seat){
        this.seat = seat;
    }
}
