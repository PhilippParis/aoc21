package aoc.day14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day14 {

    public long part1(List<String> input) {
        return getResult(input, 10);
    }

    public long part2(List<String> input) {
        return getResult(input, 40);
    }

    private long getResult(List<String> input, int steps) {
        final var template = parseTemplate(input.get(0));
        final var rules = parseRules(input.stream().skip(2).collect(Collectors.toList()));

        final var count = getElementCount(apply(template, rules, steps));
        final var max = count.values().stream().mapToLong(i -> i).max().orElse(0);
        final var min = count.values().stream().mapToLong(i -> i).min().orElse(0);
        return max - min;
    }

    private Map<String, Long> apply(Map<String, Long> template, Map<String, String> rules, int count) {
        Map<String, Long> result = template;
        for (int i = 0; i < count; i++) {
            result = apply(result, rules);
        }
        return result;
    }

    private Map<String, Long> apply(Map<String, Long> template, Map<String, String> rules) {
        Map<String, Long> result = new HashMap<>(template);
        for (Map.Entry<String, String> rule : rules.entrySet()) {
            Long count = template.getOrDefault(rule.getKey(), 0L);
            if (count > 0) {
                result.computeIfPresent(rule.getKey(),  (k, v) -> v - count);
                result.compute(rule.getKey().charAt(0) + rule.getValue(), (k, v) -> (v == null ? 0 : v) + count);
                result.compute(rule.getValue() + rule.getKey().charAt(1), (k, v) -> (v == null ? 0 : v) + count);
            }
        }
        return result;
    }

    private Map<String, Long> parseTemplate(String template) {
        return IntStream.range(2, template.length() + 1)
                .mapToObj(i -> template.substring(i - 2, i))
                .collect(Collectors.toMap(Function.identity(), i -> 1L, Long::sum));
    }

    private Map<String, Long> getElementCount(Map<String, Long> pairs) {
        Map<String, Long> result = new HashMap<>();
        for (Map.Entry<String, Long> pair : pairs.entrySet()) {
            result.compute(String.valueOf(pair.getKey().charAt(0)), (k, v) -> (v == null ? 0 : v) + pair.getValue());
            result.compute(String.valueOf(pair.getKey().charAt(1)), (k, v) -> (v == null ? 0 : v) + pair.getValue());
        }
        result.computeIfPresent("N", (k, v) -> v + 1);
        result.computeIfPresent("B", (k, v) -> v + 1);
        result = result.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, i -> i.getValue() / 2));
        return result;
    }

    private Map<String, String> parseRules(List<String> rules) {
        return rules.stream().map(i -> i.split(" -> ")).collect(Collectors.toMap(i -> i[0], i -> i[1]));
    }
}