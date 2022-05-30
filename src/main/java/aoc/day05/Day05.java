package aoc.day05;

import java.util.List;
import java.util.stream.Collectors;

public class Day05 {

    public long part1(List<String> input) {
        List<Line> lines = input.stream().map(Line::fromString).collect(Collectors.toList());
        Map mapA = new Map(lines.stream().filter(i -> !i.isDiagonal()).collect(Collectors.toList()));
        return mapA.getIntersectionCount();
    }

    public long part2(List<String> input) {
        List<Line> lines = input.stream().map(Line::fromString).collect(Collectors.toList());
        return new Map(lines).getIntersectionCount();
    }
}
