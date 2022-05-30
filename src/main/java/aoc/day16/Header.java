package aoc.day16;

public class Header {

    private final long version;
    private final Type type;

    public static Header parse(Transmission transmission) {
        return new Header(transmission.getDecimal(3), Type.parse(transmission.getDecimal(3)));
    }

    public Header(long version, Type type) {
        this.version = version;
        this.type = type;
    }

    public long getVersion() {
        return version;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Header{" +
                "version=" + version +
                ", type=" + type +
                '}';
    }
}
