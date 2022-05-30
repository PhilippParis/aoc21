package aoc.day13;

import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day13Test {
    private final int DAY = 13;
    private final Day13 puzzle = new Day13();

    @Test
    void example() {
        List<String> input = Input.getExample(DAY);
        assertEquals(17, puzzle.part1(input));
        assertEquals("""
                #####
                #...#
                #...#
                #...#
                #####
                """, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(DAY);
        assertEquals(638, puzzle.part1(input));
        assertEquals("""
                .##....##..##..#..#.###...##..###..###.
                #..#....#.#..#.#.#..#..#.#..#.#..#.#..#
                #.......#.#....##...###..#..#.#..#.###.
                #.......#.#....#.#..#..#.####.###..#..#
                #..#.#..#.#..#.#.#..#..#.#..#.#....#..#
                .##...##...##..#..#.###..#..#.#....###.
                """, puzzle.part2(input));
    }
}