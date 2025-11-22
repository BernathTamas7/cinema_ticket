package com.cinema_ticket.ui;
import javax.swing.*;
import java.time.*;

import com.cinema_ticket.model.Film;
import com.cinema_ticket.service.FilmService;

import java.awt.*;
import java.util.ArrayList;

public class Foablak extends JFrame{
    public Foablak(){
        //foablak paraméterei
        super("BME_Mozi");
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

        //cimkek letrehozasa
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

        this.add(upperPanel,BorderLayout.NORTH);
        this.add(greetPanel,BorderLayout.SOUTH);

        this.setVisible(true);
    }

}
