package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import com.ipl.Main;
import com.ipl.model.*;


import org.junit.jupiter.api.Test;

class topTenEconomicalBowler {

	@Test
	void test() {
		
		
		List<Match> matches=Main.readMatchesData();
		List<Deliveries> delivery=Main.readDeliveriesData();
		
		List<Match> sublistMatch=matches.subList(517,550);
		List<Deliveries> sublistDelivery=delivery.subList(122714, 126700);
		
		HashMap<String,Double> sublistResult=new HashMap<>();
		
		
		sublistResult.put("KA Pollard",0.5138888888888888);
		sublistResult.put("KC Cariappa",0.6666666666666666);
		sublistResult.put("JJ Bumrah",0.5428571428571428);
		sublistResult.put("I Sharma",0.5);
		sublistResult.put("PJ Cummins",0.5959595959595959);
		sublistResult.put("PP Ojha",0.5476190476190477);
		sublistResult.put("S Gopal",0.5348837209302325);
		sublistResult.put("Parvez Rasool",0.5238095238095238);
		sublistResult.put("Karanveer Singh",0.5119047619047619);
		sublistResult.put("RA Jadeja",0.4878048780487805);
		
		
		
		HashMap<String,Double> wrongData=null;
		
		double dataforShivamSharma=0.6984126984126984;
		
		
		
		assertEquals(matches.size(),636);
		
		assertEquals(delivery.size(),150460);
		
		assertThrows(NullPointerException.class,()->Main.ExtraRunsPerTeam2016(null,sublistMatch));
		
		assertNotEquals(Main.TopTenEconomicalBowlers2015(delivery, matches),wrongData);
		
		assertEquals(Main.TopTenEconomicalBowlers2015(delivery, matches).getClass().getSimpleName(),sublistResult.getClass().getSimpleName());
		
		assertEquals(Main.TopTenEconomicalBowlers2015(delivery, matches).get("Shivam Sharma"),dataforShivamSharma);
		
		assertEquals(Main.TopTenEconomicalBowlers2015(sublistDelivery,sublistMatch),sublistResult);
		
	}

}
