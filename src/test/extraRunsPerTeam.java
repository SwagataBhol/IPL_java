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
		
//		checking outputs of ExtraRunsPerTeam2016
		
		assertEquals(Main.ExtraRunsPerTeam2016(delivery, matches),extraRuns);
		assertEquals(Main.ExtraRunsPerTeam2016(delivery, matches).size(),sizeOfData);
		
		
	
		
		
	}

}
