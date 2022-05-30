package aoc.day03;

import java.util.List;

public class Day03 {

    private Report report;

    public void run(List<String> input) {
        report = new Report(input);
    }

    public int part1() {
        return report.getPowerConsumption();
    }

    public int part2() {
        return report.getLifeSupportRating();
    }

}
