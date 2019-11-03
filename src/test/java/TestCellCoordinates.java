import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCellCoordinates {

    CellCoordinates coords1;
    CellCoordinates coordsEquals1;
    CellCoordinates coords2;
    CellCoordinates coords3;
    Cell notCoords = new ConwaysCell(0, 0);

    @BeforeEach
    void init() {
        coords1 = new CellCoordinates(1, 2);
        coordsEquals1 = new CellCoordinates(1, 2);
        coords2 = new CellCoordinates(5, 6);
        coords3 = new CellCoordinates(2, 1);
    }

    @Test
    void constructor_negativeXValue_exception() {
        Exception exception =
                assertThrows(IllegalArgumentException.class, () -> new CellCoordinates(-1, 2));
        assertEquals("Cell coordinates cannot be negative.", exception.getMessage());
    }

    @Test
    void constructor_negativeYValue_exception() {
        Exception exception =
                assertThrows(IllegalArgumentException.class, () -> new CellCoordinates(2, -1));
        assertEquals("Cell coordinates cannot be negative.", exception.getMessage());
    }

    @Test
    void getEquals_sameObject_true() {
        assertEquals(coords1, coords1);
    }

    @Test
    void getEquals_sameValues_true() {
        assertNotSame(coords1, coordsEquals1);
        assertEquals(coords1, coordsEquals1);
    }

    @Test
    void getEquals_differentType_false() {
        assertNotEquals(coords1, notCoords);
    }

    @Test
    void getEquals_differentValues_false() {
        assertNotEquals(coords1, coords2);
    }

    @Test
    void hashCode_sameObject_equal() {
        assertEquals(coords1.hashCode(), coords1.hashCode());
    }

    @Test
    void hashCode_equalFields_equal() {
        assertEquals(coords1.hashCode(), coordsEquals1.hashCode());
    }

    @Test
    void hashCode_difObjects_notEqual() {
        assertNotEquals(coords1.hashCode(), notCoords.hashCode());
    }

    // the hashCode implementation is technically valid even if this test doesn't pass
    @Test
    void hashCode_difFields_notEqual() {
        assertNotEquals(coords1.hashCode(), coords2.hashCode());
    }

    // the hashCode implementation is technically valid even if this test doesn't pass
    @Test
    void hashCode_difFieldsSameTotal_notEqual() {
        assertNotEquals(coords1.hashCode(), coords3.hashCode());
    }
}
