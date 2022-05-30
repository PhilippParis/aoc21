package aoc.day16.packets;

import org.apache.commons.codec.DecoderException;
import aoc.day16.Header;
import aoc.day16.Transmission;

public class MaxPacket extends OperatorPacket {
    public MaxPacket(Header header, Transmission transmission) throws DecoderException {
        super(header, transmission);
    }

    @Override
    public long exec() {
        return getSubPackets().stream().mapToLong(Packet::exec).max().orElse(0);
    }
}
