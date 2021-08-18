package test;

import static org.junit.jupiter.api.Assertions.*;


import com.ipl.*;
import com.ipl.model.*;
import java.util.*;


import org.junit.jupiter.api.Test;

class matchesPlayedPerYear {

	@Test
	void test() {
		
		
		
		HashMap<String , Integer> wrongData = null;
		
		List<Match> matches = Main.readMatchesData();

		List<Match> sublistMatch=matches.subList(0,5);
		
		HashMap<String, Integer> subListResult = new HashMap<>(); 
		subListResult.put("2017", 5);
		
		
		
		
		
		//matches.getClass().getName();
		
		//Checking for Correct OutPut (5)
		assertEquals(Main.MatchesPlayedPerYear(sublistMatch), subListResult);
		
		assertEquals(Main.MatchesPlayedPerYear(sublistMatch).getClass().getSimpleName(),subListResult.getClass().getSimpleName());
		
		assertNotEquals(Main.MatchesPlayedPerYear(matches), wrongData);
		
		assertEquals(Main.MatchesPlayedPerYear(matches).get("2010"),60);
		
		assertEquals(matches.size(),636);
		
		assertThrows(NullPointerException.class,()->Main.MatchesPlayedPerYear(null));
		
		
	}

}
