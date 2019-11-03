import java.awt.*;
import java.util.Arrays;

/**
 * Defines the qualities of a {@link Cell}.
 */
public abstract class CellType {

  /**
   * The number of possible states in which any associated {@link Cell} can exist. Must always equal
   * the number of entries in cellColors.
   */
  private int numStates;
  /**
   * The colors any associated {@link Cell} can present. Each color must be human-distinguishable,
   * and the number of entries must always equal numStates, such that each possible state
   * corresponds to a human-distinguishable color
   */
  private Color[] cellColors;

  /**
   * Constructs a CellType.
   *
   * @param numStates the number of possible states in which any associated {@link Cell} can exist.
   * @param cellColors the colors which any associated {@link Cell} can present
   * @throws IllegalArgumentException if not all the values of cellColors are unique from one
   *     another; if numStates does not equal the number of values in cellColors
   */
  public CellType(int numStates, Color[] cellColors) {
      if (0 < numStates && numStates <= 256 && numStates == cellColors.length) {
          // no duplicate Colors
          // TODO: check that cellColors are human-distinguishable
      if (cellColors.length == Arrays.stream(cellColors).distinct().toArray().length) {
        this.numStates = numStates;
        this.cellColors = cellColors;
      } else {
        throw new IllegalArgumentException(
                "Each cell color for the new CellType must be distinct.");
      }
    } else {
      throw new IllegalArgumentException(
              "The number of states for the new CellType must equal the number of possible colors for the new CellType.");
      }
  }

  /**
   * Returns the number of possible states in which any associated {@link Cell} can exist.
   */
  public int getNumStates() {
    return numStates;
  }

  public Color[] getCellColors() {
    return Arrays.copyOf(this.cellColors, this.numStates);
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof CellType)) {
      return false;
    } else {
      CellType that = (CellType) other;
      return this.getNumStates() == that.getNumStates()
              && Arrays.equals(this.getCellColors(), that.getCellColors());
    }
  }

  // If CellTypeA's CellColors includes the same Colors as CellTypeB's CellColors, but they are
  // ordered differently, then this method will return the same hashcode--but
  // CellTypeA.equals(CellTypeB) == false
  @Override
  public int hashCode() {
    return (this.getNumStates() * 1000)
            // add the sum of the hashcodes of the colors in CellColors
            + Arrays.stream(this.getCellColors())
            .reduce(
                    0,
                    (sum, color) -> sum + color.hashCode(),
                    Integer::sum);
  }
}
