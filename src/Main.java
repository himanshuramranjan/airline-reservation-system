import enums.SeatClass;
import models.*;
import service.BookingService;
import service.FlightSearchService;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Airport delhi = new Airport("DEL", "Indira Gandhi Intl", "Delhi", "India");
        Airport mumbai = new Airport("BOM", "Chhatrapati Shivaji Intl", "Mumbai", "India");

        Route delToBom = new Route(delhi, mumbai, Duration.ofHours(2));
        Airline airIndia = new Airline("AI", "Air India");

        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            seats.add(new Seat("E" + i, SeatClass.ECONOMY));
        }

        Flight flight1 = new Flight("AI202", airIndia, delToBom,
                LocalDateTime.of(2025, 4, 22, 10, 0),
                LocalDateTime.of(2025, 4, 22, 12, 0), seats);

        FlightSearchService flightSearchService = new FlightSearchService(List.of(flight1));
        BookingService bookingService = new BookingService();

        Passenger john = new Passenger("U1", "John Doe", "john@example.com");

        List<Flight> results = flightSearchService.searchFlights(delhi, mumbai, LocalDate.of(2025, 4, 22));
        if (results.isEmpty()) {
            System.out.println("No flights found.");
        } else {
            System.out.println("Flights found: " + results.size());
            Flight selectedFlight = results.get(0);
            Booking booking = bookingService.bookTicket(john, selectedFlight, SeatClass.ECONOMY, 2);

            if (booking != null) {
                System.out.println("Booking successful! ID: " + booking.getBookingId());
                for (Seat s : booking.getSeats()) {
                    System.out.println("Seat: " + s.getSeatNumber());
                }
            } else {
                System.out.println("Booking failed. Not enough seats.");
            }
        }
    }
}