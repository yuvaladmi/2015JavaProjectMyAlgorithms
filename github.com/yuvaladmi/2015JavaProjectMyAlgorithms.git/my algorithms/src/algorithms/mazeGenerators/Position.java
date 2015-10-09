package algorithms.mazeGenerators;

import java.io.Serializable;

/**
 * This class present a position in the 3D array
 * 
 * @author Yuval Admi & Afek Ben Simon
 *
 */
public class Position implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 3L;
    int x;
    int y;
    int z;

    /**
     * CTOR
     * 
     * @param x
     * @param y
     * @param z
     */
    public Position(int x, int y, int z) {
	this.x = x;
	this.y = y;
	this.z = z;
    }

    /**
     * COPY CTOR
     * 
     * @param p
     */
    public Position(Position p) {
	this.x = p.x;
	this.y = p.y;
	this.z = p.z;
    }

    // Getter's & Setter's
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

    /**
     * This method sets a position on one of the faces of the cube It demands 2
     * of the positions will be odd to make sure we have a path
     * 
     * @param x
     * @param y
     * @param z
     */
    void setPositionRandomally(int x, int y, int z) {
	int side = (int) (Math.random() * 6);
	switch (side) {
	case 0:
	    this.x = 0;
	    do {
		this.y = (int) ((Math.random() * (y)));
	    } while (this.y % 2 == 0);
	    do {
		this.z = (int) ((Math.random() * (z)));
	    } while (this.z % 2 == 0);
	    break;
	case 1:
	    this.y = 0;
	    do {
		this.x = (int) ((Math.random() * (x)));
	    } while (this.x % 2 == 0);
	    do {
		this.z = (int) ((Math.random() * (z)));
	    } while (this.z % 2 == 0);
	    break;
	case 2:
	    this.z = 0;
	    do {
		this.x = (int) ((Math.random() * (x)));
	    } while (this.x % 2 == 0);
	    do {
		this.y = (int) ((Math.random() * (y)));
	    } while (this.y % 2 == 0);
	    break;
	case 3:
	    this.y = y - 1;
	    do {
		this.z = (int) ((Math.random() * (z)));
	    } while (this.z % 2 == 0);
	    do {
		this.x = (int) ((Math.random() * (x)));
	    } while (this.x % 2 == 0);
	    break;
	case 4:
	    this.z = z - 1;
	    do {
		this.x = (int) ((Math.random() * (x)));
	    } while (this.x % 2 == 0);
	    do {
		this.y = (int) ((Math.random() * (y)));
	    } while (this.y % 2 == 0);
	    break;
	case 5:
	    this.x = x - 1;
	    do {
		this.y = (int) ((Math.random() * (y)));
	    } while (this.y % 2 == 0);
	    do {
		this.z = (int) ((Math.random() * (z)));
	    } while (this.z % 2 == 0);
	    break;
	}
    }

    // override in order to print a position
    public String toString() {
	return "{" + x + "," + y + "," + z + "}";
    }

    @Override
    public boolean equals(Object obj) {
	if ((this.x == ((Position) obj).getX()) && (this.y == ((Position) obj).getY())
		&& (this.z == ((Position) obj).getZ())) {
	    return true;
	}
	return false;
    }
}
