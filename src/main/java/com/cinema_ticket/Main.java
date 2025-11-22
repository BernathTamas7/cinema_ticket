package com.cinema_ticket;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.cinema_ticket.model.Film;
import com.cinema_ticket.repo.FilmRepo;
import com.cinema_ticket.service.FilmService;
import com.cinema_ticket.ui.Foablak;

public class Main {
    public static void main(String[] args){
        List<Film> movies = new ArrayList<>();
        FilmService service = new FilmService(movies);
        List<LocalTime> lista = new ArrayList<>();
        lista.add(LocalTime.now());
        service.addFilm(new Film(DayOfWeek.MONDAY, lista, "Star Wars",12,"sci-fi",120,3));
        service.save();
    }
}
