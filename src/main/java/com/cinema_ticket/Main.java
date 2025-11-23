package com.cinema_ticket;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Paths;
import com.cinema_ticket.model.Film;
import com.cinema_ticket.model.Seat;
import com.cinema_ticket.model.Ticket;
import com.cinema_ticket.model.TicketType;
import com.cinema_ticket.repo.FilmRepo;
import com.cinema_ticket.service.FilmService;
import com.cinema_ticket.service.TicketService;
import com.cinema_ticket.ui.Foablak;

public class Main {
    public static void main(String[] args){
        List<Film> movies = new ArrayList<>();
        FilmService service = new FilmService(movies);
        List<LocalTime> lista = new ArrayList<>();
        lista.add(LocalTime.now());
        service.addFilm(new Film(DayOfWeek.MONDAY, lista, "Star Wars",12,"sci-fi",120,3));
        service.save();

        Ticket uj = new Ticket(TicketType.ADULT, new Film(DayOfWeek.MONDAY, lista, "Star Wars",12,"sci-fi",120,3), new Seat(0, 1, 1));
        TicketService ticketService = new TicketService(uj);
        ticketService.save();
        ticketService.delete();
        ticketService.printTicket();
        
    }
}
