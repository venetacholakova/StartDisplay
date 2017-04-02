import java.util.ArrayList;
import java.util.Collections;

public class CompetitorsStructure {
		// List of founders
		private ArrayList<Competitor> competitors;
		
		public CompetitorsStructure() {
			// Create list of founders
			//competitors =  new LinkedList<Competitor>();
		}

		/**
		 * Add a founder to the list of founders.
		 * @param f Founder object to be added to linked list
		 */
		public void add( Competitor c ){
			competitors.add(c);
		}
		
		/**
		 * Return String representation of list of founders.
		 * @return String representation of list of founders
		 */
		public String toString(){
			return competitors.toString();
		}

		public void sortCompetitors(){
			// Call sorting function from data structure class
		}
	

}
