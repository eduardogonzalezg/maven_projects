package trains;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author EG
 *
 */
public class Town {
	
	/**
	 * 
	 */
	private String name;
	
	/**
	 * 
	 */
	private int distance = Integer.MAX_VALUE;
	
	/**
	 * 
	 */
	private Map<Town, Integer> adjacentTowns = new HashMap<Town, Integer>();

	/**
	 * @param name
	 */
	public Town(String name){
		this.name = name;
	}
	
	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return
	 */
	public int getDistance(){
		return distance;
	}
	
	/**
	 * @param other
	 */
	public void setDistance(int other){
		distance = other;
	}

	/**
	 * @return
	 */
	public Map<Town, Integer> getAdjacentTowns() {
		return adjacentTowns;
	}
	
	/**
	 * @param other
	 * @param distance
	 */
	public void addAdjacentTown(Town other, int distance){
		adjacentTowns.put(other, distance);
	}	
	
	/* (non-Javadoc)
	 * Override method to made comparison methods (like contains) accurate.
	 * @see java.lang.Object#hashCode()
	 */
	@Override
    public int hashCode() {
        final int prime = 47;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
	
	/* (non-Javadoc)
	 * Override method to made comparison methods (like contains) accurate.
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    Town other = (Town) obj;
	    if (!this.name.equals(other.name))
	        return false;
	    return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		String result ="";
		Iterator<Map.Entry<Town,Integer>> itr = getAdjacentTowns().entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<Town,Integer> pair = (Map.Entry<Town,Integer>)itr.next();
			result+=this.name+"-"+pair.getValue()+"->"+pair.getKey().getName()+"; ";
		}
		return result;
	}
}
