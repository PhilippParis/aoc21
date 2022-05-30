package aoc.day05;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Line {

    private final Vector2D from;
    private final Vector2D to;

    private static final Pattern PATTERN = Pattern.compile("(?<x1>[0-9]+),(?<y1>[0-9]+) -> (?<x2>[0-9]+),(?<y2>[0-9]+)");

    public static Line fromString(String value) {
        final var m = PATTERN.matcher(value);
        if (!m.matches()) {
            throw new IllegalArgumentException();
        }
        final var from = new Vector2D(Double.parseDouble(m.group("x1")), Double.parseDouble(m.group("y1")));
        final var to = new Vector2D(Double.parseDouble(m.group("x2")), Double.parseDouble(m.group("y2")));
        return new Line(from, to);
    }

    public Line(Vector2D from, Vector2D to) {
        this.from = from;
        this.to = to;
    }

    public Vector2D getFrom() {
        return from;
    }

    public Vector2D getTo() {
        return to;
    }

    public boolean isDiagonal() {
        return from.getX() != to.getX() && from.getY() != to.getY();
    }

    public int getMaxX() {
        return (int) Math.max(from.getX(), to.getX());
    }

    public int getMaxY() {
        return (int) Math.max(from.getY(), to.getY());
    }

    public Set<Vector2D> getCoveredPoints() {
        Set<Vector2D> points = new HashSet<>(Set.of(from, to));
        int x = (int) from.getX();
        int y = (int) from.getY();
        while (x != to.getX() || y != to.getY()) {
            x += x == to.getX() ? 0 : (from.getX() < to.getX() ? 1 : -1);
            y += y == to.getY() ? 0 : (from.getY() < to.getY() ? 1 : -1);
            points.add(new Vector2D(x, y));
        }
        return points;
    }
}
