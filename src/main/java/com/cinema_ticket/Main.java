package com.cinema_ticket;

import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cinema_ticket.model.*;
import com.cinema_ticket.service.*;
import com.cinema_ticket.ui.*;

public class Main {
    public static void main(String[] args){
        //mapek
        Map<DayOfWeek, List<LocalTime>> map1 = new HashMap<>();
        List<LocalTime> list1 = new ArrayList<>();
        List<LocalTime> list2 = new ArrayList<>();
        list1.add(LocalTime.of(10,45));
        list1.add(LocalTime.of(11,30));
        list2.add(LocalTime.of(12,30));
        map1.put(DayOfWeek.MONDAY, list1);
        map1.put(DayOfWeek.FRIDAY, list2);


        //*************** */
        List<Film> movies = new ArrayList<>();
        FilmService service = new FilmService(movies);
        service.addFilm(new Film(map1, "Star Wars",12,MovieType.ACTION,120,3));
        service.save();
        SeatsServise seatService = new SeatsServise(1);
        //MainWindow view = new MainWindow(service,seatService);
        Window view = new Window(service, seatService);
    }
}
