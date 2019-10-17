import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Tests the behavior of an instance of {@link ConwaysCell} with null values for its
 * neighbors.
 */
public class TestIndivConwaysCell {

    private ConwaysCell defaultCell;

    @BeforeEach
    void init() {
        defaultCell = new ConwaysCell();
    }

    @Test
    void getState_justConstructed_0() {
        assertEquals(
                0,
                defaultCell.getState(),
                "Expected cell state to be 0 immediately following construction.");
    }
}
