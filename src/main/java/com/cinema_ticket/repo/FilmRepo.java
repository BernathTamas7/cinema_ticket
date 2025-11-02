package com.cinema_ticket.repo;
import java.util.*;
import java.nio.file.*;

import com.cinema_ticket.modell.Film;

import java.io.*;

public class FilmRepo {
    private String fileName = "cinema_repo";
    File file = new File("data/cinema_repo.txt");
    

    public void save(ArrayList<Film> tmp){
       try{
        Files.createDirectories(Paths.get("data"));
         ObjectOutputStream ou = new ObjectOutputStream(new FileOutputStream(file));
         ou.writeObject(tmp);
         ou.close();
         System.out.println("Filmek kimentve");
       }catch(Exception e){
        e.printStackTrace();
       }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Film> load(){
        try{
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream(file));
            ArrayList<Film> mov =(ArrayList<Film>) oi.readObject();
            oi.close();
            return mov;
            
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
