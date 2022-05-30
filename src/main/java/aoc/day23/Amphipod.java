package aoc.day23;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.ml.distance.ManhattanDistance;

import java.util.Objects;

public class Amphipod {

    private static final ManhattanDistance DISTANCE = new ManhattanDistance();

    private final String type;
    private final Vector2D position;
    private final int energy;
    private final int moveCount;

    private final int energyPerStep;
    private final int targetRoom;

    public Amphipod(String type, Vector2D position) {
        this(type, position, 0, 0);
    }

    public Amphipod(String type, Vector2D position, int energy, int moveCount) {
        this.type = type;
        this.position = position;
        this.energy = energy;
        this.moveCount = moveCount;
        this.targetRoom = switch (type) {
            case "A" -> 2;
            case "B" -> 4;
            case "C" -> 6;
            case "D" -> 8;
            default -> throw new IllegalArgumentException("invalid type");
        };
        this.energyPerStep = switch (type) {
            case "A" -> 1;
            case "B" -> 10;
            case "C" -> 100;
            case "D" -> 1000;
            default -> throw new IllegalArgumentException("invalid type");
        };
    }

    public Vector2D getPosition() {
        return position;
    }

    public boolean isInRoom() {
        return position.getY() != 0;
    }

    public boolean isInHallway() {
        return position.getY() == 0;
    }

    public boolean isInTargetRoom() {
        return position.getX() == targetRoom && position.getY() != 0;
    }

    public boolean canMove() {
        return moveCount < 2;
    }

    public Amphipod moveTo(Vector2D position) {
        int energyNeeded = energyPerStep * (int) DISTANCE.compute(this.position.toArray(), position.toArray());
        return new Amphipod(type, position, energy + energyNeeded, moveCount + 1);
    }

    public int getEnergy() {
        return energy;
    }

    public int getTargetRoom() {
        return targetRoom;
    }

    @Override
    public String toString() {
        return type + " / " + position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amphipod amphipod = (Amphipod) o;
        if (energy != amphipod.energy) return false;
        if (moveCount != amphipod.moveCount) return false;
        if (!type.equals(amphipod.type)) return false;
        return position.equals(amphipod.position);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + energy;
        result = 31 * result + moveCount;
        return result;
    }
}
