package aoc.day15;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.*;

public class Node {

    private final Set<Node> neighbours = new HashSet<>();
    private final Vector2D position;
    private final int distance;

    public Node(Vector2D position, int distance) {
        this.position = position;
        this.distance = distance;
    }

    public void addNeighbour(Node node) {
        neighbours.add(node);
        node.neighbours.add(this);
    }

    public int getDistance() {
        return distance;
    }

    public Vector2D getPosition() {
        return position;
    }

    public Set<Node> getNeighbours() {
        return neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return position.equals(node.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return position.toString();
    }
}
