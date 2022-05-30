package aoc.day02;

public class SubmarineA extends Submarine {

    @Override
    public void exec(final Command command) {
        switch (command.getDirection()) {
            case FORWARD -> posHorizontal += command.getUnits();
            case DOWN -> depth += command.getUnits();
            case UP -> depth -= command.getUnits();
        }
    }

}
