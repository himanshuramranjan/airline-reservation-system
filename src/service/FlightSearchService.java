package service;

import models.Airport;
import models.Flight;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearchService {
    private final List<Flight> flights;

    public FlightSearchService(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> searchFlights(Airport source, Airport destination, LocalDate date) {
        return flights.stream()
                .filter(f -> f.route().source().equals(source) &&
                        f.route().destination().equals(destination) &&
                        f.departureTime().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }
}
