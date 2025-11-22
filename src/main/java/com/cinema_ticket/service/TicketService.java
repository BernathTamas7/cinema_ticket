package com.cinema_ticket.service;
import com.cinema_ticket.model.*;
import com.cinema_ticket.repo.TicketRepo;

import java.time.DayOfWeek;
import java.util.*;

public class TicketService {
    private Ticket ticket;
    private TicketRepo repo = new TicketRepo();

    public void save(){
        repo.save(ticket);
    }

    public void load(){
        ticket = repo.load();
    }

    public void printTicket(){
        System.out.println("Title: " +  ticket.getMovie().getTitle());
        System.out.println("movie type: " +  ticket.getMovie().getType());
        System.out.println("price: " +  ticket.getPrice());
        System.out.println("seat: " +  ticket.getSeat());
        System.out.println("ticket type: " +  ticket.getType());
    }
}
