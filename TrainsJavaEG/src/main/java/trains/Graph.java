package trains;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Graph {

	private Map<String,Town> towns = new HashMap<String,Town>();

	/**
	 * Constructor
	 * @param input
	 */
	public Graph (String [] input){
		for (int a=0 ; a<input.length ; a++){
			// Split the input into 3 different values (origin town, destination town, distance).
			String currentOrigin = String.valueOf(input[a].charAt(0));
			String currentDestination = String.valueOf(input[a].charAt(1));
			int currentDistance = Integer.parseInt(String.valueOf(input[a].charAt(2)));
			if(!nodeExists(currentOrigin)){
				// Create node and add first route
				Town newTown = new Town(currentOrigin);
				newTown.addAdjacentTown(new Town(currentDestination), currentDistance);
				addTown(newTown);
			}else{
				// Get node and add another route
				getTown(currentOrigin).addAdjacentTown(new Town(currentDestination), currentDistance);				
			}
		}
	}
	
	public Map<String,Town> getTowns() {
		return towns;
	}
	
	public Town getTown(String name) {
		return this.towns.get(name);
	}
	
	public void addTown(Town other){
		towns.put(other.getName(),other);
	}
	
	public boolean nodeExists(String other){
		return this.towns.containsKey(other);
	}
	
	@Override
	public String toString(){
		String result = "";
		Iterator<Map.Entry<String,Town>> itr = towns.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<String,Town> pair = (Map.Entry<String,Town>)itr.next();
			result+=pair.getValue().toString()+"\n";
		}
		return result;
	}	
}