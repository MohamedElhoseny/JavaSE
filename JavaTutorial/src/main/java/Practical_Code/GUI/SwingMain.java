package Practical_Code.GUI;

import javax.swing.JOptionPane;

public class SwingMain {

	public static void main(String[] args) throws Exception 
	{
		Swing f = new Swing();
        JOptionPane.showMessageDialog(f, "this is a Simple message");
        JOptionPane.showMessageDialog(f, "This is a good message", "Your Message title", JOptionPane.WARNING_MESSAGE);
        
        String input = JOptionPane.showInputDialog(f, "Enter input");
        int n = JOptionPane.showConfirmDialog(f, "Save Work", "Request", JOptionPane.YES_NO_OPTION);
        System.out.println(n);
	}

}
