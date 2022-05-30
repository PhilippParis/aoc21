package aoc.day22;

import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day22Test {

    private final int DAY = 22;
    private final Day22 puzzle = new Day22();

    @Test
    void example() {
        assertEquals(590784, puzzle.part1(Input.getInput("examples/22-1.txt")));
        assertEquals(2758514936282235L, puzzle.part2(Input.getInput("examples/22-2.txt")));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(607573, puzzle.part1(input));
        assertEquals(1267133912086024L, puzzle.part2(input));
    }
}