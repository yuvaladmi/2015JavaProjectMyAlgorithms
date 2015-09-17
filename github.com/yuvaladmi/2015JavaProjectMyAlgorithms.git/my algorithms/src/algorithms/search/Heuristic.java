package algorithms.search;

/**
 * 
 * @author Yuval Admi
 * @since 26-08-2015
 *
 * @param <T>
 * 
 *            Heuristic<T> is an interface that has the following method:
 */
public interface Heuristic<T> {
    /**
     * This method calculate the distance between a current state to the goal state.
     * 
     * @param current
     * @param goal
     * @return the calculated cost
     */
    public double calculateDistance(State<T> current, State<T> goal);
}
