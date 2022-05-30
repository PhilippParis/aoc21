package aoc.day22;

import org.apache.commons.math3.geometry.euclidean.threed.Euclidean3D;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.RegionFactory;

import java.util.List;
import java.util.stream.Collectors;

public class Day22 {

    private static final RegionFactory<Euclidean3D> factory = new RegionFactory<>();

    public long part1(List<String> input) {
        List<Cuboid> cuboids = parse(input).stream().filter(i -> i.isInRange(-50, 50)).collect(Collectors.toList());
        Region<Euclidean3D> reactor = cuboids.get(0).getRegion();
        for (Cuboid cuboid : cuboids) {
            reactor = cuboid.isOn() ? factory.union(reactor, cuboid.getRegion()) :
                                      factory.difference(reactor, cuboid.getRegion());
        }
        return (long) reactor.getSize();
    }

    public long part2(List<String> input) {
        List<Cuboid> cuboids = parse(input);
        Region<Euclidean3D> reactor = cuboids.get(0).getRegion();
        for (Cuboid cuboid : cuboids) {
            reactor = cuboid.isOn() ? factory.union(reactor, cuboid.getRegion()) :
                    factory.difference(reactor, cuboid.getRegion());
        }
        return (long) reactor.getSize();
    }

    private List<Cuboid> parse(List<String> input) {
        return input.stream().map(Cuboid::parse).collect(Collectors.toList());
    }

}
