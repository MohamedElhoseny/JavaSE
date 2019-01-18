package Practical_Code.GUI;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ScrollBar extends Frame implements AdjustmentListener
{
   Label m = new Label();
   Scrollbar h = new Scrollbar(Scrollbar.HORIZONTAL,0,60,0,300);
   Scrollbar v = new Scrollbar(Scrollbar.VERTICAL, 0,30,0,300);
   
   //Scrollbar  e = new Scrollbar(obj mn el panel w hyb2a 3leh 3ltol)
   
   public ScrollBar()
   {
	   this.setVisible(true);
	   this.setSize(500,400);
	   
	   this.add(h, BorderLayout.SOUTH);
	   this.add(v, BorderLayout.EAST);
	   this.add(m, BorderLayout.CENTER);
	   
	   h.addAdjustmentListener(this);
	   v.addAdjustmentListener(this);
   }

@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		m.setText("Horizontal "+h.getValue()+" Vertical "+v.getValue());	
	}
}
