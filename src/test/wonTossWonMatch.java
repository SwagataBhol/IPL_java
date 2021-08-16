package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import com.ipl.Main;
import com.ipl.model.*;

import org.junit.jupiter.api.Test;

class wonTossWonMatch {

	@Test
	void test() {
		
		HashMap<String,Integer> wonTossWonMatch=new HashMap<>();
		List<Match> matches=Main.readMatchesData();
		
		HashMap<String,Integer> wrongData=null;
		
		wonTossWonMatch=Main.TossAndMatchesWonPerTeam(matches);
		int sizeOfData=wonTossWonMatch.size();
		
		assertEquals(Main.TossAndMatchesWonPerTeam(matches),wonTossWonMatch);
		assertEquals(Main.TossAndMatchesWonPerTeam(matches).size(),sizeOfData);
		assertNotEquals(Main.TossAndMatchesWonPerTeam(matches),wrongData);
		
	}

}
