package Practical_Code.GUI;

import java.awt.Frame;
import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu_PopUp extends Frame {
	public Menu_PopUp() {
		this.setVisible(true);
		this.setSize(300, 120);

		PopupMenu p = new PopupMenu();
		p.add("First Thing");
		p.add("Second Thing");

		this.add(p);

		this.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					p.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
	}
}
