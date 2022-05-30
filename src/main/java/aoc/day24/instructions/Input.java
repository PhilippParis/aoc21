package aoc.day24.instructions;

import aoc.day24.Memory;

public class Input extends Instruction {

    public Input(String var) {
        super(var, null);
    }

    @Override
    public void exec(Memory memory) {
        memory.set(var1, memory.getInput());
    }

    @Override
    public String toString() {
        return var1 + "=input";
    }

    @Override
    public String getRef1() {
        return null;
    }
}
