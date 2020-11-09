package demo;
import static org.junit.Assert.assertSame;

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
		UserProfileTreeMap tp = new UserProfileTreeMap();
		UserProfile u1 = new UserProfile("LizzyP","bananas123", ut.emitRandomString());
		tp.addProfile(u1);

//		UserProfileTreeMap tp = ut.emitUserProfilesTreeMap(10);
//		UserProfile u1 = new UserProfile("LizzyP","bananas123", ut.emitRandomString());
//		tp.addProfile(u1);
//		UserProfile result = tp.searchByUsername("LizzyP");
		
	}

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
