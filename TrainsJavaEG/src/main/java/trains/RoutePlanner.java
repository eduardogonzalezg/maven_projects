package trains;

import java.util.List;
import java.util.ListIterator;

public class RoutePlanner {
	
	public int calculateRouteDistance(Graph graph, List<Town> towns){
		int totalResult = 0;
		
		// To perform first comparison we need to go through the first 2 elements of the route
		Town previous = null;
		
		// Traverse the route proposed in order to check if it exists and if so its total distance.
		ListIterator<Town> iterator = towns.listIterator();
		while(iterator.hasNext() && totalResult != -1){
			Town current = graph.getTown(iterator.next().getName());
			if(previous != null){
				Integer value = previous.getAdjacentTowns().get(new Town(current.getName()));
				if (value != null) {
					totalResult += value;
				} else {
					// Route doesn't exist as one of the journeys between towns is not possible
					totalResult = -1;
				}
			}
			previous = current;
		}
		return totalResult;
	}

}
