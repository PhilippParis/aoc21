package aoc.day11;

import java.util.List;
import java.util.stream.IntStream;

public class Day11 {

    public long part1(List<String> input) {
        var map = new OctopusMap(input);
        return IntStream.range(0, 100).mapToLong(i -> map.tick()).sum();
    }

    public long part2(List<String> input) {
        var map = new OctopusMap(input);
        for (int i = 0; i < 500; i++) {
            map.tick();
            if (map.getSum() == 0) {
                return i + 1;
            }
        }
        return 0;
    }
}
