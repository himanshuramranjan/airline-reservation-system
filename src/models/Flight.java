package models;

import enums.SeatClass;
import enums.SeatStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Flight {
    private final String flightNumber;
    private final Airline airline;
    private final Route route;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;
    private final List<Seat> seats;

    public Flight(String flightNumber, Airline airline, Route route, LocalDateTime departureTime, LocalDateTime arrivalTime, List<Seat> seats) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.route = route;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seats = seats;
    }

    public synchronized List<Seat> getAvailableSeats(SeatClass seatClass) {
        return seats.stream()
                .filter(s -> s.getSeatClass() == seatClass && s.getSeatStatus() == SeatStatus.AVAILABLE)
                .collect(Collectors.toList());
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Airline getAirline() {
        return airline;
    }

    public Route getRoute() {
        return route;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
