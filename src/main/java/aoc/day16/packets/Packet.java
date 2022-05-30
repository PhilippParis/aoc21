package aoc.day16.packets;

import org.apache.commons.codec.DecoderException;
import aoc.day16.Header;
import aoc.day16.Transmission;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Packet {

    private final Header header;

    public static List<Packet> parse(Transmission transmission) throws DecoderException {
        return parse(transmission, Integer.MAX_VALUE);
    }

    public static List<Packet> parse(Transmission transmission, int max) throws DecoderException {
        List<Packet> packets = new ArrayList<>();
        Optional<Packet> next;
        while (packets.size() < max && (next = getNext(transmission)).isPresent()) {
            packets.add(next.get());
        }
        return packets;
    }

    private static Optional<Packet> getNext(Transmission transmission) throws DecoderException {
        if (transmission.size() < 10) {
            return Optional.empty();
        }
        Header header = Header.parse(transmission);
        return switch (header.getType()) {
            case LITERAL -> Optional.of(new LiteralPacket(header, transmission));
            case SUM -> Optional.of(new SumPacket(header, transmission));
            case PRODUCT -> Optional.of(new ProductPacket(header, transmission));
            case MIN -> Optional.of(new MinPacket(header, transmission));
            case MAX -> Optional.of(new MaxPacket(header, transmission));
            case GREATER_THAN -> Optional.of(new GreaterThanPacket(header, transmission));
            case LESS_THAN -> Optional.of(new LessThanPacket(header, transmission));
            case EQUAL -> Optional.of(new EqualToPacket(header, transmission));
        };
    }

    public abstract long getVersionSum();

    public abstract long exec();

    public Packet(Header header) {
        this.header = header;
    }

    public Header getHeader() {
        return header;
    }
}
