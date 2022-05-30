package aoc.day13;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day13 {

    public long part1(List<String> input) {
        final var delimiter = input.indexOf(StringUtils.EMPTY);
        final var points = getPoints(input.subList(0, delimiter));
        final var folds = getFolds(input.subList(delimiter + 1, input.size()));
        return fold(points, folds.subList(0, 1)).size();
    }

    public String part2(List<String> input) {
        final var delimiter = input.indexOf(StringUtils.EMPTY);
        final var points = getPoints(input.subList(0, delimiter));
        final var folds = getFolds(input.subList(delimiter + 1, input.size()));
        return print(fold(points, folds));
    }

    private Set<Vector2D> fold(Set<Vector2D> points, List<Vector2D> folds) {
        Set<Vector2D> result = new HashSet<>(points);
        for (Vector2D fold : folds) {
            result = result.stream().map(i -> fold(i, fold)).collect(Collectors.toSet());
        }
        return result;
    }

    private List<Vector2D> getFolds(List<String> lines) {
        return lines.stream().map(i -> i.split("=")).map(i -> {
            if (i[0].charAt(i[0].length() - 1) == 'x') {
                return new Vector2D(Integer.parseInt(i[1]), -1);
            } else {
                return new Vector2D(-1, Integer.parseInt(i[1]));
            }
        }).collect(Collectors.toList());
    }

    private Set<Vector2D> getPoints(List<String> lines) {
        return lines.stream().map(i -> i.split(",")).map(i -> new Vector2D(Integer.parseInt(i[0]),
                Integer.parseInt(i[1]))).collect(Collectors.toSet());
    }

    private Vector2D fold(Vector2D point, Vector2D fold) {
        if (fold.getX() >= 0 && point.getX() > fold.getX()) {
            return new Vector2D(fold.getX() - (point.getX() - fold.getX()), point.getY());
        }
        if (fold.getY() >= 0 && point.getY() > fold.getY()) {
            return new Vector2D(point.getX(), fold.getY() - (point.getY() - fold.getY()));
        }
        return point;
    }

    private String print(Set<Vector2D> points) {
        int width = (int) points.stream().mapToDouble(Vector2D::getX).max().orElse(0) + 1;
        int height = (int) points.stream().mapToDouble(Vector2D::getY).max().orElse(0) + 1;
        char[][] result = new char[height][width];

        IntStream.range(0, height * width).forEach(i -> result[i / width][i % width] = '.');
        points.forEach(i -> result[(int) i.getY()][(int) i.getX()] = '#');

        StringBuilder builder = new StringBuilder();
        Arrays.stream(result).forEach(i -> builder.append(new String(i)).append("\n"));
        return builder.toString();
    }
}
