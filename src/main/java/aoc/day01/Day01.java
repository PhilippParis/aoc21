package aoc.day01;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day01 {

    public long part1(final List<String> input) {
        return getIncreaseCount(parse(input));
    }

    public long part2(final List<String> input) {
        var windowSums = sliding(parse(input), 3)
                .map(i -> i.stream().mapToInt(Integer::intValue).sum()).collect(Collectors.toList());
        return getIncreaseCount(windowSums);
    }

    private long getIncreaseCount(final List<Integer> numbers) {
        return IntStream.range(1, numbers.size()).mapToObj(i -> numbers.get(i) > numbers.get(i - 1)).filter(i -> i).count();
    }

    private Stream<List<Integer>> sliding(final List<Integer> list, final int size) {
        if (size > list.size()) {
            return Stream.empty();
        }
        return IntStream.range(0, list.size() - size + 1)
                .mapToObj(start -> list.subList(start, start + size));
    }

    private List<Integer> parse(final List<String> input) {
        return input.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
