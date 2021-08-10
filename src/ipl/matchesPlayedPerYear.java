package ipl;
import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class matchesPlayedPerYear {
	public static void main(String args[]) {
	String path1="matches.csv";
	String path2="deliveries.csv";
	String line="";
	String split=",";
	String year="2016";
	
//	String keys[]= {"id","season","city","date","team1","team2","toss_winner","toss_decision","result","dl_applied","winner","win_by_runs","win_by_wickets","player_of_match","venue","umpire1","umpire2","umpire3"};
	ArrayList<String[]> match = new ArrayList<String[]>();
	HashMap<String, Integer> matchData1 = new HashMap<String,Integer>();
	HashMap<String, HashMap<String, Integer>> matchData2 = new HashMap<String, HashMap<String, Integer>>();
	HashMap<String, Integer> winner = new HashMap<String,Integer>();
	ArrayList<String[]> deliveties=new ArrayList<String[]>();
	HashMap<String, Integer> deliveryData = new HashMap<String,Integer>();
//	String[] Ids16={};
	List<String> Ids16=new ArrayList<String>();
	
	
	
	int skip=0;
	int count1=0;
	int count2=0;
	
	try {
		BufferedReader bf=new BufferedReader(new FileReader(path1));
		while((line=bf.readLine())!= null) 
		{
			  if(skip == 0){
                  skip++;
                  continue;
              }
			  String[] data=line.split(split);
			  
			 match.add(data);
			 
//			 matchesPlayedPerYear
			 if(matchData1.containsKey(data[1])==true) {
				 count1+=1;
				 matchData1.put(data[1], count1);
			 }
			 else {
				 
				 count1=1;
				 matchData1.put(data[1], count1);
			 }
			 
//			 matches won per team per year 
		 if(matchData2.containsKey(data[1])==true) {
			 if(matchData2.get(data[1]).containsKey(data[10])==true) {

				 int c=matchData2.get(data[1]).get(data[10]);
				 c+=1;
				 matchData2.get(data[1]).put(data[10],c);

					 

				 }
				 else {
					 count2=1;
					 matchData2.get(data[1]).put(data[10],count2);

				 }
				 
			 }
			 else {
				 count2=1;
				 winner.clear();
//				 winner.put(data[10],count2);
				 matchData2.put(data[1],winner );
			 }
//		filtering data for 2016 
		 if(matchData2.containsKey("2016")){
			 Ids16.add(data[0]);
			 
		 }
//		 end of while loop
		}
// Extra runs conceded per team in the year 2016
//		deliveries data read
		 int skip1=0;
		 BufferedReader br=new BufferedReader(new FileReader(path2));
			while((line=br.readLine())!= null) 
			{
				  if(skip1 == 0){
	                  skip1++;
	                  continue;
	              }
				  String[] data1=line.split(split);
				  
				  deliveties.add(data1);
				  
		}
//			System.out.println(deliveties.get(0)[16]); (how to get values of ArrayList)
		
	
		bf.close();
	}
	
	catch(IOException e) {
		e.printStackTrace();
	}
	matchData1.forEach((k,v) -> System.out.println("Key = "
           + k + ", Value = " + v));
//	matchData2.forEach((k,v) -> System.out.println("Key = "
//           + k + ", Value = " + v));
//    

//	Extra runs conceded per team in the year 2016
for(int i=0;i<deliveties.size();i++) {
	String key=deliveties.get(i)[0];
	
	if(Ids16.contains(key)) {
		
		String bowlingTeam=deliveties.get(i)[3];
		String runs=deliveties.get(i)[16];
		int extraRuns=Integer.parseInt(runs);
		
		if(deliveryData.containsKey(bowlingTeam)) {
			
			int cnt=deliveryData.get(bowlingTeam);
			cnt+=extraRuns;
			deliveryData.put(bowlingTeam,cnt);
		}
		else {
			
			deliveryData.put(bowlingTeam,extraRuns );
		}
		
	}
	
}
deliveryData.forEach((k,v) -> System.out.println("Key = "
   + k + ", Value = " + v));

}
}


