package com.cinema_ticket.model;
import java.util.*;

public class Seats {
    int roomId;
    Seat[][] seats = new Seat[10][10];

    public Seats(int roomId){
        this.roomId = roomId;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                seats[i][j].setId((i*10+j*1)+1);
                seats[i][j].setRow(i+1);
                seats[i][j].setColumn(j+1);
                double rnd = Math.random();
                if(rnd < 0.2){
                    seats[i][j].setStatus(SeatStatus.RESERVED);
                }else{
                    seats[i][j].setStatus(SeatStatus.FREE);
                }
                
            }
        }
    }

    public Seat getSeat(int row, int col){
        return seats[row-1][col-1];
    }
}
