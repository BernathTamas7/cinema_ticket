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
        service.addFilm(new Film(DayOfWeek.MONDAY, lista, "Star Wars", 12, MovieType.ACTION, 120, 3));
        service.addFilm(new Film(DayOfWeek.TUESDAY, lista, "The Matrix", 16, MovieType.SCI_FI, 136, 2));
        service.addFilm(new Film(DayOfWeek.WEDNESDAY, lista, "Inception", 12, MovieType.SCI_FI, 148, 3));
        service.addFilm(new Film(DayOfWeek.THURSDAY, lista, "Frozen", 6, MovieType.ANIMATION, 102, 2));
        service.addFilm(new Film(DayOfWeek.FRIDAY, lista, "The Dark Knight", 16, MovieType.ACTION, 152, 2));
        service.addFilm(new Film(DayOfWeek.SATURDAY, lista, "Titanic", 12, MovieType.DRAMA, 195, 2));
        service.addFilm(new Film(DayOfWeek.SUNDAY, lista, "The Conjuring", 18, MovieType.HORROR, 112, 2));
        service.addFilm(new Film(DayOfWeek.MONDAY, lista, "Interstellar", 12, MovieType.SCI_FI, 169, 2));
        service.addFilm(new Film(DayOfWeek.TUESDAY, lista, "Shrek", 6, MovieType.ANIMATION, 90, 2));
        service.addFilm(new Film(DayOfWeek.WEDNESDAY, lista, "Gladiator", 16, MovieType.ACTION, 155, 2));
        service.addFilm(new Film(DayOfWeek.THURSDAY, lista, "Avengers: Endgame", 12, MovieType.ACTION, 181, 3));
        service.addFilm(new Film(DayOfWeek.FRIDAY, lista, "Joker", 18, MovieType.DRAMA, 122, 2));
        service.addFilm(new Film(DayOfWeek.SATURDAY, lista, "Guardians of the Galaxy", 12, MovieType.ACTION, 121, 3));
        service.addFilm(new Film(DayOfWeek.SUNDAY, lista, "IT", 16, MovieType.HORROR, 135, 2));
        service.addFilm(new Film(DayOfWeek.MONDAY, lista, "Avatar", 12, MovieType.SCI_FI, 162, 3));
        service.save();
        SeatsServise seatsServise = new SeatsServise(0);
        //SeatPickPanel panel = new SeatPickPanel(seatsServise, new Film(DayOfWeek.MONDAY, lista, "Star wars 3: The revenge of the siths",12,MovieType.ACTION,120,3));
        MainWindow view = new MainWindow(service);
        
    }
}
