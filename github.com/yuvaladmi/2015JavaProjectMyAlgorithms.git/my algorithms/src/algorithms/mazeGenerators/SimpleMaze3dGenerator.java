package algorithms.mazeGenerators;
/**
 *  This class is an algorithm of creating a maze.
 * @author Yuval Admi & Afek Ben Simon
 *
 */
public class SimpleMaze3dGenerator extends AbsMaze3d {
	Maze3d maze;

	/**
	 * CTOR
	 * @param x
	 * @param y
	 * @param z
	 */
	public SimpleMaze3dGenerator(int x, int y, int z) {
		maze = new Maze3d(x, y, z);
	}

	@Override
	public Maze3d generate(int x, int y, int z) {
		maze = new Maze3d(x, y, z);
		maze.randomCells();
		Position start = maze.getStart();
		Position end = maze.getEnd();
		start.setPositionRandomally(x, y, z);
		end.setPositionRandomally(x, y, z);
		int xEnd = end.getX();
		int yEnd = end.getY();
		int zEnd = end.getZ();
		int x1 = 0, y1 = 0, z1 = 0;
		Position p = start;
		maze.createPath(start, 0);
		maze.createPath(end, 0);

		while ((p.getX() != xEnd) || (p.getY() != yEnd) || (p.getZ() != zEnd)) {
			x1 = y1 = z1 = 0;
			int num = (int) (Math.random() * 3);
			switch (num) {
			case 0:
				x1 = p.getX();
				if (x1 < xEnd) {
					x1++;
					p.setX(x1);
					maze.createPath(p, 0);
				} else if (x1 > xEnd) {
					x1--;
					p.setX(x1);
					maze.createPath(p, 0);
				}
				break;
			case 1:
				y1 = p.getY();
				if (y1 < yEnd) {
					y1++;
					p.setY(y1);
					maze.createPath(p, 0);
				} else if (y1 > yEnd) {
					y1--;
					p.setY(y1);
					maze.createPath(p, 0);
				}
				break;
			case 2:
				z1 = p.getZ();
				if (z1 < zEnd) {
					z1++;
					p.setZ(z1);
					maze.createPath(p, 0);
				} else if (z1 > zEnd) {
					z1--;
					p.setZ(z1);
					maze.createPath(p, 0);
				}
				break;
			}
		}
		return maze;
	}
}
