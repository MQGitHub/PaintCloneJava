package ca.utoronto.utm.paint;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

/**
 * 
 * A LineThicknessChooser has a lineThicknessMenu from which the user can set the line thickness.
 *
 */

public class LineThicknessChooser implements ChangeListener, ActionListener {

	private View view; // So we can talk to our parent or other components of the view
	private JSlider thickness;
	private String choice = "plain";
	
	/**
	 * Initialize the view by connecting the view and LineThicknessChooser.
	 * @param view
	 * 			The view of Paint model.
	 */
	public LineThicknessChooser(View view) {	
		this.view=view;
	}
	
	/**
	 * Construct a JMenuBar with a JSlider to choose the line thickness
	 * 
	 * @return JMenuBar with a JSlider
	 */
	
	public JMenuBar lineThicknessMenu() {
		
		JMenuBar b = new JMenuBar();
		
		JMenu lt = new JMenu("Line Thickness");
		thickness = new JSlider(0, 10, 0);
		thickness.setPaintLabels(true);
		thickness.setMajorTickSpacing(2);
		thickness.addChangeListener(this);
		lt.add(thickness);
		b.add(lt);
		
		ButtonGroup group = new ButtonGroup();		
		JMenu l = new JMenu("Line Style");
		JCheckBoxMenuItem item = new JCheckBoxMenuItem("Plain", true);
		group.add(item);
		item.addActionListener(this);
		l.add(item);
		item = new JCheckBoxMenuItem("Dashed");
		group.add(item);
		item.addActionListener(this);
		l.add(item);
		
		b.add(l);
		return b;
		}
		
	
	/**
	 * Controller aspect of this
	 */

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider x = (JSlider) e.getSource();
		this.view.getPaintPanel().setStroke(choice, x.getValue());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.getPaintPanel().setStroke(e.getActionCommand(), this.thickness.getValue());
		this.choice = e.getActionCommand();
	}
	
}
