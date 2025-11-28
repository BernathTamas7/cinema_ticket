package com.cinema_ticket.ui;
import javax.swing.*;
import java.util.List;

import com.cinema_ticket.model.*;
import com.cinema_ticket.service.FilmService;
import com.cinema_ticket.service.SeatsServise;

import java.awt.*;
import java.time.DayOfWeek;
import java.util.ArrayList;

public class Window extends JFrame implements ScreenNavigator{
    private CardLayout layout;
    private JPanel cards;
    private FilmService service;

    private JPanel mainMenuCard;
    public MovieListPanel movieListPanel;
    public SeatPickPanel seatPickPanel;
    public TicketReservation ticketReservation;

    public Window(FilmService filmService, SeatsServise seatsServise){
        this.setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        service = filmService;
        movieListPanel = new MovieListPanel(this, service);
        layout = new CardLayout();
        cards = new JPanel(layout);

        mainMenuCard = new JPanel(new BorderLayout());

        ticketReservation = new TicketReservation(this, new ArrayList<>());

        //Udvozlo cimke letrehozasa
        JLabel greetCimke = new JLabel("Udvozollek a mozi weboldalan");
        JPanel greetPanel = new JPanel();
        greetPanel.setBackground(Color.ORANGE);
        greetPanel.add(greetCimke);
        mainMenuCard.add(greetPanel, BorderLayout.SOUTH);

        //kep beszurasa es meretezese
        ImageIcon image = new ImageIcon("data/mozi_kep.png");
        Image scaled = image.getImage().getScaledInstance(120, 80, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaled));
        imageLabel.setPreferredSize(new Dimension(120, 80));

        //het napjainak gombjai
        JButton mButton = new JButton("Monday");
        JButton tuButton = new JButton("Tuesday");
        JButton wButton = new JButton("Wednesday");
        JButton thButton = new JButton("Thursday");
        JButton fButton = new JButton("Friday");
        JButton saButton = new JButton("Saturday");
        JButton suButton = new JButton("Sunday");

        //nap panel létrehozása, gombok hozzáadása
        JPanel upperPanel = new JPanel(new GridLayout(1,8));
        upperPanel.add(imageLabel);
        upperPanel.add(mButton);
        upperPanel.add(tuButton);
        upperPanel.add(wButton);
        upperPanel.add(thButton);
        upperPanel.add(fButton);
        upperPanel.add(saButton);
        upperPanel.add(suButton);

        mainMenuCard.add(upperPanel, BorderLayout.NORTH);

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

        //jobboldali panel letrehozasa
        JPanel eastPanel = new JPanel();
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

        //Dimenzio alapu szures
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

        searchField.addActionListener(e -> {
            movieListPanel.clear();
            for(DayOfWeek day : DayOfWeek.values()){
                List<Film> sortedMovies = new ArrayList<>();
                for(Film f : service.getAllMovies()){
                    if(f.getTitle().toLowerCase().contains(searchField.getText().toLowerCase())){
                        sortedMovies.add(f);
                    }
                }
                movieListPanel.showMovies(sortedMovies,day); 
            }   
        });

        eastPanel.add(searchField);
        mainMenuCard.add(eastPanel, BorderLayout.EAST);
        mainMenuCard.add(movieListPanel, BorderLayout.CENTER);

        seatPickPanel = new SeatPickPanel(this, seatsServise);

        cards.add(mainMenuCard, "MainMenuCard");
        cards.add(seatPickPanel, "SeatPickPanel");
        cards.add(ticketReservation, "TicketReservation");

        add(cards);
        setSize(800,600);
        setVisible(true);
        showMainPanel();
    }

    /*public void showMovieList() {
        layout.show(cards, "MovieListPanel");
    }*/

    public void showSeatPicker(Film f) {
        seatPickPanel.loadFilm(f);
        layout.show(cards, "SeatPickPanel");
    }

    public void showMainPanel(){
        layout.show(cards, "MainMenuCard");
    }

    public void showTicketReservation(List<Seat> seats, Film film){
        ticketReservation.loadFilm(film);
        ticketReservation.loadTickets(seats);
        ticketReservation.rebuild();
        layout.show(cards, "TicketReservation");
    }
}
