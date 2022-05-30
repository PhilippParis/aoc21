package aoc.day17;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class Day17 {

    private static final Pattern PATTERN = Pattern.compile(
            "target area: x=(?<x1>-?[0-9]+)\\.\\.(?<x2>-?[0-9]+), y=(?<y1>-?[0-9]+)\\.\\.(?<y2>-?[0-9]+)");

    private Pair<Vector2D, Vector2D> target;
    private int count = 0;
    private int maxHeight = 0;

    public void run(List<String> input) {
        target = parse(input.get(0));
        for (int y = -1000; y < 1000; y++) {
            for (int x = 1; x < 1000; x++) {
                Optional<Integer> result = test(new Vector2D(0, 0), new Vector2D(x, y), 1000);
                if (result.isPresent()) {
                    count++;
                    maxHeight = Math.max(maxHeight, result.get());
                }
            }
        }
    }

    public long part1() {
        return maxHeight;
    }

    public long part2() {
        return count;
    }

    private Pair<Vector2D, Vector2D> parse(String input) {
        var m = PATTERN.matcher(input);
        if (!m.matches()) {
            throw new IllegalArgumentException();
        }
        return Pair.of(new Vector2D(Integer.parseInt(m.group("x1")), Integer.parseInt(m.group("y1"))),
                new Vector2D(Integer.parseInt(m.group("x2")), Integer.parseInt(m.group("y2"))));
    }

    private Optional<Integer> test(Vector2D start, Vector2D initialVelocity, int maxSteps) {
        Vector2D current = start;
        Vector2D velocity = initialVelocity;
        int maxHeight = (int) current.getY();
        for (int i = 0; i < maxSteps; i++) {
            current = current.add(velocity);
            velocity = updateVelocity(velocity);
            maxHeight = (int) Math.max(maxHeight, current.getY());
            if (isPastTarget(current)) {
                return Optional.empty();
            }
            if (isInsideTarget(current)) {
                return Optional.of(maxHeight);
            }
        }
        return Optional.empty();
    }

    private Vector2D updateVelocity(Vector2D velocity) {
        if (velocity.getX() == 0) {
            return new Vector2D(0, velocity.getY() - 1);
        } else if (velocity.getX() > 0) {
            return new Vector2D(velocity.getX() - 1, velocity.getY() - 1);
        } else {
            return new Vector2D(velocity.getX() + 1, velocity.getY() - 1);
        }
    }

    private boolean isPastTarget(Vector2D point) {
        return point.getX() > target.getRight().getX() || point.getY() < target.getLeft().getY();
    }

    private boolean isInsideTarget(Vector2D point) {
        return target.getLeft().getX() <= point.getX() && target.getRight().getX() >= point.getX() &&
                target.getLeft().getY() <= point.getY() && target.getRight().getY() >= point.getY();
    }

}
