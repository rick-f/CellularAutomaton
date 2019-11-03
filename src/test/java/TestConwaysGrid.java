import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
    List<ConwaysCell> validCellsColumn;
    List<ConwaysCell> getValidCellsColumn2;

    @BeforeEach
    void init() {
        try {
            grid1 = new ConwaysGrid();
            equalsGrid1 = new ConwaysGrid();
            grid2 = new ConwaysGrid(10, 20);
            grid3 = new ConwaysGrid(20, 10);
            List<ConwaysCell> validCellsColumn =
                    Arrays.asList(new ConwaysCell(0, 0), new ConwaysCell(0, 1), new ConwaysCell(0, 2));
            List<ConwaysCell> validCellsColumn2 =
                    Arrays.asList(new ConwaysCell(1, 0), new ConwaysCell(1, 1), new ConwaysCell(1, 2));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    void constructor_zeroXDimension_exception() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new ConwaysGrid(0, 10));
        assertEquals("The grid's length and width must each be greater than 0.", e.getMessage());
    }

    @Test
    void constructor_zeroYDimension_exception() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new ConwaysGrid(10, 0));
        assertEquals("The grid's length and width must each be greater than 0.", e.getMessage());
    }

    @Test
    void constructor_negativeXDimension_exception() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new ConwaysGrid(-8, 10));
        assertEquals("The grid's length and width must each be greater than 0.", e.getMessage());
    }

    @Test
    void constructor_negativeYDimension_exception() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new ConwaysGrid(10, -8));
        assertEquals("The grid's length and width must each be greater than 0.", e.getMessage());
    }

    @Test
    void constructor_givenCellsListIsNull_exception() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new ConwaysGrid(null));
        assertEquals("The cells list for this grid cannot be null.", e.getMessage());
    }

    @Test
    void constructor_nullColumnInGivenCellsList_exception() {
        List<List<ConwaysCell>> listWithNullColumn = Arrays.asList(validCellsColumn, null);

        Exception e =
                assertThrows(IllegalArgumentException.class, () -> new ConwaysGrid(listWithNullColumn));
        assertEquals("No columns in the cells list for this grid can be null.", e.getMessage());
    }

    @Test
    void constructor_nullCellInGivenCellsList_exception() {
        validCellsColumn.add(null);
        List<ConwaysCell> columnWithOneNullCell = validCellsColumn;
        List<List<ConwaysCell>> listWithOneNullCell = Arrays.asList(getValidCellsColumn2, columnWithOneNullCell);
        Exception e =
                assertThrows(IllegalArgumentException.class, () -> new ConwaysGrid(listWithOneNullCell));
        assertEquals("No cells in this grid's list of cells can be null.", e.getMessage());
    }

    @Test
    void setGen_validNumber_setsGenToGivenNumber() {
        assertEquals(0, grid1.getGen());
        grid1.setGen(8);
        assertEquals(8, grid1.getGen());
    }

    @Test
    void setGen_negativeNumber_exception() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> grid1.setGen(-8));
        assertEquals("The generation of this grid cannot be negative.", e.getMessage());
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

    //    @Test
    //    void getEquals_differentTypeOfGrid_false() {
    //
    //    }

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
