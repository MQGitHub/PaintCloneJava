package ca.utoronto.utm.paint;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

/**
 * 
 * A ShapeChooserPanel is a JPanel of buttons. Each button represents a Shape or
 * Shape modifier which the user can choose to draw with.
 *
 */
class ShapeChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view

	/**
	 * Create the ShapeChooserPanel and attach the view to the panel.
	 * @param view
	 * 			The view of the model.
	 */
	public ShapeChooserPanel(View view) {
		this.view = view;
		String[] buttonLabels = { "Circle", "Oval", "Rectangle", "Square", "Triangle", "Squiggle", "Polyline", "Line",
				"Eraser", "Text" };
		GetIcons i = new GetIcons(buttonLabels);
		ImageIcon[] icon = i.icons();
		ButtonGroup group = new ButtonGroup();
		this.setLayout(new GridLayout(buttonLabels.length + 3, 1));
		int j = 0;
		for (String label : buttonLabels) {
			JToggleButton button = new JToggleButton();
			button.setIcon(icon[j]);
			j++;
			button.setToolTipText(label);
			group.add(button);
			this.add(button);
			button.addActionListener(this);
		}

		LineThicknessChooser t = new LineThicknessChooser(this.view);
		this.add(t.lineThicknessMenu());
		
		JRadioButton fill = new JRadioButton("Fill Shape");
		fill.addActionListener(this);
		this.add(fill);
		
		TextPanel txt = new TextPanel(this.view);
		this.add(txt.textBar());
	}

	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Fill Shape") {
			JRadioButton x = (JRadioButton) e.getSource();
			this.view.getPaintPanel().setFill(x.isSelected());
		} else {
			JToggleButton y = (JToggleButton) e.getSource();
			this.view.getPaintPanel().setMode(y.getToolTipText());
		}
	}

}
