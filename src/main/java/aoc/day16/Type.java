package aoc.day16;

import java.util.stream.Stream;

public enum Type {
    SUM(0),
    PRODUCT(1),
    MIN(2),
    MAX(3),
    LITERAL(4),
    GREATER_THAN(5),
    LESS_THAN(6),
    EQUAL(7);

    private final int value;

    Type(int value) {
        this.value = value;
    }

    public static Type parse(long value) {
        return Stream.of(values()).filter(i -> i.value == value).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("invalid type: " + value));
    }
}
