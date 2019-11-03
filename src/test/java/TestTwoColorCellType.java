import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the behavior of a {@link TwoColorCellType}.
 */
public class TestTwoColorCellType {

  private CellType type1;
  //  private CellType type1Dup;
  private CellType equalsType1;
  private CellType type1Dif;
  private CellType type2;
  private CellCoordinates notACellType = new CellCoordinates(0, 0);

  @BeforeEach
  void init() {
    Color[] colors1 = new Color[]{Color.black, Color.green};
    Color[] equalsColors1 = new Color[]{Color.black, Color.green};
    Color[] colors1Dif = new Color[]{Color.green, Color.black};
    Color[] colors2 = new Color[]{Color.black, Color.yellow};

    try {
      type1 = new TwoColorCellType(colors1);
      //      type1Dup = new TwoColorCellType(colors1);
      equalsType1 = new TwoColorCellType(equalsColors1);
      type1Dif = new TwoColorCellType(colors1Dif);
      type2 = new TwoColorCellType(colors2);
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  void constructor_nullArray_exception() {
    Exception e = assertThrows(IllegalArgumentException.class, () -> new TwoColorCellType(null));
    assertEquals("The colors to make this cell type cannot be a null object.", e.getMessage());
  }

  @Test
  void constructor_nullColors_exception() {
    Exception e =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new TwoColorCellType(new Color[]{Color.green, null}));
    assertEquals("No color comprising this cell type can be null.", e.getMessage());
  }

  @Test
  void constructor_arrayTooLong_exception() {
    Exception e =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new TwoColorCellType(new Color[]{Color.green, Color.yellow, Color.black}));
    assertEquals("This cell type is comprised of exactly 2 colors.", e.getMessage());
  }

  @Test
  void constructor_arrayTooShort_exception() {
    Exception e =
            assertThrows(
                    IllegalArgumentException.class, () -> new TwoColorCellType(new Color[]{Color.green}));
    assertEquals("This cell type is comprised of exactly 2 colors.", e.getMessage());
  }

  @Test
  void constructor_sameColors_exception() {
    Exception e =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new TwoColorCellType(new Color[]{Color.green, Color.green}));
    assertEquals(
            "Each color comprising this cell type must be distinguishable from every other one.",
            e.getMessage());
  }

  @Test
  void getEquals_sameObject_true() {
    assertEquals(type1, type1);
  }

  @Test
  void getEquals_equalFields_true() {
    assertNotSame(type1, equalsType1);
    assertEquals(type1, equalsType1);
  }

  @Test
  void getEquals_differentType_false() {
    assertNotEquals(type1, notACellType);
  }

  @Test
  void getEquals_equalExceptDifColors_false() {
    assertNotEquals(type1, type2);
  }

  @Test
  void hashCode_sameObject_equal() {
    assertEquals(type1.hashCode(), type1.hashCode());
  }

  @Test
  void hashcode_equalFields_equal() {
    assertEquals(type1.hashCode(), equalsType1.hashCode());
  }

  @Test
  void getCellColors_possiblyAliasedArray_notEquals() {
    Color[] type1Colors = type1.getCellColors();
    Color[] possibleAlias = type1.getCellColors();
    assertNotSame(type1Colors, possibleAlias);
    //    possibleAlias[0] = possibleAlias[0].brighter();
    //    assertNotEquals(possibleAlias[0], type1Colors[0]);
    //    assertFalse(Arrays.equals(possibleAlias, type1Colors));
  }

  @Test
  void hashCode_differentColors_notEqual() {
    assertNotEquals(type1.hashCode(), type2.hashCode());
  }

  @Test
  void hashCode_differentType_notEqual() {
    assertNotEquals(type1.hashCode(), notACellType.hashCode());
  }

  //  @Test
  //  void hashCode_sameCellColorsDifferentOrder_equal() {
  //    assertEquals(type1.hashCode(), type1Dif.hashCode());
  //  }

  //  @Test
  //  void hashcode_type1_neg33487152() {
  //    assertEquals(-33489152, (Color.black.hashCode() + Color.green.hashCode()));
  //    assertEquals(-33487152, type1.hashCode());
  //  }
}
