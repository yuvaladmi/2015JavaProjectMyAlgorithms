package algorithms.demo;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.AStar;
import algorithms.search.BFS;
import algorithms.search.CommonSearcher;
import algorithms.search.MazeAirDistance;
import algorithms.search.MazeManhattenDistance;
import algorithms.search.SearchableMaze;
import algorithms.search.Solution;

/**
 * 
 * @author Yuval Admi
 * @since 26-08-2015
 *
 */
public class Demo {
    /**
     * This method creates a maze and finds its solution in 3 ways: 1. BFS 2.
     * AStar - Manhatten 3. AStar - AirDistance
     */
    public void run() {
	//Create a maze
	MyMaze3dGenerator mg = new MyMaze3dGenerator(3, 5, 5);
	Maze3d maze = mg.generate(3, 5, 5);
	maze.print();
	//Create the BFS solution
	SearchableMaze sMaze = new SearchableMaze(maze);
	CommonSearcher<Position> cs = new BFS<Position>();
	Solution<Position> sol = cs.search(sMaze);
	int bfs = cs.getNumberOfNodesEvaluated();
	//Create the Astar air distance solution
	CommonSearcher<Position> cs1 = new AStar<Position>(new MazeAirDistance());
	Solution<Position> sol1 = cs1.search(sMaze);
	int astar1 = cs1.getNumberOfNodesEvaluated();
	//Create the AStar Manhattan solution
	CommonSearcher<Position> cs2 = new AStar<>(new MazeManhattenDistance());
	Solution<Position> sol2 = cs2.search(sMaze);
	int astar2 = cs2.getNumberOfNodesEvaluated();

	System.out.println("BFS:" + bfs);
	sol.print();
	System.out.println();
	System.out.println("AirDistance:" + astar1);
	sol1.print();
	System.out.println();
	System.out.println("Manhatten:" + astar2);
	sol2.print();
    }

    public static void main(String[] args) {
	Demo d=new Demo();
	d.run();
    }
}
