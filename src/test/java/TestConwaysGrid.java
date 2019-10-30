import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the behavior of a {@link Grid}.
 */
public class TestConwaysGrid {

    Grid grid1;
    Grid equalsGrid1;
    Grid grid2;
    Grid grid3;
    private CellCoordinates notAGrid = new CellCoordinates(0, 0);

    @BeforeEach
    void init() {
        try {
            grid1 = new ConwaysGrid();
            equalsGrid1 = new ConwaysGrid();
            grid2 = new ConwaysGrid(10, 20);
            grid3 = new ConwaysGrid(20, 10);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    void getEquals_sameObject_true() {
        assertEquals(grid1, grid1);
    }

    @Test
    void getEquals_equalFields_true() {
        assertNotSame(grid1, equalsGrid1);
        assertEquals(grid1, equalsGrid1);
    }

    @Test
    void getEquals_differentType_false() {
        assertNotEquals(grid1, notAGrid);
    }

    @Test
    void getEquals_equalExceptDifLength_false() {
        assertNotEquals(grid1, grid2);
    }

    @Test
    void getEquals_equalExceptDifWidth_false() {
        assertNotEquals(grid1, grid3);
    }

    @Test
    void getEquals_equalExceptGen_false() {
        equalsGrid1.setGen(1);
        assertNotEquals(grid1, equalsGrid1);
    }

    // Tests if a ConwaysGrid is equal to another with the same dimensions but with a Cell with a
    // different state than its matching cell in the other ConwaysGrid
    //    @Test
    //    void getEquals_equalExceptCellStates_false() {
    //
    //    }

    // Necessary?
    //    @Test
    //    void getEquals_equalExceptCellNeighbors_false() {
    //
    //    }

    @Test
    void hashCode_sameObject_equal() {
        assertEquals(grid1.hashCode(), grid1.hashCode());
    }

    @Test
    void hashcode_equalFields_equal() {
        assertEquals(grid1.hashCode(), equalsGrid1.hashCode());
    }

    @Test
    void hashCode_differentLength_notEqual() {
        assertNotEquals(grid1.hashCode(), grid2.hashCode());
    }

    @Test
    void hashCode_differentType_notEqual() {
        assertNotEquals(grid1.hashCode(), notAGrid.hashCode());
    }

    ////    @Test
    ////    void getCells_possiblyAliasedArray_notEquals() {
    ////    }
}
