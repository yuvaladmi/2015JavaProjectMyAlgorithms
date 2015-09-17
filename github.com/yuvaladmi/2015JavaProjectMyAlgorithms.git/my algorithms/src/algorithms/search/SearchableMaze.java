package algorithms.search;

import java.util.ArrayList;

import algorithms.mazeGenerators.Maze3d;

import algorithms.mazeGenerators.Position;

/**
 * 
 * @author Yuval Admi
 * @since 26-08-2015
 * 
 *        The class SearchableMaze implements Searchable<T> with Position. It
 *        has 3 params:
 * @param maze
 * @param startState
 * @param goalState
 *
 */
public class SearchableMaze implements Searchable<Position> {

    private Maze3d maze;
    private State<Position> startState;
    private State<Position> endState;

    /**
     * CTOR - gets a new maze and initialize our maze and the start and goal
     * states.
     * 
     * @param m
     */
    public SearchableMaze(Maze3d m) {
	this.maze = m;
	startState = new State<Position>(m.getStart());
	endState = new State<Position>(m.getEnd());
    }

    @Override
    public State<Position> getStartState() {
	return startState;
    }

    @Override
    public State<Position> getGoalState() {
	return endState;
    }

    @Override
    public ArrayList<State<Position>> getAllPossibleStates(State<Position> s) {
	ArrayList<State<Position>> positionState = getNeighbors(s);
	return positionState;
    }

    /**
     * This method gets a State<Position> and finds its neighbors it can goes
     * through
     * 
     * @param s
     * @return
     */
    public ArrayList<State<Position>> getNeighbors(State<Position> s) {
	// creating an array list of positions
	ArrayList<State<Position>> moves = new ArrayList<State<Position>>();
	Position p = s.getState();
	int xp = p.getX();
	int yp = p.getY();
	int zp = p.getZ();
	// initialize an array list of String with all the possible moves from a
	// method from the class Maze3d
	ArrayList<String> arr = maze.getPossibleMoves(p);
	// scan the array list and initialize it
	for (String move : arr) {
	    switch (move) {
	    case "up":
		moves.add(new State<Position>(new Position(xp + 1, yp, zp)));
		break;
	    case "down":
		moves.add(new State<Position>(new Position(xp - 1, yp, zp)));
		break;
	    case "forward":
		moves.add(new State<Position>(new Position(xp, yp + 1, zp)));
		break;
	    case "backward":
		moves.add(new State<Position>(new Position(xp, yp - 1, zp)));
		break;
	    case "right":
		moves.add(new State<Position>(new Position(xp, yp, zp + 1)));
		break;
	    case "left":
		moves.add(new State<Position>(new Position(xp, yp, zp - 1)));
		break;
	    }
	}
	return moves;
    }

    @Override
    public double getMoveCost() {
	return 10;
    }
}
