package trail_model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.TreeSet;

import sun.misc.Queue;

public class TrailGraph {
	/**
	 * 
	 * TrailGraph organizes TrailStops and TrailPaths  
	 * consists of TrailStops with weighted TrailPaths containing distance which connect the TrailStops together
	 * gives Trails a visual context which shows the connections between TrailStops
	 * 
	 */

	private TreeSet<TrailStop> trailStops;
	private LinkedList<Integer> distances = new LinkedList<Integer>();
	private LinkedList<TrailPath> toVisit = new LinkedList<TrailPath>();
	private LinkedList<TrailStop> visited = new LinkedList<TrailStop>();


	public TrailGraph() {
		trailStops = new TreeSet<TrailStop>();

	}
	/**
	 * adds TrailStop to Graph
	 * 
	 * @param stop TrailStop to be added
	 */
	public void addStop(TrailStop stop) {
		trailStops.add(stop);
		// adjacencyList.add(stop.getNeighbors());

	}
	
	public void addEdge(TrailPath edge) {
		TrailStop stop1 = edge.getStop1();
		TrailStop stop2 = edge.getStop2();

		stop1.addConnection(edge);
		stop2.addConnection(edge);

		stop1.addNeighbor(stop2);
		stop2.addNeighbor(stop1);

	}
	
	public int calculateDistance(TrailStop stop1, TrailStop stop2){
		LinkedList<TrailPath> common = new LinkedList<TrailPath>(stop1.getConnections());
		common.retainAll(stop2.getConnections());
		
		if(!common.isEmpty()) {
			return(common.element().getDistance());
		}
		else {
			return Integer.MAX_VALUE;
		}
	}
	
	/**
	 * Finds the shortest path between the two TrailStop objects, calculates and returns the shortest distance between them
	 * 
	 * @param start starting TrailStop
	 * @param end ending TrailStop
	 * 
	 * @return distance of shortest path between starting TrailStop and ending TrailStop
	 */

	public int dijkstra(TrailStop start, TrailStop end) {
		LinkedList<TrailStop> visited = new LinkedList<TrailStop>();
	
		int distance = 0;
		
		TrailStop target = null;

		PriorityQueue<TrailStop> pq = new PriorityQueue<TrailStop>();
		pq.add(start);

		while (pq.size() != 0) {
			TrailStop s = pq.peek();	
			visited.add(s);
			pq.poll();
			
			int compare = Integer.MAX_VALUE;
			
			for (TrailStop neighbor : s.getNeighbors()) {
				if(visited.contains(neighbor)) {
					continue;
				}
				else if(neighbor.equals(end)) {
					distance += calculateDistance(s, neighbor);
					return distance;
				}
				else {
					int cost = calculateDistance(s, neighbor);
					if(cost < compare) {
						compare = cost;
						target = neighbor;
					}
				}
			}
			
			distance += compare;
			pq.add(target);
			
		}
		return distance;

	}

//			for (TrailPath p : s.getConnections()) {
//				// int targetDist = Integer.MAX_VALUE;
//				if (p.getDistance() < compare) {
//					compare = p.getDistance();
//
//					if (!visited.contains(p.getStop1())) {
//						target = p.getStop1();
//					} else if(!visited.contains(p.getStop2())){
//						target = p.getStop2();
//					}
//					else {
//						break;
//					}
//				}
//				distance += compare;
//				pq.add(target);
//
//			}


//	public int searchDistance(TrailStop beginning, TrailStop target) {
//		for(TrailPath c: beginning.getConnections()) {	
//			if(c.getEnd().equals(target)) {
//				return distance += c.getDistance();
//		
//			}
//			
//			else {
//				distance+= c.getDistance();
//				return searchDistance(c.getEnd(), target);
//			}
//		}
//		
//		targetList.add(distance);
//		return distance;
//		
//	}

	public LinkedList<Integer> searchGraph(TrailStop stop1, TrailStop stop2, int cost) {
		visited.add(stop1);

		toVisit.clear();
		toVisit.addAll(stop1.getConnections());

		ListIterator<TrailPath> iterVisit = toVisit.listIterator();

		while (toVisit.size() != 0) {
			// for (TrailPath s : toVisit) {
			TrailPath p = iterVisit.next();
			iterVisit.remove();

			if (!visited.contains(p.getStop1())) {
				if (p.getStop1().equals(stop2)) {
					cost += (p.getDistance());
					distances.add(cost);
					cost = 0;
					return distances;

				} else {
					cost += (p.getDistance());
					visited.add(p.getStop1());
					return searchGraph(p.getStop1(), stop2, cost);
					// toVisit.addAll(p.getStop1().getConnections());
				}
			}

			if (!visited.contains(p.getStop2())) {
				if (p.getStop2().equals(stop2)) {
					cost += (p.getDistance());
					distances.add(cost);
					cost = 0;
					return distances;

				} else {
					cost += (p.getDistance());
					visited.add(p.getStop2());
					return searchGraph(p.getStop2(), stop2, cost);

				}
			}
			
			iterVisit = toVisit.listIterator();
		}

		return distances;

	}

//	public LinkedList<Integer> searchGraph(TrailStop stop1, TrailStop stop2) {
//		LinkedList<TrailStop> visited = new LinkedList<TrailStop>();
//		LinkedList<Integer> distances = new LinkedList<Integer>();
//		
//		LinkedList<Integer> distancesToTarget = new LinkedList<Integer>();
//		
//		visited.add(stop1);
//
//		LinkedList<TrailPath> toVisit = new LinkedList<TrailPath>();
//
//		for (TrailPath s : stop1.getConnections()) {
//			toVisit.add(s);
//		}
//
//		ListIterator<TrailPath> iterVisit = toVisit.listIterator();
//	
//		int d1 = 0;
//		int d2 = 0;
//		
//		while (toVisit.size() != 0) {
//			// for (TrailPath s : toVisit) {
//			TrailPath p = iterVisit.next();
//			iterVisit.remove();
//			
//			if (!visited.contains(p.getStop1())) {
//				if (p.getStop1().equals(stop2)) {
//					d1 += (p.getDistance());
//					distancesToTarget.add(d1);
//					
//				} else {
//					d1 += (p.getDistance());
//					toVisit.addAll(p.getStop1().getConnections());
//				}
//			}
//
//			if (!visited.contains(p.getStop2())) {
//				if (p.getStop2().equals(stop2)) {
//					d2 += (p.getDistance());
//					distancesToTarget.add(d2);
//			
//				}
//				d2 += (p.getDistance());
//				toVisit.addAll(p.getStop2().getConnections());
//			}
//			
//			
//			visited.add(p.getStop1());
//			visited.add(p.getStop2());
//		
//			iterVisit = toVisit.listIterator();
//		}
//
//		return distancesToTarget;
//
//	}

	@Override
	public String toString() {
		String info = null;
		StringBuilder sb = new StringBuilder();
		for (TrailStop s : trailStops) {
			info = "Trail Graph: " + "\n" + "Altitude: " + s.getAltitude() + "\n" + "Trail ID: " + s.getTrailID() + "\n"
					+ "Connections: " + s.getConnections().toString() + "\n";
			sb.append(info).append("\n");
		}

		return sb.toString();
	}

}
