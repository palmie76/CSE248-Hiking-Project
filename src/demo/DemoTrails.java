package demo;

import java.util.LinkedList;

import profile_model.UserProfile;
import trail_model.Trail;
import trail_model.TrailTreeMap;
import trail_model.TrailTreeSet;
import utilities.Utilities;

public class DemoTrails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Utilities ut = new Utilities();
		LinkedList<Trail> trailList = new LinkedList<Trail>();
		
		TrailTreeSet ts = ut.emitTrailsTreeSet(10);
		TrailTreeMap tm = ut.emitTrailsTreeMap(10);
		
		LinkedList<Trail> key = ts.searchByName("A");
		//System.out.println(key.toString());
		
		Trail t1 = new Trail("Q", "B", 1, 2, ut.emitRandomDifficulty(), ut.emitRandomType());

		trailList.add(t1);
		
	//	ts.addAllTrails(trailList);
		

		tm.addAllTrails(trailList);


		LinkedList<Trail> target1 = tm.searchByName("B");
		System.out.println(target1.toString());
		
		LinkedList<Trail> target2 = tm.searchByID(3);
		System.out.println(target2.toString());
		
		
	//	System.out.println(target1.toString());


	}

}
