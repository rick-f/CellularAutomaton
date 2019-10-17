import java.awt.*;
import java.util.ArrayList;

/** Represents one cell in a {@link Grid} for an instance of Conway's Game of Life. */
public final class ConwaysCell implements Cell<TwoColorCellType> {
  private static Color offColor = Color.black;
  private static Color onColor = Color.green;

  private CellType cellType = new TwoColorCellType(new Color[]{offColor, onColor});
  private boolean on = false;
  // TODO: assign neighbors on cell construction or grid construction?
  /**
   * The cells immediately adjacent to this cell, ordered clockwise: index 0 - North, index 1 -
   * Northeast, etc.
   */
  private final ConwaysCell[] neighbors =
          new ConwaysCell[]{null, null, null, null, null, null, null, null};

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
}
