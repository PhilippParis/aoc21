package aoc.day10;

import java.util.*;
import java.util.stream.Collectors;

public class Parser {

    private static final Map<Character, Character> chunks = Map.of('(', ')', '[', ']', '{', '}', '<', '>');

    public static Optional<Character> getIllegalCharacter(String line) {
        Stack<Character> stack = new Stack<>();
        for (Character c : line.toCharArray()) {
            if (chunks.containsKey(c)) {
                stack.push(c);
            } else if (!chunks.get(stack.pop()).equals(c)) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    public static Optional<List<Character>> getMissingChars(String line) {
        Stack<Character> stack = new Stack<>();
        for (Character c : line.toCharArray()) {
            if (chunks.containsKey(c)) {
                stack.push(c);
            } else if (!chunks.get(stack.pop()).equals(c)) {
                return Optional.empty();
            }
        }
        List<Character> result = stack.stream().map(chunks::get).collect(Collectors.toList());
        Collections.reverse(result);
        return Optional.of(result);
    }
}
