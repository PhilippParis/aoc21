package aoc.day16.packets;

import org.apache.commons.codec.DecoderException;
import aoc.day16.Header;
import aoc.day16.Transmission;

public class EqualToPacket extends OperatorPacket {
    public EqualToPacket(Header header, Transmission transmission) throws DecoderException {
        super(header, transmission);
    }

    @Override
    public long exec() {
        return getSubPackets().get(0).exec() == getSubPackets().get(1).exec() ? 1 : 0;
    }
}
