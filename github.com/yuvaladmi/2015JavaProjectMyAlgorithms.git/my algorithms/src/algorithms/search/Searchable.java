package algorithms.search;

import java.util.ArrayList;

/**
 * 
 * @author Yuval Admi
 * @param <T>
 * 
 *            The Searchable<T> is an interface that has the following methods:
 */
public interface Searchable<T> {
    /**
     * This method returns the start state of the specific element
     * 
     * @return
     */
    State<T> getStartState();

    /**
     * This method returns the goal state of the specific element
     * 
     * @return
     */
    State<T> getGoalState();

    /**
     * This method gets a specific State<T> and finds all the possible states it
     * can move to.
     * 
     * @param s
     * @return
     */
    ArrayList<State<T>> getAllPossibleStates(State<T> s);

    /**
     * This method returns the cost of one move. Each class has a different
     * cost.
     * 
     * @return the cost of one move
     */
    double getMoveCost();

}
