package aoc.day22;

import org.apache.commons.math3.geometry.euclidean.threed.Euclidean3D;
import org.apache.commons.math3.geometry.euclidean.threed.PolyhedronsSet;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.partitioning.Region;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cuboid {

    private static final Pattern pattern = Pattern.compile("(on|off) x=(?<xmin>-?[0-9]*)\\.\\.(?<xmax>-?[0-9]*),y=(?<ymin>-?[0-9]*)\\.\\.(?<ymax>-?[0-9]*),z=(?<zmin>-?[0-9]*)\\.\\.(?<zmax>-?[0-9]*)");

    private Vector3D min;
    private Vector3D max;
    private boolean on;

    public static Cuboid parse(String input) {
        Matcher m = pattern.matcher(input);
        if (!m.matches()) {
            throw new IllegalArgumentException();
        }
        return new Cuboid(new Vector3D(Integer.parseInt(m.group("xmin")), Integer.parseInt(m.group("ymin")),
                Integer.parseInt(m.group("zmin"))),
                new Vector3D(Integer.parseInt(m.group("xmax")), Integer.parseInt(m.group("ymax")),
                        Integer.parseInt(m.group("zmax"))),
                input.startsWith("on")
        );
    }

    private Cuboid(Vector3D min, Vector3D max, boolean on) {
        this.min = min;
        this.max = max;
        this.on = on;
    }

    public boolean isOn() {
        return on;
    }

    public boolean isInRange(int minRange, int maxRange) {
        return min.getX() >= minRange && max.getX() <= maxRange &&
                min.getY() >= minRange && max.getY() <= maxRange &&
                min.getZ() >= minRange && max.getZ() <= maxRange;
    }

    public Region<Euclidean3D> getRegion() {
        return new PolyhedronsSet(
                min.getX(), max.getX() + 1, min.getY(), max.getY() + 1, min.getZ(), max.getZ() + 1, 0.000001);
    }
}
