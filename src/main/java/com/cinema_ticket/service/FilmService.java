package com.cinema_ticket.service;
import com.cinema_ticket.modell.Film;
import com.cinema_ticket.repo.*;


import java.util.ArrayList;

public class FilmService {
    private FilmRepo repo = new FilmRepo();
    private ArrayList<Film> movies = new ArrayList<>();

    public FilmService(ArrayList<Film> tmp){
        movies = tmp;
    }

    public FilmService(){
        movies = new ArrayList<>();
    }

    public void addMovie Cl(Film movie){
        movies.add(movie);
    }

    public ArrayList<Film> getMovies(){
        return movies;
    }

    public void removeFilm(String nev){
       movies.removeIf((film)->film.getTitle().equals(nev));
    }

    public void removeFilm(int index){
        movies.remove(index);
    }

    public Film searchFilm(String nev){
        for(int i = 0; i < movies.size(); i++){
            if(movies.get(i).getTitle().equals(nev)){
                return movies.get(i);
            }
        }
        return null;
    }
    
    public void saveAll(){
        repo.save(movies);
    }

    public void loadAll(){
        movies = repo.load();
    }

    public void filmPrintToLabel(Film tmp){
        System.out.println(tmp.getTitle());
        System.out.println(tmp.getAgeLimit() + " | " + tmp.getType() + " | " + tmp.getLength());
        System.out.println(tmp.getDimension());
    }
}
