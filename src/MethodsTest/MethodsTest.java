package MethodsTest;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import profile_model.UserProfile;
import profile_model.UserProfileTreeMap;
import trail_model.Trail;
import trail_model.TrailGraph;
import trail_model.TrailPath;
import trail_model.TrailStop;
import trail_model.TrailTreeMap;
import utilities.Utilities;

public class MethodsTest {
	
	@Test
	public void testDijkstra() {
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
		
		assertEquals(15, graph.dijkstra(one, three));
		
		
	}
	
	@Test
	public void testSearchTrailName() {
		Utilities ut = new Utilities();
		TrailTreeMap tm = ut.emitTrailsTreeMap(10);
		Trail t1 = new Trail("Buttermilk Falls", ut.emitRandomString(), 1, 2, ut.emitRandomDifficulty(), ut.emitRandomType());
		tm.addTrail(t1);
		LinkedList<Trail> list = tm.searchByName("Buttermilk Falls");
		assertTrue(list.contains(t1));		
	}
	
	@Test
	public void testSearchUsername() {
		Utilities ut = new Utilities();
		UserProfileTreeMap tm = ut.emitUserProfilesTreeMap(10);
		UserProfile u1 = new UserProfile("LizzyP","bananas123", ut.emitRandomString());
		tm.addProfile(u1);
		assertSame(u1, tm.searchByUsername("LizzyP"));
		
	}
	
	@Test
	public void testSearchTrailByID() {
		Utilities ut = new Utilities();
		TrailTreeMap tm = ut.emitTrailsTreeMap(10);
		Trail t1 = new Trail("Buttermilk Falls", ut.emitRandomString(), 1, 2, ut.emitRandomDifficulty(), ut.emitRandomType());
		tm.addTrail(t1);
		Trail target = tm.searchByID(10);
		assertSame(t1, target);
		
	}
	
	@Test
	public void testAddUser() {
		Utilities ut = new Utilities();
		UserProfileTreeMap tm = ut.emitUserProfilesTreeMap(10);
		UserProfile u1 = new UserProfile("LizzyP","bananas123", ut.emitRandomString());
		tm.addProfile(u1);
		assertTrue(tm.getUserProfiles().containsValue(u1));
		
	}
	
	@Test
	public void testSearchUser() {
		Utilities ut = new Utilities();
		UserProfileTreeMap tm = ut.emitUserProfilesTreeMap(10);
		UserProfile u1 = new UserProfile("LizzyP","bananas123", ut.emitRandomString());
		tm.addProfile(u1);
		assertSame(tm.searchByUsername("LizzyP"), u1);
		
	}
}
