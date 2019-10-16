/**
 * An alias of a {@link Grid} that cannot be mutated.
 */
public interface ViewGrid {

  /**
   * Returns a String representing the state of all {@link Cell}s in the aliased {@link Grid}.
   */
  String getGameState();
}
