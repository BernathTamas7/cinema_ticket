package com.cinema_ticket.repo;
import com.cinema_ticket.model.*;

import com.cinema_ticket.util.LocalTimeAdapter;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.lang.reflect.Type;
import java.time.LocalTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class FilmRepo {

    private static final String SAVE_PATH = "data/films.json";

    public void saveFilms(List<Film> movies){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalTime.class, new LocalTimeAdapter()).create();
        try{
            File file = new File(SAVE_PATH);
            file.getParentFile().mkdirs();
            FileWriter fw = new FileWriter(SAVE_PATH);
            gson.toJson(movies, fw);
            System.out.println("Films saved to " + SAVE_PATH);
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<Film> loadFilms() {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalTime.class, new LocalTimeAdapter()).create();
        Type filmListType = new TypeToken<List<Film>>(){}.getType();
        try {
            FileReader fr = new FileReader(SAVE_PATH);
            List<Film> tmp = gson.fromJson(fr, filmListType);
            fr.close();
            return tmp;
        } catch (Exception e) {
            System.out.println("Could not load films.json, returning empty list.");
            return new ArrayList<>();
        }
    }
}
