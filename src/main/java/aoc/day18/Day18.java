package aoc.day18;

import java.util.List;
import java.util.stream.Collectors;

public class Day18 {

    public long part1(List<String> input) {
        List<Node> numbers = input.stream().map(Parser::parse).collect(Collectors.toList());
        return numbers.stream().skip(1).reduce(numbers.get(0), Node::add).getMagnitude();
    }

    public long part2(List<String> input) {
        List<Node> numbers = input.stream().map(Parser::parse).collect(Collectors.toList());
        int maxMagnitude = 0;
        for (Node a : numbers) {
            for (Node b : numbers) {
                if (a != b) {
                    maxMagnitude = Math.max(a.add(b).getMagnitude(), maxMagnitude);
                    maxMagnitude = Math.max(b.add(a).getMagnitude(), maxMagnitude);
                }
            }
        }
        return maxMagnitude;
    }
}
