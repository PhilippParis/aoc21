package aoc.day09;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import util.Map2D;

import java.util.*;
import java.util.stream.Collectors;

public class CaveMap extends Map2D<Integer> {

    public CaveMap(List<String> lines) {
        super(lines, i -> Arrays.stream(i.split("")).map(Integer::parseInt).collect(Collectors.toList()));
    }

    public java.util.Map<Vector2D, Integer> getLowPoints() {
        HashMap<Vector2D, Integer> result = new HashMap<>();
        for (Vector2D position : positions) {
            int height = get(position);
            int y = (int) position.getY();
            int x = (int) position.getX();
            if ((y == 0 || height < data[x][y - 1]) &&
                    (y == this.height - 1 || height < data[x][y + 1]) &&
                    (x == 0 || height < data[x - 1][y]) &&
                    (x == width - 1 || height < data[x + 1][y])) {
                result.put(position, height);
            }
        }
        return result;
    }

    public Set<Vector2D> getBasin(int x, int y) {
        int current = data[x][y];
        if (current == 9) {
            return Set.of();
        }
        Set<Vector2D> basin = new HashSet<>();
        basin.add(new Vector2D(x, y));
        if (x > 0 && data[x - 1][y] > current) {
            basin.addAll(getBasin(x - 1, y));
        }
        if (x < width - 1 && data[x + 1][y] > current) {
            basin.addAll(getBasin(x + 1, y));
        }
        if (y > 0 && data[x][y - 1] > current) {
            basin.addAll(getBasin(x, y - 1));
        }
        if (y < height - 1 && data[x][y + 1] > current) {
            basin.addAll(getBasin(x, y + 1));
        }
        return basin;
    }

    @Override
    protected Class<Integer> getTypeClass() {
        return Integer.class;
    }
}
