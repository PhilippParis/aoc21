package aoc.day21;

import java.util.Objects;

public class Player {
    private final int position;
    private final long points;

    public Player(int position) {
        this.position = position;
        this.points = 0;
    }

    public Player(int position, long points) {
        this.position = position;
        this.points = points;
    }

    public Player move(int distance) {
        int newPos = 1 + (position + distance - 1) % 10;
        return new Player(newPos, points + newPos);
    }

    public long getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return position == player.position && points == player.points;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, points);
    }
}
