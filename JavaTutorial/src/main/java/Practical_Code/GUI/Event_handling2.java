package Practical_Code.GUI;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Event_handling2 extends Frame implements ActionListener
{
	TextField t = new TextField(10);   //el 10 dh y3tbr el width bt3ha msh hynf3 t7to fe setsize
    TextField tcopy = new TextField(10);
    Button b = new Button("Copy ->");
    
    public Event_handling2(String title)
    {
    	this.setTitle(title);
    	this.setSize(350, 80);
    	this.setVisible(true);
    	this.setLayout(new FlowLayout(FlowLayout.LEFT));
    		
    	this.add(t);  this.add(b); this.add(tcopy); 
        b.addActionListener(this);
    	
    }

	@Override
	public void actionPerformed(ActionEvent e)
	{
       tcopy.setText(t.getText());
	}
    
}
