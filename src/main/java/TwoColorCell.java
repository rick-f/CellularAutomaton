import java.awt.*;
import java.util.Collection;

/**
 * Defines the qualities of a {@link Cell} which can exist in two states.
 */
public final class TwoColorCell extends CellType {

    public TwoColorCell(int numStates, Collection<Color> cellColors) throws IllegalArgumentException {
        super(2, cellColors);
    }
}
