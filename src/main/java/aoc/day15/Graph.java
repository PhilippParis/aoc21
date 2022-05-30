package aoc.day15;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.*;

public class Graph {

    public Map<Vector2D, Node> nodes = new HashMap<>();
    private final int width;
    private final int height;

    public Graph(List<String> lines, int times) {
        int initialWidth = lines.get(0).length();
        int initialHeight = lines.size();
        width = initialWidth * times;
        height = initialHeight * times;

        for (int y = 0; y < initialHeight; y++) {
            for (int x = 0; x < initialWidth; x++) {
                for (int i = 0; i < times; i++) {
                    for (int j = 0; j < times; j++) {
                        Vector2D position = new Vector2D(x + (j * initialWidth), y + (i * initialHeight));
                        int distance = lines.get(y).charAt(x) - '0' + i + j;
                        nodes.put(position, new Node(position, distance > 9? distance - 9 : distance));
                    }
                }
            }
        }
        for (Node node : nodes.values()) {
            getNeighbours(node.getPosition()).forEach(i -> i.addNeighbour(node));
        }
    }

    public Node getNode(Vector2D position) {
        return nodes.get(position);
    }

    public Map<Vector2D, Node> getNodes() {
        return nodes;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int size() {
        return nodes.size();
    }

    private Set<Node> getNeighbours(Vector2D position) {
        Set<Node> result = new HashSet<>();
        if (position.getX() > 0) {
            result.add(nodes.get(new Vector2D(position.getX() - 1, position.getY())));
        }
        if (position.getX() < width - 1) {
            result.add(nodes.get(new Vector2D(position.getX() + 1, position.getY())));
        }
        if (position.getY() > 0) {
            result.add(nodes.get(new Vector2D(position.getX(), position.getY() - 1)));
        }
        if (position.getY() < height - 1) {
            result.add(nodes.get(new Vector2D(position.getX(), position.getY() + 1)));
        }
        return result;
    }

}
