package models;

import enums.BookingStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Booking {
    private final String bookingId;
    private final List<Passenger> passengers;
    private final Flight flight;
    private final List<Seat> seats;
    private final LocalDateTime bookingTime;
    private BookingStatus status;

    public Booking(List<Passenger> passengers, Flight flight, List<Seat> seats) {
        this.bookingId = UUID.randomUUID().toString();
        this.passengers = passengers;
        this.flight = flight;
        this.seats = seats;
        this.status = BookingStatus.CONFIRMED;
        this.bookingTime = LocalDateTime.now();
    }

    public void cancel() {
        for(Seat seat : seats) seat.release();
        this.status = BookingStatus.CANCELLED;
    }

    public String getBookingId() {
        return bookingId;
    }

    public List<Passenger> getPassenger() {
        return passengers;
    }

    public Flight getFlight() {
        return flight;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public BookingStatus getStatus() {
        return status;
    }
}
