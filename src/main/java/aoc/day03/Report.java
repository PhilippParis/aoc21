package aoc.day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Report {

    private static final Collector<Object, StringBuilder, String> StringAppendCollector =
            Collector.of(StringBuilder::new,
            StringBuilder::append,
            StringBuilder::append,
            StringBuilder::toString);

    private final int width;
    private final int height;

    private final int[][] data;
    private final int[][] transposedData;
    private final List<String> lines;

    public Report(List<String> lines) {
        width = lines.get(0).length();
        height = lines.size();
        data = new int[height][width];
        transposedData = new int[width][height];

        this.lines = lines;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                data[y][x] = lines.get(y).charAt(x) - '0';
                transposedData[x][y] = data[y][x];
            }
        }
    }

    public int getPowerConsumption() {
        return getGammaRate() * getEpsilonRate();
    }

    public int getLifeSupportRating() {
        return getOxygenGeneratorRating() * getCo2ScrubberRating();
    }

    public int getGammaRate() {
        return binaryToDecimal(IntStream.range(0, width).mapToObj(this::getMostCommonBit).collect(StringAppendCollector));
    }

    public int getEpsilonRate() {
        return binaryToDecimal(IntStream.range(0, width).mapToObj(this::getLeastCommonBit).collect(StringAppendCollector));
    }

    public int getOxygenGeneratorRating() {
        return getOxygenGeneratorRating(0, new Report(new ArrayList<>(lines)));
    }

    private int getOxygenGeneratorRating(int col, Report report) {
        int mostCommonBit = report.getMostCommonBit(col);
        List<String> values =
                report.lines.stream().filter(i -> (i.charAt(col) - '0') == mostCommonBit).collect(Collectors.toList());
        if (values.size() != 1) {
            return getOxygenGeneratorRating(col + 1, new Report(values));
        }
        return values.stream().findFirst().map(this::binaryToDecimal).orElse(0);
    }

    public int getCo2ScrubberRating() {
        return getCo2ScrubberRating(0, new Report(new ArrayList<>(lines)));
    }

    private int getCo2ScrubberRating(int col, Report report) {
        int leastCommonBit = report.getLeastCommonBit(col);
        List<String> values =
                report.lines.stream().filter(i -> (i.charAt(col) - '0') == leastCommonBit).collect(Collectors.toList());
        if (values.size() != 1) {
            return getCo2ScrubberRating(col + 1, new Report(values));
        }
        return values.stream().findFirst().map(this::binaryToDecimal).orElse(0);
    }

    private int getMostCommonBit(int col) {
        Map<Integer, Long> bitCounts = getBitCounts(col);
        if (bitCounts.get(0).equals(bitCounts.get(1))) {
            return 1;
        }
        return bitCounts.get(0) > bitCounts.get(1) ? 0 : 1;
    }

    private int getLeastCommonBit(int col) {
        Map<Integer, Long> bitCounts = getBitCounts(col);
        if (bitCounts.get(0).equals(bitCounts.get(1))) {
            return 0;
        }
        return bitCounts.get(0) < bitCounts.get(1) ? 0 : 1;
    }

    private Map<Integer, Long> getBitCounts(int col) {
        return Arrays.stream(transposedData[col]).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }
}
