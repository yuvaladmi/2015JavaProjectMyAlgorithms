package algorithms.mazeGenerators;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class create a maze which includes a 3D array of int, position of start
 * and end.
 * 
 * @author Yuval Admi & Afek Ben Simon
 *
 */
public class Maze3d implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 2L;
    int[][][] maze3d;
    int x, y, z;
    Position start;
    Position end;

    public Maze3d(int x, int y, int z) {
	this.x = x;
	this.y = y;
	this.z = z;
	maze3d = new int[x][y][z];
	// We want to build bounds to the maze, so we demand the dim will be
	// odd.
	// When we have a position which his 3 values are odd, we put 0 - create
	// path.
	// If we have even one even number, we put 1- create a wall .
	for (int i = 0; i < x; i++) {
	    for (int j = 0; j < y; j++) {
		for (int t = 0; t < z; t++) {
		    if ((i % 2 != 0) && (j % 2 != 0) && (t % 2 != 0))
			maze3d[i][j][t] = 0;
		    else
			maze3d[i][j][t] = 1;
		}
	    }
	}
	start = new Position(0, 0, 0);
	end = new Position(0, 0, 0);
    }

    /**
     * CTOR which gets an array of bytes and convert it to maze3d
     * 
     * @param b
     * @throws IOException
     */
    public Maze3d(byte[] b) throws IOException {
	this.x = ByteBuffer.wrap(Arrays.copyOfRange(b, 0, 4)).getInt();
	this.y = ByteBuffer.wrap(Arrays.copyOfRange(b, 4, 8)).getInt();
	this.z = ByteBuffer.wrap(Arrays.copyOfRange(b, 8, 12)).getInt();
	this.start = new Position(ByteBuffer.wrap(Arrays.copyOfRange(b, 12, 16)).getInt(),
		ByteBuffer.wrap(Arrays.copyOfRange(b, 16, 20)).getInt(),
		ByteBuffer.wrap(Arrays.copyOfRange(b, 20, 24)).getInt());
	this.end = new Position(ByteBuffer.wrap(Arrays.copyOfRange(b, 24, 28)).getInt(),
		ByteBuffer.wrap(Arrays.copyOfRange(b, 28, 32)).getInt(),
		ByteBuffer.wrap(Arrays.copyOfRange(b, 32, 36)).getInt());
	maze3d = new int[x][y][z];
	int byteNum = 36;
	for (int i = 0; i < x; i++) {
	    for (int j = 0; j < y; j++) {
		for (int t = 0; t < z; t++) {
		    maze3d[i][j][t] = (int) b[byteNum];
		    byteNum++;
		}
	    }
	}
    }

    /**
     * Convert the data of Maze3D to a byte[]
     * 
     * @return byte[] which contains all the data of Maze3D
     * @throws IOException
     */
    public byte[] toByteArray() throws IOException {
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	DataOutputStream data = new DataOutputStream(out);

	data.writeInt(this.x);
	data.writeInt(this.y);
	data.writeInt(this.z);
	data.writeInt(this.start.getX());
	data.writeInt(this.start.getY());
	data.writeInt(this.start.getZ());
	data.writeInt(this.end.getX());
	data.writeInt(this.end.getY());
	data.writeInt(this.end.getZ());
	for (int i = 0; i < x; i++) {
	    for (int j = 0; j < y; j++) {
		for (int t = 0; t < z; t++) {
		    data.write(maze3d[i][j][t]);
		}
	    }
	}
	return out.toByteArray();
    }

    // Getter's&Setter's
    public Position getStart() {
	return start;
    }

    public void setStart(Position start) {
	this.start = start;
    }

    public Position getEnd() {
	return end;
    }

    public void setEnd(Position end) {
	this.end = end;
    }

    public int getX() {
	return x;
    }

    public void setX(int x) {
	this.x = x;
    }

    public int getY() {
	return y;
    }

    public void setY(int y) {
	this.y = y;
    }

    public int getZ() {
	return z;
    }

    public void setZ(int z) {
	this.z = z;
    }

    public int[][][] getMaze3d() {
	return maze3d;
    }

    public void setMaze3d(int[][][] maze3d) {
	this.maze3d = maze3d;
    }

    /**
     * Get a position and create a path
     * 
     * @param p
     * @param num
     */
    void createPath(Position p, int num) {
	int x = p.getX();
	int y = p.getY();
	int z = p.getZ();
	maze3d[x][y][z] = num;
    }

    /**
     * put in the maze 0 or 1 randomly
     */
    public void randomCells() {
	double rand = 0;
	for (int i = 0; i < x; i++) {
	    for (int j = 0; j < y; j++) {
		for (int t = 0; t < z; t++) {
		    rand = Math.random();
		    if (rand > 0.5)
			maze3d[i][j][t] = 1;
		    else
			maze3d[i][j][t] = 0;
		}
	    }
	}
    }

    /**
     * this method returns an array of String which says what direction we can
     * go
     * 
     * @param p
     * @return
     */
    public ArrayList<String> getPossibleMoves(Position p) {
	ArrayList<String> moves = new ArrayList<String>();
	int x = p.getX();
	int y = p.getY();
	int z = p.getZ();
	int xMaze = this.maze3d.length;
	int yMaze = this.maze3d[0].length;
	int zMaze = this.maze3d[0][0].length;
	if (x == 0) {
	    if ((maze3d[x + 1][y][z] == 0) && (x + 1 <= xMaze - 1)) {
		moves.add("up");
	    }
	} else {
	    if (x == xMaze - 1) {
		if ((maze3d[x - 1][y][z] == 0) && (x - 1 >= 0)) {
		    moves.add("down");
		}
	    } else {
		if ((maze3d[x + 1][y][z] == 0) && (x + 1 <= xMaze - 1)) {
		    moves.add("up");
		}
		if ((maze3d[x - 1][y][z] == 0) && (x - 1 >= 0)) {
		    moves.add("down");

		}
	    }
	    if (y == 0) {
		if ((maze3d[x][y + 1][z] == 0) && (y + 1 <= yMaze - 1)) {
		    moves.add("forward");
		}
	    } else {
		if (y == yMaze - 1) {
		    if ((maze3d[x][y - 1][z] == 0) && (y - 1 >= 0)) {
			moves.add("backward");
		    }
		} else {
		    if ((maze3d[x][y + 1][z] == 0) && (y + 1 <= yMaze - 1)) {
			moves.add("forward");
		    }
		    if ((maze3d[x][y - 1][z] == 0) && (y - 1 >= 0)) {
			moves.add("backward");
		    }
		}
	    }
	    if (z == 0) {
		if ((maze3d[x][y][z + 1] == 0) && (z + 1 <= zMaze - 1)) {
		    moves.add("right");
		}
	    } else {
		if (z == zMaze - 1) {
		    if ((maze3d[x][y][z - 1] == 0) && (z - 1 >= 0)) {
			moves.add("left");
		    }
		} else {
		    if ((maze3d[x][y][z + 1] == 0) && (z + 1 <= zMaze - 1)) {
			moves.add("right");
		    }
		    if ((maze3d[x][y][z - 1] == 0) && (z - 1 >= 0)) {
			moves.add("left");
		    }
		}
	    }
	}
	return moves;
    }

    /**
     * This method checks which neighbors have not been visited yet Returns an
     * array of positions of the possible neighbors we can visit
     * 
     * @param p
     * @param visit
     * @return
     */
    public ArrayList<Position> getNeighboursNotVisited(Position p, boolean[][][] visit) {
	ArrayList<Position> moves = new ArrayList<Position>();
	int xp = p.getX();
	int yp = p.getY();
	int zp = p.getZ();
	if ((xp + 2) < getX() - 1) {
	    if (!(visit[xp + 2][yp][zp])) {
		moves.add(new Position(xp + 2, yp, zp));
	    }
	}
	if (xp - 2 > 0) {
	    if (!(visit[xp - 2][yp][zp])) {
		moves.add(new Position(xp - 2, yp, zp));
	    }
	}
	if ((yp + 2) < getY() - 1) {
	    if (!(visit[xp][yp + 2][zp])) {
		moves.add(new Position(xp, yp + 2, zp));
	    }
	}
	if ((yp - 2) > 0) {
	    if (!(visit[xp][yp - 2][zp])) {
		moves.add(new Position(xp, yp - 2, zp));
	    }
	}
	if ((zp + 2) < getZ() - 1) {
	    if (!(visit[xp][yp][zp + 2])) {
		moves.add(new Position(xp, yp, zp + 2));
	    }
	}
	if ((zp - 2) > 0) {
	    if (!(visit[xp][yp][zp - 2])) {
		moves.add(new Position(xp, yp, zp - 2));
	    }
	}
	return moves;
    }

    /**
     * This method checks which cell we need to turn to '0'
     * 
     * @param p1
     * @param p2
     */
    public void brakeWall(Position p1, Position p2) {
	int xp1 = p1.getX();
	int xp2 = p2.getX();
	int yp1 = p1.getY();
	int yp2 = p2.getY();
	int zp1 = p1.getZ();
	int zp2 = p2.getZ();
	if (xp1 != xp2) {
	    if (xp1 < xp2)
		createPath(new Position(xp1 + 1, yp1, zp1), 0);
	    else
		createPath(new Position(xp1 - 1, yp1, zp1), 0);
	}
	if (zp1 != zp2) {
	    if (zp1 < zp2)
		createPath(new Position(xp1, yp1, zp1 + 1), 0);
	    else
		createPath(new Position(xp1, yp1, zp1 - 1), 0);
	}
	if (yp1 != yp2) {
	    if (yp1 < yp2)
		createPath(new Position(xp1, yp1 + 1, zp1), 0);
	    else
		createPath(new Position(xp1, yp1 - 1, zp1), 0);
	}
    }

    /**
     * @return the end position of the maze
     */
    public String getGoalPosition() {
	int x = end.getX();
	int y = end.getY();
	int z = end.getZ();
	return "{" + x + "," + y + "," + z + "}";
    }

    /**
     * get 2d cross sections of the 3d maze
     * 
     * @param num
     * @return int[][]
     * @throws IndexOutOfBoundsException
     */
    public int[][] getCrossSectionByX(int num) throws IndexOutOfBoundsException {
	if ((num < 0) || (num > x - 1)) {
	    throw new IndexOutOfBoundsException();
	}
	int[][] cross = new int[y][z];
	for (int i = 0; i < y; i++) {
	    for (int j = 0; j < z; j++) {
		cross[i][j] = maze3d[num][i][j];
	    }
	}
	return cross;
    }

    /**
     * get 2d cross sections of the 3d maze
     * 
     * @param num
     * @return int[][]
     * @throws IndexOutOfBoundsException
     */
    public int[][] getCrossSectionByY(int num) throws IndexOutOfBoundsException {
	if ((num < 0) || (num > y - 1)) {
	    throw new IndexOutOfBoundsException();
	}
	int[][] cross = new int[x][z];
	for (int i = 0; i < x; i++) {
	    for (int j = 0; j < z; j++) {
		cross[i][j] = maze3d[i][num][j];
	    }
	}
	return cross;
    }

    /**
     * get 2d cross sections of the 3d maze
     * 
     * @param num
     * @return int[][]
     * @throws IndexOutOfBoundsException
     */
    public int[][] getCrossSectionByZ(int num) throws IndexOutOfBoundsException {
	if ((num < 0) || (num > z - 1)) {
	    throw new IndexOutOfBoundsException();
	}
	int[][] cross = new int[x][y];
	for (int i = 0; i < x; i++) {
	    for (int j = 0; j < y; j++) {
		cross[i][j] = maze3d[i][j][num];
	    }
	}
	return cross;
    }

    /**
     * print method
     */
    public void print() {
	for (int i = 0; i < x; i++) {
	    for (int j = 0; j < y; j++) {
		for (int t = 0; t < z; t++) {
		    System.out.print(maze3d[i][j][t]);
		}
		System.out.println();
	    }
	    System.out.println();
	}
    }

    public boolean equals(Object obj) {
	Maze3d temp = (Maze3d) obj;
	if ((this.x != temp.getX()) || (this.y != temp.getY()) || (this.z != temp.getZ()))
	    return false;
	else {
	    if (!(this.start.equals(temp.getStart())) || !(this.end.equals(temp.getEnd())))
		return false;
	    else {
		for (int i = 0; i < this.x; i++) {
		    for (int j = 0; j < this.y; j++) {
			for (int t = 0; t < this.z; t++) {
			    if (this.maze3d[i][j][t] != temp.getMaze3d()[i][j][t])
				return false;
			}
		    }
		}
	    }
	}
	return true;
    }

    @Override
    public String toString() {
	String maze = new String();
	for (int i = 0; i < x; i++) {
	    for (int j = 0; j < y; j++) {
		for (int t = 0; t < z; t++) {
		    maze = maze + "" + (maze3d[i][j][t]);
		}
		maze = maze + "\n";
	    }
	    maze = maze + "\n\n";
	}
	    return maze;

    }
}