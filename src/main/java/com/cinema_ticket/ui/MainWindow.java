package com.cinema_ticket.ui;
import javax.swing.*;
import java.util.List;

import com.cinema_ticket.model.*;
import com.cinema_ticket.service.FilmService;
import com.cinema_ticket.service.SeatsServise;

import java.awt.*;
import java.time.DayOfWeek;
import java.util.ArrayList;

public class MainWindow extends JFrame{
    private final FilmService service;
    private final SeatsServise seatService;
    public MovieListPanel movieListPanel;
    public SeatPickPanel seatPickPanel;

    public JPanel eastPanel;
    public JPanel upperPanel;
    public JPanel greetPanel;
    
    public JPanel centerPanel;
    public MainWindow(FilmService service, SeatsServise seatsServise){
        //foablak paraméterei
        super("BME_Mozi");
        this.service = service;
        this.seatService = seatsServise;

        //center panel letrehozasa
        centerPanel = new JPanel(new BorderLayout());

        //attributumok inicializalasa
        movieListPanel = new MovieListPanel(this, service); 
        seatPickPanel = new SeatPickPanel(this, seatService);
        
        //meret 
        this.setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //kep meretezese és beszurasa
        ImageIcon image = new ImageIcon("data/mozi_kep.png");
        Image scaled = image.getImage().getScaledInstance(120, 80, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaled));
        imageLabel.setPreferredSize(new Dimension(120, 80));
        
        //-----------------------------------------
        
        //het napjainak gombjai
        JButton mButton = new JButton("Monday");
        JButton tuButton = new JButton("Tuesday");
        JButton wButton = new JButton("Wednesday");
        JButton thButton = new JButton("Thursday");
        JButton fButton = new JButton("Friday");
        JButton saButton = new JButton("Saturday");
        JButton suButton = new JButton("Sunday");

        //Udvozlo cimke letrehozasa
        JLabel greetCimke = new JLabel("Udvozollek a mozi weboldalan");
        greetPanel = new JPanel();
        greetPanel.setBackground(Color.ORANGE);
        greetPanel.add(greetCimke);

        //nap panel létrehozása, gombok hozzáadása
        upperPanel = new JPanel(new GridLayout(1,8));
        upperPanel.add(imageLabel);
        upperPanel.add(mButton);
        upperPanel.add(tuButton);
        upperPanel.add(wButton);
        upperPanel.add(thButton);
        upperPanel.add(fButton);
        upperPanel.add(saButton);
        upperPanel.add(suButton);

        centerPanel.add(movieListPanel, BorderLayout.CENTER);
        this.add(upperPanel,BorderLayout.NORTH);
        this.add(greetPanel,BorderLayout.SOUTH);
        this.add(centerPanel);
        

        //action listenerek hozzaadasa gombokhoz
        mButton.addActionListener( e -> {
            movieListPanel.clear();
            movieListPanel.showMovies(service.listByDay(DayOfWeek.MONDAY),DayOfWeek.MONDAY);
        });

        tuButton.addActionListener( e -> {
            movieListPanel.clear();
            movieListPanel.showMovies(service.listByDay(DayOfWeek.TUESDAY),DayOfWeek.TUESDAY);
        });

        wButton.addActionListener( e -> {
            movieListPanel.clear();
            movieListPanel.showMovies(service.listByDay(DayOfWeek.WEDNESDAY),DayOfWeek.WEDNESDAY);
        });

        thButton.addActionListener( e -> {
            movieListPanel.clear();
            movieListPanel.showMovies(service.listByDay(DayOfWeek.THURSDAY),DayOfWeek.THURSDAY);
        });
        
        fButton.addActionListener( e -> {
            movieListPanel.clear();
            movieListPanel.showMovies(service.listByDay(DayOfWeek.FRIDAY),DayOfWeek.FRIDAY);
        });

        saButton.addActionListener( e -> {
            movieListPanel.clear();
            movieListPanel.showMovies(service.listByDay(DayOfWeek.SATURDAY), DayOfWeek.SATURDAY);
        });

        suButton.addActionListener( e -> {
            movieListPanel.clear();
            movieListPanel.showMovies(service.listByDay(DayOfWeek.SUNDAY),DayOfWeek.SUNDAY);
        });

        //jobb oldali combobox létrehozása
        eastPanel = new JPanel();
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));

        // Tipus alapu szurés
        MovieType[] movieTypes = MovieType.values();
        JComboBox comboBoxType = new JComboBox<>(movieTypes);

        JLabel labelType = new JLabel("Styles");
        eastPanel.add(labelType);
        eastPanel.add(comboBoxType);
        
        //listázás movie Type alapjan
        comboBoxType.addActionListener(e -> {
            movieListPanel.clear();
            for(DayOfWeek day : DayOfWeek.values()){
                List<Film> sortedMovies = new ArrayList<>();
                for(Film f : service.getAllMovies()){
                    if(f.getType().equals(comboBoxType.getSelectedItem())){
                        sortedMovies.add(f);
                    }
                }
                movieListPanel.showMovies(sortedMovies,day); 
            } 
        });
        
        Integer[] dim = new Integer[]{2,3,4};
        JComboBox comboBoxDimension = new JComboBox<>(dim);
        JLabel labelDimension = new JLabel("Dimension");
        eastPanel.add(labelDimension);
        eastPanel.add(comboBoxDimension);
        
        //dimenzio alapu kereses
        comboBoxDimension.addActionListener(e -> {
            movieListPanel.clear();
            for(DayOfWeek day : DayOfWeek.values()){
                List<Film> sortedMovies = new ArrayList<>();
                for(Film f : service.getAllMovies()){
                    if(f.getDimension().equals(comboBoxDimension.getSelectedItem())){
                        sortedMovies.add(f);
                    }
                }
                movieListPanel.showMovies(sortedMovies,day); 
            }     
        });

        // Cim alapu kereseshez JTextFiled hozzaadasa
        JTextField searchField = new JTextField();
        JLabel labelTitle = new JLabel("Title");
        eastPanel.add(labelTitle);
        searchField.setPreferredSize(new Dimension(150, 75));

        searchField.setMaximumSize(new Dimension(150, 75));
        eastPanel.add(searchField);

        searchField.addActionListener(e -> {
            movieListPanel.clear();
            for(DayOfWeek day : DayOfWeek.values()){
                List<Film> sortedMovies = new ArrayList<>();
                for(Film f : service.getAllMovies()){
                    if(f.getTitle().contains(searchField.getText())){
                        sortedMovies.add(f);
                    }
                }
                movieListPanel.showMovies(sortedMovies,day); 
            }   
        });
        
        this.add(eastPanel,BorderLayout.EAST);
        this.setVisible(true);
    }

    public void switchView(JPanel newPanel){
        centerPanel.removeAll();
        centerPanel.add(newPanel, BorderLayout.CENTER);
        boolean isList = (newPanel == movieListPanel);

        upperPanel.setVisible(isList);
        eastPanel.setVisible(isList);
        greetPanel.setVisible(isList);

        centerPanel.revalidate();
        centerPanel.repaint();
    }
}
