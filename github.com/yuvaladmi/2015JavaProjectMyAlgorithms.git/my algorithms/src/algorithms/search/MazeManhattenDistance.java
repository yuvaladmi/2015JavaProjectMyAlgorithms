package algorithms.search;

import algorithms.mazeGenerators.Position;

/**
 * 
 * @author Yuval Admi
 *
 * @since 26-08-2015
 * 
 *        The MazeAirDistance implements Heuristic<T> with Position
 *
 */
public class MazeManhattenDistance implements Heuristic<Position> {

    @Override
    public double calculateDistance(State<Position> current, State<Position> goal) {
	double h = 0, temp = 0;
	Position posCurrent = current.getState();
	Position posGoal = goal.getState();
	// the distance according to x
	if (posGoal.getX() < posCurrent.getX()) {
	    temp = posCurrent.getX() - posGoal.getX();
	    h += temp;
	} else {
	    temp = posGoal.getX() - (posCurrent).getX();
	    h += temp;
	}
	// the distance according to y
	if (posGoal.getY() < posCurrent.getY()) {
	    temp = (posCurrent).getY() - posGoal.getY();
	    h += temp;
	} else {
	    temp = posGoal.getY() - posCurrent.getY();
	    h += temp;
	}
	// the distance according to z
	if (posGoal.getZ() < (posCurrent.getZ())) {
	    temp = (posCurrent).getX() - (posGoal).getX();
	    h += temp;
	} else {
	    temp = posGoal.getZ() - posCurrent.getZ();
	    h += temp;
	}
	return h;
    }

}
