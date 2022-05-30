package aoc.day20;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import util.Map2D;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Image extends Map2D<Integer> {

    private int background = 0;

    Image(int width, int height) {
        super(width, height);
    }

    Image(List<String> input) {
        super(input, i -> Arrays.stream(i.split("")).map(j -> j.equals("#") ? 1 : 0).collect(Collectors.toList()));
    }

    public Image enhance(String algorithm) {
        Image result = new Image(width + 2, height + 2);
        result.background = (background == 0 ? algorithm.charAt(0) : algorithm.charAt(511)) == '#' ? 1 : 0;
        for (Vector2D position : result.positions) {
            int algPos = getNeighboursAsBinary(position.subtract(new Vector2D(1, 1)));
            result.set(position, algorithm.charAt(algPos) == '#' ? 1 : 0);
        }
        return result;
    }

    public long getLitPixelCount() {
        return positions.stream().filter(i -> get(i) == 1).count();
    }

    private int getNeighboursAsBinary(Vector2D pos) {
        StringBuilder builder = new StringBuilder();
        for (int y = (int) pos.getY() - 1 ; y <= (pos.getY() + 1); y++) {
            for (int x = (int) pos.getX() - 1; x <= (pos.getX() + 1); x++) {
                if (x >= 0 && x < width && y >= 0 && y < height) {
                    builder.append(data[x][y]);
                } else {
                    builder.append(background);
                }
            }
        }
        return Integer.parseInt(builder.toString(), 2);
    }

    @Override
    protected Class<Integer> getTypeClass() {
        return Integer.class;
    }
}
