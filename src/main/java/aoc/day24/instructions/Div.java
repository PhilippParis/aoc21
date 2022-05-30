package aoc.day24.instructions;

import aoc.day24.Memory;

public class Div extends Instruction {

    public Div(String var1, String var2) {
        super(var1, var2);
    }

    @Override
    public void exec(Memory memory) {
        memory.set(var1, memory.get(var1) / memory.get(var2));
    }

    @Override
    public String toString() {
        return var1 + "=" + var1 + "/" + var2;
    }
}
