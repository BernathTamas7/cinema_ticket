package com.cinema_ticket.ui;
import com.cinema_ticket.model.*;
import com.cinema_ticket.service.SeatsServise;
import javax.swing.*;
import java.awt.*;

public class SeatPickPanel extends JFrame{
    Film movie;
    SeatsServise seatService;
    int ticketNumber = 0;
    public SeatPickPanel(SeatsServise s){
        super("Seat_Pick");
        seatService = s;
        this.setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //also panel letrehozasa
        JPanel downPanel = new JPanel();
        //also panelhez jegy kep hozzaadasa
        ImageIcon image = new ImageIcon("data/jegy_kep.png");
        Image scaled_2 = image.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH);
        JLabel imageLabel_2 = new JLabel(new ImageIcon(scaled_2));
        imageLabel_2.setPreferredSize(new Dimension(60, 45));
        downPanel.add(imageLabel_2);

        //jegyszamlalo letrehozasa es also panelhez adasa
        String printOut = "" + ticketNumber;
        JLabel ticketNumberLabel = new JLabel(printOut);
        downPanel.add(ticketNumberLabel);

        JPanel gridPanel = new JPanel(new GridLayout(10,10));
        for(int i = 1; i < 11; i++){
            for(int j = 1; j < 11; j++){
                JButton button = new JButton();
                if(seatService.getSeats().getSeat(i, j).getStatus().equals(SeatStatus.RESERVED)){
                    button.setBackground(Color.GRAY);
                }else{
                    button.setBackground(Color.GREEN);
                }
                button.addActionListener(e ->{
                    JButton tmp = (JButton) e.getSource();
                    if(tmp.getBackground().equals(Color.GREEN)){
                        tmp.setBackground(Color.BLUE);
                        ticketNumber++;
                    }
                    else if(tmp.getBackground().equals(Color.BLUE)){
                        tmp.setBackground(Color.GREEN);
                        ticketNumber--;
                    }
                    ticketNumberLabel.setText(""+ticketNumber);
                });
                gridPanel.add(button);
            }
        }

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
        eastPanel.add(backButton);
        eastPanel.add(confirmButton);

        
        
        


        this.add(eastPanel, BorderLayout.EAST);
        this.add(downPanel, BorderLayout.SOUTH);
        this.add(upperPanel, BorderLayout.NORTH);
        this.add(gridPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
