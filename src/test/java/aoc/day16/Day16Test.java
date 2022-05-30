package aoc.day16;

import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.Test;
import util.Input;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day16Test {
    private final int DAY = 16;
    private final Day16 puzzle = new Day16();

    @Test
    void example() throws DecoderException {
        assertEquals(16, puzzle.part1(List.of("8A004A801A8002F478")));
        assertEquals(12, puzzle.part1(List.of("620080001611562C8802118E34")));
        assertEquals(23, puzzle.part1(List.of("C0015000016115A2E0802F182340")));
        assertEquals(31, puzzle.part1(List.of("A0016C880162017C3686B18A3D4780")));

        assertEquals(3, puzzle.part2(List.of("C200B40A82")));
        assertEquals(54, puzzle.part2(List.of("04005AC33890")));
        assertEquals(7, puzzle.part2(List.of("880086C3E88112")));
        assertEquals(9, puzzle.part2(List.of("CE00C43D881120")));
        assertEquals(1, puzzle.part2(List.of("D8005AC2A8F0")));
        assertEquals(0, puzzle.part2(List.of("F600BC2D8F")));
        assertEquals(0, puzzle.part2(List.of("9C005AC2F8F0")));
        assertEquals(1, puzzle.part2(List.of("9C0141080250320F1802104A08")));
    }

    @Test
    void input() throws DecoderException {
        List<String> input = Input.getInput(DAY);
        assertEquals(953, puzzle.part1(input));
        assertEquals(246225449979L, puzzle.part2(input));
    }
}