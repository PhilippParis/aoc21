package aoc.day08;

import java.util.List;
import java.util.stream.Collectors;

public class Day08 {

    private static final BruteForceSolver SOLVER = new BruteForceSolver();

    public long part1(List<String> input) {
        final List<Display> displays = parse(input);
        return Digit.withUniqueSegmentCount.stream().
                flatMapToLong(i -> displays.stream().mapToLong(j -> j.getOutputDigitCount(i))).sum();
    }

    public long part2(List<String> input) {
        final List<Display> displays = parse(input);
        return displays.stream().mapToInt(SOLVER::solve).sum();
    }

    private List<Display> parse(List<String> input) {
        return input.stream().map(Display::fromString).collect(Collectors.toList());
    }

}
