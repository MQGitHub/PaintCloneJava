package ca.utoronto.utm.paint;

import java.util.Hashtable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * A FillChooser has a fillSelector from which the user can set
 * the fill level.
 *
 */
public class FillChooser implements ChangeListener{

	private View view;
	
	/**
	 * Initialize the view by connecting the view and FillChooser.
	 * 
	 * @param view
	 *            The view of Paint model.
	 */
	public FillChooser(View view) {
		this.view = view;
	}
	
	/**
	 * Construct a JMenuBar with a JSlider to choose the fill
	 * 
	 * @return JMenuBar with a JSlider
	 */
	public JMenuBar fillSelector() {
		JMenuBar b = new JMenuBar();
		JMenu f = new JMenu("Fill");
		
		JSlider fill = new JSlider(0,10, 0);
		fill.setPaintLabels(true);
		fill.addChangeListener(this);
		Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel>();
	    table.put (0, new JLabel("Transparent"));
	    table.put (10, new JLabel("Opaque"));
	    fill.setLabelTable(table);
	    fill.setOrientation(SwingConstants.VERTICAL);
	    fill.setInverted(true);
		f.add(fill);
		
		b.add(f);
		return b;
	}

	/**
	 * Controller aspect of this
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider x = (JSlider) e.getSource();
		this.view.getPaintPanel().setOpacity(x.getValue());
	}
	
	
}
