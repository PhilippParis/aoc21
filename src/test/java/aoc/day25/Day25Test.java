package aoc.day25;

import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day25Test {
    private final int DAY = 25;
    private final Day25 puzzle = new Day25();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(58, puzzle.exec(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(353, puzzle.exec(input));
    }
}