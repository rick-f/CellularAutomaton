/**
 * An alias of a {@link Grid} that cannot be mutated.
 */
public interface ViewGrid {

    /**
     * Returns the type of cellular automaton this Grid comprises in part.
     */
    GridType getType();

    /**
     * Returns the length (x-axis) of this Grid in {@link Cell}s.
     */
    int getLength();

    /**
     * Returns the width (y-axis) of this Grid in {@link Cell}s.
     */
    int getWidth();

//  /** Returns the assigned name for this Grid. */
//  String getName();

    /**
     * Returns the current generation of this Grid.
     */
    int getGen();

  /**
   * Returns a String representing the state of all {@link Cell}s in the aliased {@link Grid}.
   */
  String getGameState();

    @Override
    boolean equals(Object other);

    @Override
    int hashCode();
}
