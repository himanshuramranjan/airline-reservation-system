package models;

import java.time.LocalDateTime;

public class Payment {
    private final double amount;
    private final LocalDateTime paidAt;
    private final boolean successful;

    public Payment(double amount) {
        this.amount = amount;
        this.paidAt = LocalDateTime.now();
        this.successful = true;
    }
}
