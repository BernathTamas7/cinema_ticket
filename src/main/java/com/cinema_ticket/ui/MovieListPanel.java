package com.cinema_ticket.ui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.cinema_ticket.model.*;

import java.util.*;

public class MovieListPanel extends JPanel {

    private JPanel mainPanel;
    
    public MovieListPanel(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        add(mainPanel);
    }

    public void showMovies(List<Film> movies){
        mainPanel.removeAll();
        for(Film film : movies){
            JPanel newPanel = new JPanel();
            newPanel.add(new JLabel("<html>" + "Title: " + film.getTitle() + "<br>"+ "Length: " + film.getLength() + "<br>"+ "Age limit: " + film.getAgeLimit()+ "<br>" + "Type: " + film.getType() + "</html>"));
            JButton btn = new JButton("reservation");
            newPanel.add(btn);
            mainPanel.add(newPanel);
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
