package aoc.day06;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day06 {

    private static final int DAYS_INITIAL = 8;
    private static final int DAYS_RESET = 6;

    public long part1(List<String> input) {
        return getCount(parse(input.get(0)), 80);
    }

    public long part2(List<String> input) {
        return getCount(parse(input.get(0)), 256);
    }

    public Map<Integer, Long> parse(String input) {
        return Arrays.stream(input.split(",")).map(Integer::parseInt)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private long getCount(Map<Integer, Long> ageCount, int days) {
        for (int i = 0; i < days; i++) {
            long newFishCount = ageCount.getOrDefault(0, 0L);
            IntStream.range(0, DAYS_INITIAL).forEach(j -> ageCount.put(j, ageCount.getOrDefault(j + 1, 0L)));
            ageCount.put(DAYS_RESET, ageCount.getOrDefault(DAYS_RESET, 0L) + newFishCount);
            ageCount.put(DAYS_INITIAL, newFishCount);
        }
        return ageCount.values().stream().mapToLong(i -> i).sum();
    }

}
