package aoc.day02;

import java.util.stream.Stream;

public enum Direction {

    FORWARD,
    DOWN,
    UP;

    public static Direction fromString(final String value) {
        return Stream.of(values()).filter(i -> i.name().toLowerCase().equals(value))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("invalid direction " + value));
    }

}
