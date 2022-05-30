package aoc.day12;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class VisitStrategyB implements VisitStrategy{
    @Override
    public boolean isVisitable(String label, List<String> path) {
        if (StringUtils.isAllUpperCase(label)) {
            return true;
        }
        if (label.equals(Graph.LABEL_START)) {
            return false;
        }
        if (!path.contains(label)) {
            return true;
        }
        List<String> smallCaves = path.stream().filter(StringUtils::isAllLowerCase).collect(Collectors.toList());
        return !containsDuplicate(smallCaves);
    }

    private boolean containsDuplicate(List<String> list) {
        return list.stream().distinct().count() != list.size();
    }
}
