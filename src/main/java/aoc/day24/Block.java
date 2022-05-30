package aoc.day24;

import aoc.day24.instructions.Instruction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Block {

    private final List<Instruction> instructions;

    public Block(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public Set<Memory> getResults(Memory input) {
        Set<Memory> result = new HashSet<>();
        for (int w = 1; w < 10; w++) {
            if (isDiv26()) {
                if (testCondition(input, w)) {
                    result.add(execDiv26Case(input, w));
                }
            } else {
                result.add(exec(input, w));
            }
        }
        return result;
    }

    private Memory exec(Memory input, int w) {
        Memory output = new Memory(input);
        output.setInput(w);
        instructions.forEach(i -> i.exec(output));
        return output;
    }

    private Memory execDiv26Case(Memory input, int w) {
        Memory output = new Memory(input);
        output.setInput(w);
        output.setZ(input.getZ() / 26);
        return output;
    }

    private boolean isDiv26() {
        return instructions.get(4).getVar2().equals("26");
    }

    private boolean testCondition(Memory input, int w) {
        return (input.getZ() % 26 + Integer.parseInt(instructions.get(5).getVar2())) == w;
    }

}
