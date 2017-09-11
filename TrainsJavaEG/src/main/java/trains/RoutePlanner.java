package trains;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

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
				// Current town name should be in the previous adjacent towns list.
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
	
	public int calculateNumberOfRoutes(Graph graph, Town origin, Town destination, int min, int max, boolean stops){
		// Data structures necessary for the recursion
		List<List<Town>> routes = new ArrayList<List<Town>>();
		Set<Town> route = new LinkedHashSet<Town>();
		
		recursiveCalculation(graph, origin, destination, routes, route, min, max, stops);
		
		// calculate the result in paths.
		return 0;
	}
	
	private void recursiveCalculation(Graph graph, Town current, Town destination, List<List<Town>> routes, Set<Town> route, int min, int max, boolean stops){
		// Add origin to the route as it starts.
		route.add(current);
		
		// Stop condition
		if(current.equals(destination) && min <= 0){
			routes.add(new ArrayList<Town>(route));
			System.out.println("Found a route: "+printRoute(route));
			route.remove(current);			
			return;
		}else if(max == 0){
			route.remove(current);			
			return;
		}
		
		// Create an iterator over all adjacent towns of the current one
		Iterator<Map.Entry<Town,Integer>> itr = graph.getTown(current.getName()).getAdjacentTowns().entrySet().iterator();
		
		while(itr.hasNext()){
			Town nextTown = itr.next().getKey();
			recursiveCalculation(graph, nextTown, destination, routes, route, min - 1, max - 1, stops);
//			if(!route.contains(nextTown)){
//				
//			}
		}
		
		route.remove(current);		
	}
	
	public int calculateNumberOfRoutesMaxWeight(Graph graph, Town origin, Town destination, int maxWeight){
		// Data structures necessary for the recursion
		List<List<Town>> routes = new ArrayList<List<Town>>();
		Set<Town> route = new LinkedHashSet<Town>();
		
		recursiveCalculationMaxWeight(graph, origin, destination, routes, route, maxWeight, 1);
		
		// calculate the result in paths.
		return 0;
	}
	
	private void recursiveCalculationMaxWeight(Graph graph, Town current, Town destination, List<List<Town>> routes, Set<Town> route, int maxWeight, int min){
		// Add origin to the route as it starts.
		route.add(current);
		
		// Stop condition
		if(current.equals(destination) && maxWeight > 0 && min <= 0){
			routes.add(new ArrayList<Town>(route));
			System.out.println("Found a route less than 30: "+printRoute(route));
//			route.remove(current);			
			return;
		}else if(maxWeight <= 0){
//			route.remove(current);			
			return;
		}
		
		// Create an iterator over all adjacent towns of the current one
		Iterator<Map.Entry<Town,Integer>> itr = graph.getTown(current.getName()).getAdjacentTowns().entrySet().iterator();
		
		while(itr.hasNext()){
			Map.Entry<Town,Integer> entry = itr.next();
			Town nextTown = entry.getKey();
			recursiveCalculationMaxWeight(graph, nextTown, destination, routes, route, maxWeight - entry.getValue(), min -1);
		}
		
//		route.remove(current);		
	}
	
	private String printRoute(Set<Town> route){
		String result = "";
		Iterator<Town> it = route.iterator();
		while(it.hasNext()){
			result+=it.next().getName()+" - ";
		}
		return result;		
	}
	
	

}
