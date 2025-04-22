package models;

import java.time.Duration;

public class Route {
    private final Airport source;
    private final Airport destination;
    private final Duration duration;

    public Route(Airport source, Airport destination, Duration duration) {
        this.source = source;
        this.destination = destination;
        this.duration = duration;
    }

    public Airport getSource() {
        return source;
    }

    public Airport getDestination() {
        return destination;
    }

    public Duration getDuration() {
        return duration;
    }
}
