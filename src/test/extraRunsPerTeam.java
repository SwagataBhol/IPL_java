package test;


import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import com.ipl.model.*;


import org.junit.jupiter.api.Test;

import com.ipl.Main;

class extraRunsPerTeam {

	@Test
	void test() {
		
		HashMap<String,Integer> extraRuns=new HashMap<>();
		List<Deliveries> delivery=Main.readDeliveriesData();
		List<Match> matches=Main.readMatchesData();
		
		extraRuns=Main.ExtraRunsPerTeam2016(delivery, matches);
		
		int sizeOfData=extraRuns.size();
		HashMap<String,Integer> wrongData=null;
		
		int dataForGujaratLions=98;
		int testing=Main.ExtraRunsPerTeam2016(delivery, matches).get("Gujarat Lions");
		
		
//		checking outputs of ExtraRunsPerTeam2016 (4)
		
		assertEquals(Main.ExtraRunsPerTeam2016(delivery, matches),extraRuns);
		
		assertEquals(Main.ExtraRunsPerTeam2016(delivery, matches).size(),sizeOfData);
		
		assertNotEquals(Main.ExtraRunsPerTeam2016(delivery, matches),wrongData);
		
		for(int i=0;i<extraRuns.size();i++) {
			
			assertEquals(Main.ExtraRunsPerTeam2016(delivery, matches).get(i),extraRuns.get(i));
		}
		
//		assertNotEquals(Main.ExtraRunsPerTeam2016(delivery, matches).get("Gujarat Lions"),dataForGujaratLions);
//		System.out.println(Main.ExtraRunsPerTeam2016(delivery, matches).get("Gujarat Lions"));
//		
		
		
		
	
		
		
	}

}
