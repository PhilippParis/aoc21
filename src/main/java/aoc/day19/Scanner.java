package aoc.day19;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import java.util.*;
import java.util.stream.Collectors;

public class Scanner {

    private final List<Set<Double>> dist = new ArrayList<>();
    private final List<RealVector> scanners;
    private final List<RealVector> beacons;

    public Scanner(List<RealVector> scanners, List<RealVector> beacons) {
        this.scanners = scanners;
        this.beacons = beacons;
        for (RealVector beacon : beacons) {
            dist.add(beacons.stream().mapToDouble(beacon::getDistance).boxed().collect(Collectors.toSet()));
        }
    }

    public Map<RealVector, RealVector> getOverlapping(Scanner scanner) {
        Map<RealVector, RealVector> result = new HashMap<>();
        for (int i = 0; i < beacons.size(); i++) {
            for (int j = 0; j < scanner.beacons.size(); j++) {
                if (CollectionUtils.intersection(dist.get(i), scanner.dist.get(j)).size() >= 12) {
                    result.put(beacons.get(i), scanner.beacons.get(j));
                }
            }
        }
        return result;
    }

    public static Optional<Scanner> combine(Scanner s1, Scanner s2) {
        var overlap = s1.getOverlapping(s2);
        if (overlap.size() < 12) {
            return Optional.empty();
        }
        for (RealMatrix matrix : MatrixUtil.TRANSFORM_MATRICES) {
            var originCandidates = overlap.entrySet().stream().map(i -> getMappedOrigin(i.getKey(), i.getValue(), matrix)).distinct().collect(Collectors.toList());
            if (originCandidates.size() == 1) {
                var combinedBeacons = new HashSet<>(s1.beacons);
                s2.beacons.stream().map(i -> transformVector(i, originCandidates.get(0), matrix)).forEach(combinedBeacons::add);

                var combinedScanners = new HashSet<>(s1.scanners);
                s2.scanners.stream().map(i -> transformVector(i, originCandidates.get(0), matrix)).forEach(combinedScanners::add);

                return Optional.of(new Scanner(new ArrayList<>(combinedScanners), new ArrayList<>(combinedBeacons)));
            }
        }
        return Optional.empty();
    }

    private static RealVector getMappedOrigin(RealVector a, RealVector b, RealMatrix transformMatrix) {
        return a.add(transformMatrix.preMultiply(b));
    }

    private static RealVector transformVector(RealVector b, RealVector origin, RealMatrix transformMatrix) {
        return origin.subtract(transformMatrix.preMultiply(b));
    }

    public List<RealVector> getBeacons() {
        return beacons;
    }

    public List<RealVector> getScanners() {
        return scanners;
    }

    @Override
    public String toString() {
        return "Scanner{" +
                "beacons=" + beacons +
                '}';
    }
}
