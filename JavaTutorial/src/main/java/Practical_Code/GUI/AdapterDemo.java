package Practical_Code.GUI;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;

public class AdapterDemo extends Frame 
{
   TextField t = new TextField(10);
   
   public AdapterDemo()
   {
	   this.setVisible(true);
	   this.setSize(250,100);
	   this.add(t);
	   this.setLayout(new FlowLayout(FlowLayout.LEFT));
	   
	   t.addKeyListener(new AdapterClass());
   }
   
} 
