package algorithms.mazeGenerators;

/**
 * An interface of creating mazes
 * 
 * @author Yuval Admi & Afek Ben Simon
 *
 */
public interface Maze3dGenerator {

    Maze3d generate(int x, int y, int z);

    String measureAlgorithmTime(int x, int y, int z);

}
