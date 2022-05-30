package aoc.day24;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Memory {

    private final List<Long> inputs;
    private long w = 0;
    private long x = 0;
    private long y = 0;
    private long z = 0;

    public Memory() {
        inputs = new ArrayList<>();
    }

    public Memory(Memory memory) {
        this.w = memory.w;
        this.x = memory.x;
        this.y = memory.y;
        this.z = memory.z;
        this.inputs = new ArrayList<>(memory.inputs);
    }

    public long getInput() {
        return w;
    }

    public void setInput(long input) {
        inputs.add(input);
        w = input;
    }

    public void set(String var, long value) {
        switch (var) {
            case "w" ->  w = value;
            case "x" ->  x = value;
            case "y" ->  y = value;
            case "z" ->  z = value;
        }
    }

    public long get(String var) {
        return switch (var) {
            case "w" ->  w;
            case "x" ->  x;
            case "y" ->  y;
            case "z" ->  z;
            default -> Integer.parseInt(var);
        };
    }

    public List<Long> getInputs() {
        return inputs;
    }

    public long getZ() {
        return z;
    }

    public void setZ(long z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Memory memory = (Memory) o;
        return w == memory.w && x == memory.x && y == memory.y && z == memory.z && inputs.equals(memory.inputs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputs, w, x, y, z);
    }
}
