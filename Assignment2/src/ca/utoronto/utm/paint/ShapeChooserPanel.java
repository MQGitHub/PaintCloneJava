package ca.utoronto.utm.paint;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class ShapeChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view

	public ShapeChooserPanel(View view) {
		this.view = view;
		String[] buttonLabels = { "Circle", "Oval", "Rectangle", "Square", "Triangle", "Squiggle", "Polyline", "Line",
				"Eraser" };
		GetIcons i = new GetIcons(buttonLabels);
		ImageIcon[] icon = i.icons();
		ButtonGroup group = new ButtonGroup();
		this.setLayout(new GridLayout(buttonLabels.length + 2, 1));
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
