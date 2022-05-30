package aoc.day12;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class VisitStrategyA implements VisitStrategy{
    @Override
    public boolean isVisitable(String label, List<String> path) {
        return StringUtils.isAllUpperCase(label) || !path.contains(label);
    }
}
