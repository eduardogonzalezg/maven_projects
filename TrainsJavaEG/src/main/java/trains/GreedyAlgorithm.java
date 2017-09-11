/**
 * 
 */
package trains;

/**
 * @author EGonzalez
 *
 */
public interface GreedyAlgorithm {
	
	public int getDistance(Graph graph);
	
	public int getShortestDistance(Graph graph, Town origin);
		
	public boolean routeExists();
		
}
