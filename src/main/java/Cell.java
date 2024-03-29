import java.awt.*;

/**
 * Defines methods for a square cell in a {@link Grid}. At any given time, a Cell is in a state,
 * which is represented by an integer (e.g. for a Cell which can exist in two possible states, 0 ==
 * OFF, 1 == ON). A Cell's number of possible states, as well as the {@link java.awt.Color} which is
 * associated with each state, is defined by the Cell's {@link CellType}.
 *
 */
public interface Cell {

    /**
     * Returns a numerical representation of the Cell's current state.
     */
    int getState();

    /**
     * Returns the number of possible states in which this Cell can exist.
     */
    int getNumStates();

    /**
     * Returns the possible colors this Cell can be, in an order corresponding to the state of the
     * Cell (i.e. returnValue[0] == colorOfThisCellInState0).
     */
    Color[] getColors();

    /**
     * Returns the coordinates of this Cell within its {@link Grid}.
     */
    CellCoordinates getCoords();

    /**
     * Sets the Cell's state to a new value.
     *
     * @param newState the numerical representation for the Cell's new state
     */
    void setState(int newState);

    @Override
    boolean equals(Object other);

    @Override
    int hashCode();
}
