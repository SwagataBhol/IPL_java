package test;

import static org.junit.jupiter.api.Assertions.*;
import com.ipl.*;
import com.ipl.model.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class matchesPlayedPerYear {

	@Test
	void test() {
		
		HashMap<String, Integer> matchesPlayed = new HashMap<>();
		
		HashMap<String , Integer> wrongData = null;
		
		List<Match> matches = Main.readMatchesData();
		
		matchesPlayed = Main.MatchesPlayedPerYear(matches);
		int dataOf2017=matchesPlayed.get("2017");
		
		//Checking for Correct OutPut (5)
		assertEquals(Main.MatchesPlayedPerYear(matches), matchesPlayed);
		
		assertNotEquals(Main.MatchesPlayedPerYear(matches), wrongData);
		
		assertEquals(Main.MatchesPlayedPerYear(matches).size(),matchesPlayed.size());
		
		assertEquals(Main.MatchesPlayedPerYear(matches).get("2010"),60);
		
		assertEquals(Main.MatchesPlayedPerYear(matches).get("2017"),dataOf2017);
	
		
	}

}
