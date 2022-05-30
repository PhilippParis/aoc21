package aoc.day19;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.HashSet;
import java.util.Set;

public class MatrixUtil {

    public static Set<RealMatrix> TRANSFORM_MATRICES = new HashSet<>();
    static {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    if (x != y  && y != z && x != z) {
                        for (int i = 0; i < 8; i++) {
                            double[][] data = new double[3][3];
                            data[x][0] = (i & (1L)) != 0 ? -1 : 1;
                            data[y][1] = (i & (1L << 1)) != 0 ? -1 : 1;
                            data[z][2] = (i & (1L << 2)) != 0 ? -1 : 1;
                            TRANSFORM_MATRICES.add(new Array2DRowRealMatrix(data));
                        }
                    }
                }
            }
        }
    }

}
