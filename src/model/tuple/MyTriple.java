package model.tuple;

public class MyTriple extends MyPair {

    /**
     * z-coordinate
     */
    public int z;

    /**
     * Point (0,0,0)
     */
    public MyTriple() {
        z = 0;
    }

    /**
     * @param x x-coord
     * @param y y-coord
     * @param z z-coord
     */
    public MyTriple(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    /**
     * Set x and y at the same time
     *
     * @param x x-coord
     * @param y y-coord
     * @param z z-coord
     */
    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    /**
     * Take both coords from a point
     *
     * @param p point
     */
    public void setLocation(MyTriple p) {
        super.setLocation(p);
        this.z = p.z;
    }

    @Override
    public int getZ() {
        return z;
    }

    @Override
    public int hashCode() {
        return (super.hashCode() << 16) ^ z;
    }

    @Override
    public boolean equals(Object o) {
        // super also check z-coord
        return super.equals(o);
    }

    /**
     * @param d another 3D point
     * @return distance to that point
     */
    public double distance(MyTriple d) {
        return Math.sqrt((x - d.x) * (x - d.x) + (y - d.y) * (y - d.y)
                + (z - d.z) * (z - d.z));
    }

    /**
     * @param dx x-coord of other point
     * @param dy y-coord of other point
     * @param dz z-coord of other point
     * @return distance to (dx, dy, dz)
     */
    public double distance(double dx, double dy, double dz) {
        return (int) Math.sqrt((x - dx) * (x - dx) + (y - dy) * (y - dy)
                + (z - dz) * (z - dz));
    }

    @Override
    public String toString() {
        return x + " : " + y + " : " + z;
    }
}
