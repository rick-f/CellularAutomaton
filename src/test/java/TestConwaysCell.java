import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

/**
 * Tests the behavior of an instance of {@link ConwaysCell} with null values for its
 * neighbors.
 */
public class TestConwaysCell {

    private Cell defaultCell;
    private Cell defaultCell2;
    private Cell equalsDefaultCell;
    private Cell difCell1;
    private Cell difCell2;
    private Color[] blackAndGreen = new Color[]{Color.black, Color.green};
    private Color[] greenAndBlack = new Color[]{Color.green, Color.black};
    private Color[] whiteAndYellow = new Color[]{Color.white, Color.yellow};

    @BeforeEach
    void init() {
        try {
            defaultCell = new ConwaysCell();
            defaultCell2 = new ConwaysCell();
            equalsDefaultCell = new ConwaysCell(blackAndGreen);
            difCell1 = new ConwaysCell(greenAndBlack);
            difCell2 = new ConwaysCell(whiteAndYellow);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    void getState_justConstructed_0() {
        assertEquals(
                0,
                defaultCell.getState(),
                "Expected cell state to be 0 immediately following construction.");
    }

    @Test
    void getEquals_sameObject_true() {
        assertEquals(defaultCell, defaultCell);
    }

    @Test
    void getEquals_equalFields_true() {
        assertNotSame(defaultCell, defaultCell2);
        assertEquals(defaultCell, defaultCell2);
    }


    @Test
    void getEquals_equalFieldsDifConstructor_true() {
        assertNotSame(defaultCell, equalsDefaultCell);
        assertEquals(defaultCell, equalsDefaultCell);
    }

    @Test
    void getEquals_differentType_false() {
        CellType notAConwaysCell = new TwoColorCellType(blackAndGreen);
        assertNotEquals(defaultCell, notAConwaysCell);
    }

    @Test
    void getEquals_difColors_false() {
        assertNotEquals(defaultCell, difCell2);
    }

    @Test
    void getEquals_equalColorsDifOrder_false() {
        assertNotEquals(defaultCell, difCell1);
    }

    @Test
    void getEquals_sameFieldsExceptOn_false() {
        defaultCell2.setState(1);
        assertNotEquals(defaultCell, defaultCell2);
    }

//    @Test
//    void getEquals_sameFieldsExceptNeighbors_false() {
//
//    }

    @Test
    void hashCode_sameObject_equal() {
        assertEquals(defaultCell.hashCode(), defaultCell.hashCode());
    }

    @Test
    void hashCode_differentType_notEqual() {
        CellType notAConwaysCell = new TwoColorCellType(blackAndGreen);
        assertNotEquals(defaultCell.hashCode(), notAConwaysCell.hashCode());
    }

    @Test
    void hashcode_equalFields_equal() {
        assertEquals(defaultCell.hashCode(), defaultCell2.hashCode());
    }

    @Test
    void hashcode_equalFieldsDifConstructor_equal() {
        assertEquals(defaultCell.hashCode(), equalsDefaultCell.hashCode());
    }

    @Test
    void hashCode_differentFields_notEqual() {
        assertNotEquals(defaultCell.hashCode(), difCell1.hashCode());
    }
}
