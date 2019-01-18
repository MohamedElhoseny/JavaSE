package Practical_Code.GUI;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;


public class Project extends JFrame
{ 	 
	String[] arr = {"All Programs","Recently Installed","Large Programs"};
	JList<String> allprog_list = new JList<>(arr);
	
	JButton all_programe = new JButton("All Programes");
	
    public Project()
    {
        this.setVisible(true);    //890 * 600
        this.setLayout(new FlowLayout());   
        this.setSize(890, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container c = this.getContentPane();
        c.setBackground(new Color(0, 56, 86));     
            
        Container features = new JPanel();	
        features.setSize(890,600 );
         c.add(features);
    }
}
