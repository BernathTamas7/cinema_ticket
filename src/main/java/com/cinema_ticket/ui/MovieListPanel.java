package com.cinema_ticket.ui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.cinema_ticket.model.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;

public class MovieListPanel extends JPanel {

    private JPanel mainPanel;
    
    public MovieListPanel(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        add(mainPanel);
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
                    newPanel.add(btn);
                }
            }
            mainPanel.add(newPanel);
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void clear() {
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
