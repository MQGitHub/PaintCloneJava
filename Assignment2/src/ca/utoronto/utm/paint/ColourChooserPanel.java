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

/**
 * 
 * A ColourChooserPanel is a JPanel of multiple colors from which the user can
 * choose one to draw with. A ColourChooserPanel has a stateChanged of the
 * colour chosen.
 * 
 */
class ColourChooserPanel extends JPanel implements ActionListener, ChangeListener {
	private View view; // So we can talk to our parent or other components of the view
	private JToggleButton panelHider;
	private JColorChooser pcc; //panel color chooser;

	/**
	 * Create the ColourChooserPanel and attach the view to the panel.
	 * @param view
	 * 			The view of the Paint model.
	 */
	public ColourChooserPanel(View view) {
		this.view = view;
		this.pcc = new JColorChooser();
		this.panelHider = new JToggleButton("Colour Panel");
		this.pcc.setPreviewPanel(new JPanel());
		this.pcc.getSelectionModel().addChangeListener(this);
		this.pcc.setVisible(true);
		this.panelHider.addActionListener(this);
		this.add(this.panelHider);
		this.add(this.pcc);
	}
	
	/**
	 * Hides or shows the Color panel
	 */
	public void actionPerformed(ActionEvent e) {
		JToggleButton btn = (JToggleButton)e.getSource();
		if (btn.isSelected()) {
			this.pcc.setVisible(false);
         } else {
        	 this.pcc.setVisible(true);
         }
	}

	/**
	 * Sets text color of the JToggleButton
	 * @param colour color to set text
	 */
	public void updateButtonColor(Color colour) {
		this.panelHider.setOpaque(true);
		this.panelHider.setBackground(colour);
		this.panelHider.setForeground(colour);
	}

	/**
	 * Controller aspect of this
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		Color currentColor = this.pcc.getColor();
		this.updateButtonColor(currentColor);
		this.view.getPaintPanel().setColour(currentColor);
	}

}
