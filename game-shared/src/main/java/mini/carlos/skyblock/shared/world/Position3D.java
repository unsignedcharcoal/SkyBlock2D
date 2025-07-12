package mini.carlos.skyblock.shared.world;

public record Position3D(int x, int y, int z) {
    public boolean same(int ox, int oy, int oz) {
        return this.x == ox && this.y == oy && this.z == oz;
    }

    public Position3D add(int dx, int dy, int dz) {
        return new Position3D(x + dx, y + dy, z + dz);
    }

    public Position3D sub(int dx, int dy, int dz) {
        return new Position3D(x - dx, y - dy, z - dz);
    }

    public String string(){
        return "Pos: X: " + x + ", Y: " + y + ", Z: " + z;
    }
}
