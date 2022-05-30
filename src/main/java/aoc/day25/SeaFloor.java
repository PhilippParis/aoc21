package aoc.day25;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import util.Map2D;

import java.util.*;
import java.util.stream.Collectors;

public class SeaFloor extends Map2D<Cucumber> {

    public SeaFloor(int width, int height) {
        super(width, height);
    }

    public SeaFloor(List<String> lines) {
        super(lines, i -> i.chars().mapToObj(j -> Cucumber.parse((char) j)).collect(Collectors.toList()));
    }

    public SeaFloor move() {
        return move(Cucumber.EAST).move(Cucumber.SOUTH);
    }

    private SeaFloor move(Cucumber type) {
        SeaFloor result = new SeaFloor(width, height);
        for (Vector2D pos : positions) {
            Optional<Cucumber> cucumber = Optional.ofNullable(get(pos));
            if (cucumber.isPresent()) {
                if (cucumber.get() == type) {
                    result.set(getTargetPos(pos), cucumber.get());
                } else {
                    result.set(pos, cucumber.get());
                }
            }
        }
        return result;
    }

    private Vector2D getTargetPos(Vector2D pos) {
        Optional<Cucumber> cucumber = Optional.ofNullable(get(pos));
        if (cucumber.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Vector2D target = pos.add(cucumber.get().getDiff());
        target = new Vector2D(target.getX() % width, target.getY() % height);
        return isCucumberPresent(target) ? pos : target;
    }

    private boolean isCucumberPresent(Vector2D pos) {
        return get(pos) != null;
    }

    @Override
    protected Class<Cucumber> getTypeClass() {
        return Cucumber.class;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeaFloor other = (SeaFloor) o;
        return width == other.width && height == other.height && Arrays.deepEquals(data, other.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(width, height);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
