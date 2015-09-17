package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * 
 * @author Yuval Admi
 * @since 26-08-2015
 * @param <T>
 * 
 *            The class BFS<T> implements CommonSearcher<T> and override its
 *            methods
 */
public class BFS<T> extends CommonSearcher<T> {
    /**
     * This method implements the BFS search algorithm
     * 
     * @return Solution<T>
     */
    @Override
    public Solution<T> search(Searchable<T> s) {
	// add the start state to the open list
	addToOpenList(s.getStartState());
	HashSet<State<T>> closedSet = new HashSet<State<T>>();
	// while there is more states we have not checked yet
	while (openList.size() > 0) {
	    State<T> n = popOpenList();// dequeue
	    closedSet.add(n);
	    // if we found the path from the start state to the goal state
	    if ((n.getState()).equals(s.getGoalState().getState())) {
		// public method, back traces through the parents
		return backTrace(n);
	    }
	    ArrayList<State<T>> successors = s.getAllPossibleStates(n);
	    for (State<T> state : successors) {
		// update the cost and the parent
		state.setCost(n.getCost() + changeCost(state, s));
		state.setCameFrom(n);
		// if this is the first time we see this state
		if ((!closedSetContians(closedSet, state)) && (!openListContains(state))) {
		    addToOpenList(state);
		} else {
		    if (!closedSetContians(closedSet, state))
			findAndCompare(state);
		}
	    }

	}
	return null;
    }


    @Override
    public double changeCost(State<T> s, Searchable<T> search) {
	return search.getMoveCost();

    }
}