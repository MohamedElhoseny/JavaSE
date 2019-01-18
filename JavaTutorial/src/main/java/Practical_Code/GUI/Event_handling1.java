package Practical_Code.GUI;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Event_handling1 extends Frame
{
   Button b = new Button("Beep");
   
   public Event_handling1(String title)
   {
	   this.setTitle(title);
	   this.setVisible(true);
	   
	   Dimension xy = Toolkit.getDefaultToolkit().getScreenSize();   //3shan ageb el resolution bta3 el screen
	   this.setSize(xy);
	   
	   b.addActionListener(new ActionListener() {
		 //anonymous inner class
		@Override
		public void actionPerformed(ActionEvent e) {			
           System.out.println("Event Handled !");
		}
	    });
	   
	   this.add(b);
	  
   }

}
