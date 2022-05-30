package aoc.day24;

import aoc.day24.instructions.Instruction;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
z0 = w0 + 13
z1 = 26z0 + w1 + 10
z2 = 26z1 + w2 + 5
z3 = z2 + w3 + 14; z3 = z2/26
z4 = 26z3 + w4 + 5
z5 = z4 + w5 + 15; z5 = z4/26
z6 = 26z5 + w6 + 4
z7 = 26z6 + w7 + 11
z8 = 26z7 + w8 + 1
z9 = z8 + w9 + 15; z9 = z8/26
z10 = z9 + w10 + 12; z10 = z9/26
z11 = z10 + w11 + 8; z11 = z10/26
z12 = z11 + w12 + 14; z12 = z11/26
z13 = z12 + w13 + 9; z13 = z12/26
 */
public class Day24 {

    private List<Instruction> instructions;

    public Pair<Long, Long> exec(List<String> input) {
        instructions = input.stream().map(Instruction::parse).collect(Collectors.toList());

        Set<Memory> memories = new HashSet<>();
        memories.add(new Memory());

        for (Block block : getBlocks()) {
            Set<Memory> next = new HashSet<>();
            for (Memory memory : memories) {
                next.addAll(block.getResults(memory));
            }
            memories = next;
        }

        long max = 0;
        long min = Long.MAX_VALUE;
        for (Memory memory : memories) {
            if (memory.get("z") == 0) {
                long w = Long.parseLong(memory.getInputs().stream().map(String::valueOf).collect(Collectors.joining()));
                max = Math.max(max, w);
                min = Math.min(min, w);
            }
        }
        return Pair.of(min, max);
    }

    private List<Block> getBlocks() {
        List<List<Instruction>> parts = new ArrayList<>();
        List<Instruction> current = new ArrayList<>();
        for (Instruction instruction : instructions) {
            if (instruction instanceof aoc.day24.instructions.Input) {
                current = new ArrayList<>();
                parts.add(current);
            }
            current.add(instruction);
        }
        return parts.stream().map(Block::new).collect(Collectors.toList());
    }

}
