import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display extends JPanel{

	
	ArrayList<Competitor> list;
	JLabel [] names;
	public Display(ArrayList<Competitor> l) {
		
		this.list = l;
	}
	
	public void fillPanel(){
		for(int i = 0; i<10; i++){
			names[i] = new JLabel();
			names[i].setText(list.get(i).getName());
			this.add(names[i]);
		}
	}

}
