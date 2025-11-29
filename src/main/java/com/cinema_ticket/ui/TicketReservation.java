package com.cinema_ticket.ui;
import com.cinema_ticket.model.*;
import com.cinema_ticket.service.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TicketReservation extends JPanel{
    private SeatPickPanel seatPickPanel;
    private Window mainWindow;
    private Film movie;
    private List<Seat> seats;
    private int sum;
    private List<JComboBox<TicketType>> comboBoxes;

    private JPanel mainPanel;
    private JLabel sumLabel;
    

    public TicketReservation(Window main, List<Seat> seats){
        super();
        comboBoxes = new ArrayList<>();
        setLayout(new BorderLayout());
        mainWindow = main;
        this.seats = seats;
        mainPanel = new JPanel(new BorderLayout());
        

        this.add(mainPanel);
    }

    public void loadTickets(List<Seat> seats){
        this.seats = seats;
    }

    public void loadFilm(Film movie){
        this.movie = movie;
    }

    public void sumCalculate(){
        sum = 0;
        for(JComboBox<TicketType> item : comboBoxes){
            TicketType tmp = (TicketType) item.getSelectedItem();
            sum += tmp.getPrice();
        }
        sumLabel.setText("sum: "+sum);
    }

    public void rebuild(){
        sum = 0;
        sumLabel = new JLabel("Sum: 0");

        mainPanel.removeAll();
        mainPanel.setLayout(new BorderLayout());

        JPanel upperPanel = new JPanel();
        upperPanel.add(new JLabel("Choosing tickets"));
        mainPanel.add(upperPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        comboBoxes.clear();

        for (Seat seat : seats) {

            JPanel actualPanel = new JPanel();

            JPanel leftActual = new JPanel();
            leftActual.setLayout(new BoxLayout(leftActual, BoxLayout.Y_AXIS));

            JLabel ticketTypeLabel = new JLabel("ADULT");
            leftActual.add(ticketTypeLabel);

            JLabel seatRowColumn = new JLabel(seat.getRow() + " | " + seat.getColumn());
            leftActual.add(seatRowColumn);

            actualPanel.add(leftActual);

            JComboBox<TicketType> comboBox = new JComboBox<>(TicketType.values());
            actualPanel.add(comboBox);

            JLabel priceLabel = new JLabel();
            TicketType selected = (TicketType) comboBox.getSelectedItem();
            priceLabel.setText("" + selected.getPrice());
            actualPanel.add(priceLabel);

            comboBox.addActionListener(e -> {
                TicketType newSelected = (TicketType) comboBox.getSelectedItem();
                ticketTypeLabel.setText(newSelected.name());
                priceLabel.setText("" + newSelected.getPrice());
                sumCalculate();
            });

            comboBoxes.add(comboBox);

            sum += selected.getPrice();
            centerPanel.add(actualPanel);
        }

        JScrollPane scrollPane = new JScrollPane(centerPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel downPanel = new JPanel();
        downPanel.add(sumLabel);
        mainPanel.add(downPanel, BorderLayout.SOUTH);

        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));

        JButton nextButton = new JButton("Continue");

        eastPanel.add(nextButton);
        nextButton.addActionListener(e -> {
            mainWindow.showTicketData(movie, seats);
        });
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainWindow.showSeatPicker(movie));
        eastPanel.add(backButton);

        mainPanel.add(eastPanel, BorderLayout.EAST);

        sumCalculate();
        mainPanel.revalidate();
        mainPanel.repaint();
    }
   
}
