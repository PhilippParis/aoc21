package aoc.day02;

import java.util.List;
import java.util.stream.Collectors;

public class Day02 {

    public int part1(List<String> input) {
        Submarine submarine = new SubmarineA();
        return submarine.exec(input.stream().map(Command::fromString).collect(Collectors.toList()));
    }

    public int part2(List<String> input) {
        Submarine submarine = new SubmarineB();
        return submarine.exec(input.stream().map(Command::fromString).collect(Collectors.toList()));
    }

}
