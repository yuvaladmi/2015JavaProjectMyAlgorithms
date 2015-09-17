package algorithms.mazeGenerators;
/**
 * An abstract class
 * @author Yuval Admi & Afek Ben Simon
 *
 */
public abstract class AbsMaze3d implements Maze3dGenerator {
	
	@Override
	public abstract Maze3d generate(int x, int y, int z);

	/**
	 *  This method checks the time the generate method takes
	 */
	@Override
	public String measureAlgorithmTime(int x, int y, int z) {
		long startTime = 0, endTime = 0;
		startTime = System.currentTimeMillis();
		Maze3d newMaze = generate(x, y, z);
		endTime = System.currentTimeMillis();
		long timeOfGenerate = endTime - startTime;
		String seconds = " " + timeOfGenerate;
		return seconds;
	}

}
