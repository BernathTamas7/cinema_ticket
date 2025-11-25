package com.cinema_ticket.model;
import java.util.*;

public class Seats {
    int roomId;
    Seat[][] seats = new Seat[10][10];

    public Seats(int roomId){
        this.roomId = roomId;
        this.seats = new Seat[10][10];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                Seat seat = new Seat();
                seat.setId((i*10+j*1)+1);
                seat.setRow(i+1);
                seat.setColumn(j+1);
                double rnd = Math.random();
                if(rnd < 0.2){
                    seat.setStatus(SeatStatus.RESERVED);
                }else{
                    seat.setStatus(SeatStatus.FREE);
                }
                seats[i][j] = seat;
            }
        }
    }

    public Seat getSeat(int row, int col){
        return seats[row-1][col-1];
    }
}
