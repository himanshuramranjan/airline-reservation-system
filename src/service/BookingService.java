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
    public synchronized Booking bookTicket(Passenger passenger, Flight flight, SeatClass seatClass, int numSeats) {
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

        Booking booking = new Booking(passenger, flight, seatsToBook);
        passenger.addBooking(booking);
        return booking;
    }
}
