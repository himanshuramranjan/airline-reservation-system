package models;

import enums.SeatClass;
import enums.SeatStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record Flight(String flightNumber, Airline airline, Route route, LocalDateTime departureTime,
                     LocalDateTime arrivalTime, List<Seat> seats) {

    public synchronized List<Seat> getAvailableSeats(SeatClass seatClass) {
        return seats.stream()
                .filter(s -> s.getSeatClass() == seatClass && s.getSeatStatus() == SeatStatus.AVAILABLE)
                .collect(Collectors.toList());
    }
}
