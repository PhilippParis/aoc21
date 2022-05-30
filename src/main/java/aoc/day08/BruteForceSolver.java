package aoc.day08;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BruteForceSolver {

    private static final Collection<List<String>> permutations = CollectionUtils.permutations(List.of("a", "b", "c", "d", "e", "f", "g"));

    public int solve(Display display) {
        for (List<String> mapping : permutations) {
            if (testMapping(display.getSignals(), mapping)) {
                return mapDigits(display.getOutputDigits(), mapping);
            }
        }
        return 0;
    }

    private int mapDigits(List<String> digits, List<String> mapping) {
        final StringBuilder builder = new StringBuilder();
        for (String signal : digits) {
            final Set<String> segments = map(signal, mapping);
            builder.append(Arrays.stream(Digit.values()).filter(i -> i.getSegments().equals(segments))
                    .map(Enum::ordinal).findFirst().orElse(0));
        }
        return Integer.parseInt(builder.toString());
    }

    private boolean testMapping(List<String> signals, List<String> mapping) {
        for (String signal : signals) {
            final Set<String> segments = map(signal, mapping);
            if (Arrays.stream(Digit.values()).noneMatch(i -> i.getSegments().equals(segments))) {
                return false;
            }
        }
        return true;
    }

    private Set<String> map(String value, List<String> mapping) {
        return Arrays.stream(value.split("")).map(i -> mapping.get(i.charAt(0) - 97)).collect(Collectors.toSet());
    }

}
