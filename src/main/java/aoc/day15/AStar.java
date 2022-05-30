package aoc.day15;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.distance.ManhattanDistance;

import java.util.*;

public class AStar {

    private static final DistanceMeasure DISTANCE = new ManhattanDistance();

    public static long findShortestPath(Graph graph, Node start, Node goal) {
        PriorityQueue<Pair<Node, Integer>> openSet = new PriorityQueue<>(graph.size(), Comparator.comparingInt(Pair::getRight));
        Map<Node, Node> cameFrom = new HashMap<>(graph.size());
        Map<Node, Integer> gScore = new HashMap<>(graph.size());
        HashSet<Node> visited = new HashSet<>(graph.size());

        for (Node node : graph.getNodes().values()) {
            gScore.put(node, Integer.MAX_VALUE);
        }

        openSet.add(Pair.of(start , 0));
        gScore.put(start, 0);

        while (!openSet.isEmpty()) {
            Node current = openSet.remove().getLeft();
            visited.add(current);
            if (current.equals(goal)) {
                return getPathDistance(cameFrom, start, goal);
            }
            for (Node neighbour : current.getNeighbours()) {
                if (!visited.contains(neighbour)) {
                    int tentative_gScore = gScore.get(current) + neighbour.getDistance();
                    if (tentative_gScore < gScore.get(neighbour)) {
                        cameFrom.put(neighbour, current);
                        gScore.put(neighbour, tentative_gScore);
                        openSet.add(Pair.of(neighbour, tentative_gScore + h(neighbour, goal)));
                    }
                }
            }
        }
        return -1;
    }

    private static long getPathDistance(Map<Node, Node> prev, Node source, Node target) {
        List<Node> path = new ArrayList<>();
        path.add(target);
        Node current = target;
        while ((current = prev.get(current)) != null) {
            if (!current.equals(source)) {
                path.add(0, current);
            }
        }
        return path.stream().mapToInt(Node::getDistance).sum();
    }

    private static int h(Node from, Node goal) {
        return (int) DISTANCE.compute(from.getPosition().toArray(), goal.getPosition().toArray());
        //Vector2D goalPos = goal.getPosition();
        //Vector2D fromPos = from.getPosition();
        //return (int) (goalPos.getX() - fromPos.getX() + goalPos.getY() - fromPos.getY());
    }

}
