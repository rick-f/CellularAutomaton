import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a two-dimensional grid of {@link ConwaysGrid}s. A ConwaysGrid, when controlled by a
 * set of rules, is the foundation of an instance of the cellular automaton Conway's Game of Life. A
 * ConwaysGrid can be visually represented to convey the contents of Conway's Game of Life at a
 * particular generation.
 */
public final class ConwaysGrid implements Grid {
    // TODO: how to represent rules?

    private static final GridType GRID_TYPE = GridType.CGOL;
    private int length = 20;
    private int width = 20;
    private int gen = 0;
    // cells.size() == this.length | cells.get(0 <= x <= this.length).size() == this.width. No nulls.
    private List<List<ConwaysCell>> cells;
    //    private String gameName;

    /**
     * Constructs a ConwaysGrid with the default length, width, and gen. On construction all {@link
     * Cell}s are off, with no neighbors.
     */
    ConwaysGrid() {
        this.cells = getCellsForDimensions(this.length, this.width);
    }

    /**
     * Constructs a ConwaysGrid with the default gen and the given length and width. On construction
     * all {@link Cell}s are off, with no neighbors.
     *
     * @param length the length (x-axis) of this Grid in {@link Cell}s
     * @param width  the width (y-axis) of this Grid in {@link Cell}s
     */
    ConwaysGrid(int length, int width) {
        this.length = length;
        this.width = width;
        this.cells = getCellsForDimensions(this.length, this.width);
    }

    /**
     * Constructs a ConwaysGrid with the default gen and the given {@link Cell}s.
     *
     * @param cellsList the {@link Cell}s to comprise this ConwaysGrid.
     */
    ConwaysGrid(List<List<ConwaysCell>> cellsList) {
        this.length = cellsList.size();
        this.width = cellsList.get(0).size();
        this.cells = cellsList;
    }

    private static List<List<ConwaysCell>> getCellsForDimensions(int length, int width) {
        List<List<ConwaysCell>> cellsList = new ArrayList<>(length);

        for (List<ConwaysCell> cellsColumn : cellsList) { // TODO: make sure this works at all
            cellsColumn = new ArrayList<>(width);

            for (ConwaysCell cell : cellsColumn) {
                //                cell = new ConwaysCell();
                // TODO: initialize coords
                // TODO: initialize cell neighbors
            }
        }
        return cellsList;
    }

    // TODO: Builder pattern? Will want to specify cells to be on/off at start

    // TODO: implement methods

    @Override
    public void setGen(int gen) {
        // do nothing
    }

    @Override
    public List<List<Cell>> getCells() {
        return null;
    }

    @Override
    public GridType getType() {
        return null;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getGen() {
        return 0;
    }

    @Override
    public String getGameState() {
        return null;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ConwaysGrid)) {
            return false;
        } else {
            ConwaysGrid that = (ConwaysGrid) other;
            return this.getLength() == that.getLength()
                    && this.getWidth() == that.getWidth()
                    && this.getGen() == that.getGen()
                    && Arrays.deepEquals(this.getCells().toArray(), that.getCells().toArray());
        }
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
