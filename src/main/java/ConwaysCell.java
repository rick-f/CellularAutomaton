/** Represents one cell in a {@link Grid} for an instance of Conway's Game of Life. */
public class ConwaysCell implements Cell<Boolean> {
  private boolean on;

  // TODO: assign neighbors on cell construction or grid construction?
  private final ConwaysCell[] neighbors = new ConwaysCell[8];
}
