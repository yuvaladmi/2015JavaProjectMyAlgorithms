package algorithms.search;

/**
 * 
 * @author Yuval Admi
 * @since 26-08-2015
 * @param <T>
 * 
 *            The class AStar<T> extends the class BFS<T>
 */

public class AStar<T> extends BFS<T> {
    /**
     * @param h
     */
    private Heuristic<T> h;

    /**
     * CTOR - gets a type of Heuristic<T> which tells us how to calculate the
     * distance
     * 
     * @param h
     */
    public AStar(Heuristic<T> h) {
	this.h = h;
    }

    @Override
    public double changeCost(State<T> s, Searchable<T> search) {
	double temp = h.calculateDistance(s, search.getGoalState()) * search.getMoveCost();
	return (super.changeCost(s, search)) + temp;
    }

}
