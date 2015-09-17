package algorithms.search;

import java.util.Stack;

/**
 * 
 * @author Yuval Admi
 * @since 26-08-2015
 * 
 * @param <T>
 * 
 *            The class Solution shows us the expected solution
 */
public class Solution<T> {
    public Stack<T> solution;

    /**
     * CTOR
     */
    public Solution() {
	solution = new Stack<T>();
    }

    /**
     * get the stack
     * 
     * @return this stack
     */
    public Stack<T> getSolution() {
	return solution;
    }

    /**
     * enter a T t to the stack
     * 
     * @param t
     */
    public void pushToStack(T t) {
	solution.push(t);
    }

    /**
     * set our stack with a new one
     * 
     * @param solution
     */
    public void setSolution(Stack<T> solution) {
	this.solution = solution;
    }

    /**
     * print method
     */
    public void print() {
	while (!this.getSolution().isEmpty())
	    System.out.print(solution.pop() + " ");
    }
}
