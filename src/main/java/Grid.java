/**
 * Defines methods for a two-dimensional grid of {@link Cell}s. A Grid, when controlled by a set of
 * rules and visualized in some format, is the foundation of an instance of a cellular automaton.
 */
public interface Grid extends ViewGrid {

  String getName();

  GridType getType();

  /**
   * Sets the automaton's generation.
   *
   * @param gen the automaton's generation
   */
  void setGen(int gen);
}
