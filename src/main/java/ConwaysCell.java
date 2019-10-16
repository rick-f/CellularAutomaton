/** Represents one cell in a {@link Grid} for an instance of Conway's Game of Life. */
public final class ConwaysCell implements Cell<TwoColorCell> {
  private boolean on;
  // TODO: assign neighbors on cell construction or grid construction?
  /**
   * The cells immediately adjacent to this cell, ordered clockwise: index 0 - North, index 1 -
   * Northeast, etc.
   */
  private final ConwaysCell[] neighbors = new ConwaysCell[8];

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
    return 2;
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
}
