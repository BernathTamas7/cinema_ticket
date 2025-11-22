package com.cinema_ticket.model;

public enum TicketType {
    ADULT(3000),
    STUDENT(2000),
    CHILD(1000),
    PENSIONER(1500);

    private final int price;

    TicketType(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

}
