import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

/**
 * Tests the behavior of a {@link TwoColorCellType}.
 */
public class TestTwoColorCellType {

    private TwoColorCellType tcc;
    private Color[] blackAndGreenArray;

    @BeforeEach
    void init() {
        blackAndGreenArray = new Color[]{Color.black, Color.green};
    }

    @Test
    void constructor_blackAndGreenArrayListForColors_instanceConstructed() {
        try {
            tcc = new TwoColorCellType(blackAndGreenArray);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
