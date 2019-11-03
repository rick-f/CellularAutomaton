import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

/**
 * Tests the behavior of an instance of {@link ConwaysCell} with null values for its neighbors.
 */
public class TestConwaysCell {

  private Cell defaultCell;
  private Cell defaultCell2;
  private Cell equalsDefaultCell;
  private Cell difCell1;
  private Cell difCell2;
  private Cell difCellOn;
  private Color[] blackAndGreen = new Color[]{Color.black, Color.green};
  private Color[] greenAndBlack = new Color[]{Color.green, Color.black};
  private Color[] whiteAndYellow = new Color[]{Color.white, Color.yellow};
  private CellCoordinates notAConwaysCell = new CellCoordinates(0, 0);

  @BeforeEach
  void init() {
    try {
      defaultCell = new ConwaysCell(0, 0);
      defaultCell2 = new ConwaysCell(0, 0);
      equalsDefaultCell = new ConwaysCell(blackAndGreen, 0, 0);
      difCell1 = new ConwaysCell(greenAndBlack, 0, 0);
      difCell2 = new ConwaysCell(whiteAndYellow, 0, 0);
      difCellOn = new ConwaysCell(0, 0);
      difCellOn.setState(1);
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  // tested elsewhere? or not, since the constructor implementation could change?
  //  @Test
  //  void constructor_tooFewColors_exception() {  }
  //
  //  @Test
  //  void constructor_tooManyColors_exception() {  }

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
    assertNotEquals(defaultCell, notAConwaysCell);
  }

  @Test
  void getEquals_equalExceptDifColors_false() {
    assertNotEquals(defaultCell, difCell2);
  }

  @Test
  void getEquals_equalExceptColorsDifOrder_false() {
    assertNotEquals(defaultCell, difCell1);
  }

  @Test
  void getEquals_equalExceptOn_false() {
    defaultCell2.setState(1);
    assertNotEquals(defaultCell, defaultCell2);
  }

  //    @Test
  //    void getEquals_equalExceptDifCoords_true() {
  //
  //    }

  //    @Test
  //    void getEquals_equalExceptDifNeighbors_true() {
  //
  //    }

  @Test
  void hashCode_sameObject_equal() {
    assertEquals(defaultCell.hashCode(), defaultCell.hashCode());
  }

  @Test
  void hashCode_differentType_notEqual() {
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

  // this test need not pass for the implementations of hashCode and equals to be valid
  //    @Test
  //    void hashCode_differentFields_notEqual() {
  //        assertNotEquals(defaultCell.hashCode(), difCell1.hashCode());
  //    }

  @Test
  void getNumStates_conwaysCell_2() {
    assertEquals(defaultCell.getNumStates(), 2);
  }

  @Test
  void getState_justConstructed_0() {
    assertEquals(0, defaultCell.getState());
  }

  @Test
  void getState_on_1() {
    assertEquals(1, difCellOn.getState());
  }

  @Test
  void getCoords_x0AndY0() {
    assertEquals(defaultCell.getCoords(), notAConwaysCell);
  }

  @Test
  void getCellColors_possiblyAliasedArray_notEquals() {
    Color[] defaultColors = defaultCell.getColors();
    Color[] possibleAlias = defaultCell.getColors();
    assertNotSame(defaultColors, possibleAlias);
  }

  @Test
  void getCellColors_whiteAndYellow_whiteAndYellow() {
    assertArrayEquals(whiteAndYellow, difCell2.getColors());
  }

  //  @Test
  //  void getCellColors_sameColorsDifCells_equals() {}

  @Test
  void setState_validNumber_setsStateToGivenNumber() {
    assertEquals(0, defaultCell.getState());
    defaultCell.setState(1);
    assertEquals(1, defaultCell.getState());
  }

  @Test
  void setState_numberTooLarge_exception() {
    Exception exception =
            assertThrows(IllegalArgumentException.class, () -> defaultCell.setState(3));
    assertEquals(
            "Can only set a ConwaysCell to a state of 1 (on) or 0 (off).", exception.getMessage());
  }

  @Test
  void setState_negativeNumber_exception() {
    Exception exception =
            assertThrows(IllegalArgumentException.class, () -> defaultCell.setState(-1));
    assertEquals(
            "Can only set a ConwaysCell to a state of 1 (on) or 0 (off).", exception.getMessage());
  }
}
