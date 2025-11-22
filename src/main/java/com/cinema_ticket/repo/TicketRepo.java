package com.cinema_ticket.repo;
import com.cinema_ticket.model.*;
import com.cinema_ticket.util.LocalTimeAdapter;

import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class TicketRepo {
    private static final String SAVE_PATH = "data/ticket.json";

    public void save(Ticket ticket){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalTime.class, new LocalTimeAdapter()).create();
        try{
            FileWriter fw = new FileWriter(SAVE_PATH);
            System.out.println("Tickets saved to " + SAVE_PATH);
            gson.toJson(ticket,fw);
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Ticket load(){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalTime.class, new LocalTimeAdapter()).create();
        try{
            FileReader fr = new FileReader(SAVE_PATH);
            Ticket tmp = gson.fromJson(fr, Ticket.class);
            fr.close();
            return tmp;
        }catch(Exception e){
            System.out.println("Could not load ticket.json, returning null.");
            return null;
        }
    }
}
