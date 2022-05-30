package aoc.day08;

import java.util.*;

public class Display {
    private List<String> signals;
    private List<String> outputDigits;

    public static Display fromString(String value) {
        String[] split = value.split(" \\| ");
        return new Display(Arrays.asList(split[0].split(" ")), Arrays.asList(split[1].split(" ")));
    }

    public Display(List<String> signals, List<String> outputDigits) {
        this.signals = signals;
        this.outputDigits = outputDigits;
    }

    public long getOutputDigitCount(Digit digit) {
        return outputDigits.stream().filter(i -> i.length() == digit.getSegmentCount()).count();
    }

    public String getSignalForDigit(Digit digit) {
        return signals.stream().filter(i -> i.length() == digit.getSegmentCount()).findFirst().orElse("");
    }

    public List<String> getSignals() {
        return signals;
    }

    public List<String> getOutputDigits() {
        return outputDigits;
    }


}
