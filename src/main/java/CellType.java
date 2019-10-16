import java.awt.*;
import java.util.Collection;

/**
 * Defines the qualities of a {@link Cell}.
 */
public abstract class CellType {

  /**
   * The number of possible states in which any associated {@link Cell} can exist
   */
  private int numStates;
  /**
   * The colors any associated {@link Cell} can present. Each color must be human-distinguishable,
   * and the number of colors must equal numStates, such that each possible state corresponds to a
   * human-distinguishable color
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
  public CellType(int numStates, Collection<Color> cellColors) {
    if (cellColors.size() == numStates) {
      // each Color in cellColors is distinct from the others
      if (cellColors.size() == cellColors.stream().distinct().toArray().length) {
        this.numStates = numStates;
        this.cellColors = (Color[]) cellColors.toArray();
      } else {
        throw new IllegalArgumentException(
                "Each cell color for the new CellType must be distinct.");
      }
    } else {
      throw new IllegalArgumentException(
              "The number of states for the new CellType must equal the number of possible colors for the new CellType.");
    } // TODO: check that cellColors are human-distinguishable?
  }
}
