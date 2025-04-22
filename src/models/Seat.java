package models;

import enums.SeatClass;
import enums.SeatStatus;

public class Seat {
    private final String seatNumber;
    private final SeatClass seatClass;
    private SeatStatus seatStatus;

    public Seat(String seatNumber, SeatClass seatClass) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.seatStatus = SeatStatus.AVAILABLE;
    }

    public synchronized boolean book() {
        if(seatStatus == SeatStatus.AVAILABLE) {
            seatStatus = SeatStatus.BOOKED;
            return true;
        }
        return false;
    }

    public synchronized void release() {
        seatStatus = SeatStatus.AVAILABLE;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }
}
