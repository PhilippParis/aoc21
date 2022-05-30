package aoc.day21;

import aoc.day20.Day20;
import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day21Test {

    private final int DAY = 21;
    private final Day21 puzzle = new Day21();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(739785, puzzle.part1(input));
        assertEquals(444356092776315L, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(908091, puzzle.part1(input));
        assertEquals(190897246590017L, puzzle.part2(input));
    }
}