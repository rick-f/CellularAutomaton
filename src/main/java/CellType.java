/** Designates the type of a {@link Cell}. */
public class CellType<T> {

  /** the number of possible states this cell can be in* */
  private int numStates;

  /**
   * Constructs a CellType.
   *
   * @param numStates the number of possible states in which the associated {@link Cell} can exist.
   */
  public CellType(int numStates) {
    this.numStates = numStates;
  }
}
