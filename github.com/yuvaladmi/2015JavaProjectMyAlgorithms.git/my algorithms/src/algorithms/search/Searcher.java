package algorithms.search;

/**
 * 
 * @author Yuval Admi
 * @since 26-08-2015
 * 
 * @param <T>
 * 
 *            The Searcher<T> is an interface that has the following methods:
 */
public interface Searcher<T> {

    // the search method
    public Solution<T> search(Searchable<T> s);

    // get how many nodes were evaluated by the algorithm
    public int getNumberOfNodesEvaluated();

}
