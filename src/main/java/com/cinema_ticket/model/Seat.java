package com.cinema_ticket.model;

public class Seat {
    private int id;
    private int row;
    private int column;

    public Seat(int id, int row, int column){
        this.id = id;
        this.row = row;
        this.column = column;
    }

    public Seat(){
        this.id = 0;
        this.row = 1;
        this.column = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
