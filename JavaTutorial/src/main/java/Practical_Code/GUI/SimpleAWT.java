package Practical_Code.GUI;
import java.awt.*;

public class SimpleAWT 
{
	
    public static void main(String[] args)
    {
    	Frame f = new Frame();
    	f.setSize(200, 130);
    	f.setVisible(true);
    	f.setTitle("First App");
    	Label l = new Label("Hello");
    	f.add(l);
    	f.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));  
    	
    	Button b = new Button("Start");
    	f.add(b);
    	
    	//Layout :
    	  /* 1)FlowLayout => ���� ��� ���
    	   *   FlowLayout(int align , horizontal , vertical)    we also can not wrote for h ,v 
    	   * 2)GridLayout => �� ������ 
    	   *   GridLayout(int row,int column)
    	   * 3)BorderLayout => ��� ����� ����� ����� ������ ������  
    	   *   
    	   */
    	 TextField t = new TextField(20);  //20 is Colomn
         f.add(t);
    }
    public static void Gridexample(Frame f)
    {
    	//dh 2le asmo responsive Thinking
    	f.removeAll();
    	f.setLayout(new FlowLayout(FlowLayout.LEFT));
    	Panel p = new Panel();
    	p.setLayout(new GridLayout(3, 2));
    	p.add(new Label("username : "));
    	p.add(new TextField());
    	p.add(new Label("Password : "));
    	TextField pass = new TextField();
    	pass.setEchoChar('*');
    	p.add(pass);
    	p.add(new Button("OK"));
    	p.add(new Button("Cancel"));
    	
    	f.add(p);
    	f.setVisible(true);
    }
    public static void Borderexample(Frame f)
    {
    	f.removeAll();
    	f.setLayout(new BorderLayout());
    	f.add(new Button("north"), BorderLayout.NORTH);
    	f.add(new Button("west"), BorderLayout.WEST);
    	f.add(new Button("centre"), BorderLayout.CENTER);
    	f.add(new Button("east"), BorderLayout.EAST);
    	f.add(new Button("south"), BorderLayout.SOUTH);
    	f.setVisible(true);
    }
    public static void Calculator(Frame f)
    {
    	f.removeAll();
    	f.setTitle("Calculator Demo");
    	f.setSize(150, 200);
    	f.setVisible(true);
    
    	
    	Panel p = new Panel();
    	p.setLayout(new GridLayout(5, 3));
    	String[] s = {"0","+","-","*","/","="};
    	for (int i = 1; i <= 9; i++) {
			p.add(new Button(i+""));
		}
    	for (int i = 0; i < s.length; i++) {
			p.add(new Button(s[i]+""));
		}
    	TextField t = new TextField();
    	f.add(t, BorderLayout.NORTH);
    	f.add(p);
    	
    }
    public static void Lists(Frame f)
    {
    	//List
    	f.removeAll();
    	f.setLayout(new FlowLayout());
    	List l = new List(4,false);    //not same with list in Collections
    	String[] country = {"Egypt","London","Brazil","German"};
    	for (int i = 0; i < country.length; i++) {
			l.add(country[i]);
		}
    	f.add(new Label("Country"));
    	f.add(l);
    	f.setVisible(true);
    	
    	//CheckBox 
        f.removeAll();
        f.setSize(300, 120);
        f.setLayout(new GridLayout(3,4));
        f.add(new Label("CheckBox :"));
        f.add(new Checkbox("Wifi",null,true));
        f.add(new Checkbox("3G" ,null,false));
        f.add(new Checkbox("Camera",null,false));
        
        //CheckBox Group
        CheckboxGroup cbg = new CheckboxGroup();
        f.add(new Label("CheckBox Group :"));
        f.add(new Checkbox("Wifi",cbg,true));
        f.add(new Checkbox("3G" ,cbg,false));
        f.add(new Checkbox("Camera",cbg,false));
        
        //Choice list
        Choice c = new Choice();
        c.add("Red");
        c.add("White");
        c.add("Blue");
        f.add(new Label("Choose Color : "));
        f.add(c);
        
    }

}
