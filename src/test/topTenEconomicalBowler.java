package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import com.ipl.Main;
import com.ipl.model.*;


import org.junit.jupiter.api.Test;

class topTenEconomicalBowler {

	@Test
	void test() {
		
		HashMap<String,Float> topTenEcoBowler=new HashMap<>();
		List<Match> matches=Main.readMatchesData();
		List<Deliveries> delivery=Main.readDeliveriesData();
		
		topTenEcoBowler=Main.TopTenEconomicalBowlers2015(delivery, matches);
		int size=topTenEcoBowler.size();
		
		HashMap<String,Integer> wrongData=null;
//		float dataforShivamSharma=0.70;
		
		
		assertEquals(Main.TopTenEconomicalBowlers2015(delivery, matches).size(),size);
		
		assertEquals(Main.TopTenEconomicalBowlers2015(delivery, matches),topTenEcoBowler);
		
		assertNotEquals(Main.TopTenEconomicalBowlers2015(delivery, matches),wrongData);
		
//		assertEquals(Main.TopTenEconomicalBowlers2015(delivery, matches).get("Shivam Sharma"),dataforShivamSharma);
		
		
	}

}
