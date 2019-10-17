import java.awt.*;

/**
 * Defines the qualities of a {@link Cell} which can exist in two states.
 */
public final class TwoColorCellType extends CellType {

    public TwoColorCellType(Color[] cellColors) {
        super(2, cellColors);
    }
}
