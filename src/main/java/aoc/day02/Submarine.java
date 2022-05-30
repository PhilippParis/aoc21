package aoc.day02;

import java.util.List;

public abstract class Submarine {
    protected int posHorizontal = 0;
    protected int depth = 0;

    abstract void exec(final Command command);

    public int exec(final List<Command> commands) {
        commands.forEach(this::exec);
        return posHorizontal * depth;
    }
}
