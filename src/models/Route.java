package models;

import java.time.Duration;

public record Route(Airport source, Airport destination, Duration duration) {
}
