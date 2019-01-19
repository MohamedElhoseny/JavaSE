package Practical_Code.GUI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdapterClass extends KeyAdapter
{
    //aktb b2a feh el function 2le ana h7tgha bdl lma a3ml implement le interface w ynzle 7 methods w msh h7tghm
	public void keyPressed(KeyEvent arg0) 
	{
          System.out.println("Ok KeyPressed");
	}
   /*
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
  */
}
