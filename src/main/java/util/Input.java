package util;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Input {

    public static List<String> getExample(final int day) {
        return getInput(String.format("examples/%02d.txt", day));
    }

    public static List<String> getInput(final int day) {
        return getInput((String.format("inputs/%02d.txt", day)));
    }

    public static List<String> getInput(final String path) {
        try (final InputStream is = Input.class.getClassLoader().getResourceAsStream(path)) {
            if (is == null) {
                throw new IllegalArgumentException("file not found");
            }
            return IOUtils.readLines(is, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalArgumentException("failed to read file", e);
        }
    }

    public static String getFirstLine(final String path) {
        return getInput(path).get(0);
    }

}
