package aoc.day20;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day20 {

    public long part1(List<String> input) {
        final Image image = new Image(input.stream().skip(2).collect(Collectors.toList()));
        return IntStream.range(0, 2).boxed().reduce(image, (i, j) -> i.enhance(input.get(0)), (i, j) -> i)
                .getLitPixelCount();
    }

    public long part2(List<String> input) {
        final Image image = new Image(input.stream().skip(2).collect(Collectors.toList()));
        return IntStream.range(0, 50).boxed().reduce(image, (i, j) -> i.enhance(input.get(0)), (i, j) -> i)
                .getLitPixelCount();
    }
}
