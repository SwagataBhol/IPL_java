package com.ipl;

import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.ipl.model.*;


public class Main {
	
//	matches index
	static int id=0;
	static int season=1;
	static int city=2;
	static int date=3;
	static int team1=4;
	static int team2=5;
	static int tossWinner=6;
	static int tossDecision=7;
	static int result=8;
	static int dlApplied=9;
	static int winner=10;
	static int winByRuns=11;
	static int winByWicket=12;
	static int playerOfMatch=13;
	static int venue=14;
	static int umpire1=15;
	static int umpire2=16;
	static int umpire3=17;
	
// deliveries index
	static int matchId=0;
	static int innings=1;
	static int  battingTeam=2;
	static int bowlingTeam=3;
	static int over=4;
	static int ball=5;
	static int batsmanName=6;
	static int bowlerName=7;
	static int wideRuns=8;
	static int byeRuns=9;
	static int legByeRuns=10;
	static int noballRuns=11;
	static int penaltyRuns=12;
	static int batsmanRuns=13;
	static int totalRuns=15;
	static int extraRuns=16;
	
	
//	read matches data 
static List<Match> readMatchesData() {
		List<Match> matches = new ArrayList<Match>();

			
	String line="";
	int ignore=0;
	
		
		try {
			BufferedReader bf=new BufferedReader(new FileReader("./data/matches.csv"));
			while((line=bf.readLine())!= null) 
			{
				Match match=new Match();
				
				  if(ignore == 0){
					  ignore++;
	                  continue;
	              }
				  String[] data=line.split(",");
				  match.setSeason(data[season]);
				  match.setWinner(data[winner]);
				  match.setId(data[id]);
				 matches.add(match);
				 
			}
			
	}
		catch(IOException e) {
			e.printStackTrace();
		}
		return matches;
	}
// read deliveries data 
static List<Deliveries> readDeliveriesData() {
	List<Deliveries> deliveries = new ArrayList<Deliveries>();

		
String line="";
int ignore=0;

	
	try {
		BufferedReader bf=new BufferedReader(new FileReader("./data/deliveries.csv"));
		while((line=bf.readLine())!= null) 
		{
			Deliveries delivery=new Deliveries();
			
			  if(ignore == 0){
				  ignore++;
                  continue;
              }
			  String[] data=line.split(",");
			  delivery.setBowlingTeam(data[bowlingTeam]);
			  delivery.setMatchId(data[matchId]);
			  delivery.setExtraRuns(data[extraRuns]);
			  
			  deliveries.add(delivery);
//			  System.out.println(deliveries.size());
			 
		}
		 
}
	catch(IOException e) {
		e.printStackTrace();
	}
	return deliveries;
}

static HashMap<String,Integer> MatchesPlayedPerYear(List<Match> matchData){
	int count=0;
	HashMap<String, Integer> season = new HashMap<String,Integer>();
	for(int i=0;i<matchData.size();i++) {
		
		String year=matchData.get(i).getSeason();
		if(season.containsKey(year)) {
			int c=season.get(year);
			c+=1;
			season.put(year, c);
		}
		else {
			count=1;
			season.put(year, count);
		}
	}
	
	
	return season;
	
	
}
static HashMap<String,HashMap<String,Integer>> MatchesWonPerTeamPerYear(List<Match> matchData){
	
	HashMap<String, HashMap<String, Integer>> matchesWon = new HashMap<String, HashMap<String, Integer>>();
	
	for(int i=0;i<matchData.size();i++) {
		
		String year=matchData.get(i).getSeason();
		String teamName=matchData.get(i).getWinner();
		
		if(matchesWon.containsKey(year)) {
			
			if(matchesWon.get(year).containsKey(teamName)) {
				int c=matchesWon.get(year).get(teamName);
				c+=1;
				matchesWon.get(year).put(teamName,c);
			}
			else {
				
				matchesWon.get(year).put(teamName,1);
			}
		}
		else{
			
			int count=1;
			HashMap<String, Integer> winnerr = new HashMap<String,Integer>();
			 winnerr.put(teamName,count);
			 matchesWon.put(year,winnerr );
		}
	}
	return matchesWon;
}
static HashMap<String,Integer> ExtraRunsPerTeam2016(List<Deliveries> deliveryyData,List<Match> matchData){
	
	HashMap<String,Integer> extraRunsPerTeam=new HashMap<String,Integer>();
	List<String> ids2016=new ArrayList<String>();
	
	for(int i=0;i<matchData.size();i++) {
		
		String years=matchData.get(i).getSeason();

		String id=matchData.get(i).getId();
		if(years.equals("2016")) {
			
			ids2016.add(id);

		}	
	}

	for(int i=0;i<deliveryyData.size();i++) {
		
		String checkid=deliveryyData.get(i).getMatchId();
		
		
		if(ids2016.contains(checkid)) {
			String bowlingTeam=deliveryyData.get(i).getBowlingTeam();
			String extraRuns=deliveryyData.get(i).getExtraRuns();
			int extraRunsValue=Integer.parseInt(extraRuns);
			
			if(extraRunsPerTeam.containsKey(bowlingTeam)) {
				
				int cnt=extraRunsPerTeam.get(bowlingTeam);
				cnt+=extraRunsValue;
				extraRunsPerTeam.put(bowlingTeam,cnt);
			}
			else {
				
				extraRunsPerTeam.put(bowlingTeam,extraRunsValue );
			}
			
			
		}
		
	}
	
	
	
	return extraRunsPerTeam;
}

	
	public static void main(String args[]) {
		
	
	
	
	List<Match> matchData=readMatchesData(); //returning matches data
	List<Deliveries> deliveryyData=readDeliveriesData(); //returning deliveries data
	
	
	HashMap<String,Integer> problem1=MatchesPlayedPerYear(matchData); //function call for matches played per year
	problem1.forEach((k,v) -> System.out.println("Key = "
			+ k + ", Value = " + v));
	
	HashMap<String, HashMap<String, Integer>> problem2 =MatchesWonPerTeamPerYear(matchData); //function call for matches won per team per year
	problem2.forEach((k,v) -> System.out.println("Key = "
			+ k + ", Value = " + v));
	
	HashMap<String,Integer> problem3=ExtraRunsPerTeam2016(deliveryyData,matchData); //function call for extra runs played per year
	problem3.forEach((k,v) -> System.out.println("Key = "
			+ k + ", Value = " + v));
	}
}
	
//######################################################################################################################
//####################################################################################################################	
// previous data
	
//	String keys[]= {"id","season","city","date","team1","team2","toss_winner","toss_decision","result","dl_applied","winner","win_by_runs","win_by_wickets","player_of_match","venue","umpire1","umpire2","umpire3"};
	
	
//	String path1="./data/matches.csv";
//	String path2="./data/deliveries.csv";
//	String line="";
//	String split=",";
//	
//	
//	ArrayList<String[]> match = new ArrayList<String[]>();
//	HashMap<String, Integer> matchData1 = new HashMap<String,Integer>();
//	HashMap<String, HashMap<String, Integer>> matchData2 = new HashMap<String, HashMap<String, Integer>>();
//	
//	ArrayList<String[]> deliveties=new ArrayList<String[]>();
//	HashMap<String, Integer> deliveryData = new HashMap<String,Integer>();
////	String[] Ids16={};
//	List<String> Ids16=new ArrayList<String>();
//	
//	
//	
//	int skip=0;
//	int count1=0;
//	int count2=0;
//	
//	try {
//		BufferedReader bf=new BufferedReader(new FileReader(path1));
//		while((line=bf.readLine())!= null) 
//		{
//			  if(skip == 0){
//                  skip++;
//                  continue;
//              }
//			  String[] data=line.split(split);
//			  
//			 match.add(data);
//			 
////			 matchesPlayedPerYear
//			 if(matchData1.containsKey(data[1])==true) {
////				 count1+=1;
//				 int cnt=matchData1.get(data[1]);
//				 cnt+=1;
//				 matchData1.put(data[1], cnt);
//			 }
//			 else {
//				 
//				 count1=1;
//				 matchData1.put(data[1], count1);
//			 }
//			 
////			 matches won per team per year 
//		 if(matchData2.containsKey(data[1])==true) {
//			 if(matchData2.get(data[1]).containsKey(data[10])==true) {
//
//				 int c=matchData2.get(data[1]).get(data[10]);
//				 c+=1;
//				 matchData2.get(data[1]).put(data[10],c);
//
//					 
//
//				 }
//				 else {
//					 count2=1;
//					 matchData2.get(data[1]).put(data[10],count2);
//				 }
//				 
//			 }
//			 else {
//				 count2=1;
//				 HashMap<String, Integer> winner = new HashMap<String,Integer>();
//				 winner.put(data[10],count2);
//				 matchData2.put(data[1],winner );
//			 }
////		filtering data for 2016 
//		 if(matchData2.containsKey("2016")){
//			 Ids16.add(data[0]);
//			 
//		 }
////		 end of while loop
//		}
//
////		deliveries data read
//		 int skip1=0;
//		 BufferedReader br=new BufferedReader(new FileReader(path2));
//			while((line=br.readLine())!= null) 
//			{
//				  if(skip1 == 0){
//	                  skip1++;
//	                  continue;
//	              }
//				  String[] data1=line.split(split);
//				  
//				  deliveties.add(data1);
//				  
//		}
////			System.out.println(deliveties.get(0)[16]); (how to get values of ArrayList)
//		
//	
//		bf.close();
//	}
//	
//	catch(IOException e) {
//		e.printStackTrace();
//	}
////	matchData1.forEach((k,v) -> System.out.println("Key = "
////           + k + ", Value = " + v));
////	matchData2.forEach((k,v) -> System.out.println("Key = "
////           + k + ", Value = " + v));
////    
//
////	Extra runs conceded per team in the year 2016
//for(int i=0;i<deliveties.size();i++) {
//	String id=deliveties.get(i)[0];
//	
//	
//	if(Ids16.contains(id)) {
//		
//		String bowlingTeam=deliveties.get(i)[3];
//		String runs=deliveties.get(i)[16];
//		int extraRuns=Integer.parseInt(runs);
//		
//		if(deliveryData.containsKey(bowlingTeam)) {
//			
//			int cnt=deliveryData.get(bowlingTeam);
//			cnt+=extraRuns;
//			deliveryData.put(bowlingTeam,cnt);
//		}
//		else {
//			
//			deliveryData.put(bowlingTeam,extraRuns );
//		}
//		
//	}
//	
//}
////deliveryData.forEach((k,v) -> System.out.println("Key = "
////   + k + ", Value = " + v));
//
//}
//}
//

