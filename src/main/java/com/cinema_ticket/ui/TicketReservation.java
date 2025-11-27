package com.cinema_ticket.ui;
import com.cinema_ticket.model.*;
import com.cinema_ticket.service.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TicketReservation extends JPanel{
    private SeatPickPanel seatPickPanel;
    private MainWindow mainWindow;
    private Film movie;
    private List<Seat> seats;
    private int sum;

    

    public TicketReservation(MainWindow main){
        super();
        setLayout(new BorderLayout());
        mainWindow = main;
        JLabel upperLabel = new JLabel();
        this.add(upperLabel,BorderLayout.NORTH);

    }

    void loadTickets(List<Seat> seats){
        this.seats = seats;
    }

    void loadFilm(Film movie){
        this.movie = movie;
    }
}
