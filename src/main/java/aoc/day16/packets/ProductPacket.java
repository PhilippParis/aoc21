package aoc.day16.packets;

import org.apache.commons.codec.DecoderException;
import aoc.day16.Header;
import aoc.day16.Transmission;

public class ProductPacket extends OperatorPacket {
    public ProductPacket(Header header, Transmission transmission) throws DecoderException {
        super(header, transmission);
    }

    @Override
    public long exec() {
        return getSubPackets().stream().mapToLong(Packet::exec).reduce(1, (i, j) -> i * j);
    }
}
