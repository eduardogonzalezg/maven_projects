package trains;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author EGonzalez
 *
 */
public class Main {
	
	public static final String INPUT_PATTERN = "[A-Z][A-Z][0-9]*";

	public static void main(String[] args) {
		
		System.out.println("******** Hello and Welcome to the Trains Code Assignment ********\n");
		System.out.println("******** PRESS A KEY TO START THE TESTING ********");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		scanner.close();
		
		// Obtain input from file		
		String [] input = getInput(args[0]);
		
		if(input!=null){
			// Create the Graph and initialise the algorithm
			Graph graph = new Graph(input);
//			GreedyAlgorithm dijkstra = new DijsktraAlgorithm();
			
			RoutePlanner rp = new RoutePlanner();
			
			//Test 1
			List<Town> newRoute = new ArrayList();
			newRoute.add(new Town("A"));
			newRoute.add(new Town("B"));
			newRoute.add(new Town("C"));
			
			System.out.println(graph.toString());
			
			System.out.println("Distance for route A-B-C is..."+rp.calculateRouteDistance(graph, newRoute));
		}		
		
		System.out.println("******** PROGRAM FINISHED ********");
		
	}
	
	public static String [] getInput(String filePath) {
		String line = "";
		String [] result = null;
		try{
			// Open and retrieve line from file.
			BufferedReader reader = new BufferedReader(new FileReader(filePath));			
		    line = reader.readLine();		    
		    reader.close();
		    
		    // Validate input		    
		    if(validateInput(line.split(","))){
		    	result = line.split(",");
		    	System.out.println("******** INPUT IS CORRECT (delete this comment) ********");
		    }		    
		}
		catch(Exception ex)
		{
			System.err.format("An Exception was thrown when accessing '%s'.\n", filePath);
		    ex.printStackTrace();
		}	
		return result;
	}
	
	public static boolean validateInput(String [] input) throws Exception{
		for (int a=0 ; a<input.length ; a++){
			String current = input[a];
			if(!current.matches(INPUT_PATTERN)){
				throw new RegexException("The input file is badly formatted.");
			}
		}
		return true;
	}
}