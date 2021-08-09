package ipl;


import java.io.*;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

  

public class matchesPlayedPerYear {
	public static void main(String args[]) {
	String path="matches.csv";
	String line="";
	String split=",";
//	int count=0;
	String[] season=new String[700];
	
	try {
		BufferedReader bf=new BufferedReader(new FileReader(path));
		while((line=bf.readLine())!= null) 
		{
			 List<String> match = new ArrayList<String>();
//			String[] match = line.split(split); 
//			List<String> match = Arrays.asList(line.split(split));
			 match.add(line);
			System.out.println(match);
			
			
		}
		
		bf.close();
	}
	
	
	catch(IOException e) {
		e.printStackTrace();
	}
//	catch(FileNotFoundException ex) {
//		ex.printStackTrace();
//	}
	
	
}
}

