package aoc.day12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Vertex {

    private final Set<Vertex> neighbours = new HashSet<>();
    private final String label;
    private final VisitStrategy visitStrategy;

    public Vertex(String label, VisitStrategy visitStrategy) {
        this.label = label;
        this.visitStrategy = visitStrategy;
    }

    public void addEdge(Vertex to) {
        neighbours.add(to);
    }

    public Set<List<String>> getPathsTo(String target, List<String> path) {
        path.add(label);
        if (label.equals(target)) {
            return Set.of(path);
        }
        return neighbours.stream()
                .filter(i -> i.isVisitable(path))
                .map(i -> i.getPathsTo(target, new ArrayList<>(path)))
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    public boolean isVisitable(List<String> path) {
        return visitStrategy.isVisitable(label, path);
    }
}
