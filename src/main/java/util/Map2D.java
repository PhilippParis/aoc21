package util;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public abstract class Map2D<T> {

    protected final int width;
    protected final int height;
    protected final T[][] data;
    protected final Set<Vector2D> positions = new HashSet<>();

    public Map2D(List<String> input, Function<String, List<T>> rowMapper) {
        this(input.size() > 0 ? rowMapper.apply(input.get(0)).size() : 0, input.size());
        for (int y = 0; y < height; y++) {
            final List<T> row = rowMapper.apply(input.get(y));
            for (int x = 0; x < width; x++) {
                data[x][y] = row.get(x);
            }
        }
    }

    public Map2D(int width, int height) {
        this.width = width;
        this.height = height;
        data = (T[][]) Array.newInstance(getTypeClass(), width, height);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                positions.add(new Vector2D(x, y));
            }
        }
    }

    public void setAll(T value) {
        positions.forEach(i -> set(i, value));
    }

    public T get(int x, int y) {
        return data[x][y];
    }

    public T get(Vector2D pos) {
        return data[(int) pos.getX()][(int) pos.getY()];
    }

    public void set(Vector2D pos, T value) {
        data[(int) pos.getX()][(int) pos.getY()] = value;
    }

    public void apply(Vector2D pos, Function<T, T> modifier) {
        set(pos, modifier.apply(get(pos)));
    }

    protected abstract Class<T> getTypeClass();
}
