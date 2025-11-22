package com.cinema_ticket.model;

public class Ticket {
    TicketType type;
    int price;
    Film movie;

    public Ticket(TicketType type, Film movie){
        this.type = type;
        this.price = type.getPrice();
        this.movie = movie;
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
}
