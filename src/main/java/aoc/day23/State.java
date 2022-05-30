package aoc.day23;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class State {
    private static final Set<Integer> VALID_HALLWAY_POSITIONS = Set.of(0, 1, 3, 5, 7, 9, 10);

    private final Map<Vector2D, Amphipod> pods;
    private final int roomSize;

    public State(Map<Vector2D, Amphipod> pods) {
        this.pods = pods;
        roomSize = pods.values().stream().mapToInt(i -> (int) i.getPosition().getY()).max().orElse(0);
    }

    private State(Map<Vector2D, Amphipod> pods, int roomSize) {
        this.pods = pods;
        this.roomSize = roomSize;
    }

    public Set<State> next() {
        Set<State> result = new HashSet<>();
        for (Amphipod pod : pods.values()) {
            for (Amphipod moved : move(pod)) {
                HashMap<Vector2D, Amphipod> clone = new HashMap<>(pods);
                clone.remove(pod.getPosition());
                clone.put(moved.getPosition(), moved);
                result.add(new State(clone, roomSize));
            }
        }
        return result;
    }

    private Set<Amphipod> move(Amphipod pod) {
        if (!pod.canMove()) {
            return Set.of();
        }
        if (pod.isInHallway()) {
            return moveIntoTargetRoom(pod);
        }
        if (pod.isInRoom()) {
            return moveIntoHallway(pod);
        }
        throw new IllegalStateException();
    }

    private Set<Amphipod> moveIntoHallway(Amphipod pod) {
        Set<Amphipod> result = new HashSet<>();
        int yPos = (int) pod.getPosition().getY();
        int xPos = (int) pod.getPosition().getX();
        // check if pod can move outside of room
        for (int i = 1; i < yPos; i++) {
            if (pods.containsKey(new Vector2D(xPos, i))) {
                return Set.of();
            }
        }
        // move to right
        for (int x = xPos; x <= 10; x++) {
            if (VALID_HALLWAY_POSITIONS.contains(x)) {
                Vector2D position = new Vector2D(x, 0);
                if (pods.containsKey(position)) {
                    break;
                }
                result.add(pod.moveTo(position));
            }
        }
        // move to left
        for (int x = xPos; x >= 0; x--) {
            if (VALID_HALLWAY_POSITIONS.contains(x)) {
                Vector2D position = new Vector2D(x, 0);
                if (pods.containsKey(position)) {
                    break;
                }
                result.add(pod.moveTo(position));
            }
        }
        return result;
    }

    private Set<Amphipod> moveIntoTargetRoom(Amphipod pod) {
        int xPos = (int) pod.getPosition().getX();
        int xTargetRoom = pod.getTargetRoom();
        // check if target room contains pods of another type
        for (Amphipod amphipod : pods.values()) {
            Vector2D position = amphipod.getPosition();
            if (position.getY() != 0 && position.getX() == xTargetRoom && amphipod.getTargetRoom() != xTargetRoom) {
                return Set.of();
            }
        }
        // check if hallway is free
        for (int i = Math.min(xPos, xTargetRoom); i < Math.max(xPos, xTargetRoom); i++) {
            Vector2D vector2D = new Vector2D(i, 0);
            if (i != xPos && pods.containsKey(vector2D)) {
                return Set.of();
            }
        }
        // move into room
        for (int y = roomSize; y > 0; y--) {
            Vector2D targetPos = new Vector2D(xTargetRoom, y);
            if (!pods.containsKey(targetPos)) {
                return Set.of(pod.moveTo(targetPos));
            }
        }
        throw new IllegalStateException();
    }

    public boolean isSuccessful() {
        return pods.values().stream().allMatch(Amphipod::isInTargetRoom);
    }

    public int getEnergy() {
        return pods.values().stream().mapToInt(Amphipod::getEnergy).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return pods.equals(state.pods);
    }

    @Override
    public int hashCode() {
        return pods.hashCode();
    }
}
