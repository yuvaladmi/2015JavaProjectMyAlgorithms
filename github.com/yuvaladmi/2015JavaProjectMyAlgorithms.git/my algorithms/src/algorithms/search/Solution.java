package algorithms.search;

import java.io.Serializable;
import java.util.Stack;

import algorithms.mazeGenerators.Position;

/**
 * 
 * @author Yuval Admi
 * @since 26-08-2015
 * 
 * @param <T>
 * 
 *            The class Solution shows us the expected solution
 */
public class Solution<T> implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 4L;
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
    @Override
    public String toString(){
	String solutionString = new String();
	while (!this.getSolution().isEmpty())
	    solutionString+=(" "+solution.pop());
	return solutionString;
    }
    @Override
    public boolean equals(Object solution){
	Solution<T> obj = (Solution<T>) solution;
	Stack<T> firstStack = this.getSolution();
	Stack<T> secondStack = obj.getSolution();
	if(firstStack.equals(secondStack))
	    return true;
	return false;
	
    }
}
