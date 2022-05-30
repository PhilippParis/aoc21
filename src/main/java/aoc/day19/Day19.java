package aoc.day19;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.ml.distance.ManhattanDistance;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Day19 {

    private Scanner scanner;

    public void run(List<String> input) {
        List<Scanner> scanners = getScanners(input);
        scanner = new Scanner(scanners.get(0).getScanners(), scanners.get(0).getBeacons());
        scanners.remove(0);
        while(!scanners.isEmpty()) {
            for (Scanner scanner2 : scanners) {
                Optional<Scanner> combined = Scanner.combine(scanner, scanner2);
                if (combined.isPresent()) {
                    scanner = combined.get();
                    scanners.remove(scanner2);
                    break;
                }
            }
        }
    }

    public long part1() {
        return scanner.getBeacons().size();
    }

    public long part2() {
        long maxDistance = 0;
        for (RealVector s1 : scanner.getScanners()) {
            for (RealVector s2 : scanner.getScanners()) {
                maxDistance = (long) Math.max(maxDistance, new ManhattanDistance().compute(s1.toArray(), s2.toArray()));
            }
        }
        return maxDistance;
    }

    private List<Scanner> getScanners(List<String> lines) {
        var scanners = new ArrayList<Scanner>();
        var points = new ArrayList<RealVector>();
        for (String line : lines) {
            if (StringUtils.isBlank(line)) {
                scanners.add(new Scanner(List.of(new ArrayRealVector(3)), points));
                points = new ArrayList<>();
            } else if (!StringUtils.startsWith(line, "---")) {
                points.add(parse(line));
            }
        }
        scanners.add(new Scanner(List.of(new ArrayRealVector(3)), points));
        return scanners;
    }

    private RealVector parse(String line) {
        String[] split = line.split(",");
        return new ArrayRealVector(new double[]{Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])});
    }

}
