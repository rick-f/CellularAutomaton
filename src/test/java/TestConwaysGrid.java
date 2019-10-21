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

    @BeforeEach
    void init() {
        try {
            grid1 = new ConwaysGrid();
            equalsGrid1 = new ConwaysGrid();
            grid2 = new ConwaysGrid(10, 10);
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
        ConwaysCell notAGrid = new ConwaysCell();
        assertNotEquals(grid1, notAGrid);
    }

    @Test
    void getEquals_differentDimensions_false() {
        assertNotEquals(grid1, grid2);
    }

//    @Test
//    void getEquals_sameDimensionsDifferentCells_false() {
//
//    }

//    @Test
//    void getEquals_equalFieldsExceptGen_false() {
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
    void hashCode_differentDimensions_notEqual() {
        assertNotEquals(grid1.hashCode(), grid2.hashCode());
    }

//    @Test
//    void hashCode_sameDimensionsDifferentCells_notEqual() {
//
//    }

    @Test
    void hashCode_differentType_notEqual() {
        ConwaysCell notACellgrid = new ConwaysCell();
        assertNotEquals(grid1.hashCode(), notACellgrid.hashCode());
    }

////    @Test
////    void getCells_possiblyAliasedArray_notEquals() {
////    }

}
