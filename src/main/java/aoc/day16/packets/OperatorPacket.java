package aoc.day16.packets;

import org.apache.commons.codec.DecoderException;
import aoc.day16.Header;
import aoc.day16.Transmission;

import java.util.List;

public abstract class OperatorPacket extends Packet {

    List<Packet> subPackets;

    public OperatorPacket(Header header, Transmission transmission) throws DecoderException {
        super(header);
        if (transmission.getNextBit()) {
            int count = transmission.getDecimal(11);
            subPackets = Packet.parse(transmission, count);
        } else {
            int length = transmission.getDecimal(15);
            subPackets = Packet.parse(transmission.get(length));
        }
    }

    public List<Packet> getSubPackets() {
        return subPackets;
    }

    @Override
    public long getVersionSum() {
        return getHeader().getVersion() + subPackets.stream().mapToLong(Packet::getVersionSum).sum();
    }
}
