import java.util.List;

/**
 * Defines methods for an object representing a two-dimensional grid of {@link Cell}s. A Grid, when
 * controlled by a set of rules, is the foundation of an instance of a cellular automaton. A Grid
 * can be visually represented to convey the contents of a cellular automaton at a particular
 * generation.
 */
public interface Grid extends ViewGrid {

  String getName();

  GridType getType();

  int getLength();

  int getWidth();

  /**
   * Sets the automaton's generation.
   *
   * @param gen the automaton's generation
   */
  void setGen(int gen);

  /**
   * Returns a deep copy of the {@link Cell}s in this grid.
   */
  List<List<Cell>> getCells();
}
