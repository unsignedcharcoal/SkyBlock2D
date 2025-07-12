package mini.carlos.skyblock.shared.world;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {

    private double offSetX, offSetY, offSetZ;
    private double x, y, z;

    public Position(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void add(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public void sub(double x, double y, double z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
    }

    public void add(double x, double y, double z, double offSetX, double offSetY, double offSetZ) {
        this.x += x;
        this.y += y;
        this.z += z;
        this.offSetX += offSetX;
        this.offSetY += offSetY;
        this.offSetZ += offSetZ;
    }

    public void sub(double x, double y, double z, double offSetX, double offSetY, double offSetZ) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
        this.offSetX -= offSetX;
        this.offSetY -= offSetY;
        this.offSetZ -= offSetZ;
    }

    public boolean same(int x, int y, int z) {
        return this.x == x && this.y == y && this.z == z;
    }
}
