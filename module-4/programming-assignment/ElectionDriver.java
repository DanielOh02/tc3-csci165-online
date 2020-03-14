// Daniel Oh
// CSCI 165

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ElectionDriver {
	
	private ArrayList<ElectionResults2016> result = new ArrayList<ElectionResults2016>();
	
	public void fillList() {

		String line;
		int lineNum = 1;
			
		double demoVote;
		double gopVote;
		double totalVote;
		double perDem; 
		double perGop;
		String state; 
		String county; 
		int    fips;
		
		
		try {
			
			FileReader fileReader = new FileReader("2016_US_County_Level_Presidential_Results.csv");
			Scanner scanner = new Scanner(fileReader);
			
			while (scanner.hasNextLine()) {
				if (lineNum != 1) {
					
					line = scanner.nextLine();
					
					String[] data = line.split(",");
				
					
					demoVote = Double.parseDouble(data[1]);
					
					gopVote = Double.parseDouble(data[2]);
					
					totalVote = Double.parseDouble(data[3]);
					
					perDem = Double.parseDouble(data[4]);
					
					perGop = Double.parseDouble(data[5]);
						
					state = data[7];
					
					county = data[8];
					
					fips = Integer.parseInt(data[9]);
					
					ElectionResults2016 election = new ElectionResults2016(demoVote, gopVote, totalVote, perDem, perGop, state, county, fips);
					
					result.add(election);
					
				
				} else {
					
					line = scanner.nextLine();
					lineNum ++;
					
				} // end of else 
					
			
			
			
			}
			scanner.close();
			
			} catch (FileNotFoundException fnf){
			  System.out.println("Error: File Not Found!");

			}
	
		
	}
		
	public int findLargestMargin() {
		
		double demoTotal = 0;
		double gopTotal  = 0;
		
		for (ElectionResults2016 x : result) {
			demoTotal += x.getDemVotes();
			gopTotal += x.getGOPVotes();
			
		}
		

		return (int) Math.abs(demoTotal - gopTotal);
		
		
	}
	
	public int findLargestMargin(String state) {
		
		double demoTotal = 0;
		double gopTotal  = 0;
		String currentState;
		
		for (ElectionResults2016 x : result) {
				currentState = x.getState();
				
			if (currentState.equals(state) == true) {
				demoTotal += x.getDemVotes();
				gopTotal += x.getGOPVotes();
			}
			
		}
		
		return (int) Math.abs(demoTotal - gopTotal);
			
	}

	public String[] getStateTotals() {
		
		String [] stateList = new String [51]; // since there are 51 states including DC 
		String currentState = "AK";
		String winParty = null;
		int index = 0;
		int totalDem = 0;
		int totalGOP = 0;
		int margin;
		
		for (ElectionResults2016 x : result) {
			if (currentState.equals(x.getState()) == true){
				totalDem += x.getDemVotes();
				totalGOP += x.getGOPVotes();
				
			} else if (x != result.get(result.size()-1)) {
				
				// find who won
				if (totalDem > totalGOP)
					winParty = "Democratic Party";
				else
					winParty = "Republican Party";
				
				// find margin
				margin = Math.abs(totalDem - totalGOP);
				
				// add to the array
				stateList[index] =  "State: "   +   currentState + ", " +
						"Democratic: "	        +   totalDem     + ", " +
						"Republican: "       	+   totalGOP     + ", " +
						"Margin of Victory: "  	+   margin       + ", " +
						"Winning Party: "  		+   winParty;
				
				// reset variables 
					
				totalDem = (int) x.getDemVotes();
				totalGOP = (int) x.getGOPVotes();
				currentState = x.getState();
				index ++;			
				
			} else 
				
				// find who won
				if (totalDem > totalGOP)
					winParty = "Democratic Party";
				else
					winParty = "Republican Party";
				
				// find margin
				margin = Math.abs(totalDem - totalGOP);
				
				// add to the array
				stateList[index] =  "State: "   +   currentState + ", " +
						"Democratic: "	        +   totalDem     + ", " +
						"Republican: "       	+   totalGOP     + ", " +
						"Margin of Victory: "  	+   margin       + ", " +
						"Winning Party: "  		+   winParty;
			
		} // end of for loop
		
		return stateList;
		
	} // end of state total 
	
	public static void  main (String args[]) {
		
		ElectionDriver ed = new ElectionDriver();
		ed.fillList();
		System.out.println(ed.findLargestMargin());
		System.out.println(ed.findLargestMargin("OR"));
		String [] stateList = ed.getStateTotals();
		
		for (int i = 0; i < 51; i++)
			System.out.println(stateList[i]);
			
	} // end of main

} // end of class
	
	
