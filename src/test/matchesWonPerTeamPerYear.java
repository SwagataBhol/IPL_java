package test;


import static org.junit.jupiter.api.Assertions.*;
import com.ipl.model.*;
import com.ipl.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class matchesWonPerTeamPerYear {

	@Test
	void test() {
		HashMap<String,HashMap<String , Integer>> matchesWon=new HashMap<>();
		
		List<Match> matches=Main.readMatchesData();
		matchesWon=Main.MatchesWonPerTeamPerYear(matches);
		
		HashMap<String,HashMap<String , Integer>> wrongData = null;
		int size=matchesWon.size();
		
		HashMap<String,Integer> dataOf2009=new HashMap<>();
		dataOf2009=Main.MatchesWonPerTeamPerYear(matches).get("2009");

		
//		comparing outputs
		assertEquals(Main.MatchesWonPerTeamPerYear(matches),matchesWon);
		
		assertNotEquals(Main.MatchesWonPerTeamPerYear(matches),wrongData);
		
		assertEquals(Main.MatchesWonPerTeamPerYear(matches).size(),size);
		
		assertEquals(Main.MatchesWonPerTeamPerYear(matches).get("2009"),dataOf2009);
		
		
		
		
		
		
		
		
	}

}
