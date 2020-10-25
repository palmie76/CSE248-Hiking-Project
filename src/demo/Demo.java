package demo;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Random;

import profile_model.UserProfile;
import profile_model.UserProfileTreeMap;
import profile_model.UserProfileTreeSet;
import trail_model.Trail;
import trail_model.TrailTreeMap;
import trail_model.TrailTreeSet;
import utilities.Utilities;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Utilities ut = new Utilities();
		
		long[][] resultsProfile = new long[10][2];

		int limit = 10;
		
		for(int i = 0; i < resultsProfile.length; i++) {
			UserProfileTreeMap tm = ut.emitUserProfilesTreeMap(limit);
			Random generator1 = new Random();
			Object[] values1 = tm.getUserProfiles().values().toArray();
			UserProfile randomValue = (UserProfile) values1[generator1.nextInt(values1.length)];
			
			UserProfileTreeSet ts = ut.emitUserProfilesTreeSet(limit);
			Random generator2 = new Random();
			Object[] values2 = ts.getUserProfiles().toArray();
			UserProfile randomValue2 = (UserProfile) values2[generator2.nextInt(values2.length)];
			
			long startMap = System.currentTimeMillis();
			profileMapMethods(tm, randomValue);
			long resultMap = System.currentTimeMillis() - startMap;
			
	
			long startSet = System.currentTimeMillis();
			profileSetMethods(ts, randomValue2);
			long resultSet = System.currentTimeMillis() - startSet;
		
			resultsProfile[i][0] = resultMap;
			resultsProfile[i][1] = resultSet;
			limit = limit * 4;
		}
		
		
	}

//		String t = ut.emitRandomString();
//		System.out.println(t.toString());
//		LinkedList profileList = new LinkedList<UserProfile>();
//
//		UserProfileTreeSet ts = ut.emitUserProfilesTreeSet(0);
//		UserProfileTreeMap tm = ut.emitUserProfilesTreeMap(0);
//				
//		UserProfile up1 = new UserProfile("D", "B", "C", ut.createHikingHistory());
//		UserProfile up2 = new UserProfile("C", "B", "C", ut.createHikingHistory());
//		UserProfile up3 = new UserProfile("B", "B", "C", ut.createHikingHistory());
//		UserProfile up4 = new UserProfile("A", "B", "C", ut.createHikingHistory());
//		LinkedList<UserProfile> list = new LinkedList<UserProfile>();
//		list.add(up1);
//		list.add(up2);
//		list.add(up3);
//		list.add(up4);
//		tm.addAllProfiles(list);
//		
//		UserProfile target = tm.searchUserProfile(up1);
//		LinkedList<UserProfile> target1 = tm.searchUserProfile(up3);
//		System.out.println(target1.toString());
//		
//		UserProfile target2 = tm.deleteProfile(up1);
//		System.out.println(target2.toString());
//		
//		System.out.println(tm.toString());
		
//		long[][] resultsTrail = new long[10][2];
//
//		int limit = 10;
//		
//		for(int i = 0; i < resultsTrail.length; i++) {
//			TrailTreeMap tm = ut.emitTrailsTreeMap(limit);
//			Random generator1 = new Random();
//			Object[] values1 = tm.getTrailMap().values().toArray();
//			Trail randomValue = (Trail) values1[generator1.nextInt(values1.length)];
//			
//			TrailTreeSet ts = ut.emitTrailsTreeSet(limit);
//			Random generator2 = new Random();
//			Object[] values2 = ts.getTrailSet().toArray();
//			Trail randomValue2 = (Trail) values2[generator2.nextInt(values2.length)];
//			
//			long startMap = System.currentTimeMillis();
//			trailMapMethods(tm, randomValue);
//			long resultMap = System.currentTimeMillis() - startMap;
//			
//			long startSet = System.currentTimeMillis();
//			trailSetMethods(ts, randomValue2);
//			long resultSet = System.currentTimeMillis() - startSet;
//		
//			resultsTrail[i][0] = resultMap;
//			resultsTrail[i][1] = resultSet;
//			limit = limit * 2;
//	
//		
//	
//		}
//	}
	
	
	static void profileMapMethods(UserProfileTreeMap um, UserProfile target){
		//um.addProfile(userTarget);
		LinkedList<UserProfile> key = um.searchUserProfile(target);
		um.deleteProfile(target);
		
	
	}
	
	static void profileSetMethods(UserProfileTreeSet us, UserProfile target){
	//	us.addProfile(userTarget);
		LinkedList<UserProfile> key = us.searchUserProfile(target);
		us.deleteProfile(target);
		
	}
		
//		
//		void profileMapMethods(UserProfileTreeMap um/*, UserProfile target*/){
//		um.addProfile(userTarget);
//			LinkedList<UserProfile> key = um.searchUserProfile(userTarget);
//			um.deleteProfile(userTarget);
//			
//		
//		}
//		
//		void profileSetMethods(UserProfileTreeSet us/*, UserProfile target*/){
//			us.addProfile(userTarget);
//			LinkedList<UserProfile> key = us.searchUserProfile(userTarget);
//			us.deleteProfile(userTarget);
//			
//		}
		
		static void trailMapMethods(TrailTreeMap tm, Trail trailTarget) {
		//	tm.addTrail(trailTarget);
			LinkedList<Trail> keyID = tm.searchByID(trailTarget.getTrailID());
			LinkedList<Trail> keyName = tm.searchByName(trailTarget.getTrailName());
			tm.removeTrail(trailTarget);
			
		
		}
		
		static void trailSetMethods(TrailTreeSet ts, Trail trailTarget) {
			//ts.addTrail(trailTarget);
			LinkedList<Trail> keyID = ts.searchByID(trailTarget.getTrailID());
			LinkedList<Trail> keyName = ts.searchByName(trailTarget.getTrailName());
			ts.removeTrail(trailTarget);
			
		}
	

}
