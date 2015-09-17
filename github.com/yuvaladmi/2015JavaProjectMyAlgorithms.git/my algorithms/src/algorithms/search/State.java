package algorithms.search;

/**
 * 
 * @author Yuval Admi
 * @since 26-08-2015
 * 
 * @param <T>
 *            represent the type of our state
 * 
 *            The class State represent a specific state that includes:
 * @param state
 *            - location
 * @param cost
 *            - the weight of the path
 * @param cameFrom
 *            - the previous State
 */
public class State<T> {
    private T state;
    private double cost; // cost to reach this state
    private State<T> cameFrom;

    /**
     * CTOR
     * 
     * @param state
     */
    public State(T state) { // CTOR
	this.state = state;
	this.cost = 0;
	this.cameFrom = null;
    }

    /**
     * Copy CTOR
     * 
     * @param s
     */
    public State(State<T> s) {
	this.state = s.state;
	this.cost = s.cost;
	this.cameFrom = s.cameFrom;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) { // we override Object's equals method
	return state.equals(((State<T>) (obj)).getState());
    }

    /**
     * get State
     * 
     * @return this state
     */
    public T getState() {
	return state;
    }

    /**
     * set State
     * 
     * @param state
     */
    public void setState(T state) {
	this.state = state;
    }

    /**
     * get cost
     * 
     * @return this.cost
     */
    public double getCost() {
	return cost;
    }

    /**
     * set cost
     * 
     * @param cost
     */
    public void setCost(double cost) {
	this.cost = cost;
    }

    /**
     * get the previous state
     * 
     * @return cameFrom
     */
    public State<T> getCameFrom() {
	return cameFrom;
    }

    /**
     * set the previous state
     * 
     * @param cameFrom
     */
    public void setCameFrom(State<T> cameFrom) {
	this.cameFrom = cameFrom;
    }

    /**
     * print method
     */
    public void print() {
	System.out.print("{" + state + "," + cost + "}");
	System.out.println();
    }

}
