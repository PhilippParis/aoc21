package aoc.day24;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day24Test {
    private final Day24 puzzle = new Day24();

    @Test
    void input() {
        List<String> input = Input.getInput(24);
        Pair<Long, Long> result = puzzle.exec(input);
        assertEquals(12934998949199L, result.getRight());
        assertEquals(11711691612189L, result.getLeft());
    }
}