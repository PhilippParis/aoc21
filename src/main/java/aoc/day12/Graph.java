package aoc.day12;

import java.util.*;

public class Graph {

    public static final String LABEL_START = "start";
    public static final String LABEL_END = "end";
    private final Map<String, Vertex> vertices = new HashMap<>();
    private final VisitStrategy visitStrategy;

    public Graph(VisitStrategy visitStrategy) {
        this.visitStrategy = visitStrategy;
    }

    public static Graph parse(List<String> lines, VisitStrategy visitStrategy) {
        Graph graph = new Graph(visitStrategy);
        lines.stream().map(i -> i.split("-")).forEach(i -> graph.addEdge(i[0], i[1]));
        return graph;
    }

    public void addEdge(String from, String to) {
        vertices.putIfAbsent(from, new Vertex(from, visitStrategy));
        vertices.putIfAbsent(to, new Vertex(to, visitStrategy));
        vertices.get(from).addEdge(vertices.get(to));
        vertices.get(to).addEdge(vertices.get(from));
    }

    public Set<List<String>> getPathsFromStartToEnd() {
        return vertices.get(LABEL_START).getPathsTo(LABEL_END, new ArrayList<>());
    }

}
