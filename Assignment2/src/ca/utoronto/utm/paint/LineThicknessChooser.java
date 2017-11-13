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
	private int t = 0;
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
		JMenu line = new JMenu("Line Modifiers");
		
		JMenu lt = new JMenu("Line Thickness");
		JSlider thickness = new JSlider(0, 10, 0);
		thickness.setPaintLabels(true);
		thickness.setMajorTickSpacing(2);
		thickness.addChangeListener(this);
		lt.add(thickness);
		line.add(lt);
		
		Image[] img = new Image[2];
		int j = 0;
		for (String label : new String[]{"line", "dash"}) {
			ImageIcon x = new ImageIcon(getClass().getResource(label + ".png"));
			Image image = x.getImage();
			img[j] = image.getScaledInstance(35, 30, java.awt.Image.SCALE_SMOOTH);
			j++;
		}
		
		ButtonGroup group = new ButtonGroup();		
		JMenu l = new JMenu("Line Style");
		JCheckBoxMenuItem item = new JCheckBoxMenuItem();
		item.setIcon(new ImageIcon(img[0]));
		item.setToolTipText("Plain");
		item.setSelected(true);
		group.add(item);
		item.addActionListener(this);
		l.add(item);
		
		item = new JCheckBoxMenuItem();
		group.add(item);
		item.setIcon(new ImageIcon(img[1]));
		item.setToolTipText("Dashed");
		item.addActionListener(this);
		l.add(item);
		line.add(l);
		
		b.add(line);
		return b;
		}
		
	
	/**
	 * Controller aspect of this
	 */

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider x = (JSlider) e.getSource();
		this.view.getPaintPanel().setStroke(choice, x.getValue());
		this.t = x.getValue();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.getPaintPanel().setStroke(e.getActionCommand(), this.t);
		this.choice = e.getActionCommand();
	}
	
}
