package aoc.day24.instructions;

import aoc.day24.Memory;

public abstract class Instruction {

    protected final String var1;
    protected final String var2;

    public Instruction(String var1, String var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    public static Instruction parse(String line) {
        String arg1 = String.valueOf(line.charAt(4));
        if (line.startsWith("inp")) {
            return new Input(arg1);
        }
        String arg2 = line.substring(6);
        if (line.startsWith("add")) {
            return new Add(arg1, arg2);
        }
        if (line.startsWith("mul")) {
            return new Mul(arg1, arg2);
        }
        if (line.startsWith("div")) {
            return new Div(arg1, arg2);
        }
        if (line.startsWith("mod")) {
            return new Mod(arg1, arg2);
        }
        if (line.startsWith("eql")) {
            return new Eql(arg1, arg2);
        }
        throw new IllegalArgumentException();
    }

    public abstract void exec(Memory memory);

    public String getVar1() {
        return var1;
    }

    public String getVar2() {
        return var2;
    }

    public String getRef1() {
        return var1;
    }

    public String getRef2() {
        return var2;
    }

}
