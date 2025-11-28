package com.cinema_ticket.ui;
import com.cinema_ticket.model.*;
import java.util.List;

public interface ScreenNavigator {
    void showMainPanel();
    void showSeatPicker(Film film);
    void showTicketReservation(List<Seat> seats, Film film);
}
