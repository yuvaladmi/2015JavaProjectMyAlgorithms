package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Stack;

/**
 * This class is an algorithm of creating a maze. The algorithms' name:
 * "Recursive backtracker" We create a maze and being assisted by a 3D array of
 * boolean - it will check which cell has not been visited yet
 * 
 * @author Yuval Admi & Afek Ben Simon
 *
 */

public class MyMaze3dGenerator extends AbsMaze3d {
    private boolean[][][] visit;
    private Maze3d myMaze;

    /**
     * CTOR
     * 
     * @param x
     * @param y
     * @param z
     */
    public MyMaze3dGenerator(int x, int y, int z) {
	myMaze = new Maze3d(x, y, z);
	visit = new boolean[x][y][z];
	for (int i = 0; i < x; i++) {
	    for (int j = 0; j < y; j++) {
		for (int t = 0; t < z; t++) {
		    visit[i][j][t] = false;
		}
	    }
	}
    }

    /**
     * Turns a cell to "visit"
     * 
     * @param p
     */
    void visitCell(Position p) {
	int xp = p.getX();
	int yp = p.getY();
	int zp = p.getZ();
	visit[xp][yp][zp] = true;
    }

    /**
     * "Recursive backtracker" algorithm
     */
    @Override
    public Maze3d generate(int x, int y, int z) {
	int totalCells = (x / 2) * (y / 2) * (z / 2);
	Position current = randPosition();
	visitCell(current);
	int numOfVisitiedCells = 1;
	Stack<Position> aCell = new Stack<Position>();
	while (numOfVisitiedCells < totalCells) {
	    ArrayList<Position> adjustCells = myMaze.getNeighboursNotVisited(current, visit);
	    if (!(adjustCells.isEmpty())) {
		int randomCell = (int) ((Math.random() * adjustCells.size()));
		Position temp = adjustCells.get(randomCell);
		aCell.push(current);
		myMaze.brakeWall(current, temp);
		current = temp;
		visitCell(current);
		numOfVisitiedCells++;
	    } else {
		if (!(aCell.isEmpty())) {
		    Position temp = aCell.pop();
		    current = temp;
		} else {
		    Position temp = unVisitedRandomCell();
		    current = temp;
		    visitCell(current);
		    numOfVisitiedCells++;
		}
	    }
	}
	Position start = new Position(x, y, z);
	Position end = new Position(x, y, z);
	start.setPositionRandomally(x, y, z);
	end.setPositionRandomally(x, y, z);
	myMaze.setStart(start);
	myMaze.setEnd(end);
	myMaze.createPath(start, 0);
	myMaze.createPath(end, 0);
	return myMaze;
    }

    /**
     * @return an unvisited random cell in the correct bounds that has not been
     *         visited yet
     */
    Position unVisitedRandomCell() {
	Position rand = new Position(0, 0, 0);
	int x, y, z;
	do {
	    rand = randPosition();
	    x = rand.getX();
	    y = rand.getY();
	    z = rand.getZ();
	} while (visit[x][y][z] == true);

	return rand;

    }

    /**
     * @return position in the correct bounds that we can go throw (has a path -
     *         0)
     */
    Position randPosition() {
	int x = 0;
	int y = 0;
	int z = 0;
	int xMaze = myMaze.getX() - 1;
	int yMaze = myMaze.getY() - 1;
	int zMaze = myMaze.getZ() - 1;
	while ((myMaze.getMaze3d()[x][y][z]) != 0) {

	    x = (int) (Math.random() * xMaze) + 1;
	    y = (int) (Math.random() * yMaze) + 1;
	    z = (int) (Math.random() * zMaze) + 1;
	}
	Position p = new Position(x, y, z);
	return p;
    }
}
