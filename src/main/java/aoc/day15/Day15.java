package aoc.day15;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.List;

public class Day15 {

    public long part1(List<String> input) {
        return aStar(input, 1);
    }

    public long part2(List<String> input) {
        return aStar(input, 5);
    }

    private long aStar(List<String> lines, int times) {
        Graph graph = new Graph(lines, times);
        Node source = graph.getNode(new Vector2D(0, 0));
        Node target = graph.getNode(new Vector2D(graph.getWidth() - 1, graph.getHeight() - 1));
        return AStar.findShortestPath(graph, source, target);
    }
}
