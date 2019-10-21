import java.awt.*;

/** Represents one cell in a {@link Grid} for an instance of Conway's Game of Life. */
public final class ConwaysCell implements Cell<TwoColorCellType> {
    // The color of this ConwaysCell when it is off
    private Color offColor = Color.black;
    // The color of this ConwaysCell when it is on
    private Color onColor = Color.green;

    private TwoColorCellType cellType = new TwoColorCellType(new Color[]{offColor, onColor});
  private boolean on = false;
  // TODO: assign neighbors on cell construction or grid construction?
  /**
   * The cells immediately adjacent to this cell, ordered clockwise: index 0 - North, index 1 -
   * Northeast, etc.
   */
  private final ConwaysCell[] neighbors =
          new ConwaysCell[]{null, null, null, null, null, null, null, null};

    /**
     * Constructs a ConwaysCell with the above specified offColor, onColor, and state (field "on").
     */
    public ConwaysCell() {
    }

    /**
     * Constructs a ConwaysCell with the given offColor and onColor.
     *
     * @param customColors [0] = color to be displayed when this ConwaysCell is off; [1] = "..." on
     */
    public ConwaysCell(Color[] customColors) {
        offColor = customColors[0];
        onColor = customColors[1];
        cellType = new TwoColorCellType(new Color[]{offColor, onColor});
    }

  @Override
  public int getState() {
    if (on) {
      return 1;
    } else {
      return 0;
    }
  }

  @Override
  public int getNumStates() {
    return this.cellType.getNumStates();
  }

  @Override
  public void setState(int newState) {
    if (newState == 0) {
      on = false;
    } else if (newState == 1) {
      on = true;
    } else {
      throw new IllegalArgumentException("Can only set a ConwaysCell to a state of 1 or 0.");
    }
  }

    @Override
    public boolean equals(Object other) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
