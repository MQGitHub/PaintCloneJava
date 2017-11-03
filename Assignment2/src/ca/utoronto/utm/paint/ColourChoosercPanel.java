package ca.utoronto.utm.paint;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class ColourChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	JLabel label;
	public ColourChooserPanel(View view) {	
		this.view=view;
		label = new JLabel(" Colours: ");
		//label.setMinimumSize();
		this.add(label);
		Color[] buttonColors = { Color.black, Color.lightGray, Color.blue, Color.magenta, Color.cyan, Color.orange,
				Color.darkGray, Color.pink, Color.gray, Color.red, Color.green, Color.white, Color.yellow};
		this.setLayout(new GridLayout(1, buttonColors.length));
		for (Color colors : buttonColors) {
			JButton button = new JButton();
			button.setBackground(colors);
			button.setBorder(new LineBorder(colors));
			button.setActionCommand("colour");
			this.add(button);
			button.addActionListener(this);
		}
	}
	
	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.getPaintPanel().setMode(e.getActionCommand());
		this.view.getPaintPanel().setColour(((Component) e.getSource()).getBackground());
		System.out.println(e.getActionCommand());
	}

	
}
