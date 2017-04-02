import javax.xml.parsers.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class NamesReader {

	/**
	 * Main method that starts the program. Sets up an xml document and calls parseFile method.
	 * @param args name of file containing xml structure
	 */
	public static void main(String[] args) {	
		
		try {
			
			// Setup XML Document
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			DocumentBuilder builder = factory.newDocumentBuilder();

			Document document = builder.parse("bul.xml");
			
			Display display = new Display(parseFile(document));
		}
		
		catch (Exception ioenfe) {
			// inform user of problem
			System.out.println("Error: IOException. ");
		}
	}

	/**
	 * Navigate through the major document structure.
	 * @param document xml document passed
	 */
	private static ArrayList<Competitor> parseFile(Document document) {
		
		ArrayList<Competitor> competitors = new ArrayList<>();
		
		Node docRoot = document.getDocumentElement();
		
		NodeList list = document.getElementsByTagName("ClassStart");
		for(int c = 1; c <= list.getLength(); c++ ){
			NodeList children = list.item(c).getChildNodes();
			
			List<Node> personStarts = new ArrayList<>();
			for(int j = 0; j < children.getLength(); j++){
				Node child = children.item(j);
				
				if (child.getNodeName().equals("PersonStart")){
					personStarts.add(child);
					//System.out.println(child +" " +j);
				}
			}
			for(int i = 1; i <= personStarts.size(); i++){
				
//				System.out.println(i);
//				System.out.println(personStarts.size());
				XPathFactory xPathfactory = XPathFactory.newInstance();
				XPath xpath = xPathfactory.newXPath();
			
				try {
					String name, team, time;
					XPathExpression familyExp = xpath.compile("StartList/ClassStart["+c+"]/PersonStart["+i+"]/Person/PersonName/Family");
					XPathExpression givenExp = xpath.compile("StartList/ClassStart["+c+"]/PersonStart["+i+"]/Person/PersonName/Given");
					
					XPathExpression teamExp = xpath.compile("StartList/ClassStart["+c+"]/PersonStart["+i+"]/Club/ShortName");
					XPathExpression timeExp = xpath.compile("StartList/ClassStart["+c+"]/PersonStart["+i+"]/Start/StartTime/Clock");
					
					name = familyExp.evaluate(document) + " " + givenExp.evaluate(document);
					team = teamExp.evaluate(document);
					time = timeExp.evaluate(document);
					
					if(!name.equals("Vakant") && !name.equals("")){
						competitors.add(new Competitor(name, team, time));
					}
				
//					System.out.println(name +" "+team+" "+ time);
//					System.out.println(familyExp.evaluate(document));
//					System.out.println(givenExp.evaluate(document));
//					System.out.println(teamExp.evaluate(document));
//					System.out.println(timeExp.evaluate(document));
					
	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		Collections.sort(competitors, new Comparator<Competitor>(){
			@Override
			public int compare(Competitor c1, Competitor c2){
				return c1.getTime().compareTo(c2.getTime());
			}
		});	return competitors;
	}
	
	/**
	 * Recursive method called on all nodes in the document, as well as all
	 * nodes that a particular node has.
	 * 
	 * @param n root node of the document
	 */
	private static void parseNode(Node n)  throws XPathExpressionException{
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		try{
			XPathExpression familyExp = xpath.compile("StartList");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}