package com.cinema_ticket;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.cinema_ticket.model.*;
import com.cinema_ticket.service.*;
import com.cinema_ticket.ui.*;

public class Main {
    public static void main(String[] args){
        List<Film> movies = new ArrayList<>();
        FilmService service = new FilmService(movies);
        List<LocalTime> lista = new ArrayList<>();
        lista.add(LocalTime.now());
        service.addFilm(new Film(DayOfWeek.MONDAY, lista, "Star Wars",12,MovieType.ACTION,120,3));
        service.addFilm(new Film(DayOfWeek.WEDNESDAY, lista, "Zootopia 2",12,MovieType.ANIMATION,90,2));
        service.save();
        MainWindow view = new MainWindow(service);
        
    }
}
