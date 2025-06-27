package mini.carlos.skyblock.shared.world;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {

    private int x;
    private int y;
    private int z;

    private int offX;
    private int offY;
    private int offZ;

    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.offX = 0;
        this.offY = 0;
        this.offZ = 0;
    }

    public static Position of(int x, int y, int z) {
        return new Position(x, y, z);
    }

    public static Position of(int x, int y, int z, int offX, int offY, int offZ) {
        return new Position(x, y, z, offX, offY, offZ);
    }

    public int getWorldX() {
        return x + offX;
    }

    public int getWorldY() {
        return y + offY;
    }

    public int getWorldZ() {
        return z + offZ;
    }

    public void setOffset(int dx, int dy, int dz) {
        this.offX = dx;
        this.offY = dy;
        this.offZ = dz;
    }

    public void resetOffset() {
        this.offX = 0;
        this.offY = 0;
        this.offZ = 0;
    }
}
