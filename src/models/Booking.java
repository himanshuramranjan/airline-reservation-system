package models;

import enums.BookingStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Booking {
    private final String bookingId;
    private final Passenger passenger;
    private final Flight flight;
    private final List<Seat> seats;
    private final LocalDateTime bookingTime;
    private BookingStatus status;

    public Booking(Passenger passenger, Flight flight, List<Seat> seats) {
        this.bookingId = UUID.randomUUID().toString();
        this.passenger = passenger;
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

    public Passenger getPassenger() {
        return passenger;
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
