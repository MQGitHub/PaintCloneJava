package ca.utoronto.utm.paint;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class ColourChooserPanel extends JPanel implements ChangeListener {
	private View view; // So we can talk to our parent or other components of the view
	private JLabel label;
	private JColorChooser pcc; //panel color chooser
	public ColourChooserPanel(View view) {	
		this.view = view;
		pcc = new JColorChooser();
		label = new JLabel(" Colours: ");
		//label.setMinimumSize();
		this.add(label);
		//pcc.setBorder(BorderFactory.createTitledBorder("Colours"));
		this.pcc.setPreviewPanel(new JPanel());
		this.pcc.getSelectionModel().addChangeListener(this);
		this.add(pcc);
	}
	
	/**
	 * Controller aspect of this
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		Color currentColor = this.pcc.getColor();
		this.view.getPaintPanel().setMode("Colour");
		this.view.getPaintPanel().setColour(currentColor);
	}

	
}
