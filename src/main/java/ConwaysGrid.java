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
        List<List<ConwaysCell>> cellsList = new ArrayList<>();

        for (int x = 0; x < length; x++) {
//      cellsList.add(new ArrayList<>(width));
//      List<ConwaysCell> cellsColumn = cellsList.get(x);
            List<ConwaysCell> cellsColumn = new ArrayList<>(width);

            for (int y = 0; y < width; y++) {
                cellsColumn.add(new ConwaysCell(x, y));
                // TODO: initialize coords
                // TODO: initialize cell neighbors
            }
            cellsList.add(cellsColumn);
        }
        return cellsList;
    }

    // TODO: Builder pattern? Will want to specify cells to be on/off at start

    // TODO: implement methods

    @Override
    public void setGen(int gen) {
        this.gen = gen;
    }

    //TODO: make a deep copy
    @Override
    public List<? extends List<? extends Cell>> getCells() {
        return this.cells;
    }

    @Override
    public GridType getType() {
        return GRID_TYPE;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getGen() {
        return this.gen;
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
        return (this.gen * 1000000000)
                + (this.length * 10000)
                + this.width
                + this.cells.stream().reduce(0, (sum, cell) -> sum + cell.hashCode(), Integer::sum);
    }
}
