package ca.utoronto.utm.paint;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class ShapeChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	
	public ShapeChooserPanel(View view) {	
		this.view=view;
		
		String[] buttonLabels = { "Circle","Oval", "Rectangle", "Square", "Squiggle", "Polyline", "Line" };
		ButtonGroup group =  new ButtonGroup();
		this.setLayout(new GridLayout(buttonLabels.length + 1, 1));
		for (String label : buttonLabels) {
			JToggleButton button = new JToggleButton(label);
			group.add(button);
			this.add(button);
			button.addActionListener(this);
		}
		
		LineThicknessChooser t = new LineThicknessChooser(this.view);
		this.add(t.lineThicknessMenu());
		
		
	}
	
	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.getPaintPanel().setMode(e.getActionCommand());
	}
	
}

