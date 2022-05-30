package aoc.day02;

import org.apache.commons.lang3.StringUtils;

public class Command {

    private final Direction direction;
    private final int units;

    public static Command fromString(final String value) {
        String[] split = StringUtils.split(value, StringUtils.SPACE);
        return new Command(Direction.fromString(split[0]), Integer.parseInt(split[1]));
    }

    public Command(Direction direction, int units) {
        this.direction = direction;
        this.units = units;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getUnits() {
        return units;
    }
}
