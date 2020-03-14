// Daniel Oh
// CSCI 165s

public class ElectionResults2016 {

	// private variables 
	private double demVotes;
	
	private double gopVotes;
	
	private double totalVotes;
	
	private double percentDem;
	
	private double percentGOP;
	
	private String stateAbbreviation;
	
	private String county;
	
	private int fips;
	
	// constructor 
	public ElectionResults2016(double demV, double gopV, double totalV, double perDem, double perGOP, String state, String county, int fips) {
		demVotes = demV;
		
		gopVotes = gopV;
		
		totalVotes = totalV;
		
		percentDem = perDem;
		
		percentGOP = perGOP;
		
		stateAbbreviation = state;
		
		this.county = county;
		
		this.fips = fips;
		
	
	}

	public double getTotalVotes() {
		
		return totalVotes;
		
	}
	
	public double getDemVotes() {
		
		return demVotes;
		
	}
	
	public double getGOPVotes() {
		
		return gopVotes;
		
	}
	
	public double getPercentDifference() {
		
			return Math.abs(demVotes - gopVotes) / ((demVotes + gopVotes) / 2);
		
	}
	
	public String getState() {
		
		return stateAbbreviation;
		
	}
	
	public String getCounty() {
		
		return county;
		
	}
	
	public String toString() {
		
		String line = String.format("Democratic Vote: %.1f Republic Vote: %.1f Total Vote: %.1f State: %s County: %s fips: %d", demVotes, gopVotes, totalVotes, stateAbbreviation, county, fips);
		
		return line;
		
	}
	
	
	
	
	
	
	
} // end of class
