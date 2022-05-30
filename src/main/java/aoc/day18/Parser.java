package aoc.day18;

import org.apache.commons.lang3.StringUtils;

public class Parser {

    public static Node parse(String input) {
        if (StringUtils.isNumeric(input)) {
            return new Node(Integer.parseInt(input));
        }
        int index = getSplitIndex(input);
        return new Node(parse(input.substring(1, index)), parse(input.substring(index + 1, input.length() - 1)));
    }

    private static int getSplitIndex(String input) {
        int bracketCount = 0;
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[') bracketCount++;
            if (chars[i] == ']') bracketCount--;
            if (chars[i] == ',' && bracketCount == 1) return i;
        }
        throw new IllegalStateException();
    }

}
