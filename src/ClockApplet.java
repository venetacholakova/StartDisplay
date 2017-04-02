import java.applet.*;
import java.awt.*;
import java.util.*;

public class ClockApplet extends Applet implements Runnable {
	Thread t, t1;
	int offset = 0;
	String time;

	public void start() {
		t = new Thread(this);
		t.start();
	}

	public void run() {
		t1 = Thread.currentThread();
		while (t1 == t) {
			repaint();
			try {
				t1.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	public void paint(Graphics g) {
		Calendar cal = new GregorianCalendar();
		String hour = String.valueOf(cal.get(Calendar.HOUR));
		String minute = String.valueOf(cal.get(Calendar.MINUTE)+offset);  //Need fix for offset
		String second = String.valueOf(cal.get(Calendar.SECOND));
		
		time = (hour + ":" + minute + ":" + second);
		time = fixTime(time);
		g.drawString(time, 20, 30);
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
}