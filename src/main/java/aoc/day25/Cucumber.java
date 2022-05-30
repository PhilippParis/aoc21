package aoc.day25;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.stream.Stream;

public enum Cucumber {
    EAST('>', 1, 0),
    SOUTH('v', 0, 1);

    private final char value;
    private final int xDiff;
    private final int yDiff;

    public static Cucumber parse(char value) {
        return Stream.of(values()).filter(i -> i.value == value).findFirst().orElse(null);
    }

    Cucumber(char value, int xDiff, int yDiff) {
        this.value = value;
        this.xDiff = xDiff;
        this.yDiff = yDiff;
    }

    public Vector2D getDiff() {
        return new Vector2D(xDiff, yDiff);
    }

    @Override
    public String toString() {
        return Character.toString(value);
    }

}
