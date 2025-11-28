package com.cinema_ticket.ui;
import com.cinema_ticket.model.*;
import com.cinema_ticket.service.SeatsServise;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SeatPickPanel extends JPanel{
    Film movie;
    Window mainWindow;
    SeatsServise seatService;
    int ticketNumber = 0;
    List<Seat> seats;

    private JLabel titleLabel;
    private JLabel lengthLabel;
    private JLabel ageLabel;
    private JLabel typeLabel;
    private JLabel ticketNumberLabel;
    private JPanel gridPanel;

    public SeatPickPanel(Window main,SeatsServise s){
        seats = new ArrayList<>();
        seatService = s;
        mainWindow = main;
        setLayout(new BorderLayout());

        //also panel letrehozasa
        JPanel downPanel = new JPanel();
        //also panelhez jegy kep hozzaadasa
        ImageIcon image = new ImageIcon("data/jegy_kep.png");
        Image scaled_2 = image.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH);
        JLabel imageLabel_2 = new JLabel(new ImageIcon(scaled_2));
        imageLabel_2.setPreferredSize(new Dimension(60, 45));
        downPanel.add(imageLabel_2);
        ticketNumberLabel = new JLabel("0");
        downPanel.add(ticketNumberLabel);

        
        //labelek inicializalasa
        titleLabel = new JLabel();
        lengthLabel = new JLabel();
        ageLabel = new JLabel();
        typeLabel = new JLabel();

        //baloldali panel keszitese es film tartalmának kiirasa
        JPanel westPanel = new JPanel(new GridLayout(6, 1));
        westPanel.add(titleLabel);
        westPanel.add(lengthLabel);
        westPanel.add(ageLabel);
        westPanel.add(typeLabel);

        gridPanel = new JPanel(new GridLayout(10,10));
        

        //felso panel letrehozasa es kep beszurasa es meretezese
        ImageIcon icon = new ImageIcon("data/vaszon_kep.png");
        Image scaled = icon.getImage().getScaledInstance(800, 80, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaled));
        imageLabel.setPreferredSize(new Dimension(800, 80));
        JPanel upperPanel = new JPanel();
        upperPanel.add(imageLabel);

        //jobb oldali panel elkeszitese, gombok rarakasa
        JPanel eastPanel = new JPanel(new GridLayout(2, 1));
        JButton backButton = new JButton("Back");
        JButton confirmButton = new JButton("Confirm");
        backButton.addActionListener(e -> {
            mainWindow.showMainPanel();
        });
        confirmButton.addActionListener(e -> {
            mainWindow.showTicketReservation(seats, movie);
            System.out.println(seats.size());
        });
        eastPanel.add(backButton);
        eastPanel.add(confirmButton);


        //panelek fopanelhez adasa
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(downPanel, BorderLayout.SOUTH);
        this.add(upperPanel, BorderLayout.NORTH);
        this.add(gridPanel, BorderLayout.CENTER);
    }

    public void loadFilm(Film m) {
        this.movie = m;

        titleLabel.setText("<html><p width='100'>" + movie.getTitle() + "</p></html>");
        lengthLabel.setText(movie.getLength() + " minutes");
        ageLabel.setText("age limit: " + movie.getAgeLimit());
        typeLabel.setText("type: " + movie.getType());
        rebuildSeats();
    }

    public void rebuildSeats(){
        seats.clear();
        ticketNumber = 0;
        ticketNumberLabel.setText("0");
        gridPanel.removeAll();

        for(int i = 1; i < 11; i++){
            for(int j = 1; j < 11; j++){
                JButton button = new JButton();
                if(seatService.getSeats().getSeat(i, j).getStatus().equals(SeatStatus.RESERVED)){
                    button.setBackground(Color.GRAY);
                }else{
                    button.setBackground(Color.GREEN);
                }
                button.putClientProperty("row", i);
                button.putClientProperty("col", j);
                button.addActionListener(e ->{
                JButton tmp = (JButton) e.getSource();
                int row = (int) tmp.getClientProperty("row");
                int col = (int) tmp.getClientProperty("col");

                if(tmp.getBackground().equals(Color.GREEN)){
                    tmp.setBackground(Color.BLUE);
                    ticketNumber++;

                    Random rand = new Random();
                    int x = rand.nextInt(10000);

                    Seat seat = new Seat(x, row, col, SeatStatus.PICKED);
                    seats.add(seat);
                }
                else if(tmp.getBackground().equals(Color.BLUE)){
                    tmp.setBackground(Color.GREEN);
                    ticketNumber--;

                    seats.removeIf(s -> s.getRow() == row && s.getColumn() == col);
                }

                    ticketNumberLabel.setText("" + ticketNumber);
                });
                gridPanel.add(button);
            }
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }
}
