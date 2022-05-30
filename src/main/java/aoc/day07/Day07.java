package aoc.day07;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day07 {

    public long part1(List<String> input) {
        final List<Integer> positions = parse(input);
        final int max = positions.stream().max(Integer::compare).orElse(0);
        return getSolution(positions, max, i -> i);
    }

    public long part2(List<String> input) {
        final List<Integer> positions = parse(input);
        final int max = positions.stream().max(Integer::compare).orElse(0);
        return getSolution(positions, max, i -> i * (i + 1) / 2);
    }

    private List<Integer> parse(List<String> input) {
        return Arrays.stream(input.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private int getSolution(List<Integer> positions, int max, Function<Integer, Integer> fuelCost) {
        return IntStream.range(0, max)
                .map(i -> positions.stream().map(pos -> fuelCost.apply(Math.abs(i - pos))).mapToInt(j -> j).sum())
                .min()
                .orElse(0);
    }

}
