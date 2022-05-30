package aoc.day12;

import java.util.List;

public class Day12 {

    public long part1(List<String> input) {
        Graph graph = Graph.parse(input, new VisitStrategyA());
        return graph.getPathsFromStartToEnd().size();
    }

    public long part2(List<String> input) {
        Graph graph = Graph.parse(input, new VisitStrategyB());
        return graph.getPathsFromStartToEnd().size();
    }
}
