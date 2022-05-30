package aoc.day17;

import org.junit.jupiter.api.Test;
import util.Input;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day17Test {
    private final int DAY = 17;
    private final Day17 puzzle = new Day17();

    @Test
    void example() {
        puzzle.run(Input.getExample(DAY));
        assertEquals(45, puzzle.part1());
        assertEquals(112, puzzle.part2());
    }

    @Test
    void input() {
        puzzle.run(Input.getInput(DAY));
        assertEquals(3003, puzzle.part1());
        assertEquals(940, puzzle.part2());
    }
}