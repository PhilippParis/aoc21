package aoc.day02;

public class SubmarineB extends Submarine {

    private int aim = 0;

    @Override
    public void exec(final Command command) {
        switch (command.getDirection()) {
            case FORWARD -> {
                posHorizontal += command.getUnits();
                depth += aim * command.getUnits();
            }
            case DOWN -> aim += command.getUnits();
            case UP -> aim -= command.getUnits();
        }
    }

}
