package Practical_Code.GUI;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogClass extends Dialog implements ActionListener
{
	Button y = new Button("Yes");
	Button n = new Button("No");
	Label m = new Label("Do You Want to Exit Program : ");
	
    public DialogClass(Frame f) 
    {
		super(f,true);  //Model Dialog
		this.setLayout(new FlowLayout());
		this.setSize(200,120);
		this.add(m); 
		this.add(y); 
		this.add(n);
		y.addActionListener(this);
		n.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{		
		if (e.getSource() == y)
		{
			System.exit(0);
		} 
		else if (e.getSource() == n)
		{
            this.setVisible(false);
		}
	}

}
