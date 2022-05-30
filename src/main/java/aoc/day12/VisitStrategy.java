package aoc.day12;

import java.util.List;

public interface VisitStrategy {

    boolean isVisitable(String label, List<String> path);

}
