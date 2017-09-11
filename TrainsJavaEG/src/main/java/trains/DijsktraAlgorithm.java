package trains;

import java.util.HashSet;
import java.util.Set;

/**
 * @author EGonzalez
 *
 */
public class DijsktraAlgorithm implements GreedyAlgorithm {

	@Override
	public int getDistance(Graph graph) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int getShortestDistance(Graph graph, Town origin) {
		// TODO Auto-generated method stub
		origin.setDistance(0);
		
		Set<Town> visitedTowns = new HashSet<Town>();
		Set<Town> unvisitedTowns = new HashSet<Town>();
		
		unvisitedTowns.add(origin);
		
//		while(unsettledTowns.size() != 0){
//			Town currentTown = getLowestDistanceNode(unsettledNodes);
//			
//		}
		
		return 0;
	}

	@Override
	public boolean routeExists() {
		// TODO Auto-generated method stub
		return false;
	}
}
