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
		
		List<Match> sublistMatch=matches.subList(0, 0);
		List<Deliveries> sublistDelivery=delivery.subList(0, 0);
		
//		HashMap<String,double> sublistResult=new HashMap<>();
//		Shivam Sharma, Value = 0.70
//		sublistResult.put("Shivam Sharma",0.70);
		
		
		HashMap<String,Integer> wrongData=null;
//		float dataforShivamSharma=0.70;
		
		
		assertEquals(matches.size(),636);
		
		assertEquals(delivery.size(),150460);
		
//		assertNotEquals(Main.TopTenEconomicalBowlers2015(delivery, matches),wrongData);
		
//		assertEquals(Main.TopTenEconomicalBowlers2015(delivery, matches).getClass().getSimpleName(),sublistResult.getClass().getSimpleName());
		
//		assertEquals(Main.TopTenEconomicalBowlers2015(delivery, matches).get("Shivam Sharma"),dataforShivamSharma);
		
		
	}

}
