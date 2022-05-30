package aoc.day05;

import util.Map2D;

import java.util.List;

public class Map extends Map2D<Integer> {

    private final List<Line> lines;

    public Map(List<Line> lines) {
        super(lines.stream().mapToInt(Line::getMaxX).max().orElse(0) + 1,
                lines.stream().mapToInt(Line::getMaxY).max().orElse(0) + 1);
        this.lines = lines;
        setAll(0);
        drawLines();
    }

    public long getIntersectionCount() {
        return positions.stream().map(this::get).filter(i -> i > 1).count();
    }

    private void drawLines() {
        lines.forEach(this::drawLine);
    }

    private void drawLine(Line line) {
        line.getCoveredPoints().forEach(i -> apply(i, j -> j + 1));
    }

    @Override
    protected Class<Integer> getTypeClass() {
        return Integer.class;
    }
}
