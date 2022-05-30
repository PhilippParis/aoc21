package aoc.day25;

import java.util.List;

public class Day25 {

    public long exec(List<String> input) {
        SeaFloor map = new SeaFloor(input);
        for (long i = 0; i < 100000; i++) {
            SeaFloor next = map.move();
            if (next.equals(map)) {
                return i + 1;
            }
            map = next;
        }
        return -1;
    }
}
