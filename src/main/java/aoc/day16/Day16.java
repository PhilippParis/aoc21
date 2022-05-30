package aoc.day16;

import aoc.day16.packets.Packet;
import org.apache.commons.codec.DecoderException;

import java.util.List;

public class Day16 {

    public long part1(List<String> input) throws DecoderException {
        Transmission transmission = Transmission.fromHex(input.get(0));
        List<Packet> packets = Packet.parse(transmission);
        return packets.get(0).getVersionSum();
    }

    public long part2(List<String> input) throws DecoderException {
        Transmission transmission = Transmission.fromHex(input.get(0));
        List<Packet> packets = Packet.parse(transmission);
        return packets.get(0).exec();
    }
}
