package Practical_Code.GUI;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DialogDemo extends Frame
{
	DialogClass message;
	FileDialog  select;   //������ ���� ������ ��� ���� ������� �� ���������� ������ ���� ��� ����� �������� ��� ����� ��������� ��� ���� �� ���� ������� �� ������� �������
    public DialogDemo()
    {
    	this.setVisible(true);
    	this.add(new Label("Welcome"));
    	this.setSize(200, 200);
    	
    	message = new DialogClass(this);
    	
    	//bdl el functions dh kolha a3mlha bdl this new windowsAdapter
    	this.addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e)
    		{
    			message.setVisible(true);
    		}
  		});
     	
        this.setLayout(new FlowLayout());
        
        Button b = new Button("Select file");
        select = new FileDialog(this);
        this.add(b);
        
        b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				select.setVisible(true);
			}
		});
  
    }
		
}

