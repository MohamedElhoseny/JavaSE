package Practical_Code.GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class Swing extends JFrame
{
    public Swing() throws Exception
    {
    	this.setTitle("SwingDemo");
    	this.setSize(400,300);
    	this.setVisible(true);
    	this.setLayout(new FlowLayout(FlowLayout.LEFT));
    //	Container c = this.getContentPane();
    //	c.add(new JButton("Login"));
    	this.add(new JButton("Login"));
    	this.add(new JTextField(10));
    	this.add(new JButton("Password"));
    	
    	JPasswordField pass = new JPasswordField(10);
    
    	this.add(pass);
    	pass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				String p = new String(pass.getPassword());    //lma y2olk msh 3rf y3ml convert mn char[] to String a3mlha be new
				System.out.println("Pass = "+p);
			}
		});

    	//setvalueat(value,row,column)
    	JTable t = new JTable(4, 2);
    	for(int i=0 ; i< 4; i++)
    	{
    		t.setValueAt(i, i, 0);
    		t.setValueAt(i*i, i, 1);
    	}
    	this.add(t);
    	
    	
    	String[] color = {"Red","White","Black"};
        JComboBox<String> c = new JComboBox<>(color);
        
        this.add(c);
        
        
            
        String[] lang = {"c++","java","pascal"};
        JList<String> l = new JList<>(lang);
        this.add(l);
        
        l.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				JList<String> l = (JList<String>) e.getSource();
				String values = l.getSelectedValue();
				System.out.println(values);
			}
		});
        
        //tree
         
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Computer") , c1 = new DefaultMutableTreeNode("HDD"),
        		c2 = new DefaultMutableTreeNode("CPU") , c3 = new DefaultMutableTreeNode("Mouse");
        //add all to root
        root.add(c1); root.add(c2); root.add(c3);
        
        c1.add(new DefaultMutableTreeNode("Samsung"));
        c1.add(new DefaultMutableTreeNode("Seagate"));
        
        c2.add(new DefaultMutableTreeNode("Intel"));
        c2.add(new DefaultMutableTreeNode("AMD"));
        
        c3.add(new DefaultMutableTreeNode("Sony"));
        c3.add(new DefaultMutableTreeNode("Dell"));
        
      //  this.add(root); error where Jtree
         JTree tree = new JTree(root);
        this.add(tree);
        
        
        //colorChooser
        JLabel banner = new JLabel("Sample Text", JLabel.CENTER);
        this.add(banner);
        
        JColorChooser cc = new JColorChooser();
        cc.getSelectionModel().addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
			  Color selected = cc.getColor();
			  banner.setForeground(selected);
			}
		});
        
        this.add(cc);
         
        JProgressBar proc = new JProgressBar(0,100);
        this.add(proc);
        
        proc.setStringPainted(true);  //lazem t7tha 3shan y3mlo process bar msh 7aga 3mla zy loading       
        proc.setIndeterminate(false);  //dh 2nta mmken tshel percentage w t5leha ra7a gaya
       
        for (int i = 0; i<=100 ; i++) {
			proc.setValue(i);
			Thread.sleep(200);
		}
        //��� ���� ��� �� ���� ����� ��� �� ������ ��� ������ ��� ������ ���� ���� ��� ���� ������ ���� ��� �����
    }
}
