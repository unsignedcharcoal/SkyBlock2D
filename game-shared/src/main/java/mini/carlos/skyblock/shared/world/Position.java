package mini.carlos.skyblock.shared.world;

import lombok.Data;

@Data
public class Position {

    private double offSetX, offSetY, offSetZ;
    private double x, y, z;

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
}
