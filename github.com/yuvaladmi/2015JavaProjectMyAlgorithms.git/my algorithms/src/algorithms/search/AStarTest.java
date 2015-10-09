package algorithms.search;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Test;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;

public class AStarTest {

    @Test
    public void shortestPathTest() {

	byte[] maze = { 0, 0, 0, 5, 0, 0, 0, 5, 0, 0, 0, 5, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 4,
		0, 0, 0, 1,

		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,

		1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1,

		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,

		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,

		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
	Maze3d mazeTest = null;
	try {
	    mazeTest = new Maze3d(maze);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	CommonSearcher<Position> cs1 = new AStar<Position>(new MazeAirDistance());
	SearchableMaze sMaze = new SearchableMaze(mazeTest);
	Solution<Position> solution = cs1.search(sMaze);
	Solution<Position> trueSol = new Solution<Position>();
	trueSol.pushToStack(new Position(1, 4, 1));
	trueSol.pushToStack(new Position(1, 3, 1));
	trueSol.pushToStack(new Position(1, 2, 1));
	trueSol.pushToStack(new Position(1, 1, 1));
	trueSol.pushToStack(new Position(1, 1, 0));
	System.out.println();
	trueSol.print();
	System.out.println();
	solution.print();
	assertEquals(trueSol, solution);
    }

    @Test
    public void startEqualsEndTest() {

	byte[] maze = { 0, 0, 0, 5, 0, 0, 0, 5, 0, 0, 0, 5, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1,
		0, 0, 0, 0,

		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,

		1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1,

		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,

		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,

		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
	Maze3d mazeTest = null;
	try {
	    mazeTest = new Maze3d(maze);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	CommonSearcher<Position> cs1 = new AStar<Position>(new MazeAirDistance());
	SearchableMaze sMaze = new SearchableMaze(mazeTest);
	Solution<Position> solution = cs1.search(sMaze);
	Solution<Position> trueSol = new Solution<Position>();
	trueSol.pushToStack(new Position(1, 1, 0));
	trueSol.print();
	System.out.println();
	solution.print();
	assertEquals(trueSol, solution);
    }
}
