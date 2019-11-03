import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

/** Represents one cell in a {@link Grid} for an instance of Conway's Game of Life. */
public final class ConwaysCell implements Cell {
    //  // The color of this ConwaysCell when it is off
    //  private Color offColor = Color.black;
    //  // The color of this ConwaysCell when it is on
    //  private Color onColor = Color.green;

    // TODO: should cellType be the sole place where colors are stored?
    private TwoColorCellType cellType = new TwoColorCellType(new Color[]{Color.black, Color.green});
  private boolean on = false;
    private final CellCoordinates coords;
  // TODO: assign neighbors on cell construction or grid construction?
  /**
   * The cells immediately adjacent to this cell, ordered clockwise: index 0 - North, index 1 -
   * Northeast, etc.
   */
  private final ConwaysCell[] neighbors =
          new ConwaysCell[]{null, null, null, null, null, null, null, null};

    /**
     * Constructs a ConwaysCell with the default {@link CellType} and state (field "on").
     */
    public ConwaysCell(int x, int y) {
        this.coords = new CellCoordinates(x, y);
    }

    /**
     * Constructs a ConwaysCell with the given colors assigned to its off and on states, respectively.
     *
     * @param customColors [0] = color to be displayed when this ConwaysCell is off; [1] = "..." on
     */
    public ConwaysCell(Color[] customColors, int x, int y) {
        cellType = new TwoColorCellType(customColors);
        this.coords = new CellCoordinates(x, y);
    }

  @Override
  public int getState() {
    if (on) {
        return 1;
    } else { //off
      return 0;
    }
  }

  @Override
  public int getNumStates() {
      return this.cellType.getNumStates();
  }

    @Override
    public Color[] getColors() {
        return this.cellType.getCellColors();
    }

    @Override
    public CellCoordinates getCoords() {
        return this.coords;
  }

  @Override
  public void setState(int newState) {
    if (newState == 0) {
      on = false;
    } else if (newState == 1) {
      on = true;
    } else {
        throw new IllegalArgumentException("Can only set a ConwaysCell to a state of 1 (on) or 0 (off).");
    }
  }

    // Two ConwaysCells with different coords and neighbors are equal nonetheless.
    // TODO: is this a reasonable way to define equality?
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ConwaysCell)) {
            return false;
        } else {
            ConwaysCell that = (ConwaysCell) other;
            return (this.getState() == that.getState() && this.getNumStates() == that.getNumStates())
                    && Arrays.equals(this.getColors(), that.getColors());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cellType, on);
  }
}
