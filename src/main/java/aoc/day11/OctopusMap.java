package aoc.day11;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import util.Map2D;

import java.util.*;
import java.util.stream.Collectors;

public class OctopusMap extends Map2D<Integer> {

    public OctopusMap(List<String> lines) {
        super(lines, i -> Arrays.stream(i.split("")).map(Integer::parseInt).collect(Collectors.toList()));
    }

    public long tick() {
        positions.forEach(i -> apply(i, j -> j + 1));
        Optional<Vector2D> point;
        while ((point = getFlashCandidate()).isPresent()){
            flash(point.get());
        }
        positions.forEach(i -> apply(i, j -> Math.max(j, 0)));
        return positions.stream().filter(i -> get(i) == 0).count();
    }

    public void flash(Vector2D point) {
        if (get(point) <= 9) {
            return;
        }
        set(point, Integer.MIN_VALUE);
        getNeighbours(point).stream().peek(i -> apply(i, j -> j + 1)).forEach(this::flash);
    }

    public long getSum() {
        return positions.stream().mapToLong(this::get).sum();
    }

    private Optional<Vector2D> getFlashCandidate() {
        return positions.stream().filter(i -> get(i) > 9).findFirst();
    }

    private List<Vector2D> getNeighbours(Vector2D point) {
        List<Vector2D> points = new ArrayList<>();
        for (int y = (int) point.getY() - 1 ; y <= (point.getY() + 1); y++ ) {
            for (int x = (int) point.getX() - 1 ; x <= (point.getX() + 1); x++ ) {
                if ((x != point.getX() || y != point.getY()) && x >= 0 && x < width && y >= 0 && y < height) {
                    points.add(new Vector2D(x, y));
                }
            }
        }
        return points;
    }

    @Override
    protected Class<Integer> getTypeClass() {
        return Integer.class;
    }
}
