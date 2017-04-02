
import java.text.SimpleDateFormat;
import java.util.Date;


public class Competitor {

	// Variables for ID, name, year, and college of each founder
	private String name,
				   team,
				   time; //hh:mm:ss
	//private int seconds;
	private String pattern = "HH:mm:ss";
	private Date date;
	/**
	 * Constructor of the Competitor class.
	 * @param name of competitor
	 * @param team of competitor
	 * @param time starting time
	 */
	public Competitor(String name, String team, String time) {
		// Call founder method to set variables
		competitor(name, team, time);
		
	}

	/**
	 * Set values for the private variables to passed values.
	 * @param name
	 * @param team
	 * @param time
	 */
	public void competitor(String name, String team, String time){
		this.name = name;
		this.team = team;
		this.time = time;
		
	if(!time.equals("")){
				time = fixTime(time);
		
		//System.out.println(time);
		SimpleDateFormat f = new SimpleDateFormat(pattern);
		
	try{
			date = f.parse(time); 
		//seconds = convert(time);
		}catch(Exception e){
			e.printStackTrace();
	}
		
		}

	}
	
	private String fixTime(String t){
		String[] arr = t.split(":");
		String result ="";
		for(int i = 0; i<arr.length; i++){
			if(arr[i].length()!=2){
				arr[i] = "0" + arr[i];	
				
			}
			// If we are not at ss /seconds/ attach ":" after
			if(i!=arr.length-1){
				result +=arr[i]+":";
			}
			else{
				result +=arr[i];
			}
			
		}
		return result;
	}
	
//	private int convert(String time){
//		String []array = time.split(":");   
//		int result = 0;
//		for(int i = array.length - 1; i > 0; i--){
//			for(int j = 0; j < array.length; j++){
//				int num = Integer.parseInt(array[i]);
//				double res = Math.pow(60,j);
//			
//				result = num*(int)res;
//			}
//		}
//		return result;
//	}
	
	public Date getTime(){
		return date;
	}
	
	public String getName(){
		return name;
	}
	
	/**
	 * Print out the contents of Competitor.
	 * @return contents of a Competitor object as String
	 */
	public String toString(){
		// Save contents in a String
		String contents = ("Name is: " + name + "  " +
								"Team is: " + team + "  " + "Time is: " + time + "\n"); 
		// Print contents
		System.out.println(contents);
		
		// Return string representation of contents of founder
		return contents;
	}
	
	public int compareTo(Date date){
		return this.date.compareTo(date);
	}
	
}
