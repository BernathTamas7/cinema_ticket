package com.cinema_ticket.ui;
import com.cinema_ticket.model.*;
import com.cinema_ticket.service.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import com.cinema_ticket.repo.TicketRepo;

public class TicketData extends JPanel{
    String name;
    String email;
    String phone;
    Film movie;
    List<Seat> seats;
    Window mainWindow;
    JPanel mainPanel;

    public TicketData(Window main){
        super();
        mainWindow = main;
        this.seats = seats;
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(new JLabel("Your datas"),BorderLayout.NORTH);
        
        //name megadasa
        JPanel centerPanel = new JPanel();
        JLabel giveNameLabel = new JLabel("Your name:");
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(giveNameLabel);
        JTextField nameText = new JTextField();
        centerPanel.add(nameText);
        nameText.addActionListener(e -> {
            name = nameText.getText();
        });

        //email megadasa
        JLabel giveEmailLabel = new JLabel("Your email:");
        centerPanel.add(giveEmailLabel);
        JTextField emailText = new JTextField();
        centerPanel.add(emailText);
        emailText.addActionListener(e -> {
            email = emailText.getText();
        });

        //feltetelek elfogadasa
        JCheckBox confirm = new JCheckBox("I will make the purchase");
        centerPanel.add(confirm);
        mainPanel.add(centerPanel,BorderLayout.CENTER);

        //back es finish buying, eastpanel
        JButton backButton = new JButton("back");
        backButton.addActionListener(e -> {
            mainWindow.showTicketReservation(seats, movie);
        });
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
        eastPanel.add(backButton);
        mainPanel.add(eastPanel,BorderLayout.EAST);

        JButton finishButton = new JButton("Finish");
        finishButton.addActionListener(e -> {
            if(confirm.isSelected()){
                JOptionPane.showMessageDialog(this, "Sikeres foglalás!");
                
            }
        });

        this.add(mainPanel);
    }

    public void loadFilm(Film movie){
        this.movie = movie;
    }

    public void loadSeats(List<Seat> seats){
        this.seats = seats;
    }
}
