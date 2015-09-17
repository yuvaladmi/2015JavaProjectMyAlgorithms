package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.lang.Math;

/**
 * 
 * @author Yuval Admi
 * @since 26-08-2015
 * 
 *        The MazeAirDistance implements Heuristic<T> with Position
 *
 */
public class MazeAirDistance implements Heuristic<Position> {

    @Override
    public double calculateDistance(State<Position> current, State<Position> goal) {
	double h = 0, temp = 0;
	Position posCurrent = current.getState();
	Position posGoal = goal.getState();
	// the distance according to x
	temp = posCurrent.getX() - posGoal.getX();
	temp = Math.pow(temp, 2);
	h += temp;
	// the distance according to y
	temp = posCurrent.getY() - posGoal.getY();
	temp = Math.pow(temp, 2);
	h += temp;
	// the distance according to z
	temp = posCurrent.getZ() - posGoal.getZ();
	temp = Math.pow(temp, 2);
	h += temp;
	h = Math.sqrt(h);
	return h;
    }

}
