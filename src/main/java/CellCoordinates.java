/**
 * Represents the coordinates of a {@link Cell} within its {@link Grid}. Immutable.
 */
public final class CellCoordinates {
    private final int x;
    private final int y;

    /**
     * Constructs a CellCoordinates with the given coordinates.
     *
     * @param x the number of {@link Cell}s to the left of this CellCoordinates' {@link Cell}, within
     *          its {@link Grid}
     * @param y the number of {@link Cell}s below this CellCoordinates' {@link Cell}, within its
     *          {@link * Grid} Grid}
     */
    CellCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof CellCoordinates)) {
            return false;
        } else {
            CellCoordinates that = (CellCoordinates) other;
            return this.x == that.x && this.y == that.y;
        }
    }

    @Override
    public int hashCode() {
        return this.x * 100000 + this.y;
    }
}
