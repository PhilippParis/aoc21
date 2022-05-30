package aoc.day21;

public class DeterministicDice {

    private int rolls = 0;
    private int value = 0;

    public int roll() {
        rolls++;
        value = 1 + value % 100;
        return value;
    }

    public int getRolls() {
        return rolls;
    }
}
