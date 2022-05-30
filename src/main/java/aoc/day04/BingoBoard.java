package aoc.day04;

import org.apache.commons.lang3.StringUtils;
import util.Map2D;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BingoBoard extends Map2D<Integer> {

    private static final int MARKED = -1;

    public BingoBoard(List<String> input) {
        super(input, i -> Arrays.stream(i.split(" +")).filter(StringUtils::isNumeric)
                .map(Integer::parseInt).collect(Collectors.toList()));
    }

    public boolean mark(int number) {
        positions.stream().filter(i -> get(i) == number).forEach(i -> set(i, MARKED));
        return hasWon();
    }

    public long getSumOfUnmarked() {
        return positions.stream().mapToInt(this::get).filter(i -> i != MARKED).sum();
    }

    public boolean hasWon() {
        for (int x = 0; x < width; x++) {
            if (Arrays.stream(data[x]).allMatch(i -> i == MARKED)) {
                return true;
            }
        }
        for (int y = 0; y < height; y++) {
            int y2 = y;
            if (IntStream.range(0, width).map(x -> data[x][y2]).allMatch(i -> i == MARKED)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected Class<Integer> getTypeClass() {
        return Integer.class;
    }
}
