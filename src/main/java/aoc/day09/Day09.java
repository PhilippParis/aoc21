package aoc.day09;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Day09 {

    public long part1(List<String> input) {
        final var lowPoints = new CaveMap(input).getLowPoints();
        return lowPoints.values().stream().mapToInt(i -> i + 1).sum();
    }

    public long part2(List<String> input) {
        final var map = new CaveMap(input);
        final var lowPoints = map.getLowPoints();
        return lowPoints.keySet().stream().map(i -> map.getBasin((int) i.getX(), (int) i.getY())).map(Set::size)
                .sorted(Collections.reverseOrder()).limit(3).reduce(1, (a, b) -> a * b);
    }
}
