package com.cinema_ticket.ui;
import javax.swing.*;
import java.util.List;

import com.cinema_ticket.model.*;
import com.cinema_ticket.service.FilmService;

import java.awt.*;
import java.time.DayOfWeek;
import java.util.ArrayList;

public class MainWindow extends JFrame{
    private final FilmService service;
    public MainWindow(FilmService service){
        //foablak paraméterei
        super("BME_Mozi");
        MovieListPanel movieListPanel = new MovieListPanel();
        this.setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.service = service;

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
        JPanel greetPanel = new JPanel();
        greetPanel.setBackground(Color.ORANGE);
        greetPanel.add(greetCimke);

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

        this.add(movieListPanel,BorderLayout.CENTER);
        this.add(upperPanel,BorderLayout.NORTH);
        this.add(greetPanel,BorderLayout.SOUTH);

        //action listenerek hozzaadasa gombokhoz
        mButton.addActionListener( e -> {
            movieListPanel.showMovies(service.listByDay(DayOfWeek.MONDAY));
            System.out.println("actionlistener" + service.getAllMovies().size());
        });

        tuButton.addActionListener( e -> {
            movieListPanel.showMovies(service.listByDay(DayOfWeek.TUESDAY));
            System.out.println("actionlistener" + service.getAllMovies().size());
        });

        wButton.addActionListener( e -> {
            movieListPanel.showMovies(service.listByDay(DayOfWeek.WEDNESDAY));
            System.out.println("actionlistener" + service.getAllMovies().size());
        });

        thButton.addActionListener( e -> {
            movieListPanel.showMovies(service.listByDay(DayOfWeek.THURSDAY));
            System.out.println("actionlistener" + service.getAllMovies().size());
        });
        
        fButton.addActionListener( e -> {
            movieListPanel.showMovies(service.listByDay(DayOfWeek.FRIDAY));
            System.out.println("actionlistener" + service.getAllMovies().size());
        });

        saButton.addActionListener( e -> {
            movieListPanel.showMovies(service.listByDay(DayOfWeek.SATURDAY));
            System.out.println("actionlistener" + service.getAllMovies().size());
        });

        suButton.addActionListener( e -> {
            movieListPanel.showMovies(service.listByDay(DayOfWeek.SUNDAY));
            System.out.println("actionlistener" + service.getAllMovies().size());
        });

        //jobb oldali combobox létrehozása
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));

        // Tipus alapu szurés
        MovieType[] movieTypes = MovieType.values();
        JComboBox comboBoxType = new JComboBox<>(movieTypes);

        JLabel labelType = new JLabel("Styles");
        eastPanel.add(labelType);
        eastPanel.add(comboBoxType);
        

        comboBoxType.addActionListener(e -> {
            List<Film> sortedMovies = new ArrayList<>();
            for(Film f : service.getAllMovies()){
                if(f.getType().equals(comboBoxType.getSelectedItem())){
                    sortedMovies.add(f);
                }
            }
            movieListPanel.showMovies(sortedMovies);      
        });

        Integer[] dim = new Integer[]{2,3,4};
        JComboBox comboBoxDimension = new JComboBox<>(dim);
        JLabel labelDimension = new JLabel("Dimension");
        eastPanel.add(labelDimension);
        eastPanel.add(comboBoxDimension);
        
        
        comboBoxDimension.addActionListener(e -> {
            List<Film> sortedMovies = new ArrayList<>();
            for(Film f : service.getAllMovies()){
                if(f.getDimension().equals(comboBoxDimension.getSelectedItem())){
                    sortedMovies.add(f);
                }
            }
            movieListPanel.showMovies(sortedMovies);      
        });

        // Cim alapu kereseshez JTextFiled hozzaadasa
        JTextField searchField = new JTextField();
        JLabel labelTitle = new JLabel("Title");
        eastPanel.add(labelTitle);
        searchField.setPreferredSize(new Dimension(150, 75));

        searchField.setMaximumSize(new Dimension(150, 75));
        eastPanel.add(searchField);

        searchField.addActionListener(e -> {
            System.out.println("lefutott");
            String text = searchField.getText();
            List<Film> sortedMovies = new ArrayList<>();
            for(Film f : service.getAllMovies()){
                if(f.getTitle().contains(text)){
                    sortedMovies.add(f);
                }
            }
            movieListPanel.showMovies(sortedMovies);
        });


        
        this.add(eastPanel,BorderLayout.EAST);
        this.setVisible(true);
    }

}
