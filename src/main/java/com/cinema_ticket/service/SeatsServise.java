package com.cinema_ticket.service;
import com.cinema_ticket.model.*;

public class SeatsServise {
    int id;
    Seats seats;
    public SeatsServise(int id){
        seats = new Seats(id);
        this.id = id;
    }

    public Seats getSeats(){
        return seats;
    }
}
