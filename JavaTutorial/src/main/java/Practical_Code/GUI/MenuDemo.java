package Practical_Code.GUI;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;

public class MenuDemo extends Frame
{
    Menu color = new Menu("Colors");
    Menu shape = new Menu("Shapes");
    Menu _2d = new Menu("2d Shapes");
    Menu _3d = new Menu("3d Shapes");
    
    public MenuDemo()
    {
    	this.setSize(400,200);
    	this.setLayout(new FlowLayout(FlowLayout.LEFT));
    	this.setVisible(true);
    	
    	color.add("Red");
    	color.add("White");
    	color.add("yellow");
    	
    	_2d.add("rectangle");
    	_2d.add("Square");
    	
    	_3d.add("Cube");
    	_3d.add("Sphere");
    	
    	shape.add(_2d);
    	shape.add(_3d);
    	
    	//Colors Menu and Shapes that have 2 menu (2d , 3d)   Must but in MenuBar to add them in Frame
    	
    	MenuBar nav = new MenuBar();
    	nav.add(color);
    	nav.add(shape);
    	
    	
    	//this.add(nav);  error can not add menubar or menu         Method to add ==>> setMenuBar
    	
    	this.setMenuBar(nav);
    }
}
