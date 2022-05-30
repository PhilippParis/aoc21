package aoc.day16;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.Collector;

public class Transmission {

    private final String buffer;
    private int index = 0;

    public static Transmission fromHex(String hex) throws DecoderException {
        return new Transmission(Arrays.stream(hex.split("")).map(i -> Integer.parseInt(i, 16))
                .map(Integer::toBinaryString)
                .map(i -> StringUtils.leftPad(i, 4, "0"))
                .collect(Collector.of(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString)));
    }

    public Transmission(String binaryString) throws DecoderException {
        buffer = binaryString;
    }

    public int size() {
        return buffer.length() - index;
    }

    public Transmission get(int bitLength) throws DecoderException {
        index += bitLength;
        return new Transmission(buffer.substring(index - bitLength, index));
    }

    public int getDecimal(int bitLength) {
        index += bitLength;
        return Integer.parseInt(buffer.substring(index - bitLength, index), 2);
    }

    public String getString(int bitLength) {
        index += bitLength;
        return buffer.substring(index - bitLength, index);
    }

    public boolean getNextBit() {
        index += 1;
        return buffer.charAt(index - 1) == '1';
    }

    @Override
    public String toString() {
        return "Transmission{" +
                "index='" + index + '\'' +
                ", buffer=" + buffer +
                '}';
    }
}
