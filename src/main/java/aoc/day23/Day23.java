package aoc.day23;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day23 {

    private static final Set<State> cache = new HashSet<>();
    private int minEnergy = Integer.MAX_VALUE;

    public long exec(List<String> input) {
        minEnergy = Integer.MAX_VALUE;
        cache.clear();

        List<String> lines = input.stream().skip(2).limit(input.size() - 3).collect(Collectors.toList());
        move(new State(parse(lines)));
        return minEnergy;
    }

    private void move(State state) {
        if (cache.contains(state)) {
            return;
        }
        int currentEnergy = state.getEnergy();
        if (currentEnergy >= minEnergy) {
            return;
        }
        if (state.isSuccessful()) {
            minEnergy = Math.min(currentEnergy, minEnergy);
            return;
        }
        cache.add(state);
        state.next().forEach(this::move);
    }

    private HashMap<Vector2D, Amphipod> parse(List<String> lines) {
        HashMap<Vector2D, Amphipod> pods = new HashMap<>();
        for (int y = 0; y < lines.size(); y++) {
            for (int x = 0; x < lines.get(y).length(); x++) {
                char character = lines.get(y).charAt(x);
                if (character != '#' && character != ' ') {
                    pods.compute(new Vector2D(x - 1, y + 1), (k, v) -> new Amphipod(String.valueOf(character), k));
                }
            }
        }
        return pods;
    }

}
