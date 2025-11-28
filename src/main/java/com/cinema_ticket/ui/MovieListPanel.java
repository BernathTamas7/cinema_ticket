package com.cinema_ticket.ui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.cinema_ticket.model.*;
import com.cinema_ticket.service.FilmService;

import java.awt.BorderLayout;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;

public class MovieListPanel extends JPanel {
    private Window window;
    private FilmService service;

    private JPanel mainPanel;
    private JPanel centerPanel;
    private JPanel eastPanel;
    private JPanel upperPanel;
    private JPanel greetPanel;
    
    public MovieListPanel(Window window, FilmService service) {
        this.window = window;
        this.service = service;
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
    
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        this.add(mainPanel,BorderLayout.CENTER);
    }


    public void showMovies(List<Film> movies, DayOfWeek day){
        for(Film film : movies){
            List<LocalTime> times = film.getDates().get(day);
            if (times == null || times.isEmpty()) {
                continue;
            }
            JPanel newPanel = new JPanel();     
            newPanel.add(new JLabel("<html>" + "Title: " + film.getTitle() + "<br>"+ "Length: " + film.getLength() + "<br>"+ "Age limit: " + film.getAgeLimit()+ "<br>" + "Type: " + film.getType() + "</html>"));
            if(film.getDates().get(day) != null){
                for(int i = 0;i < film.getDates().get(day).size(); i++){
                    JButton btn = new JButton(""+film.getDates().get(day).get(i));
                    btn.addActionListener(e -> {
                        window.seatPickPanel.loadFilm(film);
                        window.showSeatPicker(film);
                    });
                    newPanel.add(btn);
                }
            }
            centerPanel.add(newPanel);
        }
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    public void clear() {
        centerPanel.removeAll();
        centerPanel.revalidate();
        centerPanel.repaint();
    }
}
