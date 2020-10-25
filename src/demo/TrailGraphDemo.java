package demo;

import java.util.LinkedList;

import trail_model.TrailGraph;
import trail_model.TrailPath;
import trail_model.TrailStop;

public class TrailGraphDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrailStop one = new TrailStop(1);
		TrailStop two = new TrailStop(2);
		TrailStop three = new TrailStop(3);
		TrailStop four = new TrailStop(4);
		
		TrailPath p1 = new TrailPath(one, two, 5);
		TrailPath p2 = new TrailPath(two, three, 10);
		TrailPath p3 = new TrailPath(four, two, 3);
		TrailPath p4 = new TrailPath(three, four, 2);
		
		TrailGraph graph = new TrailGraph();
		graph.addStop(one);
		graph.addStop(two);
		graph.addStop(three);
		graph.addStop(four);
		
		graph.addEdge(p1);
		graph.addEdge(p2);
		graph.addEdge(p3);
		graph.addEdge(p4);
		
		LinkedList<Integer> target = graph.searchGraph(one, four, 0);
		int dijkstra = graph.dijkstra(one, three);
		
	
		
		//System.out.println(s1.getConnections().toString());
		
	

	}

}
