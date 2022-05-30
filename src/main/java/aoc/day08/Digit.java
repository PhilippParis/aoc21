package aoc.day08;

import java.util.List;
import java.util.Set;

public enum Digit {

    ZERO("a", "b", "c", "e", "f", "g"),
    ONE("c", "f"),
    TWO("a", "c", "d", "e", "g"),
    THREE("a", "c", "d", "f", "g"),
    FOUR("b", "c", "d", "f"),
    FIVE("a", "b", "d", "f", "g"),
    SIX("a", "b", "d", "e", "f", "g"),
    SEVEN("a", "c", "f"),
    EIGHT("a", "b", "c", "d", "e", "f", "g"),
    NINE("a", "b", "c", "d", "f", "g");

    public static List<Digit> withUniqueSegmentCount = List.of(Digit.ONE, Digit.FOUR, Digit.SEVEN, Digit.EIGHT);

    private final Set<String> segments;

    Digit(String... segments) {
        this.segments = Set.of(segments);
    }

    public int getSegmentCount() {
        return segments.size();
    }

    public Set<String> getSegments() {
        return segments;
    }
}
