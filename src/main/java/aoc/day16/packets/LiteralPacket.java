package aoc.day16.packets;

import aoc.day16.Header;
import aoc.day16.Transmission;

public class LiteralPacket extends Packet {

    private final long value;

    public LiteralPacket(Header header, Transmission transmission) {
        super(header);
        StringBuilder builder = new StringBuilder();
        boolean lastGroup;
        do {
            lastGroup = !transmission.getNextBit();
            builder.append(transmission.getString(4));
        } while (!lastGroup);
        value = Long.parseLong(builder.toString(), 2);
    }

    @Override
    public long getVersionSum() {
        return getHeader().getVersion();
    }

    @Override
    public long exec() {
        return value;
    }

    public long getValue() {
        return value;
    }
}
