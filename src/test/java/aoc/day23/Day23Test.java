package aoc.day23;

import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day23Test {
    private final int DAY = 23;
    private final Day23 puzzle = new Day23();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(12521, puzzle.exec(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(11120, puzzle.exec(input));

        input.add(3, "  #D#C#B#A#");
        input.add(4, "  #D#B#A#C#");
        assertEquals(49232, puzzle.exec(input));
    }
}