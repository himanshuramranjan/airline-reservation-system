package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Passenger extends User {
    private final List<Booking> bookings = new ArrayList<>();

    public Passenger(String userId, String name, String email) {
        super(userId, name, email);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookingHistory() {
        return Collections.unmodifiableList(bookings);
    }
}
