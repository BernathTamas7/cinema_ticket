package com.cinema_ticket.service;
import com.cinema_ticket.model.*;
import com.cinema_ticket.repo.FilmRepo;

import java.time.DayOfWeek;
import java.util.*;

public class FilmService {
    private List<Film> movies = new ArrayList<>();
    private FilmRepo repo = new FilmRepo();


    public FilmService(List<Film> movies){
        this.movies = movies;
    }

    public FilmService(){
        this.movies = new ArrayList<>();
        repo = new FilmRepo();
    }

    public List<Film> getAllMovies(){
        return movies;
    }

    public void setMovies(List<Film> movies){
        this.movies = movies;
    }

    public void addFilm(Film movie){
        movies.add(movie);
    }

    public void removeByName(String name){
        movies.removeIf(f -> f.getTitle().equals(name));
    }

    public List<Film> filterByNames(String param){
        List<Film> newList = new ArrayList<>();
        for(Film f : movies){
            if(f.getTitle().contains(param)){
                newList.add(f);
            }
        }
        return newList;
    }

    public List<Film> listByDay(DayOfWeek day){
        List<Film> newList = new ArrayList<>();
        for(Film f : movies){
            if(f.getDatesByDay(day) != null){
                newList.add(f);
            }
        }
        return newList;
    }

    public List<Film> listByName(String param){
        List<Film> newList = new ArrayList<>();
        for(Film f : movies){
            if(f.getTitle().equals(param)){
                newList.add(f);
            }
        }
        return newList;
    }

    public List<Film> filterByType(MovieType type){
        List<Film> newList = new ArrayList<>();
        for(Film f : movies){
            if(f.getType().equals(type)){
                newList.add(f);
            }
        }
        return newList;
    }

    public void save(){
        repo.saveFilms(movies);
    }

    public void load(){
        movies = repo.loadFilms();
    }

    public void removeAll(){
        movies.clear();
    }
}
