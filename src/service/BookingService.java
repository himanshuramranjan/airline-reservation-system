package service;

import enums.SeatClass;
import models.Booking;
import models.Flight;
import models.Passenger;
import models.Seat;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookingService {
    public synchronized Booking bookTicket(List<Passenger> passengers, Flight flight, SeatClass seatClass, int numSeats) {
        List<Seat> availableSeats = flight.getAvailableSeats(seatClass);
        if(availableSeats.size() < numSeats) return null;

        List<Seat> seatsToBook = new ArrayList<>();
        for (int i = 0; i < numSeats; i++) {
            Seat seat = availableSeats.get(i);
            if (seat.book()) seatsToBook.add(seat);
        }

//      If even one seat fails to book, release all previously booked ones (rollback).
        if (seatsToBook.size() != numSeats) {
            for (Seat s : seatsToBook) s.release();
            return null;
        }

        return new Booking(passengers, flight, seatsToBook);
    }
}
